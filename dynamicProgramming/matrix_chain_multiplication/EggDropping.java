package dynamicProgramming.matrix_chain_multiplication;

import java.util.Arrays;

/**
 * LeetCode link: https://leetcode.com/problems/super-egg-drop/
 * 
 * You are given k identical eggs and you have access to a building with n
 * floors labeled from 1 to n.
 * 
 * You know that there exists a floor f where 0 <= f <= n such that any egg
 * dropped at a floor higher than f will break, and any egg dropped at or below
 * floor f will not break.
 * 
 * Each move, you may take an unbroken egg and drop it from any floor x (where 1
 * <= x <= n). If the egg breaks, you can no longer use it. However, if the egg
 * does not break, you may reuse it in future moves.
 * 
 * Return the minimum number of moves that you need to determine with certainty
 * what the value of f is.
 */
public class EggDropping {
 public static void main(String[] args) {
  int k = 3, n = 14;
  System.out.println(superEggDrop(k, n));
 }

 /**
  * This solution gives TLE in leet code but passes in GFG
  * 
  * For further optimized
  * solution:https://www.geeksforgeeks.org/eggs-dropping-puzzle-binomial-coefficient-and-binary-search-solution/
  * 
  * https://www.geeksforgeeks.org/egg-dropping-puzzle-with-2-eggs-and-k-floors/
  */
 private static int superEggDrop(int k, int n) {
  int[][] dp = new int[k + 1][n + 1];
  for (int[] row : dp)
   Arrays.fill(row, -1);

  return solve(dp, k, n);
 }

 private static int solve(int[][] dp, int k, int n) {

  if (n == 0 || n == 1 || k == 1)
   return n;
  if (dp[k][n] != -1)
   return dp[k][n];
  int mn = Integer.MAX_VALUE;
  int low, high;
  for (int f = 1; f <= n; f++) {
   if (dp[k - 1][n - 1] != -1)
    low = dp[k - 1][f - 1];
   else
    low = solve(dp, k - 1, f - 1);

   if (dp[k][n - f] != -1)
    high = dp[k][n - f];
   else
    high = solve(dp, k, n - f);

   int temp = 1 + Math.max(low, high);

   mn = Math.min(mn, temp);
  }
  return dp[k][n] = mn;
 }

 /**
  * This is the most optimized approach.
  * https://leetcode.com/problems/super-egg-drop/submissions/ Time Complexity :
  * O(n Log k)
  * 
  * @param k
  * @param n
  * @return
  */
 private static int superEggDropOptimized(int k, int n) {
  int low = 1, high = n;
  while (low < high) {
   int mid = (low + high) / 2;
   if (binomialCoefficient(mid, k, n) < n)
    low = mid + 1;
   else
    high = mid;
  }

  return low;
 }

 private static int binomialCoefficient(int x, int k, int n) {
  int sum = 0, term = 1;
  for (int i = 1; i <= k && sum < n; ++i) {
   term *= x - i + 1;
   term /= i;
   sum += term;
  }
  return sum;
 }
}
