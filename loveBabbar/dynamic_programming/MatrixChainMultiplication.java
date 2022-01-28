package loveBabbar.dynamic_programming;

import java.util.Arrays;

/**
 * Given a sequence of matrices, find the most efficient way to multiply these
 * matrices together. The efficient way is the one that involves the least
 * number of multiplications.
 * 
 * The dimensions of the matrices are given in an array arr[] of size N (such
 * that N = number of matrices + 1) where the ith matrix has the dimensions
 * (arr[i-1] x arr[i]).
 * 
 */
public class MatrixChainMultiplication {
 static int[][] dp = new int[101][101];

 public static void main(String[] args) {
  int[] arr = new int[] { 40, 20, 30, 10, 30 };
  int n = arr.length;
  // System.out.println(matrixMultiplication(n, arr));
  System.out.println(matrixMultiplicationTabulation(n, arr));
 }

 private static int matrixMultiplicationTabulation(int n, int[] arr) {
  /*
   * For simplicity of the program, one extra row and one extra column are
   * allocated in m[][]. 0th row and 0th column of m[][] are not used
   */
  int m[][] = new int[n][n];

  int i, j, k, L;

  /*
   * m[i, j] = Minimum number of scalar multiplications needed to compute the
   * matrix A[i]A[i+1]...A[j] = A[i..j] where dimension of A[i] is p[i-1] x p[i]
   */

  // cost is zero when multiplying one matrix.
  for (i = 1; i < n; i++)
   m[i][i] = 0;

  // L is chain length.
  for (L = 2; L < n; L++) {
   for (i = 1; i < n - L + 1; i++) {
    j = i + L - 1;
    if (j == n)
     continue;
    m[i][j] = Integer.MAX_VALUE;
    for (k = i; k <= j - 1; k++) {
     // cost/scalar multiplications
     m[i][j] = Math.min(m[i][j], m[i][k] + m[k + 1][j] + arr[i - 1] * arr[k] * arr[j]);

    }
   }
  }

  return m[1][n - 1];

 }

 private static int matrixMultiplication(int n, int[] arr) {
  for (int[] row : dp)
   Arrays.fill(row, -1);
  return solve(arr, 1, n - 1);

 }

 private static int solve(int[] arr, int i, int j) {

  if (i >= j)
   return 0;
  if (dp[i][j] != -1) {
   return dp[i][j];
  }
  dp[i][j] = Integer.MAX_VALUE;
  for (int k = i; k <= j - 1; k++) {
   dp[i][j] = Math.min(dp[i][j], solve(arr, i, k) + solve(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]));

  }
  return dp[i][j];
 }
}
