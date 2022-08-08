package general;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountSubsequenceWithSumGreater {
    public static void main(String[] args) {
        int[] array = new int[] { -6, -5, 10, -8, -4, 10, 5, 10, -1, -2 };
        List<Integer> Arr = Arrays.stream(array).boxed().collect(Collectors.toList());
        int X = 5;
        int N = 10;

        int ans = calcAns(N, Arr, X);
        System.out.println(ans);
    }

    private static int calcAns(int N, List<Integer> Arr, int X) {
        int[][] dp = new int[N][X + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < X + 1; j++) {
                dp[i][j] = -1;
            }
        }

        return countSubsequenceUtil(0, X, Arr, N, dp) - 1;
    }

    private static int countSubsequenceUtil(int ind, int sum, List<Integer> arr, int N, int[][] dp) {
        if (ind == N)
            return 1;

        if (dp[ind][sum] != -1)
            return dp[ind][sum];

        if (arr.get(ind) >= sum * arr.get(ind))
            dp[ind][sum] = countSubsequenceUtil(ind + 1, sum,
                    arr, N, dp) +

                    countSubsequenceUtil(ind + 1, sum - arr.get(ind), arr, N, dp);
        else
            dp[ind][sum] = countSubsequenceUtil(ind + 1, sum, arr, N, dp);

        return dp[ind][sum];
    }

}
