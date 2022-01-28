package dynamicProgramming.longest_common_subsequence;

public class PrintLRS {
 public static void main(String[] args) {
  String str = "axxxy";
  System.out.println(printLrs(str));
 }

 private static String printLrs(String str) {
  int[][] dp = lrs(str);
  int n = str.length();
  for (int i = 0; i < n + 1; i++) {
   for (int j = 0; j < n + 1; j++) {
    System.out.print(dp[i][j] + " ");
   }
   System.out.println();
  }

  StringBuilder lrsBuilder = new StringBuilder();

  int i = n, j = n;
  while (i > 0 && j > 0) {
   // If this cell is same as diagonally
   // adjacent cell just above it, then
   // same characters are present at
   // str[i-1] and str[j-1]. Append any
   // of them to result.
   if (dp[i][j] == dp[i - 1][j - 1] + 1) {
    lrsBuilder.append(str.charAt(i - 1));
    i--;
    j--;
   } else {
    // Otherwise we move to the side
    // that that gave us maximum result
    if (dp[i][j] == dp[i - 1][j])
     i--;
    else
     j--;
   }
  }
  return lrsBuilder.reverse().toString();
 }

 private static int[][] lrs(String str) {
  String str1 = str;
  int n = str.length();
  int[][] dp = new int[n + 1][n + 1];
  for (int i = 0; i < n + 1; i++) {
   for (int j = 0; j < n + 1; j++) {
    if (i == 0 || j == 0)
     dp[i][j] = 0;
    else if (str.charAt(i - 1) == str1.charAt(j - 1) && i != j)
     dp[i][j] = dp[i - 1][j - 1] + 1;
    else
     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
   }
  }
  return dp;
 }
}
