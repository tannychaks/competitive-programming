package striverSDEsheet.day23;

import java.util.ArrayList;

public class GraphDFS {
    private static ArrayList<ArrayList<Integer>> adj; // adjacency list

    GraphDFS(int v) {
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
        GraphDFS g = new GraphDFS(v);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        ArrayList<Integer> ans = g.dfs(v, adj);
        printAns(ans);
    }

    private ArrayList<Integer> dfs(int v, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfsRecur(i, visited, adj, dfs);
            }
        }
        return dfs;
    }

    private void dfsRecur(int vertex, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs) {
        dfs.add(vertex);
        visited[vertex] = true;
        for (Integer it : adj.get(vertex)) {
            if (!visited[it]) {
                visited[it] = true;
                dfsRecur(it, visited, adj, dfs);
            }
        }
    }

    private static void printAns(ArrayList<Integer> ans) {
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
