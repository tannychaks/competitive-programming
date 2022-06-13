package striverSDEsheet.day20;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/maximum-erasure-value/
 */
public class MaxErasureVal {
    public static void main(String[] args) {
        int[] nums = new int[] { 5, 2, 1, 2, 5, 2, 1, 2, 5 };
        int ans = maximumUniqueSubarray(nums);
        System.out.println(ans);
        ans = maximumUniqueSubarrayOptimized(nums);
        System.out.println(ans);
    }

    private static int maximumUniqueSubarrayOptimized(int[] nums) {
        boolean[] present = new boolean[10001];
        int left = 0, sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!present[nums[i]]) {
                sum += nums[i];
                present[nums[i]] = true;
            } else {
                max = Math.max(max, sum);
                while (nums[left] != nums[i]) {
                    present[nums[left]] = false;
                    sum -= nums[left];
                    left++;
                }
                left++;
            }
        }
        return Math.max(max, sum);
    }

    /**
     * https://leetcode.com/problems/maximum-erasure-value/discuss/2140577/An-Interesting-Optimisation-or-JAVA-Explanation
     * 
     * @param nums
     * @return
     */
    private static int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int l = 0, r = 0;
        int maxScore = 0, currScore = 0;
        while (r < nums.length) {
            while (!set.add(nums[r])) {
                currScore -= nums[l];
                set.remove(nums[l++]);
            }
            currScore += nums[r];
            maxScore = Math.max(maxScore, currScore);
            r++;
        }

        return maxScore;
    }
}
