package striverSDEsheet.day23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheckCycleDirectedGraphBFS {
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

    private static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adjacencyList) {
        return topoSort(v, adjacencyList);
    }

    private static boolean topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] ans = new int[v];
        int[] indegree = new int[v];
        for (int i = 0; i < v; i++)
            for (Integer it : adj.get(i))
                indegree[it]++;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++)
            if (indegree[i] == 0)
                q.offer(i);
        int ind = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
            Integer vertex = q.poll();
            ans[ind++] = vertex;
            cnt++;
            for (Integer it : adj.get(vertex)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.offer(it);
            }
        }
        if (cnt == v)
            return false;
        return true;

    }
}
