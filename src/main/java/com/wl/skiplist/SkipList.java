package com.wl.skiplist;

import java.util.Comparator;
import java.util.Random;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class SkipList<K extends Comparable, V> {

    private int MAX_LEVEL = 32;
    private double CHANCE = 0.5;

    private Comparator<K> comparator;

    //头节点，必须要是最大层数
    private Node<K, V> first;

    private int level = 0;

    //总数量
    private int size = 0;

    public SkipList(Comparator<K> comparator) {
        this.comparator = comparator;
        first = new Node<>(null, null, new Node[MAX_LEVEL]);
    }

    public SkipList() {
        this(null);
    }


    /**
     * 查找节点
     * 1.搜索的值大于该节点的KEY，把该节点赋值给当前节点
     * 2.搜索的值小于该节点的KEY，往下走一层
     *
     * @param key
     * @return
     */
    public Node<K, V> find(K key) {
        checkKey(key);
        Node<K, V> node = first;
        for (int i = level - 1; i >= 0; i--) {

            while (node.nexts[i] != null && cmp(key, node.nexts[i].key) < 0) {
                node = node.nexts[i];
            }
            if (node.nexts[i] != null && node.nexts[i].key == key) {
                return node.nexts[i];
            }
        }
        return null;
    }

    /**
     * 添加
     * 首先计算层数,创建节点
     *
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        Node<K, V> node = first;
        Node<K, V>[] pres = new Node[level];

        //找到节点的位置
        for (int i = level - 1; i >= 0; i--) {
            while (node.nexts[i] != null && cmp(key, node.nexts[i].key) < 0) {
                node = node.nexts[i];
            }
            //说明已经存在了
            if (node.nexts[i] != null && node.nexts[i].key == key) {
                node.nexts[i].value = value;
                return;
            }
            pres[i] = node;
        }

        //来到这里说明是没有找到是可以新增的，并且已经到了第0层
        int newLevel = randomLevel();

        Node<K, V> newNode = new Node<>(key, value, new Node[newLevel]);
        for (int i = 0; i < newLevel; i++) {
            if (i >= level) {
                first.nexts[i] = newNode;
            } else {
                newNode.nexts[i] = pres[i].nexts[i];
                pres[i].nexts[i] = newNode;
            }
        }
        level = Math.max(newLevel, level);
        size++;
    }

    /**
     * 移除
     *
     * @param key
     */
    public Node<K, V> remove(K key) {
        //节点
        Node<K, V> node = first;
        Node<K, V> oldNode = null;
        Node<K, V>[] prev = new Node[level];
        int cmp = -1;
        boolean exist = false;
        for (int i = level - 1; i >= 0; i--) {
            while (node.nexts[i] != null && (cmp = cmp(key, node.nexts[i].key)) < 0) {
                node = node.nexts[i];
            }
            //说明已经存在了
            if (cmp == 0) {
                exist = true;
            }
            prev[i] = node;
        }
        if (!exist) {
            return null;
        }

        oldNode = node.nexts[0];

        for (int i = 0; i < oldNode.nexts.length; i++) {
            prev[i].nexts[i] = oldNode.nexts[i];
        }
        //更新有效层数
        int newLevel = level;

        while (--newLevel > 0 && first.nexts[newLevel] == null) {
            level = newLevel;
        }
        size--;
        return oldNode;
    }

    /**
     * 随机层数
     *
     * @return
     */
    int randomLevel() {
        int maxLevel = 1;
        //0-0.999
        Random random = new Random();
        while (random.nextDouble() < CHANCE && maxLevel < MAX_LEVEL) {
            maxLevel++;
        }
        return maxLevel;
    }

    void checkKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("不能为null");
        }
    }

    int cmp(K k1, K k2) {
        if (comparator == null) {
            return k1.compareTo(k2);
        } else {
            return comparator.compare(k1, k2);
        }
    }


    class Node<K, V> {
        public Node(K key, V value, Node<K, V>[] nexts) {
            this.key = key;
            this.value = value;
            this.nexts = nexts;
        }

        public K key;
        public V value;
        public Node<K, V> nexts[];

        @Override
        public String toString() {
            return key + ":" + value + "_" + nexts.length;
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("一共" + level + "层").append("\n");
        for (int i = level - 1; i >= 0; i--) {
            Node<K, V> node = first;
            while (node.nexts[i] != null) {
                sb.append(node.nexts[i]);
                sb.append("\t");
                node = node.nexts[i];
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
