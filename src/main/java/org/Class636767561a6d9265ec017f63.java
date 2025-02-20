package org;

import java.util.Iterator;
import java.util.List;

public class Class636767561a6d9265ec017f63 implements Iterator<Vertex> {
    private List<Vertex> vertices;
    private boolean[] visited;
    private int currentIndex;

    public Class636767561a6d9265ec017f63(List<Vertex> vertices) {
        this.vertices = vertices;
        this.visited = new boolean[vertices.size()];
        this.currentIndex = 0;
    }

    /** 
     * Controlla se esistono vertici non visitati.
     * @return true se esistono vertici non visitati.
     */
    @Override 
    public boolean hasNext() {
        while (currentIndex < vertices.size()) {
            if (!visited[currentIndex]) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    // Other methods like next() and remove() would be implemented here
}

class Vertex {
    // Vertex implementation
}