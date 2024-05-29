import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem2 {    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices in the graph:");
        int numVertices = scanner.nextInt();

        int[][] adjacencyMatrix = new int[numVertices][numVertices];

        System.out.println("Enter the adjacency matrix:");

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("The edges of the graph are:");

        Map<String, Integer> edgeFrequency = new HashMap<>();

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    String edge = "(" + (i + 1) + ", " + (j + 1) + ")";
                    System.out.println(edge);
                    edgeFrequency.put(edge, edgeFrequency.getOrDefault(edge, 0) + 1);
                }
            }
        }

        System.out.println("The number of times each edge appears:");
        for (Map.Entry<String, Integer> entry : edgeFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time(s)");
        }


    }
}