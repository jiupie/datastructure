package com.wl.queue;

import org.junit.Test;

/**
 * SimpleQueueTest class
 *
 * @author 南顾北衫
 * @date 2020/9/18 12:13
 * @email 17674641491@163.com
 */
public class SimpleQueueTest {
    @Test
    public void test() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        System.out.println(queue);
        queue.deQueue();
        queue.deQueue();
        System.out.println(queue);
    }
}