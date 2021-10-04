package com.wl.union;

/**
 * 并查集 quick union 基于rank优化，增加树的高度，主要是修改合并的方法，将树高度低的树嫁接到高的树上
 * 路径减半：使路径上每隔一个节点就指向其祖父节点（parent的parent）。
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class UnionFindQU_Rank_PH implements UnionFind {
    private int[] container;
    private int[] heights;

    public UnionFindQU_Rank_PH(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("capacity must be >0");
        }
        container = new int[capacity];
        for (int i = 0; i < container.length; i++) {
            container[i] = i;
        }
        heights = new int[capacity];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = 1;
        }

    }

    /**
     * 查找，主要是查询根元素返回根元素
     * 路径减半：使路径上每隔一个节点就指向其祖父节点（parent的parent）。
     *
     * @param v
     * @return 根元素
     */
    @Override
    public int find(int v) {
        while (v != container[v]) {
            container[v] = container[container[v]];
            v = container[v];
        }
        return v;
    }

    /**
     * 基于树的高度
     * 让矮的树嫁接到高的树上
     * <p>
     * 数组的索引存的是内容，数组的内容存的是根节点
     * <p>
     * 只需要再树的高度相等的时候才修改树的高度
     *
     * @param v1
     * @param v2
     * @return
     */
    @Override
    public int union(int v1, int v2) {
        v1 = find(v1);
        v2 = find(v2);
        if (heights[v1] > heights[v2]) {
            container[v2] = v1;
        } else if (heights[v1] < heights[v2]) {
            container[v1] = v2;
        } else {
            container[v1] = v2;
            heights[v2] += 1;
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
