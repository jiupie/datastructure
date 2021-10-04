package com.wl.union;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 使用链表+映射（Map）
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class GenericUnionFind<V> {
    private Map<V, Node<V>> nodes = new HashMap<>();

    public void makeSet(V v) {
        if (nodes.containsKey(v)) {
            return;
        }
        nodes.put(v, new Node<>(v));
    }

    /**
     * 找出v的根结点
     */
    private Node<V> findNode(V v) {
       /* Node<V> node = nodes.get(v);
        if (node == null) {
            return null;
        }
        while (node.parent != null && node.parent != node) {
            node = node.parent.parent;
        }
        return node;*/
        Node<V> node = nodes.get(v);
        if (node == null) {
            return null;
        }
        while (!Objects.equals(node.value, node.parent.value)) {
            node.parent = node.parent.parent;
            node = node.parent;
        }
        return node;
    }

    public void union(V v1, V v2) {
        Node<V> p1 = findNode(v1);
        Node<V> p2 = findNode(v2);
        if (p1 == null || p2 == null) {
            return;
        }
        if (Objects.equals(p1.value, p2.value)) {
            return;
        }
        if (p1.rank < p2.rank) {
            p1.parent = p2;
        } else if (p1.rank > p2.rank) {
            p2.parent = p1;
        } else {
            p1.parent = p2;
            p1.rank += 1;
        }
    }


    public V find(V v) {
        Node<V> node = findNode(v);
        return node == null ? null : node.value;
    }

    public boolean isSame(V v1, V v2) {
        return Objects.equals(find(v1), find(v2));
    }

    private static class Node<V> {
        //父节点
        Node<V> parent = this;
        //树高度
        int rank = 1;
        //值
        V value;

        public Node(V value) {
            this.value = value;
        }
    }
}
