package dynamicProgramming.longest_common_subsequence;

public class PrintSCS {
 public static void main(String[] args) {
  String s1 = "AGGTAB";
  String s2 = "GXTXAYB";
  int x = s1.length(), y = s2.length();
  System.out.println(printScs(x, y, s1, s2));
 }

 private static String printScs(int x, int y, String s1, String s2) {
  int[][] dp = lcs(s1, s2, x, y);
  int i = x, j = y;
  StringBuilder scs = new StringBuilder();

  while (i > 0 && j > 0) {
   if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
    scs.append(s1.charAt(i - 1));
    i--;
    j--;
   } else {
    if (dp[i - 1][j] > dp[i][j - 1]) {
     scs.append(s1.charAt(i - 1));
     i--;
    } else {
     scs.append(s2.charAt(j - 1));
     j--;
    }
   }
  }

  while (i > 0) {
   scs.append(s1.charAt(i - 1));
   i--;
  }

  while (j > 0) {
   scs.append(s2.charAt(j - 1));
   j--;
  }
  return scs.reverse().toString();
 }

 private static int[][] lcs(String s1, String s2, int x, int y) {
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
