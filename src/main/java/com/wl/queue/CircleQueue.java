package com.wl.queue;

import org.junit.Test;

/**
 * CircleQueue class
 * 循环链表使用动态数组实现
 *
 * @author 南顾北衫
 * @date 2020/9/14 10:44
 * @email 17674641491@163.com
 */
public class CircleQueue<E> {
    private int front; // 队头指针
    private int size; // 元素数量

    private E elements[]; // 元素
    public static final int DEFAULT_CAPACITY = 10; // 初始容量


    public CircleQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }


    /**
     * 入队
     *
     * @param element
     */
    public void enQueue(E element) {
        //数组扩容判断
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    /**
     * 扩容操作
     *
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        if (capacity < length()) {
            return;
        }
        int newCapacity = length() + (length() >> 1);
        E[] newElements = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
    }

    /**
     * 出队
     *
     * @return
     */
    public E deQueue() {
        E element = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return element;
    }

    /**
     * @param index
     * @return
     */
    public int index(int index) {
        return (front + index) % length();
    }

    /**
     * 提高效率，使用加减代替%运算
     *
     * @param index
     * @return
     */
    public int indexOptimize(int index) {
        index += front;
        if (index > length()) {
            return index - length();
        } else {
            return index;
        }
    }


    /**
     * 元素的数量
     */
    public int size() {
        return size;
    }

    public int length() {
        return elements.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("length=" + length() + ",size=" + size + ",front=" + front + " {");
        for (int i = 0; i < length(); i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(elements[i]);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
