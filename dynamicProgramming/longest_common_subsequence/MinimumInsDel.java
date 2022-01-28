package dynamicProgramming.longest_common_subsequence;

public class MinimumInsDel {
 public static void main(String[] args) {
  String str1 = "heap", str2 = "pea";
  System.out.println(minOperations(str1, str2));
 }

 private static int minOperations(String str1, String str2) {
  int lcsLength = lcs(str1, str2, str1.length(), str2.length());
  return (str1.length() - lcsLength) + (str2.length() - lcsLength);
 }

 private static int lcs(String str1, String str2, int m, int n) {
  int[][] dp = new int[m + 1][n + 1];
  for (int i = 0; i < m + 1; i++) {
   for (int j = 0; j < n + 1; j++) {
    if (i == 0 || j == 0)
     dp[i][j] = 0;
    else if (str1.charAt(i - 1) == str2.charAt(j - 1))
     dp[i][j] = 1 + dp[i - 1][j - 1];
    else
     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
   }
  }
  return dp[m][n];
 }
}
