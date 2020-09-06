package com.wsdcoding.graph;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Description:
 * @Authror wsdcoding
 */
public class ListGraph<V, E> extends Graph<V, E> {
    public ListGraph() {
    }


    public static class Vertex<V, E> {
        V value;
        Set<Edge<V, E>> inEdge = new HashSet<>();
        Set<Edge<V, E>> outEdge = new HashSet<>();
        public Vertex(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex<?, ?> vertex = (Vertex<?, ?>) o;
            return Objects.equals(value, vertex.value) ;
        }

        @Override
        public int hashCode() {
            return value == null ? 0 : value.hashCode();
        }

        @Override
        public String toString() {
           return value == null ? "null" : value.toString();
            //            return "Vertex{" +
//                    "value=" + value +
//                    '}';
        }
    }

    public static class Edge<V, E> {

    }

    @Override
    public int edgesSize() {
        return 0;
    }

    @Override
    public int verticesSize() {
        return 0;
    }

    @Override
    public void addVertex(Object o) {

    }

    @Override
    public void addEdge(Object from, Object to) {

    }

    @Override
    public void addEdge(Object from, Object to, Object weight) {

    }

    @Override
    public void removeVertex(Object o) {

    }

    @Override
    public void removeEdge(Object frome, Object to) {

    }
}
