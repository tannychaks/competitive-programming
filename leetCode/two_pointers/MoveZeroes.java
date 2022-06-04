package leetCode.two_pointers;

import java.util.Arrays;

/** https://leetcode.com/problems/move-zeroes/ */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[] { 0, 1, 0, 3, 12 };
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void moveZeroes(int[] nums) {
        int i = 0;
        while (i < nums.length && nums[i] != 0)
            i++;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
            }
        }

    }
}
