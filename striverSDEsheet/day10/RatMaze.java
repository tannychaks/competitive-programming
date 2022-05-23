package striverSDEsheet.day10;

import java.util.ArrayList;
import java.util.Arrays;

public class RatMaze {
    public static void main(String[] args) {
        int n = 4;
        int[][] m = new int[][] { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };

        ArrayList<String> ans = findPath(m, n);

        ans.stream().forEach(System.out::println);
    }

    /**
     * Time Complexity: O(4^(m*n)), because on every cell we need to try 4 different
     * directions.
     * 
     * Space Complexity: O(m*n) ,Maximum Depth of the recursion tree(auxiliary
     * space).
     * 
     * @param m
     * @param n
     * @return
     */
    private static ArrayList<String> findPath(int[][] m, int n) {

        int[] di = new int[] { 1, 0, 0, -1 };
        int[] dj = new int[] { 0, -1, 1, 0 };

        ArrayList<String> ans = new ArrayList<>();
        int vis[][] = new int[n][n];

        for (int arr[] : vis) {
            Arrays.fill(arr, 0);
        }

        if (m[0][0] == 1)
            solve(0, 0, m, n, ans, "", vis, di, dj);
        return ans;
    }

    private static void solve(int i, int j, int[][] m, int n, ArrayList<String> ans, String move, int[][] vis,
            int[] di, int[] dj) {
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }

        String dir = "DLRU";

        for (int ind = 0; ind < 4; ind++) {
            int nexti = i + di[ind];
            int nextj = j + dj[ind];

            if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && vis[nexti][nextj] == 0 && m[nexti][nextj] == 1) {
                vis[i][j] = 1;
                solve(nexti, nextj, m, n, ans, move + dir.charAt(ind), vis, di, dj);
                vis[i][j] = 0;
            }
        }
    }
}
