package org;

import java.util.HashMap;
import java.util.Map;

public class Class636767601a6d9265ec0180fd<V, E> {
    private Map<V, Map<V, E>> adjacencyList;

    public Class636767601a6d9265ec0180fd() {
        adjacencyList = new HashMap<>();
    }

    /** 
     * Aggiunge un arco all'indice.
     * @param sourceVertex il vertice sorgente
     * @param targetVertex il vertice di destinazione
     * @param e l'arco
     */
    protected void addToIndex(V sourceVertex, V targetVertex, E e) {
        adjacencyList.putIfAbsent(sourceVertex, new HashMap<>());
        adjacencyList.get(sourceVertex).put(targetVertex, e);
    }
}