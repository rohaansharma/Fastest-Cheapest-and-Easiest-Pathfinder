import javafx.util.Pair;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijkstra {
    private LinkedList<Edge>[] adjacencyList;
    private int vertices;
    private int source;
    private int destination;
    private boolean[] shortestPathFound;
    private int[] distance;
    private int[] parent;

    Dijkstra(int source, int destination, Graph graph) {
        this.source = source;
        this.destination = destination;
        vertices = graph.getVertices();
        adjacencyList = graph.getAdjacencyList();
        shortestPathFound = new boolean[vertices];
        distance = new int[vertices];
        parent = new int[vertices];
    }

    public boolean[] getShortestPathFound() {
        return shortestPathFound;
    }

    public void setShortestPathFound(boolean[] shortestPathFound) {
        this.shortestPathFound = shortestPathFound;
    }

    public int[] getDistance() {
        return distance;
    }

    public void setDistance(int[] distance) {
        this.distance = distance;
    }

    public int[] getParent() {
        return parent;
    }

    public void setParent(int[] parent) {
        this.parent = parent;
    }

    public LinkedList<Edge>[] getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(LinkedList<Edge>[] adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public void applyDijkstra() {
        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        parent[source] = -1;

        PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>(vertices, (p1, p2) -> {
            int p1Key = p1.getKey();
            int p2Key = p2.getKey();
            return p1Key - p2Key;
        });

        Pair<Integer, Integer> firstPair = new Pair<>(distance[source], source);
        distance[source] = 0;
        priorityQueue.offer(firstPair);

        while (!priorityQueue.isEmpty()) {
            Pair<Integer, Integer> pair = priorityQueue.poll();
            int currentVertex = pair.getValue();
            if (shortestPathFound[currentVertex] == false) {
                shortestPathFound[currentVertex] = true;
                LinkedList<Edge> adjacentVertices = adjacencyList[currentVertex];
                for (int i = 0; i < adjacentVertices.size(); i++) {
                    Edge edges = adjacentVertices.get(i);
                    int destination = edges.getDestination();
                    if (shortestPathFound[destination] == false) {
                        int newWeight = distance[currentVertex] + edges.getWeight();
                        int currentWeight = distance[destination];
                        if (currentWeight > newWeight) {
                            Pair<Integer, Integer> currentPair = new Pair<>(newWeight, destination);
                            priorityQueue.offer(currentPair);
                            distance[destination] = newWeight;
                            parent[destination] = currentVertex;
                        }
                    }
                }
            }
        }
    }
}
