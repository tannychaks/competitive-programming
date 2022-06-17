package striverSDEsheet.day23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {

    private static ArrayList<ArrayList<Integer>> adj; // adjacency list

    GraphBFS(int v) {
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(i, new ArrayList<>());
    }

    /**
     * Function to add an edge into the graph
     * 
     * @param v : No. of vertices
     * @param w : Weight of Edge
     */
    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    public static void main(String[] args) {
        int v = 4;
        GraphBFS g = new GraphBFS(v);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        ArrayList<Integer> ans = g.bfs(v, adj);
        printAns(ans);
    }

    private static void printAns(ArrayList<Integer> ans) {
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    /**
     * Time Complexity : O(N+E)
     * 
     * N = Nodes , E = travelling through adjacent nodes
     * 
     * Space Complexity : O(N+E) + O(N) + O(N)
     * 
     * Space for adjacency list, visited array, queue data structure
     * 
     * @param v
     * @param adj
     * @return
     */

    private ArrayList<Integer> bfs(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) { // This is just for connected components. For single component,can remove this
            if (!visited[i]) {

                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                visited[i] = true;

                while (!q.isEmpty()) {
                    Integer vertex = q.poll();
                    bfs.add(vertex);

                    for (Integer it : adj.get(vertex)) {
                        if (!visited[it]) {
                            visited[it] = true;
                            q.offer(it);
                        }
                    }
                }
            }
        }
        return bfs;
    }
}
