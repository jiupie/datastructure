package com.wl.array;

import java.security.Signature;
import java.util.Arrays;
import java.util.Objects;

/**
 * Array class
 *
 * @author 南顾北衫
 * @date 2020/9/7 12:32
 * @email 17674641491@163.com
 */
public class Array<T> {
    //初始容量
    private static final int DEFAULT_CAPACITY = 10;

    private static final int ELEMENT_NOT_FOUND = -1;

    //当前使用了多少
    private int SIZE = 0;

    //数组
    private T[] items;

    public Array() {
        this(DEFAULT_CAPACITY);
    }

    public Array(int capacity) {
        //判断传入的容量是否小于10
        capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capacity;
        this.items = (T[]) new Object[capacity];
    }

    public int size() {
        return SIZE;
    }

    public boolean isEmpty() {
        return SIZE == 0;
    }

    /**
     * 判断是否有element元素
     *
     * @param element
     * @return
     */
    public boolean contains(T element) {
        return indexOf(element) != ELEMENT_NOT_FOUND ? true : false;
    }

    /**
     * 添加元素到最后面
     *
     * @param element
     */
    public void add(T element) {
        items[SIZE++] = element;
    }

    /**
     * 往index位置添加元素
     * 元素往后移
     *
     * @param index
     * @param element
     */
    public void add(int index, T element) {
        if (index < 0 || index > SIZE) {
            throw new RuntimeException("Index:" + index + ",Size:" + SIZE);
        }
        ensureCapacity();

        for (int i = SIZE; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = element;
        SIZE++;
    }

    /**
     * 缩容
     */
    public void trim() {
        int oldCapacity = items.length;
        //如果当前容量小于容量的一半 或者 容量小于10
        if (SIZE > oldCapacity >> 1 || oldCapacity < DEFAULT_CAPACITY) {
            return;
        }
        int newCapacity = oldCapacity >> 1;
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < SIZE; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
    }

    /**
     * 扩容
     */
    public void ensureCapacity() {
        //当前数组容量
        int oldCapacity = items.length;
        //如果当前容量小于总容量直接返回
        if (SIZE < oldCapacity) {
            return;
        }
        //扩容1.5倍    >> 1 原来的数除以2      << 1 原来的数乘以2
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        T[] newArray = (T[]) new Object[newCapacity];

        for (int i = 0; i < items.length; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
    }


    /**
     * 获取index元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (index < 0 || index > SIZE) {
            throw new RuntimeException("Index:" + index + ",Size:" + SIZE);
        }
        return items[index];
    }

    /**
     * 设置index位置的元素
     *
     * @param index
     * @param element
     * @return
     */
    public T set(int index, T element) {
        if (index < 0 || index > SIZE) {
            throw new RuntimeException("Index:" + index + ",Size:" + SIZE);
        }
        T ele = items[index];
        items[index] = element;
        return ele;
    }

    /**
     * 删除index位置对应的元素
     * 元素往前移动
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        //数组是否越界
        if (index < 0 || index > SIZE) {
            throw new RuntimeException("Index:" + index + ",Size:" + SIZE);
        }
        T element = items[index];

        for (int i = index + 1; i < SIZE; i++) {
            items[i - 1] = items[i];
        }
        items[--SIZE] = null;
        trim();
        return element;
    }

    /**
     * 查看元素的位置
     *
     * @param element
     * @return
     */
    public int indexOf(T element) {
        for (int i = 0; i < SIZE; i++) {
            if (items[i] == element) {
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 清除所有元素
     */
    public void clear() {
        SIZE = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < SIZE; i++) {
            stringBuilder.append(" " + items[i]);
        }
        stringBuilder.append("},size:" + SIZE);

        return stringBuilder.toString();
    }

    public int length() {
        return items.length;
    }
}
