package striverSDEsheet.day23;

import java.util.ArrayList;

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][] { { 0, 1 } };

        boolean ans = canFinish(numCourses, prerequisites);
        System.out.println(ans);
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph g = new Graph(numCourses);

        ArrayList<ArrayList<Integer>> adj = g.getAdjacencyList();
        for (int[] course : prerequisites)
            adj.get(course[0]).add(course[1]);

        return !isCycle(numCourses, adj);
    }

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

    private static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        boolean[] stack = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (checkCycle(i, stack, vis, adj))
                    return true;
            }
        }
        return false;
    }

    private static boolean checkCycle(int node, boolean[] stack, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {

        vis[node] = true;
        stack[node] = true;
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                if (checkCycle(it, stack, vis, adj))
                    return true;
            } else if (stack[it])
                return true;
        }
        stack[node] = false;
        return false;
    }

}
