import java.util.HashMap;
import java.util.Map;

public class Graph<V, E> {
    private Map<V, Map<V, E>> adjacencyMap;

    public Graph() {
        adjacencyMap = new HashMap<>();
    }

    /**
     * अनुक्रमणिका में एक किनारा जोड़ें।
     * @param sourceVertex स्रोत वर्टेक्स
     * @param targetVertex लक्ष्य वर्टेक्स
     * @param e किनारा
     */
    protected void addToIndex(V sourceVertex, V targetVertex, E e) {
        if (!adjacencyMap.containsKey(sourceVertex)) {
            adjacencyMap.put(sourceVertex, new HashMap<>());
        }
        adjacencyMap.get(sourceVertex).put(targetVertex, e);
    }

    // Optional: Method to get the adjacency map for testing or other purposes
    public Map<V, Map<V, E>> getAdjacencyMap() {
        return adjacencyMap;
    }
}