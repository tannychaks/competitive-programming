package dynamicProgramming.longest_common_subsequence;

public class LongestCommonSubstring {
 public static void main(String[] args) {
  String s1 = "ABCDGH";
  String s2 = "ACDGHR";
  int x = 6, y = 6;
  System.out.println(longestCommonSubstring(x, y, s1, s2));
 }

 private static int longestCommonSubstring(int x, int y, String s1, String s2) {
  int[][] dp = new int[x + 1][y + 1];
  int ans = 0;
  for (int i = 0; i < x + 1; i++) {
   for (int j = 0; j < y + 1; j++) {
    if (i == 0 || j == 0)
     dp[i][j] = 0;
    else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
     dp[i][j] = 1 + dp[i - 1][j - 1];
     ans = Math.max(ans, dp[i][j]);
    } else
     dp[i][j] = 0;
   }
  }
  return ans;
 }
}
