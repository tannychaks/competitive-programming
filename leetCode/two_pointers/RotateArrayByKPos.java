package leetCode.two_pointers;

import java.util.Arrays;

/** https://leetcode.com/problems/rotate-array/ */
public class RotateArrayByKPos {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        rotate(nums, k);

        System.out.println(Arrays.toString(nums));
    }

    private static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % nums.length;
        flip(nums, 0, n - k - 1);
        flip(nums, n - k, n - 1);
        flip(nums, 0, n - 1);
    }

    private static void flip(int[] nums, int low, int high) {

        while (low <= high) {
            nums[low] += nums[high] - (nums[high] = nums[low]);
            low++;
            high--;
        }
    }
}
