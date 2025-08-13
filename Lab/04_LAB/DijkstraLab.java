import java.util.*;

public class DijkstraLab {

    static final int INT_MAX = Integer.MAX_VALUE;
    static final int V = 7;
    static String[] vertexNames = {"A", "B", "C", "D", "E", "F", "G"};

    public static void dijkstra(int[][] graph, int source) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        String[] path = new String[V];

        Arrays.fill(dist, INT_MAX);
        Arrays.fill(visited, false);
        for (int i = 0; i < V; i++) {
            path[i] = vertexNames[source];
        }
        dist[source] = 0;

        System.out.println("Dijkstra's Algorithm Execution \n");

        for (int count = 0; count < V - 1; count++) {
            int u = minDist(dist, visited);
            visited[u] = true;

            System.out.println("Step " + (count + 1));
            System.out.println("Visited Nodes   : " + Arrays.toString(visited));
            System.out.println("Current Distances: " + Arrays.toString(dist));

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != INT_MAX 
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    path[v] = path[u] + " -> " + vertexNames[v];
                }
            }

            System.out.println("Updated Distances: " + Arrays.toString(dist));
            System.out.println("Paths            : " + Arrays.toString(path));
            System.out.println("--------------------------------------------\n");
        }

        System.out.println("Final Shortest Paths from " + vertexNames[source]);
        for (int i = 0; i < V; i++) {
            if (i != source) {
                System.out.printf("%s -> %s : %-3d | Path: %s\n",
                        vertexNames[source], vertexNames[i], dist[i], path[i]);
            }
        }
    }

    private static int minDist(int[] dist, boolean[] visited) {
        int min = INT_MAX, minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
         int[][] graph = {
                { 0, 4, 0, 0, 0, 10, 0 }, 
                { 4, 0, 3, 0, 0, 0, 18 }, 
                { 0, 3, 0, 7, 8, 0, 0 },  
                { 0, 0, 7, 0, 5, 0, 6 },  
                { 0, 0, 8, 5, 0, 2, 0 },  
                { 10, 0, 0, 0, 2, 0, 3 }, 
                { 0, 18, 0, 6, 0, 3, 0 }  
        };

        dijkstra(graph, 0);
    }
}
