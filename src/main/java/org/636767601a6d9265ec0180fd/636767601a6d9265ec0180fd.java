import java.util.HashMap;
import java.util.Map;

public class Graph<V, E> {
    private Map<V, Map<V, E>> adjacencyMap;

    public Graph() {
        this.adjacencyMap = new HashMap<>();
    }

    /**
     * Add an edge to the index.
     * @param sourceVertex the source vertex
     * @param targetVertex the target vertex
     * @param e the edge
     */
    protected void addToIndex(V sourceVertex, V targetVertex, E e) {
        // Ensure the source vertex exists in the adjacency map
        adjacencyMap.putIfAbsent(sourceVertex, new HashMap<>());
        
        // Add the edge from sourceVertex to targetVertex
        adjacencyMap.get(sourceVertex).put(targetVertex, e);
    }
}