import java.util.Scanner;

public class PrimsMST_1 {

    static int V;

    // Find vertex with minimum key value
    public static int minKey(int key[], boolean mstSet[]) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Print MST
    public static void printMST(int parent[], int graph[][]) {
        int totalCost = 0;

        System.out.println("\nEdge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            totalCost += graph[i][parent[i]];
        }

        System.out.println("Total Cost of MST: " + totalCost);
    }

    // Prim's Algorithm
    public static void primMST(int graph[][]) {

        int parent[] = new int[V];
        int key[] = new int[V];
        boolean mstSet[] = new boolean[V];

        // Initialize
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;     // start from vertex 0
        parent[0] = -1; // root

        for (int count = 0; count < V - 1; count++) {

            int u = minKey(key, mstSet);
            mstSet[u] = true;

            System.out.println("Step " + (count + 1) + ": Pick vertex " + u);

            for (int v = 0; v < V; v++) {

                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        V = sc.nextInt();

        int graph[][] = new int[V][V];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        primMST(graph);

        sc.close();
    }
}

/*
================ SAMPLE OUTPUT =================

Enter number of vertices:
5

Enter adjacency matrix:
0 2 0 6 0
2 0 3 8 5
0 3 0 0 7
6 8 0 0 9
0 5 7 9 0

Step 1: Pick vertex 0
Step 2: Pick vertex 1
Step 3: Pick vertex 2
Step 4: Pick vertex 4

Edge    Weight
0 - 1   2
1 - 2   3
0 - 3   6
1 - 4   5

Total Cost of MST: 16

================================================
*/
