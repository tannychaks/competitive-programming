package striverSDEsheet.day1;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/relative-sort-array/
 */
public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 }, arr2 = { 2, 1, 4, 3, 9, 6 };
        int[] ans = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int el : arr1) {
            if (el < min)
                min = el;
            if (el > max)
                max = el;
        }

        int range = max - min + 1;
        int[] freqArr = new int[range];

        for (int i = 0; i < arr1.length; i++) {
            int index = arr1[i] - min;
            freqArr[index]++;
        }

        int[] ans = new int[arr1.length];
        int k = 0;

        for (int el : arr2) {
            int index = el - min;
            while (freqArr[index] != 0) {
                ans[k++] = el;
                freqArr[index]--;
            }
        }

        for (int i = 0; i < freqArr.length; i++) {
            while (freqArr[i] != 0) {
                ans[k++] = i + min;
                freqArr[i]--;
            }
        }
        return ans;
    }

}
