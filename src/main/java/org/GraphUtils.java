package org;

import java.util.Set;
import org.jgrapht.Graph;

public class GraphUtils {

    /** 
     * Controlla se il sottografo di <code>graph</code> indotto dai dati <code>vertices</code> è completo, cioè un clique.
     * @param graph il grafo.
     * @param vertices i vertici da cui indurre il sottografo.
     * @return true se il sottografo indotto è un clique.
     */
    private static <V,E> boolean isClique(Graph<V,E> graph, Set<V> vertices) {
        if (vertices.size() < 2) {
            return true; // A single vertex or empty set is trivially a clique
        }

        for (V v1 : vertices) {
            for (V v2 : vertices) {
                if (!v1.equals(v2) && !graph.containsEdge(v1, v2)) {
                    return false; // If there is no edge between any two vertices, it's not a clique
                }
            }
        }
        return true; // All pairs of vertices are connected
    }
}