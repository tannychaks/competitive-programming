package striverSDEsheet.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS {
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
        while (!q.isEmpty()) {
            Integer vertex = q.poll();
            ans[ind++] = vertex;

            for (Integer it : adj.get(vertex)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.offer(it);
            }
        }
        return ans;
    }
}
