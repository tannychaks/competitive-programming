package striverSDEsheet.day23;

import java.util.ArrayList;

public class CheckCycleDirectedGraphDFS {
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
        int v = 2;
        Graph g = new Graph(v);
        g.addEdge(0, 1);

        g.addEdge(1, 0);

        boolean ans = isCycle(v, g.getAdjacencyList());
        System.out.println(ans);
    }

    private static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        boolean[] dfsVis = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i])
                if (checkForCycle(i, dfsVis, vis, adj))
                    return true;
        }
        return false;
    }

    private static boolean checkForCycle(int vertex, boolean[] dfsVis, boolean[] vis,
            ArrayList<ArrayList<Integer>> adj) {
        vis[vertex] = true;
        dfsVis[vertex] = true;
        for (Integer it : adj.get(vertex)) {
            if (!vis[it]) {
                if (checkForCycle(it, dfsVis, vis, adj))
                    return true;
            } else if (dfsVis[it])
                return true;
        }
        dfsVis[vertex] = false;
        return false;
    }

}
