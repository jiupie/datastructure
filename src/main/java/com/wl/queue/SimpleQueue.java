package com.wl.queue;


import com.wl.link.DeLink;


/**
 * SimpleQueue class
 * 队列
 * 双向链表实现
 *
 * @author 南顾北衫
 * @date 2020/9/15 21:12
 * @email 17674641491@163.com
 */
public class SimpleQueue<E> {
    private DeLink<E> list = new DeLink<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    /**
     * 入队
     *
     * @param element
     */
    public void enQueue(E element) {
        list.add(element);
    }

    /**
     * 出队
     *
     * @return
     */
    public E deQueue() {
        return list.remove(0);
    }

    public E front() {
        return list.get(0);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
