import java.util.*;

public class Problem4 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the number of vertices: ");
        int n = input.nextInt();
        
        System.out.print("Enter the number of edges: ");
        int m = input.nextInt();
        
        int[] degree = new int[n];
        
        for (int i = 0; i < m; i++) {
            System.out.print("Enter the vertices associated with edge " + (i+1) + ": ");
            int u = input.nextInt();
            int v = input.nextInt();
            
            degree[u-1]++;
            degree[v-1]++;
        }
        
        System.out.println("The degree of each vertex is:");
        
        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + (i+1) + ": " + degree[i]);
        }
    }
}