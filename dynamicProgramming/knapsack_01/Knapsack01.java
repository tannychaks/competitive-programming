package dynamicProgramming.knapsack_01;

import java.util.Arrays;

public class Knapsack01 {
  public static void main(String[] args) {
    // int val[] = { 60, 100, 120 };
    // int wt[] = { 10, 20, 30 };

    int val[] = { 5, 2, 3, 1, 4 };
    int wt[] = { 5, 2, 3, 1, 4 };
    int W = 5;
    int N = val.length;

    System.out.println(knapSack(W, wt, val, N));
  }

  /**
   * Top down approach O(n^2)
   * 
   * @param w
   * @param wt
   * @param val
   * @param n
   * @return
   */
  private static int knapSack(int w, int[] wt, int[] val, int n) {
    int[][] dp = new int[n + 1][w + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < w + 1; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
        else if (wt[i - 1] <= j)
          dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
        else
          dp[i][j] = dp[i - 1][j];
      }
    }
    return dp[n][w];
  }

  /**
   * Space complexity optimized TC: O(n*W) SC: O(W)
   * 
   * @param val
   * @param wt
   * @param n
   * @param W
   * @return
   */
  static int spaceOptimizedKnapSack(int val[], int wt[], int n, int W) {
    // array to store final result
    // dp[i] stores the profit with KnapSack capacity "i"
    int[] dp = new int[W + 1];

    // initially profit with 0 to W KnapSack capacity is 0
    Arrays.fill(dp, 0);

    // iterate through all items
    for (int i = 0; i < n; i++)

      // traverse dp array from right to left
      for (int j = W; j >= wt[i]; j--)
        dp[j] = Math.max(dp[j], val[i] + dp[j - wt[i]]);

    /*
     * above line finds out maximum of dp[j](excluding ith element value) and val[i]
     * + dp[j-wt[i]] (including ith element value and the profit with
     * "KnapSack capacity - ith element weight")
     */
    return dp[W];
  }
}
