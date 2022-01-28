package dynamicProgramming.unbounded_knapsack;

/**
 * Given a value N, find the number of ways to make change for N cents, if we
 * have infinite supply of each of S = { S1, S2, .. , SM } valued coins.
 */
public class CoinChangeMaxWays {
 public static void main(String[] args) {
  int n = 4, m = 3;
  int[] s = new int[] { 1, 2, 3 };
  System.out.println(countCoinChange(s, n, m));
 }

 private static long countCoinChange(int[] s, int n, int m) {
  long[][] dp = new long[m + 1][n + 1];
  for (int i = 0; i < m + 1; i++) {
   for (int j = 0; j < n + 1; j++) {
    if (i == 0)
     dp[i][j] = 0;
    if (j == 0)
     dp[i][j] = 1;
   }
  }
  for (int i = 1; i < m + 1; i++) {
   for (int j = 1; j < n + 1; j++) {
    if (s[i - 1] <= j)
     dp[i][j] = dp[i - 1][j] + dp[i][j - s[i - 1]];
    else
     dp[i][j] = dp[i - 1][j];
   }
  }
  return dp[m][n];
 }
}
