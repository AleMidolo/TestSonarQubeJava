import org.jgrapht.Graph;
import org.jgrapht.GraphMapping;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.alg.isomorphism.IsomorphicGraphMapping;

public class GraphUtils {

    /**
     * 计算一个恒等自同构（即图的自映射，其中每个顶点也映射到自身）。
     * @param graph 输入图
     * @param <V> 图的顶点类型
     * @param <E> 图的边类型
     * @return 从图到图的映射
     */
    public static <V,E> IsomorphicGraphMapping<V,E> identity(Graph<V,E> graph) {
        return new IsomorphicGraphMapping<V,E>(
            graph, // source graph
            graph, // target graph (same as source for identity mapping)
            new HashMap<V,V>() {{ // vertex mapping
                for(V v : graph.vertexSet()) {
                    put(v, v);
                }
            }},
            new HashMap<E,E>() {{ // edge mapping
                for(E e : graph.edgeSet()) {
                    put(e, e);
                }
            }}
        );
    }
}