package dynamicProgramming.unbounded_knapsack;

/**
 * Given an integer N denoting the Length of a line segment. You need to cut the
 * line segment in such a way that the cut length of a line segment each time is
 * either x , y or z. Here x, y, and z are integers. After performing all the
 * cut operations, your total number of cut segments must be maximum.
 */
public class MaximizeCutSegments {
 public static void main(String[] args) {
  int x = 5, y = 3, z = 2;
  int n = 8;
  System.out.println(maximizeCuts(n, x, y, z));
 }

 private static int maximizeCuts(int n, int x, int y, int z) {
  int[] dp = new int[n + 1];
  for (int i = 0; i < n + 1; i++)
   dp[i] = -1;
  dp[0] = 0;
  for (int i = 0; i < n + 1; i++) {

   if (dp[i] == -1)
    continue;

   if (i + x <= n)
    dp[i + x] = Math.max(dp[i + x], dp[i] + 1);

   if (i + y <= n)
    dp[i + y] = Math.max(dp[i + y], dp[i] + 1);

   if (i + z <= n)
    dp[i + z] = Math.max(dp[i + z], dp[i] + 1);
  }

  // if no segment can be cut then return 0
  if (dp[n] == -1) {
   dp[n] = 0;
  }
  return dp[n];
 }
}
