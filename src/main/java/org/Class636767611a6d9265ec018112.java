package org;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Class636767611a6d9265ec018112<V> {
    private Iterator<V> vertexIterator;

    public Class636767611a6d9265ec018112(Iterator<V> vertexIterator) {
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