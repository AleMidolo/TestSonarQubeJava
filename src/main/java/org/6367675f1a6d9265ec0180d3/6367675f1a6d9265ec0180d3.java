import org.jgrapht.Graph;
import org.jgrapht.alg.isomorphism.IsomorphicGraphMapping;

import java.util.HashMap;
import java.util.Map;

public class GraphUtils {

    /**
     * Calcula un automorfismo de identidad (es decir, un mapeo propio de un grafo en el que cada vértice también se mapea a sí mismo).
     * @param graph el grafo de entrada
     * @param <V> el tipo de vértice del grafo
     * @param <E> el tipo de arista del grafo
     * @return un mapeo de grafo a grafo
     */
    public static <V, E> IsomorphicGraphMapping<V, E> identidad(Graph<V, E> graph) {
        Map<V, V> vertexMapping = new HashMap<>();
        Map<E, E> edgeMapping = new HashMap<>();

        // Mapea cada vértice a sí mismo
        for (V vertex : graph.vertexSet()) {
            vertexMapping.put(vertex, vertex);
        }

        // Mapea cada arista a sí misma
        for (E edge : graph.edgeSet()) {
            edgeMapping.put(edge, edge);
        }

        return new IsomorphicGraphMapping<>(vertexMapping, edgeMapping, graph, graph);
    }
}