import java.util.Scanner;

public class Entry {
    public static void main(String[] args) throws IllegalArgumentException {
        int shortestPathVertices = 87;
        int easiestPathVertices = 106;
        int cheapestPathVertices = 87;
        Graph shortestPathGraph = new Graph(shortestPathVertices);
        PrintPathShortest shortestPathPrint = new PrintPathShortest(shortestPathGraph);
        int source;
        int destination;
        String inputSource;
        String inputDestination;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the source ");
        inputSource = sc.nextLine();
        System.out.println("Enter the destination ");
        inputDestination = sc.nextLine();
        source = shortestPathPrint.getLocationIndex(inputSource);
        destination = shortestPathPrint.getLocationIndex(inputDestination);
        if (source == -1 || destination == -1) {
            throw new IllegalArgumentException("Illegal input");
        }

        //Shortest Path
        System.out.println();
        System.out.println("Shortest Path");
        ShortestPath shortestPath = new ShortestPath(shortestPathGraph);
        shortestPath.connect();
        Dijkstra shortestPathDijkstra = new Dijkstra(source, destination, shortestPathGraph);
        shortestPathDijkstra.applyDijkstra();
        shortestPathPrint.printPath(shortestPathDijkstra.getParent(), shortestPathDijkstra.getDistance(), source, destination);
        System.out.println();

        //Easiest Path
        System.out.println("Easiest Path");
        Graph easiestPathGraph = new Graph(easiestPathVertices);
        EasiestPath easiestPath = new EasiestPath(easiestPathGraph);
        easiestPath.connect();
        Dijkstra easiestPathDijkstra = new Dijkstra(source, destination, easiestPathGraph);
        easiestPathDijkstra.applyDijkstra();
        PrintPathEasy easiestPathPrint = new PrintPathEasy(easiestPathGraph);
        easiestPathPrint.printPath(easiestPathDijkstra.getParent(), easiestPathDijkstra.getDistance(), source, destination);
        System.out.println();

        //Cheapest Path
        System.out.println("Cheapest Path");
        Graph cheapestPathGraph = new Graph(cheapestPathVertices);
        CheapestPath cheapestPath = new CheapestPath(cheapestPathGraph);
        cheapestPath.connect();
        Dijkstra cheapestPathDijkstra = new Dijkstra(source, destination, cheapestPathGraph);
        cheapestPathDijkstra.applyDijkstra();
        PrintPathCheapest cheaptestPathPrint = new PrintPathCheapest(cheapestPathGraph);
        cheaptestPathPrint.printPath(cheapestPathDijkstra.getParent(), cheapestPathDijkstra.getDistance(), source, destination);


    }
}