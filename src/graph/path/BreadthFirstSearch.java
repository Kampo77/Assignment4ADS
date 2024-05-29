package graph.path;

import graph.Edge;
import graph.MyGraph;

import java.util.*;

public class BreadthFirstSearch<Vertex> implements Search<Vertex> {
    public List<Vertex> bfs(MyGraph<Vertex> graph, Vertex start) {
        List<Vertex> visited = new ArrayList<>();
        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> seen = new HashSet<>();

        queue.add(start);
        seen.add(start);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            visited.add(current);

            for (var edge : graph.getEdges(current)) {
                Vertex neighbor = edge.getDest();
                if (!seen.contains(neighbor)) {
                    queue.add(neighbor);
                    seen.add(neighbor);
                }
            }
        }

        return visited;
    }
}
