package striverSDEsheet.day1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }

    public static void nextPermutation(int[] nums) {
        // edge-cases
        if (nums == null || nums.length <= 1)
            return;

        int i = nums.length - 2, j;
        // find index1
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if (i >= 0) {
            // find index2
            j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i])
                j--;
            // swap index1 and index2
            nums[i] += nums[j] - (nums[j] = nums[i]);
        }
        // reverse to find lowest rank permuytation
        reverse(nums, i + 1, nums.length - 1);

    }

    private static void reverse(int[] nums, int i, int j) {
        while (i <= j) {
            nums[i] += nums[j] - (nums[j] = nums[i]);
            i++;
            j--;
        }
    }
}
