import java.util.HashMap;
import java.util.Map;

public class GraphIndex<V, E> {
    private Map<V, Map<V, E>> index;

    public GraphIndex() {
        index = new HashMap<>();
    }

    /**
     * Aggiunge un arco all'indice.
     * @param sourceVertex il vertice sorgente
     * @param targetVertex il vertice di destinazione
     * @param e l'arco
     */
    protected void addToIndex(V sourceVertex, V targetVertex, E e) {
        if (!index.containsKey(sourceVertex)) {
            index.put(sourceVertex, new HashMap<>());
        }
        index.get(sourceVertex).put(targetVertex, e);
    }
}