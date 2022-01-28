package dynamicProgramming.knapsack_01;

public class CountOfSubsetWithGivenDifference {
  public static void main(String[] args) {
    int N = 4;
    int arr[] = { 1, 1, 2, 3 };
    int diff = 1;
    System.out.println(countSubsetWithDifference(N, arr, diff));
  }

  private static int countSubsetWithDifference(int n, int[] arr, int diff) {
    int totalSum = 0;
    for (int i = 0; i < n; i++)
      totalSum += arr[i];

    if (((diff + totalSum) & 1) == 1)
      return 0;
    int sum = (diff + totalSum) / 2;
    return countSubsetWithGivenSum(n, arr, sum);
  }

  private static int countSubsetWithGivenSum(int n, int[] arr, int sum) {
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
