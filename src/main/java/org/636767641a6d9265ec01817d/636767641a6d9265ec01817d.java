import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class BipartiteGraphGenerator<V, E> {

    /**
     * 构建一个完整的二分图
     * @param target 目标图对象
     * @param resultMap 存储生成的顶点
     */
    @Override
    public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
        // 假设图有两个部分，分别称为左部和右部
        List<V> leftPart = new ArrayList<>();
        List<V> rightPart = new ArrayList<>();

        // 生成左部的顶点
        for (int i = 0; i < 5; i++) {
            V vertex = target.addVertex();
            leftPart.add(vertex);
            resultMap.put("left_" + i, vertex);
        }

        // 生成右部的顶点
        for (int i = 0; i < 5; i++) {
            V vertex = target.addVertex();
            rightPart.add(vertex);
            resultMap.put("right_" + i, vertex);
        }

        // 连接左部和右部的所有顶点
        for (V leftVertex : leftPart) {
            for (V rightVertex : rightPart) {
                target.addEdge(leftVertex, rightVertex);
            }
        }
    }
}

// 假设Graph接口如下
interface Graph<V, E> {
    V addVertex();
    E addEdge(V source, V target);
}

// 假设顶点和边的类型为String
class SimpleGraph implements Graph<String, String> {
    private List<String> vertices = new ArrayList<>();
    private List<String> edges = new ArrayList<>();

    @Override
    public String addVertex() {
        String vertex = "v" + vertices.size();
        vertices.add(vertex);
        return vertex;
    }

    @Override
    public String addEdge(String source, String target) {
        String edge = source + "-" + target;
        edges.add(edge);
        return edge;
    }
}