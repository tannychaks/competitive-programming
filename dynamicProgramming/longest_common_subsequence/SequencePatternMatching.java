package dynamicProgramming.longest_common_subsequence;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false
 * otherwise.
 * 
 * Leet code link: https://leetcode.com/problems/is-subsequence/
 * 
 * 392. Is Subsequence
 */
public class SequencePatternMatching {
 public static void main(String[] args) {
  String s = "axy", t = "adxcpy";
  System.out.println(isSubsequence(s, t));
 }

 /**
  * This is an optimized approach O(m+n)
  */
 private static boolean isSubsequence(String s, String t) {
  // We use 2-pointer approach here

  int i = 0, j = 0;
  while (i < s.length()) {
   if (j == t.length())
    return false;
   else if (s.charAt(i) == t.charAt(j)) {
    i++;
    j++;
   } else
    j++;
  }
  return true;
 }

 /**
  * This is the LCS approach O(m*n)
  * 
  * @param s
  * @param t
  * @return
  */
 private static boolean isSubsequenceLCS(String s, String t) {
  int lcs = lcs(s, t, s.length(), t.length());

  return lcs == s.length();
 }

 private static int lcs(String s, String t, int m, int n) {
  int[][] dp = new int[m + 1][n + 1];
  for (int i = 0; i < m + 1; i++) {
   for (int j = 0; j < n + 1; j++) {
    if (i == 0 || j == 0)
     dp[i][j] = 0;
    else if (s.charAt(i - 1) == t.charAt(j - 1))
     dp[i][j] = dp[i - 1][j - 1] + 1;
    else
     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
   }
  }
  return dp[m][n];
 }
}
