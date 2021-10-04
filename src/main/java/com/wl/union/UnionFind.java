package com.wl.union;

/**
 * 并查集接口
 * 数组索引存的是元素，数组内容存的是根节点
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public interface UnionFind {
    /**
     * 查找元素
     *
     * @param v
     * @return
     */
    int find(int v);

    /**
     * 合并元素
     *
     * @param v1
     * @param v2
     * @return
     */
    int union(int v1, int v2);

    /**
     * 查询是否在同一个集合中
     *
     * @param v1
     * @param v2
     * @return
     */
    boolean isSame(int v1, int v2);
}
