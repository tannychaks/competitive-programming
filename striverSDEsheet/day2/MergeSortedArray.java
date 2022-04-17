package striverSDEsheet.day2;

import java.util.Arrays;

/**
 * 
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/
 * 
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
 * order, and two integers m and n, representing the number of elements in nums1
 * and nums2 respectively.
 * 
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 * The final sorted array should not be returned by the function, but instead be
 * stored inside the array nums1. To accommodate this, nums1 has a length of m +
 * n, where the first m elements denote the elements that should be merged, and
 * the last n elements are set to 0 and should be ignored. nums2 has a length of
 * n.
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = new int[] { 2, 5, 6 };

        int m = 3, n = 3;

        merge(nums1, m, nums2, n);
        printArray(nums1);
    }

    private static void printArray(int[] nums1) {
        Arrays.stream(nums1).forEach(num -> System.out.print(num + " "));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int maxOf1 = m - 1, maxOf2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (maxOf1 >= 0 && maxOf2 >= 0) {
                if (nums1[maxOf1] > nums2[maxOf2]) {
                    nums1[i] = nums1[maxOf1];
                    maxOf1--;
                } else {
                    nums1[i] = nums2[maxOf2];
                    maxOf2--;
                }
            } else if (maxOf1 >= 0) {
                nums1[i] = nums1[maxOf1];
                maxOf1--;
            } else {
                nums1[i] = nums2[maxOf2];
                maxOf2--;
            }
        }

    }

}
