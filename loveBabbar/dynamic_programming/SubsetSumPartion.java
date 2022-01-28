package loveBabbar.dynamic_programming;

public class SubsetSumPartion {
 public static void main(String[] args) {
  int n = 4;
  int[] arr = { 1, 5, 11, 5 };
  System.out.println(equalPartition(n, arr));
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
   // for (int i = 0; i < n + 1; i++) {
   // for (int j = 0; j < sum + 1; j++) {
   // System.out.print(dp[i][j] + " ");
   // }
   // System.out.println();
   // }
   return dp[n][sum] ? 1 : 0;
  }
 }
}
