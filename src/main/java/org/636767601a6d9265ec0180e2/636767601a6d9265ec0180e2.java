import java.util.*;
import org.apache.commons.lang3.tuple.Pair;

public class SeparatorComputer {

    private Graph<V,E> graph; // Graph instance variable
    
    private List<Pair<List<Pair<Integer,Integer>>,E>> computeGlobalSeparatorList() {
        List<Pair<List<Pair<Integer,Integer>>,E>> globalSeparators = new ArrayList<>();
        
        // Iterate through all edges in the graph
        for (E edge : graph.edgeSet()) {
            // Get vertices incident to edge
            V source = graph.getEdgeSource(edge);
            V target = graph.getEdgeTarget(edge);
            
            // Get neighborhood subgraph around edge
            Set<V> neighborhood = new HashSet<>();
            neighborhood.add(source);
            neighborhood.add(target);
            neighborhood.addAll(Graphs.neighborListOf(graph, source));
            neighborhood.addAll(Graphs.neighborListOf(graph, target));
            
            Graph<V,E> subgraph = new AsSubgraph<>(graph, neighborhood);
            
            // Find minimal separators in neighborhood
            List<Pair<Integer,Integer>> separators = findMinimalSeparators(subgraph, source, target);
            
            // Add separators with associated edge to global list
            globalSeparators.add(Pair.of(separators, edge));
        }
        
        return globalSeparators;
    }
    
    // Helper method to find minimal separators between two vertices
    private List<Pair<Integer,Integer>> findMinimalSeparators(Graph<V,E> graph, V source, V target) {
        List<Pair<Integer,Integer>> separators = new ArrayList<>();
        
        // Use max flow / min cut to find minimal separators
        EdmondsKarpMFImpl<V,E> maxFlow = new EdmondsKarpMFImpl<>(graph);
        
        for (V u : graph.vertexSet()) {
            for (V v : graph.vertexSet()) {
                if (u == v) continue;
                
                double flow = maxFlow.calculateMaximumFlow(u, v);
                if (flow > 0) {
                    separators.add(Pair.of(graph.getVertexIndex(u), graph.getVertexIndex(v)));
                }
            }
        }
        
        return separators;
    }
}