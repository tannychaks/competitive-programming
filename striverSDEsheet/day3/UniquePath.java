package striverSDEsheet.day3;

import java.util.Arrays;

/**
 * https://takeuforward.org/data-structure/grid-unique-paths-count-paths-from-left-top-to-the-right-bottom-of-a-matrix/
 * 
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePath {
    public static void main(String[] args) {
        int m = 3, n = 2;
        System.out.println(uniquePathsRecursive(m, n));
        System.out.println(uniquePathsDynamic(m, n));
        System.out.println(uniquePathOptimal(m, n));
    }

    /**
     * Using Combinatorics
     * 
     * @param m
     * @param n
     * @return
     */
    private static int uniquePathOptimal(int m, int n) {
        long ans = 1, N = n + m - 2, r = m - 1;

        for (int i = 1; i <= r; i++) {
            ans = ans * (N - r + i) / i;
        }
        return (int) ans;
    }

    /**
     * 
     * @param m
     * @param n
     * @return
     */
    private static int uniquePathsDynamic(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int num = countPathsDynamic(0, 0, dp, m, n);
        if (m == 1 && n == 1)
            return num;
        return dp[0][0];
    }

    private static int countPathsDynamic(int i, int j, int[][] dp, int m, int n) {
        if (i == n - 1 && j == m - 1)
            return 1;
        if (i >= n || j >= m)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        else
            return dp[i][j] = countPathsDynamic(i, j + 1, dp, m, n) + countPathsDynamic(i + 1, j, dp, m, n);
    }

    /**
     * Recursive Approach
     * 
     * @param m
     * @param n
     * @return
     */
    private static int uniquePathsRecursive(int m, int n) {
        return countPathsRecursive(0, 0, m, n);
    }

    private static int countPathsRecursive(int i, int j, int m, int n) {
        if (i == n - 1 && j == m - 1)
            return 1;
        if (i >= n || j >= m)
            return 0;
        else
            return countPathsRecursive(i, j + 1, m, n) + countPathsRecursive(i + 1, j, m, n);
    }
}
