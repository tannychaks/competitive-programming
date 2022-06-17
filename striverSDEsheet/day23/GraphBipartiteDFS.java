package striverSDEsheet.day23;

public class GraphBipartiteDFS {
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
                if (!dfsCheck(i, graph, color))
                    return false;
        }
        return true;
    }

    private static boolean dfsCheck(int vertex, int[][] graph, int[] color) {
        color[vertex] = 1;

        for (Integer it : graph[vertex]) {
            if (color[it] == -1) {
                color[it] = 1 - color[vertex];
                if (!dfsCheck(it, graph, color))
                    return false;
            } else if (color[it] == color[vertex])
                return false;
        }
        return true;
    }

}
