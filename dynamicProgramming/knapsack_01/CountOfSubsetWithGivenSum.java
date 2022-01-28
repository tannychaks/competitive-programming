package dynamicProgramming.knapsack_01;

import java.util.Scanner;

public class CountOfSubsetWithGivenSum {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int k = sc.nextInt();
    int arr[] = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println(countSubset(N, arr, k));
    sc.close();
  }

  private static int countSubset(int n, int[] arr, int sum) {
    int[][] dp = new int[n + 1][sum + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < sum + 1; j++) {
        if (i == 0)
          dp[i][j] = 0;
        if (j == 0)
          dp[i][j] = 1;
      }
    }
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (arr[i - 1] <= j)
          dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
        else
          dp[i][j] = dp[i - 1][j];
      }
    }
    return dp[n][sum];
  }
}
