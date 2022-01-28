package dynamicProgramming.matrix_chain_multiplication;

import java.util.Arrays;

/**
 * Given a string str, a partitioning of the string is a palindrome partitioning
 * if every sub-string of the partition is a palindrome. Determine the fewest
 * cuts needed for palindrome partitioning of given string.
 * 
 * Input: str = "ababbbabbababa" Output: 3 Explaination: After 3 partitioning
 * substrings are "a", "babbbab", "b", "ababa".
 * 
 * Problem link:https://www.geeksforgeeks.org/palindrome-partitioning-dp-17/
 */
public class PalindromePartitioning {
 public static void main(String[] args) {
  String str = "ababbbabbababa";
  System.out.println(palindromicPartition(str));
 }

 static int[][] dp = new int[501][501];

 private static int palindromicPartition(String str) {
  for (int[] row : dp)
   Arrays.fill(row, -1);
  return solveOptimized(str, 0, str.length() - 1);
 }

 private static int solve(String str, int i, int j) {
  if (i >= j || isPalin(str, i, j))
   return 0;
  if (dp[i][j] != -1)
   return dp[i][j];
  dp[i][j] = Integer.MAX_VALUE;
  for (int k = i; k <= j - 1; k++) {
   dp[i][j] = Math.min(dp[i][j], solve(str, i, k) + solve(str, k + 1, j) + 1);
  }
  return dp[i][j];
 }

 private static int solveOptimized(String str, int i, int j) {
  if (i >= j || isPalin(str, i, j))
   return 0;
  if (dp[i][j] != -1)
   return dp[i][j];
  dp[i][j] = Integer.MAX_VALUE;
  for (int k = i; k <= j - 1; k++) {
   int left, right;
   if (dp[i][k] != -1)
    left = dp[i][k];
   else
    left = solve(str, i, k);

   if (dp[k + 1][j] != -1)
    right = dp[k + 1][j];
   else
    right = solve(str, k + 1, j);
   dp[i][j] = Math.min(dp[i][j], left + right + 1);
  }
  return dp[i][j];
 }

 static boolean isPalin(String s, int i, int j) {
  while (i < j) {
   if (s.charAt(i) != s.charAt(j))
    return false;
   i++;
   j--;
  }
  return true;
 }

}
