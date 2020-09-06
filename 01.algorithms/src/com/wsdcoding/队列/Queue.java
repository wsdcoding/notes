package com.wsdcoding.队列;

import com.wsdcoding.链表.LinkedList;
import com.wsdcoding.链表.List;

/**
 * @Description:
 * @Authror Mohanjun
 * @Date 2020/5/17 11:55
 */
public class Queue<E> {
    // 使用双向链表实现队列
    private List<E> list = new LinkedList<>();

    // 元素的数量
    public int size() {
        return list.size();
    }

    // 是否为空
    public boolean isEmpty() {
        return list.isEmpty();
    }
    // 清空队列
    public void clear(){
        list.clear();
    }
    // 入队
    public void enQueue(E element) {
        list.add(element);
    }

    // 出队
    public E deQueue() {
        return list.remove(0);
    }

    // 获取队列的头元素
    public E front() {
        return list.get(0);
    }
}

