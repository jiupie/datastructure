package com.wl.link;

/**
 * LinkListCircle class
 * 循环单链表
 *
 * @author 南顾北衫
 * @date 2020/9/16 18:56
 * @email 17674641491@163.com
 */
public class LinkListCircle<E> implements List<E> {
    private int size;
    private Node<E> first;
    private static final int ELEMENT_NOT_FOUND = -1;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(E element) {
        add(size - 1, element);
    }

    @Override
    public E get(int index) {
        return (E) node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    /**
     * 指定索引添加元素
     * 找前一个索引元素
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForSize(index);
        //是在头结点位置插入节点
        if (index == 0) {
            //first先不能改 因为node()查询的时候需要
            Node newNode = new Node<>(first, element);
            Node last = (size == 0) ? newNode : node(size - 1);
            last.next = newNode;
            first = newNode;
        } else {
            Node<E> node = node(index - 1);
            node.next = new Node<>(node.next, element);
        }
        size++;

    }

    /**
     * 通过索引移除元素
     * 找前一个索引元素
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        Node<E> oldNode = null;
        if (index == 0) {
            //如果只有一个节点
            oldNode = first;
            if (size == 1) {
                first = null;
            } else {
                Node last = node(size - 1);
                first = first.next;
                last.next = first;
            }
        } else {
            Node<E> node = node(index - 1);
            oldNode = node.next;
            node.next = oldNode.next;
        }
        size--;
        return oldNode.element;
    }

    /**
     * 通过元素获取索引位置
     *
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;

            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == element) {
                    return i;
                }
                node = node.next;
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    /**
     * 通过index获取节点
     *
     * @param index
     * @return
     */
    public Node node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 清空链表
     */
    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    /**
     * 节点类
     *
     * @param <E>
     */
    private static class Node<E> {
        private Node<E> next;
        private E element;

        public Node(Node<E> next, E element) {
            this.next = next;
            this.element = element;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(element).append("_").append(next.element);
            return stringBuilder.toString();
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
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    /**
     * 检查是否越界
     * 检查add()的下标越界(可以在size位置添加元素)
     *
     * @param index
     */
    protected void rangeCheckForSize(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[size=").append(size).append(", ");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(node);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }

}
