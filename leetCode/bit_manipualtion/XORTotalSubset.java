package leetCode.bit_manipualtion;

/**
 * https://leetcode.com/problems/sum-of-all-subset-xor-totals/
 * 
 * 1863. Sum of All Subset XOR Totals
 * 
 * SAME as SUM of SUM of SUBSEQUENCES problem.
 * 
 * The XOR total of an array is defined as the bitwise XOR of all its elements,
 * or 0 if the array is empty.
 * 
 * For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
 * Given an array nums, return the sum of all XOR totals for every subset of
 * nums.
 * 
 * Note: Subsets with the same elements should be counted multiple times.
 * 
 * An array a is a subset of an array b if a can be obtained from b by deleting
 * some (possibly zero) elements of b
 */
public class XORTotalSubset {
 public static void main(String[] args) {
  int[] nums = new int[] { 5, 1, 6 };
  System.out.println(subsetXORSum(nums));
 }

 private static int subsetXORSum(int[] nums) {
  int bitwiseOr = 0;
  for (int num : nums)
   bitwiseOr |= num;
  int ans = bitwiseOr * (int) Math.pow(2, nums.length - 1);
  return ans;
 }
}
