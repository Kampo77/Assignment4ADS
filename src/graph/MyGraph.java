package graph;
import java.util.*;

public class MyGraph<Vertex> {
    private Map<Vertex, List<Edge<Vertex>>> map;
    private boolean undirected;

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
        this.map = new HashMap<>();
    }

    public void addVertex(Vertex vertex) {
        map.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex source, Vertex dest, int weight) {
        map.computeIfAbsent(source, k -> new ArrayList<>()).add(new Edge<>(source, dest, weight));
        if (undirected) {
            map.computeIfAbsent(dest, k -> new ArrayList<>()).add(new Edge<>(dest, source, weight));
        }
    }

    public List<Edge<Vertex>> getEdges(Vertex vertex) {
        return map.get(vertex);
    }

    public Set<Vertex> getVertices() {
        return map.keySet();
    }

    public boolean isUndirected() {
        return undirected;
    }
}
