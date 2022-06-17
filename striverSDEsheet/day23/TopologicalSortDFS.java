package striverSDEsheet.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any
 * Topological Sorting of that Graph.
 */
public class TopologicalSortDFS {
    static class Graph {
        private ArrayList<ArrayList<Integer>> adj; // adjacency list

        Graph(int v) {
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

        ArrayList<ArrayList<Integer>> getAdjacencyList() {
            return this.adj;
        }
    }

    public static void main(String[] args) {
        int v = 6;
        Graph g = new Graph(v);

        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        int[] ans = topoSort(v, g.getAdjacencyList());
        System.out.println(Arrays.toString(ans));
    }

    private static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i])
                findTopoSort(i, st, vis, adj);
        }
        int[] ans = new int[v];
        int ind = 0;
        while (!st.isEmpty())
            ans[ind++] = st.pop();
        return ans;
    }

    private static void findTopoSort(int vertex, Stack<Integer> st, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[vertex] = true;
        for (Integer it : adj.get(vertex)) {
            if (!vis[it])
                findTopoSort(it, st, vis, adj);
        }
        st.push(vertex);
    }
}
