import java.util.*;

public class GraphPathTransformer {
  
  public List<Integer> setToPath(Set<Edge> tour, Graph graph) {
  if (tour == null || tour.isEmpty() || graph == null) {
  return new ArrayList<>();
  }

  List<Integer> path = new ArrayList<>();
  Edge currentEdge = tour.iterator().next();
  int currentVertex = currentEdge.getSource();
  path.add(currentVertex);

  Set<Edge> remainingEdges = new HashSet<>(tour);
  remainingEdges.remove(currentEdge);

  while (!remainingEdges.isEmpty()) {
  currentVertex = currentEdge.getDestination();
  path.add(currentVertex);

  // Find next edge that connects to current vertex
  Edge nextEdge = null;
  for (Edge edge : remainingEdges) {
  if (edge.getSource() == currentVertex) {
  nextEdge = edge;
  break;
  } else if (edge.getDestination() == currentVertex) {
  // Reverse edge direction if needed
  nextEdge = new Edge(edge.getDestination(), edge.getSource(), edge.getWeight());
  break;
  }
  }

  if (nextEdge == null) {
  break; // No connecting edge found
  }

  currentEdge = nextEdge;
  remainingEdges.remove(nextEdge);
  }

  return path;
  }
}

// Supporting classes needed for compilation
class Edge {
  private int source;
  private int destination;
  private double weight;

  public Edge(int source, int destination, double weight) {
  this.source = source;
  this.destination = destination;
  this.weight = weight;
  }

  public int getSource() {
  return source;
  }

  public int getDestination() {
  return destination;
  }

  public double getWeight() {
  return weight;
  }
}

class Graph {
  // Graph implementation details omitted for brevity
}