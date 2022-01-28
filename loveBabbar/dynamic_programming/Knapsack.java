package loveBabbar.dynamic_programming;

public class Knapsack {
  public static void main(String[] args) {
    int val[] = { 10, 45, 60, 90 };
    int wt[] = { 15, 20, 30, 40 };

    int W = 80;
    int N = val.length;
    System.out.println(knapSack(W, wt, val, N));
  }

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
}
