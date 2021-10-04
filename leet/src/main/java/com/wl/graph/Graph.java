package com.wl.graph;

import java.util.ArrayList;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public interface Graph<V, E> {
    /**
     * 边的数量
     *
     * @return
     */
    int edgesSize();

    /**
     * 顶点数量
     *
     * @return
     */
    int vertexSize();


    /**
     * 添加顶点
     *
     * @param v
     */
    void addVertex(V v);

    /**
     * 添加边，带权值
     *
     * @param from   起点
     * @param to     终点
     * @param weight 权值
     */
    void addEdge(V from, V to, E weight);

    /**
     * 添加边,没有权值
     *
     * @param from 起点
     * @param to   终点
     */
    void addEdge(V from, V to);


    /**
     * 删除顶点
     *
     * @param v
     */
    void removeVertex(V v);

    /**
     * 删除边
     *
     * @param from 起点
     * @param to   终点
     */
    void removeEdge(V from, V to);


    /**
     * bfs 广度优先遍历
     *
     * @param v 访问起点
     * @return
     */
    ArrayList<GraphImp.Vertex<V, E>> bfs(V v);

    /**
     * dfs 深度优先遍历
     *
     * @param v 访问起点
     * @return
     */
    ArrayList<GraphImp.Vertex<V, E>> dfs(V v);

    /**
     * AOV 拓扑排序 卡恩算法
     *
     * @return
     */
    ArrayList<GraphImp.Vertex<V, E>> topologicSort();
}
