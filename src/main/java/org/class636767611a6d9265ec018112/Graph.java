package org.class636767611a6d9265ec018112;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Graph<V> {
    private Iterator<V> vertexIterator;

    public Graph(Iterator<V> vertexIterator) {
        this.vertexIterator = vertexIterator;
    }

    /** 
     * {@inheritDoc}
     */
    @Override 
    protected V fornireProssimoVertice() {
        if (vertexIterator == null || !vertexIterator.hasNext()) {
            throw new NoSuchElementException("No more vertices available.");
        }
        return vertexIterator.next();
    }
}