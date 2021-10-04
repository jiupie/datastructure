package com.wl.union;

/**
 * 并查集 quick union
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class UnionFindQU implements UnionFind {
    private int[] container;

    public UnionFindQU(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("capacity must be >0");
        }
        container = new int[capacity];
        for (int i = 0; i < container.length; i++) {
            container[i] = i;
        }
    }

    /**
     * 查找，主要是查询根元素返回根元素
     *
     * @param v
     * @return 根元素
     */
    @Override
    public int find(int v) {
        while (container[v] != v) {
            v = container[v];
        }
        return v;
    }

    /**
     * 让v1的根节点指向v2的根节点
     * 数组的索引存的是内容，数组的内容存的是根节点
     *
     * @param v1
     * @param v2
     * @return
     */
    @Override
    public int union(int v1, int v2) {
        v1 = find(v1);
        v2 = find(v2);
        container[v1] = v2;
        return 0;
    }

    /**
     * 查看是否在同一个集合中
     *
     * @param v1
     * @param v2
     * @return
     */
    @Override
    public boolean isSame(int v1, int v2) {
        return find(v1) == find(v2);
    }
}
