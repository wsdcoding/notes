package com.wsdcoding.队列;

import com.wsdcoding.队列.circle.CircleDeque;
import com.wsdcoding.队列.circle.CircleQueue;

/**
 * @Description:
 * @Authror Mohanjun
 * @Date 2020/5/17 11:54
 */
public class Main {
    static void test1() {
        //        Queue<Integer> queue = new Queue<>();
//        queue.enQueue(11);
//        queue.enQueue(22);
//        queue.enQueue(33);
//        queue.enQueue(44);
//        while (!queue.isEmpty()){
//            System.out.println(queue.deQueue());
//        }
        /**双端队列 */
        Deque<Object> deque = new Deque<>();
        deque.enQueueFront(11);
        deque.enQueueFront(22);
        deque.enQueueRear(33);
        deque.enQueueRear(44);
        while (!deque.isEmpty()) {
            System.out.println(deque.deQueueFront());
        }
    }

    static void test2() {
        CircleQueue<Integer> circleQueue = new CircleQueue<Integer>();
        // 0 1 2 3 4 5 6 7 8 9
        for (int i = 0; i < 10; i++) {
            circleQueue.enQueue(i);
        }
        // null null null null null 5 6 7 8 9
        for (int i = 0; i < 5; i++) {
            circleQueue.deQueue();
        }
        //5个元素又入队
        //15 16 17 18 19 5 6 7 8 9
        for (int i = 15; i < 20; i++) {
            circleQueue.enQueue(i);
        }
        System.out.println(circleQueue);
        while (!circleQueue.isEmpty()) {
            System.out.println(circleQueue.deQueue());
        }
    }

    static void test3(){
        CircleDeque<Integer> circleDeque = new CircleDeque<>();
        //头 5 4 3 2 1   100 101 102 103 104 105 尾
        //进入下一次循环：
        //头 5 4 3 2 1   100 101 102 103 104 105 106 null 7 6 尾
        //头 8, 7, 6, 5, 4, 3, 2, 1, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, null, null, 10, 9
        for (int i = 0; i < 10; i++) {
                circleDeque.enQueueFront(i + 1);
                circleDeque.enQueueRear(i + 100);
        }
        //头 null, 7, 6, 5, 4, 3, 2, 1, 100, 101, 102, 103, 104, 105, 106, null, null, null, null, null, null, null
        for (int i = 0; i < 3; i++) {
                circleDeque.deQueueFront();
                circleDeque.deQueueRear();
        }
        //头 11, 7, 6, 5, 4, 3, 2, 1, 100, 101, 102, 103, 104, 105, 106, null, null, null, null, null, null, 12
        circleDeque.enQueueFront(11);
        circleDeque.enQueueFront(12);
        System.out.println(circleDeque);
        while (!circleDeque.isEmpty()){
            System.out.println(circleDeque.deQueueFront());
        }
    }
    public static void main(String[] args) {
        test2();
        test3();
    }
}
