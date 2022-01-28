package dynamicProgramming.longest_common_subsequence;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 * 
 * 
 * Leet Code link:https://leetcode.com/problems/longest-palindromic-subsequence/
 * 
 * 516. Longest Palindromic Subsequence
 * 
 */
public class LongestPalindromicSubsequence {
  public static void main(String[] args) {
    String seq = "agbcba";
    int n = seq.length();
    System.out.println(lps(seq, n));
  }

  private static int lps(String seq, int n) {
    String reverseSeq = reverse(seq);
    return lcs(seq, reverseSeq, n, n);
  }

  private static int lcs(String a, String b, int m, int n) {
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
        else if (a.charAt(i - 1) == b.charAt(j - 1))
          dp[i][j] = 1 + dp[i - 1][j - 1];
        else
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }
    return dp[m][n];
  }

  private static String reverse(String s) {
    int length = s.length();
    if (length == 0)
      return "";
    int l = 0;
    int r = length - 1;
    char[] ch = s.toCharArray();
    while (l < r) {
      char c = ch[l];
      ch[l] = ch[r];
      ch[r] = c;
      l++;
      r--;
    }
    return new String(ch);
  }

}
