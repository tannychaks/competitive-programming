package dynamicProgramming.knapsack_01;

public class TargetSum {
  public static void main(String[] args) {

    int nums[] = { 1, 1, 1, 1, 1 };
    int target = 3;
    System.out.println(targetSum(nums, target));
  }

  private static int targetSum(int[] nums, int target) {
    int totalSum = 0;
    for (int i = 0; i < nums.length; i++)
      totalSum += nums[i];
    if (target > totalSum)
      return 0;
    /**
     * one more condition needs to be checked i.e.if(((target + totalSum)& 1) == 1)
     * then we would never get the difference S by partitioning the array into two
     * subsets.
     */
    if (((target + totalSum) & 1) == 1) // checking for odd
      return 0;
    int sum = (target + totalSum) / 2;
    return countSubsetWithGivenSum(nums.length, nums, sum);
  }

  private static int countSubsetWithGivenSum(int length, int[] nums, int sum) {
    int[][] dp = new int[length + 1][sum + 1];
    dp[0][0] = 1; // 1st change
    // for (int i = 0; i < length + 1; i++) {
    // for (int j = 0; j < sum + 1; j++) {
    // if (i == 0)
    // dp[i][j] = 0;
    // if (j == 0)
    // dp[i][j] = 1;
    // }
    // }

    for (int i = 1; i < length + 1; i++) {
      for (int j = 0; j < sum + 1; j++) { // 2nd change
        if (nums[i - 1] <= j)
          dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
        else
          dp[i][j] = dp[i - 1][j];
      }
    }

    return dp[length][sum];
  }
}
