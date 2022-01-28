package dynamicProgramming.knapsack_01;

public class SubsetSum {
  public static void main(String[] args) {
    // int n = 5;
    // int arr[] = { 1, 5, 3, 7, 4 };
    int n = 4;
    int arr[] = { 2, 7, 11, 15 };
    int sum = 9;
    if (isSubsetSum(n, arr, sum))
      System.out.println("YES");
    else
      System.out.println("NO");
  }

  private static boolean isSubsetSum(int n, int[] arr, int sum) {
    boolean[][] dp = new boolean[n + 1][sum + 1];
    // Initialization
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < sum + 1; j++) {
        if (i == 0)
          dp[i][j] = false;
        if (j == 0)
          dp[i][j] = true;
      }
    }
    // Choice Diagram
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (arr[i - 1] <= j)
          dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
        else
          dp[i][j] = dp[i - 1][j];
      }
    }
    return dp[n][sum];
  }
}
