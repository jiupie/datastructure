package 图;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 684. 冗余连接
 * https://leetcode-cn.com/problems/redundant-connection/
 * 在本问题中, 树指的是一个连通且无环的无向图。
 * <p>
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * <p>
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
 * <p>
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的无向图为:
 * <p>
 * 1
 * <p>
 * / \
 * <p>
 * 2 - 3
 * 示例 2：
 * <p>
 * 输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * 输出: [1,4]
 * 解释: 给定的无向图为:
 * <p>
 * 5 - 1 - 2
 * <p>
 * |   |
 * <p>
 * 4 - 3
 * 注意:
 * <p>
 * 输入的二维数组大小在 3 到 1000。
 * 二维数组中的整数在1到N之间，其中N是输入数组的大小。
 * <p>
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class _684_冗余连接 {
    public static void main(String[] args) {

//        int[][] test = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[][] test = {{1, 4}, {3, 4}, {1, 3}, {1, 2}, {4, 5}};
//        int[][] test = {{1, 2}, {1, 3}, {2, 3}};
//        int[] result = findRedundantConnection1(test);
        int[] result = findRedundantConnection2(test);
        System.out.println("结果：" + Arrays.toString(result));

    }


    /**
     * 使用dfs
     *
     * @param edges
     * @return
     */
    public static int[] findRedundantConnection(int[][] edges) {
        return null;
    }


    /**
     * 使用并查集
     *
     * @param edges
     * @return
     */
    public static int[] findRedundantConnection1(int[][] edges) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            hashSet.add(edges[i][0]);
            hashSet.add(edges[i][1]);
        }

        int[] integers = new int[hashSet.size() + 1];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = i;
        }
        int j = 0;
        for (int i = 0; i < edges.length; i++) {
            if (find(integers, edges[i][0]) == find(integers, edges[i][1])) {
                j = i;
            } else {
                union(integers, edges[i][0], edges[i][1]);
            }
        }
        return edges[j];
    }

    public static void union(int[] u, int v1, int v2) {
        int v1Parent = find(u, v1);
        int v2Parent = find(u, v2);
        u[v1Parent] = v2Parent;
    }

    public static int find(int[] u, int v) {
        while (v != u[v]) {
            v = u[v];
        }
        return v;
    }


    /**
     * 使用拓扑排序
     * 1.转成邻接表
     * 2.入度数组
     * 3.拓扑排序
     *
     * @param edges
     * @return
     */
    public static int[] findRedundantConnection2(int[][] edges) {
        //所有顶点
        HashSet<Integer> vertexSet = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            vertexSet.add(edges[i][0]);
            vertexSet.add(edges[i][1]);
        }
        //邻接表
        HashSet<Integer>[] hashSet = new HashSet[vertexSet.size() + 1];

        for (int i = 0; i < edges.length; i++) {
            //起点
            int from = edges[i][0];
            //终点
            int to = edges[i][1];
            //from to
            if (hashSet[from] == null) {
                hashSet[from] = new HashSet<>();
            }
            hashSet[from].add(to);

            //to from
            if (hashSet[to] == null) {
                hashSet[to] = new HashSet<>();
            }
            hashSet[to].add(from);
        }

        //入度数组
        int[] inDegree = new int[hashSet.length + 1];
        for (int i = 0; i < hashSet.length; i++) {
            if (hashSet[i] != null) {
                inDegree[i] = hashSet[i].size();
            }
        }
        //进行拓扑排序
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 1) {
                queue.offer(i);
            }
        }
        HashSet<Integer> used = new HashSet<>();


        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            used.add(poll);
            if (hashSet[poll] != null) {
                for (Integer integer : hashSet[poll]) {
                    inDegree[integer] = inDegree[integer] - 1;
                    if (inDegree[integer] == 1) {
                        queue.offer(integer);
                    }
                }
            }
        }
        if (used.size() == 1 && used.contains(0)) {
            return edges[edges.length - 1];
        } else {
            int i = 0;
            for (int i1 = 0; i1 < edges.length; i1++) {
                if (!used.contains(edges[i1][0]) && !used.contains(edges[i1][1])) {
                    i = i1;
                }
            }
            return edges[i];
        }
    }


}
