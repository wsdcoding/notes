package com.wsdcoding.graph;

/**
 * @Description:
 * @Authror wsdcoding
 */
public abstract class Graph<V, E> {
    /**
     * @return
     * @Description: 接口设计
     */
    public abstract int edgesSize();

    public abstract int verticesSize();

    public abstract void addVertex(V v);

    public abstract void addEdge(V from, V to);

    public abstract void addEdge(V from, V to, E weight);

    public abstract void removeVertex(V v);

    public abstract void removeEdge(V frome, V to);


}
