package loveBabbar.dynamic_programming;

public class EditDistance {
 public static void main(String[] args) {
  String s = "geek", t = "gesek";
  System.out.println(editDistance(s, t));
 }

 private static int editDistance(String s, String t) {
  int m = s.length(), n = t.length();
  int[][] dp = new int[m + 1][n + 1];

  for (int i = 0; i < m + 1; i++) {
   for (int j = 0; j < n + 1; j++) {
    if (i == 0)
     dp[i][j] = j;
    else if (j == 0)
     dp[i][j] = i;
    else if (s.charAt(i - 1) == t.charAt(j - 1))
     dp[i][j] = dp[i - 1][j - 1];
    else
     dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
   }
  }
  return dp[m][n];
 }

 private static int min(int i, int j, int k) {
  if (i <= j && i <= k)
   return i;
  else if (j <= i && j <= k)
   return j;
  else
   return k;
 }
}
