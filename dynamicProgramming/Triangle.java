package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/triangle/
 */
public class Triangle {
    public static void main(String[] args) {
        int[][] nums = new int[][] { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
        List<List<Integer>> triangle = new ArrayList<>();
        for (int[] arr : nums) {
            triangle.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        }
        int ans = minimumTotal(triangle);
        System.out.println(ans);
    }

    /**
     * https://www.youtube.com/watch?v=1IL5sxfoA-I
     * 
     * @param triangle
     * @return
     */
    private static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++)
            dp[i] = triangle.get(n - 1).get(i);
        for (int i = n - 2; i >= 0; i--)
            for (int j = 0; j < triangle.get(i).size(); j++)
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
        return dp[0];
    }

}
