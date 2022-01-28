package dynamicProgramming.knapsack_01;

/**
 * Given a non-empty array nums containing only positive integers, find if the
 * array can be partitioned into two subsets such that the sum of elements in
 * both subsets is equal.
 * 
 * Leet Code link:https://leetcode.com/problems/partition-equal-subset-sum/
 * 
 * 416. Partition Equal Subset Sum
 */
public class EqualSumPartition {
  public static void main(String[] args) {
    int N = 4;
    int arr[] = { 1, 5, 11, 5 };
    // int N = 4;
    // int arr[] = { 1, 5, 11, 5 };
    if (equalPartition(N, arr) == 1)
      System.out.println("YES");
    else
      System.out.println("NO");
  }

  private static int equalPartition(int n, int[] arr) {
    int totalSum = 0, sum = 0;
    for (int i = 0; i < n; i++) {
      totalSum += arr[i];
    }
    // System.out.println("total sum = " + totalSum);
    if ((totalSum & 1) == 1) // checking for odd sum
      return 0;
    else {
      sum = totalSum / 2;
      // System.out.println("subset sum = " + sum);
      // Now code same as Subset Sum problem
      boolean[][] dp = new boolean[n + 1][sum + 1];
      // initialization
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

      return dp[n][sum] ? 1 : 0;
    }

  }
}
