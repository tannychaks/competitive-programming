package striverSDEsheet.day23;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBipartiteBFS {
    public static void main(String[] args) {
        int[][] graph = new int[][] { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
        boolean ans = isBipartite(graph);
        System.out.println(ans);
    }

    private static boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];
        for (int i = 0; i < v; i++)
            color[i] = -1;
        for (int i = 0; i < v; i++) {
            if (color[i] == -1)
                if (!bfsCheck(i, graph, color))
                    return false;
        }
        return true;
    }

    private static boolean bfsCheck(int vertex, int[][] graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        color[vertex] = 1;
        q.offer(vertex);

        while (!q.isEmpty()) {
            Integer node = q.poll();

            for (Integer it : graph[node]) {
                if (color[it] == -1) {
                    color[it] = 1 - color[node];
                    q.offer(it);
                } else if (color[it] == color[node])
                    return false;
            }
        }
        return true;
    }

}
