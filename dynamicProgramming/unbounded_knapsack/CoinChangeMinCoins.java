package dynamicProgramming.unbounded_knapsack;

/**
 * Given a value V and array coins[] of size M, the task is to make the change
 * for V cents, given that you have an infinite supply of each of coins{coins1,
 * coins2, ..., coinsm} valued coins. Find the minimum number of coins to make
 * the change. If not possible to make change then return -1.
 */
public class CoinChangeMinCoins {
 public static void main(String[] args) {
  int m = 1, v = 15;
  int[] coins = new int[] { 4 };
  System.out.println(minCoins(coins, m, v));
 }

 private static int minCoins(int[] coins, int m, int v) {

  int[][] dp = new int[m + 1][v + 1];
  final int INF = Integer.MAX_VALUE - 1;
  // Initialization
  for (int i = 0; i < m + 1; i++) {
   for (int j = 0; j < v + 1; j++) {
    if (j == 0)
     dp[i][j] = 0;
    if (i == 0)
     dp[i][j] = INF;
    // Uniqueness : 2nd row initialization
    if (i == 1) {
     if (j % coins[i - 1] == 0)
      dp[i][j] = j / coins[i - 1];
     else
      dp[i][j] = INF;
    }
   }
  }
  // Code Variation :unbounded knapsack
  for (int i = 2; i < m + 1; i++) {
   for (int j = 1; j < v + 1; j++) {
    if (coins[i - 1] <= j)
     dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
    else
     dp[i][j] = dp[i - 1][j];
   }
  }
  return dp[m][v] == INF ? -1 : dp[m][v];
 }
}
