package leetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. Intersection of Two Arrays II
 * 
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * 
 * Given two integer arrays nums1 and nums2, return an array of their
 * intersection. Each element in the result must appear as many times as it
 * shows in both arrays and you may return the result in any order.
 */
public class Intersection2Arrays {
    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 2, 2, 1 };
        int[] nums2 = new int[] { 2, 2 };
        printArray(intersect(nums1, nums2));
    }

    private static void printArray(int[] arr) {
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }

    private static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            Integer count = map.get(num);
            if (count != null)
                map.put(num, ++count);
            else
                map.put(num, 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            Integer count = map.get(num);
            if (count != null && count > 0) {
                list.add(num);
                map.put(num, --count);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
