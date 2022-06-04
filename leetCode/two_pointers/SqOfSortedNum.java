package leetCode.two_pointers;

import java.util.Arrays;

/** https://leetcode.com/problems/squares-of-a-sorted-array/ */
public class SqOfSortedNum {
    public static void main(String[] args) {
        int[] nums = new int[] { -4, -1, 0, 3, 10 };
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {

        int[] sortedSquares = new int[nums.length];
        int pointer1 = 0, pointer2 = nums.length - 1, i = nums.length - 1;

        while (pointer1 <= pointer2) {
            if (Math.abs(nums[pointer1]) > Math.abs(nums[pointer2])) {
                sortedSquares[i--] = nums[pointer1] * nums[pointer1];
                pointer1++;
            } else {

                sortedSquares[i--] = nums[pointer2] * nums[pointer2];
                pointer2--;
            }
        }

        return sortedSquares;
    }
}
