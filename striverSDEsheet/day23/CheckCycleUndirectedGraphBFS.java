package striverSDEsheet.day23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheckCycleUndirectedGraphBFS {
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

    static class Pair {
        int node;
        int parent;

        Pair() {
        }

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    private static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i])
                if (checkForCycle(i, vis, adj))
                    return true;
        }
        return false;
    }

    private static boolean checkForCycle(int vertex, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        Queue<Pair> q = new LinkedList<>();
        vis[vertex] = true;
        q.offer(new Pair(vertex, -1));

        while (!q.isEmpty()) {
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.poll();
            for (Integer it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.offer(new Pair(it, node));
                } else if (it != parent)
                    return true;
            }
        }
        return false;
    }
}
