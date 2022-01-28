package dynamicProgramming.unbounded_knapsack;

/**
 * Given a set of N items, each with a weight and a value, and a weight limit W.
 * Find the maximum value of a collection containing any of the N items any
 * number of times so that the total weight is less than or equal to W.
 */
public class UnboundedKnapsack {
 public static void main(String[] args) {
  int val[] = { 1, 1 };
  int wt[] = { 2, 1 };

  int W = 3;
  int N = val.length;
  System.out.println(knapSack(N, W, val, wt));
 }

 private static int knapSack(int n, int w, int[] val, int[] wt) {
  int[][] dp = new int[n + 1][w + 1];
  for (int i = 0; i < n + 1; i++) {
   for (int j = 0; j < w + 1; j++) {
    if (i == 0 || j == 0)
     dp[i][j] = 0;
    else if (wt[i - 1] <= j)
     dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i][j - wt[i - 1]]);
    else
     dp[i][j] = dp[i - 1][j];
   }
  }
  return dp[n][w];
 }

}
