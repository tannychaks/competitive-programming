package striverSDEsheet.day1;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class SortWithoutSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 0, 2, 1, 1, 0 };
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;
        while (j <= k) {
            switch (nums[j]) {
                case 0:
                    nums[i] += nums[j] - (nums[j] = nums[i]);
                    i++;
                    j++;
                    break;
                case 1:
                    j++;
                    break;
                case 2:
                    nums[j] += nums[k] - (nums[k] = nums[j]);
                    k--;
                    break;
            }
        }
    }
}
