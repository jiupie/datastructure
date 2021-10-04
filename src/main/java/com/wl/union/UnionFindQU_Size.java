package com.wl.union;

/**
 * 并查集 quick union 基于size优化，树的数量优化，
 * 把元素多的嫁接到元素少的上
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class UnionFindQU_Size implements UnionFind {
    private int[] container;
    private int[] sizes;

    public UnionFindQU_Size(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("capacity must be >0");
        }
        container = new int[capacity];
        for (int i = 0; i < container.length; i++) {
            container[i] = i;
        }
        sizes = new int[capacity];
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = 1;
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
        if (v1 == v2) {
            return 0;
        }
        //v2多于v1
        if (sizes[v1] < sizes[v2]) {
            container[v1] = v2;
            sizes[v2] += sizes[v1];
        } else {
            container[v2] = v1;
            sizes[v1] += sizes[v2];
        }
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
