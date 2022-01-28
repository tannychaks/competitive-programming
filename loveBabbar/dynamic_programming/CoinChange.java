package loveBabbar.dynamic_programming;

public class CoinChange {
 public static void main(String[] args) {
  int n = 4, m = 3;
  int[] s = new int[] { 1, 2, 3 };
  System.out.println(count(s, m, n));
 }

 public static long count(int s[], int m, int n) {
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
