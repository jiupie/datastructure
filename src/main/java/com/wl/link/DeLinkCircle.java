package com.wl.link;

/**
 * DeLink class
 * 双向链表
 *
 * @author 南顾北衫
 * @date 2020/9/16 15:41
 * @email 17674641491@163.com
 */
public class DeLinkCircle<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;
    private static final int ELEMENT_NOT_FOUND = -1;

    public DeLinkCircle() {

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
        //第0个节点和最后一个位置
        if (index == size) {
            //第0个节点
            if (first == null) {
                newNode = new Node<>(null, null, element);
                first = newNode;
                last = newNode;
                newNode.next = newNode;
                newNode.prev = last;
            } else {
                //最后一个位置
                newNode = new Node<>(last, first, element);
                last.next = newNode;
                last = newNode;
                first.prev = last;
            }
        } else {
            Node<T> prev = node.prev;

            //在头结点加入
            if (prev == last) {
                newNode = new Node<>(last, first, element);
                first.prev = newNode;
                first = newNode;
                last.next = first;
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

        //如果他的下一个节点是first节点说明是删除最后一个节点
        if (next == first) {
            prev.next = first;
            last = prev;
            first.prev = prev;
        } else if (prev == last) {
            //如果前一个节点是最后一个节点说明想删除第一个节点
            last.next = next;
            first = next;
            next.prev = last;
        } else {
            prev.next = next;
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

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(prev.element).append("_").append(element).append("_").append(next.element);
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
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[size=").append(size).append(", ");
        Node<T> node = first;
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
