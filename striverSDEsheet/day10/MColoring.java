package striverSDEsheet.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MColoring {
    public static void main(String[] args) {
        int N = 4, M = 3;
        List<Integer>[] G = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList<>();
        }
        G[0].add(1);
        G[1].add(0);
        G[1].add(2);
        G[2].add(1);
        G[2].add(3);
        G[3].add(2);
        G[3].add(0);
        G[0].add(3);
        G[0].add(2);
        G[2].add(0);
        int[] color = new int[N];
        Arrays.stream(G).forEach(list -> {
            list.stream().forEach(val -> System.out.print(val + " "));
            System.out.println();
        });
        System.out.println(graphColoring(G, color, 0, M));
    }

    private static boolean graphColoring(List<Integer>[] g, int[] color, int i, int m) {
        int n = g.length;
        return solve(n, g, color, i, m);
    }

    private static boolean solve(int n, List<Integer>[] g, int[] color, int node, int m) {
        if (node == n)
            return true;

        for (int col = 1; col <= m; col++) {
            if (isSafe(node, g, color, col)) {
                color[node] = col;
                if (solve(n, g, color, node + 1, m))
                    return true;
                color[node] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int node, List<Integer>[] g, int[] color, int col) {

        for (int it : g[node])
            if (color[it] == col)
                return false;
        return true;
    }
}
