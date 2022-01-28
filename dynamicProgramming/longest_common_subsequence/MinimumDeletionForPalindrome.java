package dynamicProgramming.longest_common_subsequence;

public class MinimumDeletionForPalindrome {
 public static void main(String[] args) {
  String seq = "aebcbda";

  System.out.println(minimumNumberOfDeletions(seq));
 }

 private static int minimumNumberOfDeletions(String s) {
  int n = s.length();
  String reverseS = reverse(s);
  int lps = lcs(s, reverseS, n, n);
  return n - lps;
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
