import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public class BipartiteGraphGenerator<V, E> {

    /**
     * Costruisce un grafo bipartito completo
     */
    @Override
    public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
        // Estrai i vertici dalle due partizioni
        List<V> partition1 = new ArrayList<>();
        List<V> partition2 = new ArrayList<>();

        for (Map.Entry<String, V> entry : resultMap.entrySet()) {
            if (entry.getKey().startsWith("A")) {
                partition1.add(entry.getValue());
            } else if (entry.getKey().startsWith("B")) {
                partition2.add(entry.getValue());
            }
        }

        // Aggiungi tutti i vertici al grafo
        for (V vertex : partition1) {
            target.addVertex(vertex);
        }
        for (V vertex : partition2) {
            target.addVertex(vertex);
        }

        // Aggiungi tutti gli archi tra le due partizioni
        for (V v1 : partition1) {
            for (V v2 : partition2) {
                target.addEdge(v1, v2);
            }
        }
    }
}