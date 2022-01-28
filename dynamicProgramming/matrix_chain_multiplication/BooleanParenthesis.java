package dynamicProgramming.matrix_chain_multiplication;

import java.util.Arrays;

/**
 * 
 * Problem
 * link:https://www.geeksforgeeks.org/boolean-parenthesization-problem-dp-37/
 * 
 * Given a boolean expression S of length N with following symbols. Symbols 'T'
 * ---> true 'F' ---> false and following operators filled between symbols
 * Operators & ---> boolean AND | ---> boolean OR ^ ---> boolean XOR Count the
 * number of ways we can parenthesize the expression so that the value of
 * expression evaluates to true.
 * 
 * Your Task: You do not need to read input or print anything. Your task is to
 * complete the function countWays() which takes N and S as input parameters and
 * returns number of possible ways modulo 1003.
 */
public class BooleanParenthesis {
 public static void main(String[] args) {
  String s = "T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F";
  int n = s.length();
  System.out.println(countWays(n, s));
 }

 private static int countWays(int n, String s) {
  int dp[][][] = new int[n + 1][n + 1][2];
  for (int row[][] : dp) {
   for (int col[] : row) {
    Arrays.fill(col, -1);
   }
  }
  return countParenthesis(s, 0, n - 1, 1, dp);
 }

 private static int countParenthesis(String s, int i, int j, int isTrue, int[][][] dp) {

  // Base condition
  if (i > j)
   return 0;
  if (i == j) {
   if (isTrue == 1)
    return s.charAt(i) == 'T' ? 1 : 0;
   else
    return s.charAt(i) == 'F' ? 1 : 0;
  }
  if (dp[i][j][isTrue] != -1)
   return dp[i][j][isTrue];
  int ans = 0;
  int leftTrue, leftFalse, rightTrue, rightFalse;
  for (int k = i + 1; k <= j - 1; k++) {
   if (dp[i][k - 1][1] != -1)
    leftTrue = dp[i][k - 1][1];
   else {
    leftTrue = countParenthesis(s, i, k - 1, 1, dp);
   }

   if (dp[i][k - 1][0] != -1)
    leftFalse = dp[i][k - 1][0];
   else {
    leftFalse = countParenthesis(s, i, k - 1, 0, dp);
   }
   if (dp[k + 1][j][1] != -1)
    rightTrue = dp[k + 1][j][1];
   else {
    rightTrue = countParenthesis(s, k + 1, j, 1, dp);
   }
   if (dp[k + 1][j][0] != -1)
    rightFalse = dp[k + 1][j][0];
   else {
    rightFalse = countParenthesis(s, k + 1, j, 0, dp);
   }

   if (s.charAt(k) == '|') {
    if (isTrue == 1)
     ans += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
    else
     ans += leftFalse * rightFalse;
   } else if (s.charAt(k) == '&') {
    if (isTrue == 0)
     ans += leftFalse * rightFalse + leftTrue * rightFalse + leftFalse * rightTrue;
    else
     ans += leftTrue * rightTrue;
   } else if (s.charAt(k) == '^') {
    if (isTrue == 1)
     ans += leftTrue * rightFalse + leftFalse * rightTrue;
    else
     ans += leftTrue * rightTrue + leftFalse * rightFalse;
   }

  }
  return dp[i][j][isTrue] = ans % 1003;
 }
}
