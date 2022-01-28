package leetCode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * Leetcode link: https://leetcode.com/problems/two-sum/
 * 
 * 1. Two Sum
 */
public class TwoSum {
 public static void main(String[] args) {
  int[] nums = new int[] { 2, 7, 11, 15 };
  int target = 9;
  System.out.println(Arrays.toString(twoSum(nums, target)));
 }

 private static int[] twoSum(int[] nums, int target) {
  Map<Integer, Integer> map = new HashMap<>();
  for (int i = 0; i < nums.length; i++) {
   int curr = nums[i];
   if (map.get(target - curr) != null) {
    return new int[] { i, map.get(target - curr) };
   }
   map.put(curr, i);
  }
  return new int[] {};
 }
}
