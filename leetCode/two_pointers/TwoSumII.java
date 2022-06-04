package leetCode.two_pointers;

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;
        int[] ans = twoSum(nums, target);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] twoSum(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int sum = nums[low] + nums[high];
            if (sum == target)
                return new int[] { low + 1, high + 1 };
            else if (sum < target)
                low++;
            else
                high--;
        }
        return new int[2];
    }
}
