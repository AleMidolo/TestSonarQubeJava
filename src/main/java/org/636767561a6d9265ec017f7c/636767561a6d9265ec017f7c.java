import java.util.*;

public class GraphPathTransformer {
    
    public List<Integer> setToPath(Set<Edge> tour, Graph graph) {
        if (tour == null || tour.isEmpty() || graph == null) {
            return new ArrayList<>();
        }

        List<Integer> path = new ArrayList<>();
        Map<Integer, List<Edge>> adjacencyMap = new HashMap<>();

        // Build adjacency map from edges
        for (Edge edge : tour) {
            adjacencyMap.computeIfAbsent(edge.getSource(), k -> new ArrayList<>()).add(edge);
            adjacencyMap.computeIfAbsent(edge.getDestination(), k -> new ArrayList<>()).add(edge);
        }

        // Start with any vertex that has edges
        int currentVertex = tour.iterator().next().getSource();
        path.add(currentVertex);

        // Build path by following edges
        while (path.size() <= tour.size()) {
            List<Edge> edges = adjacencyMap.get(currentVertex);
            
            // Find unused edge
            Edge nextEdge = null;
            for (Edge edge : edges) {
                if (isEdgeAvailable(edge, path)) {
                    nextEdge = edge;
                    break;
                }
            }

            if (nextEdge == null) {
                break;
            }

            // Add next vertex to path
            currentVertex = (nextEdge.getSource() == currentVertex) ? 
                          nextEdge.getDestination() : nextEdge.getSource();
            path.add(currentVertex);
        }

        return path;
    }

    private boolean isEdgeAvailable(Edge edge, List<Integer> path) {
        // Check if this edge creates a cycle before we're done
        if (path.size() < path.size() - 1) {
            int source = edge.getSource();
            int dest = edge.getDestination();
            
            // Edge is available if one vertex is in path and other isn't
            boolean sourceInPath = path.contains(source);
            boolean destInPath = path.contains(dest);
            return sourceInPath ^ destInPath;
        }
        // For last edge, both vertices should be in path
        return true;
    }

    // Helper classes
    public static class Edge {
        private int source;
        private int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }

        public int getSource() {
            return source;
        }

        public int getDestination() {
            return destination;
        }
    }

    public static class Graph {
        private List<Edge> edges;
        private int vertices;

        public Graph(int vertices) {
            this.vertices = vertices;
            this.edges = new ArrayList<>();
        }

        public void addEdge(Edge edge) {
            edges.add(edge);
        }

        public List<Edge> getEdges() {
            return edges;
        }

        public int getVertices() {
            return vertices;
        }
    }
}