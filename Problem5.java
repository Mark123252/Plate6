import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();

        List<Edge> edges = new ArrayList<>();
        System.out.println("Enter the edges in the format \"source target\" (one edge per line):");
        for (int i = 0; i < numEdges; i++) {
            int source = scanner.nextInt();
            int target = scanner.nextInt();
            edges.add(new Edge(source, target));
        }
        boolean isBipartite = checkBipartite(edges);
        if (isBipartite) {
            System.out.println("The graph is bipartite");
        } else {
            System.out.println("The graph is not bipartite");
        }
    }
    static class Edge {
        int source;
        int target;

        public Edge(int source, int target) {
            this.source = source;
            this.target = target;
        }
        public String toString() {
            return source + " -> " + target;
        }
    }
    static boolean checkBipartite(List<Edge> edges) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (Edge edge : edges) {
            int source = edge.source;
            int target = edge.target;
            if (numberMap.containsKey(source) && numberMap.get(source) == numberMap.get(target)) {
                return false;
            }
            numberMap.put(source, -1 * getNumber(numberMap, target));
            numberMap.put(target, getNumber(numberMap, source));
        }
        return true;
    }

    static int getNumber(Map<Integer, Integer> numberMap, int vertex) {
        return numberMap.containsKey(vertex) ? numberMap.get(vertex) : 1;
    }
}

