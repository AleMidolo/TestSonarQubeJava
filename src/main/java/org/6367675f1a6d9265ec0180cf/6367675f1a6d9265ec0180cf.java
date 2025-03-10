import org.jgrapht.Graph;
import java.util.Set;

public class CliqueChecker {

    /**
     * Verifica si el subgrafo de <code>graph</code> inducido por los <code>vertices</code> dados es completo, es decir, un clique.
     * @param graph el grafo.
     * @param vertices los vértices de los que se inducirá el subgrafo.
     * @return true si el subgrafo inducido es un clique.
     */
    private static <V, E> boolean isClique(Graph<V, E> graph, Set<V> vertices) {
        // Verificar que todos los vértices en el conjunto están en el grafo
        for (V vertex : vertices) {
            if (!graph.containsVertex(vertex)) {
                return false;
            }
        }

        // Verificar que todos los pares de vértices están conectados por una arista
        for (V v1 : vertices) {
            for (V v2 : vertices) {
                if (!v1.equals(v2) && !graph.containsEdge(v1, v2)) {
                    return false;
                }
            }
        }

        return true;
    }
}