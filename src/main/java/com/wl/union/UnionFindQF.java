package com.wl.union;

/**
 * quick find
 * <p>
 * 合并 O(n)
 * 查询 O(1)
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class UnionFindQF implements UnionFind {
    private int[] container;

    public UnionFindQF(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("capacity must be >0");
        }
        container = new int[capacity];
        //初始化
        for (int i = 0; i < container.length; i++) {
            container[i] = i;
        }
    }

    /**
     * 查询 O(1)
     *
     * @param v
     * @return
     */
    @Override
    public int find(int v) {
        return container[v];
    }

    /**
     * v1 所在集合的所有元素都指向 v2 的根节点。
     *
     * @param v1
     * @param v2
     * @return 根元素
     */
    @Override
    public int union(int v1, int v2) {
        int parent = find(v2);
        int temp = container[v1];
        for (int i = 0; i < container.length; i++) {
            if (container[i] == temp) {
                container[i] = parent;
            }
        }
        return parent;
    }

    @Override
    public boolean isSame(int v1, int v2) {
        return find(v1) == find(v2);
    }
}
