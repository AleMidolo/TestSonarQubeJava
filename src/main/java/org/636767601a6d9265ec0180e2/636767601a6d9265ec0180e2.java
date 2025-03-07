import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        adjacencyList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjacencyList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    private List<Pair<List<Pair<Integer, Integer>>, Integer>> computeGlobalSeparatorList() {
        List<Pair<List<Pair<Integer, Integer>>, Integer>> globalSeparators = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            int u = entry.getKey();
            for (int v : entry.getValue()) {
                List<Pair<Integer, Integer>> separators = findMinimalSeparators(u, v);
                globalSeparators.add(new Pair<>(separators, u));
            }
        }

        return globalSeparators;
    }

    private List<Pair<Integer, Integer>> findMinimalSeparators(int u, int v) {
        // Placeholder for the actual implementation of finding minimal separators
        // This is a complex problem and typically involves advanced graph algorithms
        // such as BFS, DFS, or flow-based methods.
        List<Pair<Integer, Integer>> separators = new ArrayList<>();
        // Example: Adding a dummy separator for illustration
        separators.add(new Pair<>(u, v));
        return separators;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);

        List<Pair<List<Pair<Integer, Integer>>, Integer>> result = graph.computeGlobalSeparatorList();
        for (Pair<List<Pair<Integer, Integer>>, Integer> pair : result) {
            System.out.println("Edge: " + pair.getSecond());
            System.out.println("Separators: " + pair.getFirst());
        }
    }
}

class Pair<K, V> {
    private K first;
    private V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}