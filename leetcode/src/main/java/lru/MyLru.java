package lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class MyLru {

    private Node<Integer, String> head;
    private Node<Integer, String> tail;
    private int initCapacity;

    class Node<Integer, String> {
        public Node<Integer, String> prev;
        public Node<Integer, String> next;
        private Integer key;
        private String value;

        public Node() {

        }

        public Node(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyLru(int initCapacity) {
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.prev = head;
        this.initCapacity = initCapacity;
    }

    Map<Integer, Node<Integer, String>> hashMap = new HashMap<>();

    public void addHeader(Node<Integer, String> node) {
        Node<Integer, String> next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    public void removeTail() {
        removeNode(tail.prev);
    }

    public void put(Integer key, String value) {
        if (hashMap.containsKey(key)) {
            Node<Integer, String> node = hashMap.get(key);
            hashMap.put(key, node);
            removeNode(node);
            addHeader(node);
        } else {
            Node<Integer, String> node = new Node<>(key, value);
            hashMap.put(key, node);
            if (hashMap.size() > initCapacity) {
                hashMap.remove(tail.prev.key);
                removeTail();
                addHeader(node);
            } else {
                addHeader(node);
            }
        }
    }

    private void removeNode(Node<Integer, String> node) {
        Node<Integer, String> prev = node.prev;
        Node<Integer, String> next = node.next;
        prev.next = next;
        next.prev = prev;

        node.prev = null;
        node.next = null;
    }

    public String get(Integer key) {
        if (hashMap.containsKey(key)) {
            Node<Integer, String> node = hashMap.get(key);
            removeNode(node);
            addHeader(node);
            return node.value;
        } else {
            return null;
        }
    }


    public static void main(String[] args) {
        MyLru myLru = new MyLru(3);
        myLru.put(1, "1");
        myLru.put(2, "2");
        myLru.put(3, "3");
        System.out.println(myLru.hashMap.keySet());

        myLru.put(4, "4");
        System.out.println(myLru.hashMap.keySet());

        myLru.put(3, "1");
        System.out.println(myLru.hashMap.keySet());
        myLru.put(3, "1");
        System.out.println(myLru.hashMap.keySet());
        myLru.put(3, "1");
        System.out.println(myLru.hashMap.keySet());
        myLru.put(5, "1");
        System.out.println(myLru.hashMap.keySet());
    }
}
