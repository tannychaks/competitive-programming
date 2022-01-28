package dynamicProgramming.knapsack_01;

import java.util.ArrayList;
import java.util.List;

public class MinimumSubsetSumDifference {
  public static void main(String[] args) {
    int n = 4;
    int arr[] = { 1, 6, 11, 5 };

    System.out.println(minDifference(n, arr));
  }

  private static int minDifference(int n, int[] arr) {
    int range = 0;
    for (int i = 0; i < n; i++)
      range += arr[i];

    List<Integer> possibleSumSubsets = isSubsetSumPossible(arr, n, range);

    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i < possibleSumSubsets.size(); i++)
      minDiff = Math.min(minDiff, Math.abs(range - (2 * possibleSumSubsets.get(i))));
    return minDiff;
  }

  private static List<Integer> isSubsetSumPossible(int[] arr, int n, int range) {
    boolean[][] dp = new boolean[n + 1][range + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < range + 1; j++) {
        if (i == 0)
          dp[i][j] = false;
        if (j == 0)
          dp[i][j] = true;
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < range + 1; j++) {
        if (arr[i - 1] <= j)
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
        else
          dp[i][j] = dp[i - 1][j];
      }
    }

    List<Integer> possibleSumSubsets = new ArrayList<>();
    for (int i = 0; i < range + 1; i++) {
      if (dp[n][i])
        possibleSumSubsets.add(i);
    }
    return possibleSumSubsets;
  }
}
