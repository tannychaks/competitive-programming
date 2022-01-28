package dynamicProgramming.unbounded_knapsack;

/**
 * Rod Cutting Problem Given a rod of length n inches and an array of prices
 * that contains prices of all pieces of size smaller than n. Determine the
 * maximum value obtainable by cutting up the rod and selling the pieces.
 * Example: if length of the rod is 8 and the values of different pieces are
 * given as following, then the maximum obtainable value is 22 (by cutting in
 * two pieces of lengths 2 and 6)
 * 
 * 
 * 
 * length | 1 2 3 4 5 6 7 8 -------------------------------------------- price |
 * 1 5 8 9 10 17 17 20
 */
public class RodCutting {
 public static void main(String[] args) {
  int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
  int n = 8;
  System.out.println(rodCut(price, n));
 }

 private static int rodCut(int[] price, int n) {
  int length[] = new int[n];
  for (int i = 0; i < n; i++) {
   length[i] = i + 1;
  }
  int[][] dp = new int[n + 1][price.length + 1];
  for (int i = 0; i < n + 1; i++) {
   for (int j = 0; j < n + 1; j++) {
    if (i == 0 || j == 0)
     dp[i][j] = 0;
    else if (length[i - 1] <= j)
     dp[i][j] = Math.max(dp[i - 1][j], price[i - 1] + dp[i][j - length[i - 1]]);
    else
     dp[i][j] = dp[i - 1][j];
   }
  }
  return dp[n][n];
 }
}
