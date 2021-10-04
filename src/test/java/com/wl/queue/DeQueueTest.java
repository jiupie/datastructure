package com.wl.queue;

import org.junit.Test;

/**
 * DeQueueTest class
 *
 * @author 南顾北衫
 * @date 2020/9/18 12:22
 * @email 17674641491@163.com
 */
public class DeQueueTest {
    @Test
    public void test() {
        DeQueue<Integer> queue = new DeQueue<>();
        queue.enQueueFront(1);
        queue.enQueueFront(2);
        queue.enQueueRear(3);
        queue.enQueueRear(4);
        queue.enQueueRear(5);
        System.out.println(queue);//2,1,3,4,5
        queue.deQueueRear();//2,1,3,4
        System.out.println(queue);
        queue.deQueueFront();//1,3,4
        System.out.println(queue);
    }
}