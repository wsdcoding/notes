package com.wsdcoding.队列.circle;


/**
 * @Description: 循环队列：可在两端添加、删除操作的循环队列，参考动态数组，各项接口可以优化到 O(1)的时间复杂度
 * 这个用数组实现且优化之后的队列也叫作循环队列。
 * @Authror Mohanjun
 * @Date 2020/5/17 12:33
 */
public class CircleQueue<E> {
    // 记录第0个元素的索引
    private int front;
    // 当前队列存储的元素个数
    private int size;
    // 用来存储元素的数组
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public CircleQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    // 当前队列存储的元素数量
    public int size() {
        return size;
    }

    // 当前队列是否为空
    public boolean isEmpty() {
        return size == 0;
    }
    // 清空队列
    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        size = 0;
        front = 0;
    }
    // 入队
    public void enQueue(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    // 出队
    public E deQueue() {
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }

    // 查看索引为0的元素
    public E front() {
        return elements[front];
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("capcaacity=").append(elements.length)
                .append(" size=").append(size)
                .append(" front=").append(front)
                .append(", [");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }

    /**
     * 索引映射封装 (i + front) % elements.length
     */
    private int index(int index) {
        index += front;
        return index - (index >= elements.length ? elements.length : 0);
    }

    /**
     * 保证要有 capacity 的容量
     *
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }

        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
        front = 0;
        System.out.println(oldCapacity + "循环队列扩容为" + newCapacity);
    }
}


