import java.util.Iterator;
import java.util.NoSuchElementException;

public class Graph<V> {
    private final Iterator<V> vertexIterator;

    public Graph(Iterator<V> vertexIterator) {
        this.vertexIterator = vertexIterator;
    }

    /** 
     * {@inheritDoc}
     */
    @Override 
    protected V fornireProssimoVertice() {
        if (vertexIterator.hasNext()) {
            return vertexIterator.next();
        } else {
            throw new NoSuchElementException("No more vertices available.");
        }
    }
}