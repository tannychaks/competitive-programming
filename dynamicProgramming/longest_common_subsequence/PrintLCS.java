package dynamicProgramming.longest_common_subsequence;

public class PrintLCS {
 public static void main(String[] args) {
  String s1 = "AGGTAB";
  String s2 = "GXTXAYB";
  int x = s1.length(), y = s2.length();
  System.out.println(printLcs(x, y, s1, s2));
 }

 private static String printLcs(int x, int y, String s1, String s2) {

  int[][] dp = lcs(x, y, s1, s2);
  StringBuilder lcsbuilder = new StringBuilder();
  int i = x, j = y;
  while (i > 0 && j > 0) {
   if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
    lcsbuilder.append(s1.charAt(i - 1));
    i--;
    j--;
   } else {
    if (dp[i][j - 1] > dp[i - 1][j])
     j--;
    else
     i--;
   }
  }
  return lcsbuilder.reverse().toString();
 }

 private static int[][] lcs(int x, int y, String s1, String s2) {
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
  return dp;
 }
}
