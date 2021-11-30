import java.util.LinkedList;

public class Graph {
    private int vertices;
    private LinkedList<Edge>[] adjacencyList;

    Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public LinkedList<Edge>[] getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(LinkedList<Edge>[] adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public void connectVertices(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencyList[source].addFirst(edge);
        edge = new Edge(destination, source, weight);
        adjacencyList[destination].addFirst(edge);
    }
}
