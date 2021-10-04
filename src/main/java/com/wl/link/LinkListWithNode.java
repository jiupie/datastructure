package com.wl.link;

/**
 * LinkList class
 * 单向链表带有虚拟头结点
 *
 * @author 南顾北衫
 * @date 2020/9/8 15:56
 * @email 17674641491@163.com
 */
public class LinkListWithNode<E> implements List<E> {
    private int size;

    public LinkListWithNode() {
        first = new Node<>(null, null);
    }

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
        add(size, element);
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
     * 修改
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        Node<E> node = index == 0 ? first : node(index - 1);
        node.next = new Node<>(node.next, element);
        size++;
    }

    /**
     * 通过索引移除元素
     * 找前一个索引元素
     * 修改
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = index == 0 ? first : node(index - 1);
        Node<E> oldNode = node.next;
        node.next = oldNode.next;
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
     * 修改
     *
     * @param index
     * @return
     */
    public Node node(int index) {
        rangeCheck(index);
        Node<E> node = first.next;
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
     * 修改
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        Node<E> node = first.next;
        while (node != null) {
            stringBuilder.append(node.element + " ");
            node = node.next;
        }
        stringBuilder.append("},size:" + size);
        return stringBuilder.toString();
    }
}
