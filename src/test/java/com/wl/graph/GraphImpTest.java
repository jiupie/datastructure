package com.wl.graph;

import org.junit.Before;
import org.junit.Test;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class GraphImpTest {
    private static GraphImp<Object, Double> graph;

    @Before
    public void init() {
        graph = (GraphImp<Object, Double>) undirectedGraph(Data.SP);
        graph.print();
        System.out.println("============");
    }


    /**
     * 测试图的创建
     */
    @Test
    public void createGraph() {
        graph.print();
    }

    /**
     * 测试顶点删除
     */
    @Test
    public void delete() {
        //移除顶点
        graph.removeVertex("0");
        graph.print();
        graph.removeVertex("1");
        graph.print();
    }

    /**
     * bfs遍历
     */
    @Test
    public void bfs() {
        System.out.println(graph.bfs("A"));
    }

    @Test
    public void dfs() {
//        System.out.println(graph.dfs(1));
//        System.out.println(graph.dfs("a"));
        System.out.println(graph.dfs(1));

    }

    @Test
    public void topologicSort() {
//        System.out.println(graph.topologicSort());
        System.out.println(graph.topologicSort2());
    }

    /**
     * 最小生成树
     */
    @Test
    public void mst() {
        graph.mst().forEach(System.out::println);
    }


    /**
     * 有向图
     */
    private static Graph<Object, Double> directedGraph(Object[][] data) {
        GraphImp<Object, Double> graph = new GraphImp<>();
        for (Object[] edge : data) {
            if (edge.length == 1) {
                graph.addVertex(edge[0]);
            } else if (edge.length == 2) {
                graph.addEdge(edge[0], edge[1]);
            } else if (edge.length == 3) {
                double weight = Double.parseDouble(edge[2].toString());
                graph.addEdge(edge[0], edge[1], weight);
            }
        }
        return graph;
    }

    /**
     * 无向图
     *
     * @param data
     * @return
     */
    private static Graph<Object, Double> undirectedGraph(Object[][] data) {
        GraphImp<Object, Double> graph = new GraphImp<>();
        for (Object[] edge : data) {
            if (edge.length == 1) {
                graph.addVertex(edge[0]);
            } else if (edge.length == 2) {
                graph.addEdge(edge[0], edge[1]);
                graph.addEdge(edge[1], edge[0]);
            } else if (edge.length == 3) {
                double weight = Double.parseDouble(edge[2].toString());
                graph.addEdge(edge[0], edge[1], weight);
                graph.addEdge(edge[1], edge[0], weight);
            }
        }
        return graph;
    }


    @Test
    public void dijkstra() {
        System.out.println(graph.dijkstra("A"));
    }
}