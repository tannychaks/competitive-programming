package dynamicProgramming.longest_common_subsequence;

/**
 * Given two sequences, find the length of longest subsequence present in both
 * of them. Both the strings are of uppercase
 * 
 * Input: A = 6, B = 6 str1 = ABCDGH str2 = AEDFHR Output: 3 Explanation: LCS
 * for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 */
public class LCS {
 public static void main(String[] args) {
  String s1 = "ABCDGH";
  String s2 = "AEDFHR";
  int x = 6, y = 6;
  System.out.println(lcs(x, y, s1, s2));
 }

 private static int lcs(int x, int y, String s1, String s2) {
  int[][] dp = new int[x + 1][y + 1];

  for (int i = 0; i < x + 1; i++) {
   for (int j = 0; j < y + 1; j++) {
    if (i == 0 || j == 0)
     dp[i][j] = 0;
    else if (s1.charAt(i - 1) == s2.charAt(j - 1))
     dp[i][j] = 1 + dp[i - 1][j - 1];
    else
     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
   }
  }
  return dp[x][y];
 }
}
