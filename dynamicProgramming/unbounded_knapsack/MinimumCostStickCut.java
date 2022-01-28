package dynamicProgramming.unbounded_knapsack;

import java.util.Arrays;

/**
 * Leetcode link: https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
 * 
 * Given a wooden stick of length n units. The stick is labelled from 0 to n.
 * For example, a stick of length 6 is labelled as follows:
 * 
 * 
 * Given an integer array cuts where cuts[i] denotes a position you should
 * perform a cut at.
 * 
 * You should perform the cuts in order, you can change the order of the cuts as
 * you wish.
 * 
 * The cost of one cut is the length of the stick to be cut, the total cost is
 * the sum of costs of all cuts. When you cut a stick, it will be split into two
 * smaller sticks (i.e. the sum of their lengths is the length of the stick
 * before the cut). Please refer to the first example for a better explanation.
 * 
 * Return the minimum total cost of the cuts.
 * 
 * Input: n = 7, cuts = [1,3,4,5] Output: 16
 */
public class MinimumCostStickCut {

 public static void main(String[] args) {
  // int[] a = new int[] { 1, 3, 4, 5 };
  // int n = 7;
  int[] a = new int[] { 5, 2, 3, 1, 4 };
  int n = 5;
  System.out.println(minCost(n, a));
 }

 public static int minCost(int n, int[] cuts) {
  A = new int[cuts.length + 2];
  System.arraycopy(cuts, 0, A, 1, cuts.length);
  A[0] = 0;
  A[A.length - 1] = n;

  Arrays.sort(A);

  // dp[i][j] := minCost(cuts[i..j])
  dp = new int[A.length][A.length];

  return minCost(0, A.length - 1);
 }

 private static int[][] dp;
 private static int[] A;

 private static int minCost(int i, int j) {
  if (j - i <= 1)
   return 0;
  if (dp[i][j] != 0)
   return dp[i][j];

  dp[i][j] = Integer.MAX_VALUE;

  for (int k = i + 1; k < j; ++k)
   dp[i][j] = Math.min(dp[i][j], A[j] - A[i] + minCost(i, k) + minCost(k, j));

  System.out.println(Arrays.deepToString(dp));
  return dp[i][j];
 }
}
