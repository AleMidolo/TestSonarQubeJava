import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultGraphPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 将集合表示转换为图路径。
 * @param tour 包含可巡回边的集合
 * @param graph 图
 * @return 图路径
 */
protected <V, E> GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
    if (tour.isEmpty()) {
        throw new IllegalArgumentException("Tour cannot be empty");
    }

    List<E> edgeList = new ArrayList<>(tour);
    List<V> vertexList = new ArrayList<>();

    // Start with the first edge
    E firstEdge = edgeList.get(0);
    V startVertex = graph.getEdgeSource(firstEdge);
    V endVertex = graph.getEdgeTarget(firstEdge);

    vertexList.add(startVertex);
    vertexList.add(endVertex);

    // Iterate through the remaining edges to build the path
    for (int i = 1; i < edgeList.size(); i++) {
        E currentEdge = edgeList.get(i);
        V source = graph.getEdgeSource(currentEdge);
        V target = graph.getEdgeTarget(currentEdge);

        if (source.equals(vertexList.get(vertexList.size() - 1))) {
            vertexList.add(target);
        } else if (target.equals(vertexList.get(vertexList.size() - 1))) {
            vertexList.add(source);
        } else {
            throw new IllegalArgumentException("Tour edges are not connected");
        }
    }

    return new DefaultGraphPath<>(graph, vertexList, edgeList);
}