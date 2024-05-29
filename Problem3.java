import java.util.Scanner;

public class Problem3 {    
    private static boolean hasCycle = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the graph: ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("Enter the adjacency matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        if (hasCycle(matrix)) {
            System.out.println("The graph has a cycle");
        } else {
            System.out.println("The graph does not have a cycle");
        }

        scanner.close();
    }

    private static boolean hasCycle(int[][] matrix) {
        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            if (!visited[i]) {
                dfs(matrix, visited, i, -1);
                if (hasCycle) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void dfs(int[][] matrix, boolean[] visited, int vertex, int parent) {
        visited[vertex] = true;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[vertex][i] == 1) {
                if (!visited[i]) {
                    dfs(matrix, visited, i, vertex);
                } else if (i != parent) {
                    hasCycle = true;
                }
            }
        }
    }
}


