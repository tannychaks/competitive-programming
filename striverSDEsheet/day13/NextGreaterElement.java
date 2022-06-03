package striverSDEsheet.day13;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/next-greater-element-i
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums1 = new int[] { 4, 1, 2 };
        int[] nums2 = new int[] { 1, 3, 4, 2 };
        int[] ans = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        int[] ans = new int[nums1.length];
        // added elemests with their index in map
        for (int i = 0; i < nums1.length; i++) {
            int a = nums1[i];
            // nums1 is a subset of nums2
            // so a will definitely be present inside nums2
            int index = map.get(a);
            // now from index to length of nums2 , search for elemets just greater than a
            // int max=-1;
            int max = -1;
            for (int j = index + 1; j < nums2.length; j++) {
                if (nums2[j] > a) {
                    max = nums2[j];
                    break;
                }
            }
            ans[i] = max;
        }
        return ans;
    }
}
