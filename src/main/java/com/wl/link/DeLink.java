package com.wl.link;

import com.wl.practice.josephs.DeLinkCircle;

/**
 * DeLink class
 * 双向链表
 *
 * @author 南顾北衫
 * @date 2020/9/16 15:41
 * @email 17674641491@163.com
 */
public class DeLink<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;
    private static final int ELEMENT_NOT_FOUND = -1;

    public DeLink() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    public Node<T> node(int index) {
        rangeCheck(index);
        int length = size >> 1;
        Node<T> node;
        if (index < length) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }

        return node;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) == ELEMENT_NOT_FOUND ? false : true;
    }

    @Override
    public void add(T element) {
        add(size, element);
    }

    @Override
    public T get(int index) {
        return (T) node(index);
    }

    @Override
    public T set(int index, T element) {
        Node<T> node = node(index);
        node.element = element;
        return element;
    }

    /**
     * 添加节点，要注意第0个节点和最后一个节点
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, T element) {
        //索引检查
        rangeCheck(index);
        Node<T> newNode;
        //要添加位置的节点
        Node<T> node = node(index);
        if (index == size) {
            if (first == null) {
                newNode = new Node<>(null, null, element);
                first = newNode;
                last = first;
            } else {
                newNode = new Node<>(last, null, element);
                last.next = newNode;
                last = newNode;
            }
        } else {
            Node<T> prev = node.prev;

            //prev为空，说明是第0个节点
            if (prev == null) {
                newNode = new Node<>(null, first, element);
                first.prev = newNode;
                first = newNode;
            } else {
                newNode = new Node<>(prev, node, element);
                prev.next = newNode;
                node.prev = newNode;
            }
        }
        size++;
    }

    /**
     * 移除节点，要注意第0个节点和最后一个节点
     *
     * @param index
     * @return
     */
    @Override
    public T remove(int index) {
        rangeCheck(index);
        //要删除的节点
        Node<T> node = node(index);
        //要删除的后一个节点
        Node<T> next = node.next;
        //要删除的前一个节点
        Node<T> prev = node.prev;

        //prev为空，说明是第0个节点
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }

        //next为空，说明是第最后一个节点
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(T element) {
        if (element == null) {
            Node<T> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            Node<T> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == element) {
                    return i;
                }
                node = node.next;
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    class Node<T> {
        Node<T> prev;
        Node<T> next;
        public T element;

        public Node(Node<T> prev, Node<T> next, T element) {
            this.prev = prev;
            this.next = next;
            this.element = element;
        }

    }

    /**
     * 越界抛出异常
     *
     * @param index
     */
    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    /**
     * 检查是否越界
     *
     * @param index
     */
    protected void rangeCheck(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        Node<T> node = first;
        while (node != null) {
            stringBuilder.append(node.element + " ");
            node = node.next;
        }
        stringBuilder.append("},size:" + size);
        return stringBuilder.toString();
    }
}
