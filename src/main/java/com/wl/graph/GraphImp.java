package com.wl.graph;

import com.wl.union.GenericUnionFind;

import java.util.*;

/**
 * 邻接表实现图
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class GraphImp<V, E extends Comparable> implements Graph<V, E> {

    /**
     * 传入V获取对应的顶点 ，也可以看做是存储顶点的map
     */
    private Map<V, Vertex<V, E>> map = new HashMap<>();

    /**
     * 存储边
     */
    private Set<Edge<V, E>> edges = new HashSet<>();

    public void print() {
        System.out.println("[顶点] 一共有" + map.size() + "个顶点");
        map.forEach((k, v) -> {
            System.out.println(v);
        });
        System.out.println("[边] 一共有" + edges.size() + "条边");
        edges.forEach((v) -> {
            System.out.println(v);
        });
    }

    @Override
    public int edgesSize() {
        return edges.size();
    }

    @Override
    public int vertexSize() {
        return map.size();
    }

    @Override
    public void addVertex(V v) {
        //判断是否存在该顶点，存在就不添加了
        if (map.containsKey(v)) {
            return;
        }
        //添加点到map中
        map.put(v, new Vertex<>(v));
    }

    @Override
    public void addEdge(V from, V to, E weight) {
        Vertex<V, E> fromVertex;
        Vertex<V, E> toVertex;
        //添加起点
        if ((fromVertex = map.get(from)) == null) {
            //添加点到map中
            fromVertex = new Vertex<>(from);
            map.put(from, fromVertex);
        }
        //添加终点
        if ((toVertex = map.get(to)) == null) {
            //添加点到map中
            toVertex = new Vertex<>(to);
            map.put(to, toVertex);
        }

        //创建边
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex, weight);
        //添加边到edges中
        edges.add(edge);

        fromVertex.outEdge.add(edge);
        toVertex.inEdge.add(edge);
    }

    @Override
    public void addEdge(V from, V to) {
        addEdge(from, to, null);
    }

    @Override
    public void removeVertex(V v) {
        Vertex<V, E> vertex;
        if ((vertex = map.get(v)) == null) {
            return;
        }
        //入度边，终点,
        Set<Edge<V, E>> inEdge = vertex.inEdge;
        inEdge.forEach((Edge<V, E> edge) -> {
            edge.fromVertex.outEdge.remove(edge);
            edges.remove(edge);
        });
        //出度边， 起点 ，
        Set<Edge<V, E>> outEdge = vertex.outEdge;
        outEdge.forEach((Edge<V, E> edge) -> {
            //
            edge.toVertex.inEdge.remove(edge);
            edges.remove(edge);
        });
        //从map中删除该顶点
        map.remove(v);

    }

    @Override
    public void removeEdge(V from, V to) {
        removeVertex(from);
        removeVertex(to);
    }


    /**
     * 广度遍历算法
     *
     * @param v 起点，开始遍历的起点
     * @return
     */
    @Override
    public ArrayList<Vertex<V, E>> bfs(V v) {
        Vertex<V, E> vertex;
        if ((vertex = map.get(v)) == null) {
            return null;
        }
        //存储bfs遍历的结果
        ArrayList<Vertex<V, E>> vertexArrayList = new ArrayList<>(map.size());

        //set存储已经遍历过的顶点
        HashSet<Vertex<V, E>> vertexHashSet = new HashSet<>();
        //队列，存储临时节点
        Queue<Vertex<V, E>> queue = new LinkedList<>();
        //把起点放入队列
        queue.offer(vertex);
        //如果队列不为空继续循环
        while (!queue.isEmpty()) {
            //从队列中取出对头元素
            Vertex<V, E> veVertexPoll = queue.poll();
            //如果已经遍历到的节点不会加入到bfs结果中，和set中
            if (!vertexHashSet.contains(veVertexPoll)) {
                vertexArrayList.add(veVertexPoll);
                vertexHashSet.add(veVertexPoll);
            }

            for (Edge<V, E> veEdge : veVertexPoll.outEdge) {
                if (!vertexHashSet.contains(veEdge.toVertex)) {
                    queue.offer(veEdge.toVertex);
                }
            }
        }
        return vertexArrayList;

    }

    @Override
    public ArrayList<Vertex<V, E>> dfs(V v) {
        Vertex<V, E> vertex;
        if ((vertex = map.get(v)) == null) {
            return null;
        }
      /*  ArrayList<Vertex<V, E>> list = new ArrayList<>();
        HashSet<Vertex<V, E>> hashSet = new HashSet<>();
        dfs(vertex, hashSet, list);*/
        ArrayList<Vertex<V, E>> list = dfs(vertex);
        return list;
    }

    /**
     * 拓扑排序
     * 有环会造成死循环（不推荐使用）
     *
     * @return
     */
    @Override
    public ArrayList<Vertex<V, E>> topologicSort() {
        //为了不破坏图原来的结构,新增一个hashmap存储顶点的入度
        HashMap<Vertex<V, E>, Integer> hashMap = new HashMap<>();

        //存储拓扑排序结果
        ArrayList<Vertex<V, E>> list = new ArrayList<>();

        //遍历所有顶点，并且把顶点的入度放入map中
        map.forEach((V v, Vertex<V, E> vertex) -> {
            hashMap.put(vertex, vertex.inEdge.size());
        });

        //获取hashmap中的顶点和入度数
        Set<Map.Entry<Vertex<V, E>, Integer>> vertices = hashMap.entrySet();

        //只有当拓扑排序结果的顶点数等于图的顶点数时才退出循环
        while (list.size() != map.size()) {
            Iterator<Map.Entry<Vertex<V, E>, Integer>> iterator = vertices.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Vertex<V, E>, Integer> next = iterator.next();
                //如果hashmap的value等于0，说明入度为0，可以输出
                if (next.getValue() == 0) {
                    list.add(next.getKey());
                    //获取到入度为0顶点的出度边
                    Set<Edge<V, E>> outEdge = next.getKey().outEdge;
                    //把出度边的 顶点to的入度减1
                    for (Edge<V, E> veEdge : outEdge) {
                        Integer integer = hashMap.get(veEdge.toVertex);
                        hashMap.put(veEdge.toVertex, --integer);
                    }
                    //把当前元素从hashmap中移除，说明改元素已经输出了。
                    iterator.remove();
                }
            }
        }
        return list;
    }

    /**
     * 使用队列
     * 小码哥
     *
     * @return
     */
    public ArrayList<Vertex<V, E>> topologicSort2() {
        //为了不破坏图原来的结构,新增一个hashmap存储顶点的入度
        HashMap<Vertex<V, E>, Integer> hashMap = new HashMap<>();

        //存储拓扑排序结果
        ArrayList<Vertex<V, E>> list = new ArrayList<>();

        Queue<Vertex<V, E>> queue = new LinkedList<>();

        //遍历所有顶点，并且把顶点的入度放入map中
        map.forEach((V v, Vertex<V, E> vertex) -> {
            int inSize = vertex.inEdge.size();
            if (inSize == 0) {
                queue.offer(vertex);
            } else {
                hashMap.put(vertex, vertex.inEdge.size());
            }
        });

        while (!queue.isEmpty()) {
            Vertex<V, E> poll = queue.poll();
            list.add(poll);
            for (Edge<V, E> veEdge : poll.outEdge) {
                int inSize = hashMap.get(veEdge.toVertex) - 1;
                if (inSize == 0) {
                    queue.offer(veEdge.toVertex);
                } else {
                    hashMap.put(veEdge.toVertex, inSize);
                }
            }
        }
        return list;
    }

    /**
     * 递归实现dfs
     *
     * @param vertex
     * @param set
     * @param list
     */
    public void dfs(Vertex<V, E> vertex, Set<Vertex<V, E>> set, ArrayList<Vertex<V, E>> list) {
        if (vertex == null) {
            return;
        }
        list.add(vertex);
        set.add(vertex);
        for (Edge<V, E> veEdge : vertex.outEdge) {
            if (set.contains(veEdge.toVertex)) {
                continue;
            }
            dfs(veEdge.toVertex, set, list);
        }
    }

    /**
     * 非递归dfs遍历
     * 每次只进一条边
     *
     * @param vertex
     * @return
     */
    public ArrayList<Vertex<V, E>> dfs(Vertex<V, E> vertex) {
        //栈
        Stack<Vertex<V, E>> stack = new Stack<>();
        //set,存储已经遍历过顶点，防止重复遍历
        HashSet<Vertex<V, E>> hashSet = new HashSet<>();
        //存储遍历结果
        ArrayList<Vertex<V, E>> list = new ArrayList<>();

        //把起点顶点入栈
        stack.push(vertex);

        while (!stack.isEmpty()) {
            //出栈
            Vertex<V, E> pop = stack.pop();
            //把结果加入遍历结果中
            if (!hashSet.contains(pop)) {
                list.add(pop);
                //把to加入到访问过的set中
                hashSet.add(pop);
            }
            //循环出栈的出度边
            for (Edge<V, E> veEdge : pop.outEdge) {
                if (hashSet.contains(veEdge.toVertex)) {
                    continue;
                }
                //选择一条边的from to，入栈
                stack.push(veEdge.fromVertex);
                stack.push(veEdge.toVertex);
                break;
            }
        }
        return list;

    }

    /**
     * 顶点类
     */
    static class Vertex<V, E> {
        //值
        V value;

        //入度，也就是终点指向这个点的边
        Set<Edge<V, E>> inEdge = new HashSet<>();
        //出度，起点指向该点的边
        Set<Edge<V, E>> outEdge = new HashSet<>();

        public Vertex(V value, Set<Edge<V, E>> inEdge, Set<Edge<V, E>> outEdge) {
            this.value = value;
            this.inEdge = inEdge;
            this.outEdge = outEdge;
        }

        public Vertex(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Vertex)) {
                return false;
            }

            Vertex<?, ?> vertex = (Vertex<?, ?>) o;

            if (value != null && vertex.value != null && value.equals(vertex.value)) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return value != null ? value.hashCode() : 0;
        }

        @Override
        public String toString() {
            return value == null ? "null" : value.toString();
        }
    }

    /**
     * 边类
     *
     * @param <V>
     * @param <E>
     */
    static class Edge<V, E> {
        public Edge(Vertex<V, E> fromVertex, Vertex<V, E> toVertex, E weight) {
            this.fromVertex = fromVertex;
            this.toVertex = toVertex;
            this.weight = weight;
        }

        //该边的起点
        Vertex<V, E> fromVertex;

        //该边的终点
        Vertex<V, E> toVertex;

        //权值
        E weight;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Edge)) {
                return false;
            }

            Edge<?, ?> edge = (Edge<?, ?>) o;

            if (fromVertex != null ? !fromVertex.equals(edge.fromVertex) : edge.fromVertex != null) {
                return false;
            }
            if (toVertex != null ? !toVertex.equals(edge.toVertex) : edge.toVertex != null) {
                return false;
            }
            return weight != null ? weight.equals(edge.weight) : edge.weight == null;
        }

        @Override
        public int hashCode() {
            int result = fromVertex != null ? fromVertex.hashCode() : 0;
            result = 31 * result + (toVertex != null ? toVertex.hashCode() : 0);
            result = 31 * result + (weight != null ? weight.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Edge [from=" + fromVertex + ", to=" + toVertex + ", weight=" + weight + "]";
        }


    }


    public Set<Edge<V, E>> mst() {
//        return prim();
        return kruskal();
    }

    /**
     * prim算法
     * 最小生成树，从一个顶点出发
     *
     * @return
     */
    private Set<Edge<V, E>> prim() {
        //存储已经遍历过的边
        HashSet<Edge<V, E>> edges = new HashSet<>();

        Iterator<Vertex<V, E>> iterator = map.values().iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        // 标记已经添加的顶点
        Set<Vertex<V, E>> addedVertices = new HashSet<>();

        //获取一个顶点
        Vertex<V, E> vertex = iterator.next();
        addedVertices.add(vertex);

        //小顶堆
        PriorityQueue<Edge<V, E>> priorityQueue = new PriorityQueue<>(new Comparator<Edge<V, E>>() {
            @Override
            public int compare(Edge<V, E> o1, Edge<V, E> o2) {
                return o1.weight.compareTo(o2.weight);
            }
        });

        vertex.outEdge.forEach((outEdge -> priorityQueue.add(outEdge)));

        while (!priorityQueue.isEmpty() && addedVertices.size() < map.size()) {
            //取出最小值
            Edge<V, E> poll = priorityQueue.poll();
            //判断边的终点是否在已经访问过的set中
            if (addedVertices.contains(poll.toVertex)) {
                continue;
            }
            edges.add(poll);
            addedVertices.add(poll.toVertex);
            //访问边的出度边
            poll.toVertex.outEdge.forEach((outEdges -> {
                priorityQueue.add(outEdges);
            }));
        }

        return edges;
    }

    /**
     * kruskal
     * 最小生成树，每次选边最小的
     *
     * @return
     */
    private Set<Edge<V, E>> kruskal() {
        //小顶堆
        PriorityQueue<Edge<V, E>> priorityQueue = new PriorityQueue<>(new Comparator<Edge<V, E>>() {
            @Override
            public int compare(Edge<V, E> o1, Edge<V, E> o2) {
                return o1.weight.compareTo(o2.weight);
            }
        });

        //quick union
        GenericUnionFind<Vertex<V, E>> unionFind = new GenericUnionFind<>();

        //把所有的边都加入到小顶堆中
        edges.forEach((edge) -> {
                    priorityQueue.add(edge);
                }
        );

        //把所有的顶点加入到unionfind
        Collection<Vertex<V, E>> values = map.values();
        values.forEach((vertex -> unionFind.makeSet(vertex)));

        //存储已经遍历过的边
        HashSet<Edge<V, E>> edges = new HashSet<>();

        while (!priorityQueue.isEmpty() && edges.size() < vertexSize()) {
            //获取最小边
            Edge<V, E> poll = priorityQueue.poll();
            //判断是否构成了一个环
            if (unionFind.isSame(poll.toVertex, poll.fromVertex)) {
                continue;
            }
            //添加到最小生成树的边里面
            edges.add(poll);
            //并查集中合并 from和to顶点 变成一个村庄里的
            unionFind.union(poll.fromVertex, poll.toVertex);
        }

        return edges;
    }


    /**
     * 迪杰斯特拉算法，求最短路径
     * 不能有负权边和负权环
     * <p>
     * 1.从某个顶点开始出发,找出发顶点的出度边对应的终点，初始化
     * <p>
     * 2.找出当前路径中最短的路径
     * 3.从最短的路径中的终点
     */
    public Map<Vertex<V, E>, Double> dijkstra(String vertex) {
        Vertex<V, E> beginVertex = null;
        if ((beginVertex = map.get(vertex)) == null) {
            return null;
        }
        Map<Vertex<V, E>, Integer> shortPath = new HashMap<>();
        Map<Vertex<V, E>, Double> selectPath = new HashMap<>();
        Map<Vertex<V, E>, Double> mapVer = new HashMap<>();

        //获取起点 出度边的
        Set<Edge<V, E>> outEdge = beginVertex.outEdge;


        //初始化
        for (Edge<V, E> veEdge : outEdge) {
            mapVer.put(veEdge.toVertex, (Double) veEdge.weight);
        }

        while (!mapVer.isEmpty()) {
            //获取最小路径 的点
            Map.Entry<Vertex<V, E>, Double> minPath = getMinPath(mapVer);

            //把选择的最小的边放入选择map中去
            selectPath.put(minPath.getKey(), minPath.getValue());

            //从所有顶点中移除已经选择的边
            mapVer.remove(minPath.getKey());

            for (Edge<V, E> veEdge : minPath.getKey().outEdge) {
                if (selectPath.containsKey(veEdge.toVertex)) {
                    continue;
                }
                Double aDouble = mapVer.get(veEdge.toVertex);
                //说明是没有最小边的
                if (aDouble == null) {
                    mapVer.put(veEdge.toVertex, selectPath.get(veEdge.fromVertex) + (Double) veEdge.weight);
                } else {
                    mapVer.put(veEdge.toVertex, aDouble > selectPath.get(veEdge.fromVertex) + (Double) veEdge.weight ? selectPath.get(veEdge.fromVertex) + (Double) veEdge.weight : aDouble);
                }
            }
        }

        return selectPath;
    }

    public Map.Entry<Vertex<V, E>, Double> getMinPath(Map<Vertex<V, E>, Double> map) {
        //从拉起来的边中选择最小的边
        Set<Map.Entry<Vertex<V, E>, Double>> vertices = map.entrySet();
        Iterator<Map.Entry<Vertex<V, E>, Double>> iterator = vertices.iterator();
        Map.Entry<Vertex<V, E>, Double> minPath = iterator.next();

        //遍历set
        while (iterator.hasNext()) {
            Map.Entry<Vertex<V, E>, Double> next = iterator.next();
            if (next.getValue() < minPath.getValue()) {
                minPath = next;
            }
        }
        return minPath;
    }


}
