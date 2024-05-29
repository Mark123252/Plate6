import java.util.*;

public class Problem1 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        List<List<Integer>> adjacencyList = new ArrayList<>();

        System.out.println("Enter the edges of the graph in the format 'u v', where u and v are vertices");
        System.out.println("Enter a blank line to finish");
        while (true) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }
            String[] parts = line.split("\\s+");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            while (adjacencyList.size() <= u || adjacencyList.size() <= v) {
                adjacencyList.add(new ArrayList<>());
            }
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }
        boolean[] visited = new boolean[adjacencyList.size()];
        int numComponents = 0;
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (!visited[i]) {
                numComponents++;
                dfs(adjacencyList, visited, i);
            }
        }
        if (numComponents == 1) {
            System.out.println("The graph is connected");
        } else {
            System.out.println("The graph is not connected");
            System.out.println("The number of connected components is " + numComponents);
        }

        sc.close();
    }
    private static void dfs(List<List<Integer>> adjacencyList, boolean[] visited, int vertex) {
        visited[vertex] = true;
        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(adjacencyList, visited, neighbor);
            }
        }
    }

}