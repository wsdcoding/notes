package com.wsdcoding.circle;

/**
 * @Description: 循环双端队列
 * @Authror Mohanjun
 * @Date 2020/5/17 18:51
 */
public class CircleDeque<E> {
    // 记录第0个元素的索引
    private int front;
    // 当前队列存储的元素个数
    private int size;
    // 用来存储元素的数组
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public CircleDeque() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }
    // 当前队列是否为空
    public boolean isEmpty() {
        return size == 0;
    }
    // 清空队列
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[index(i)] = null;
        }        size = 0;
        size = 0;
        front = 0;
    }
    // 从队头入队
    public void enQueueFront(E element) {
        ensureCapacity(size + 1);
        front = index(-1);
        elements[front] = element;
        size++;

    }
    // 从队头出队
    public E deQueueFront() {
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }
    // 从队尾入队
    public void enQueueRear(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }
    // 从队尾出队
    public E deQueueRear() {
        int rearIndex = index(size - 1);
        E rear = elements[rearIndex];
        elements[rearIndex] = null;
        size--;
        return rear;
    }
    // 获取队列的头元素
    public E front() {
        return elements[front];
    }
    // 获取队列的尾元素
    public E rear() {
        return elements[index(size - 1)];
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
    private int index(int index){
        //前提条件： m > 0 , n >= 0, n < 2m   m: length  n: front + size
        // n % m 等价于 n - (m > n ? 0 : m)
        index += front;
        if (index < 0){
            return index + elements.length;
        }
        return index - (index >= elements.length ? elements.length : 0);
    }
    /**
     * 保证要有 capacity 的容量
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
        System.out.println(oldCapacity + "循环双端队列扩容为" + newCapacity);
    }
}
