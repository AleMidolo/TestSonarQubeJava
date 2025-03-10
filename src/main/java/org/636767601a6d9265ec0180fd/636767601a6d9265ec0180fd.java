import java.util.HashMap;
import java.util.Map;

public class GraphIndex<V, E> {
    private Map<V, Map<V, E>> index;

    public GraphIndex() {
        this.index = new HashMap<>();
    }

    /**
     * 将边添加到索引中。
     * @param sourceVertex 源顶点
     * @param targetVertex 目标顶点
     * @param e 边
     */
    protected void addToIndex(V sourceVertex, V targetVertex, E e) {
        if (!index.containsKey(sourceVertex)) {
            index.put(sourceVertex, new HashMap<>());
        }
        index.get(sourceVertex).put(targetVertex, e);
    }

    // 其他方法可以根据需要添加
}