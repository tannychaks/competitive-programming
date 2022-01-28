package leetCode.bit_manipualtion;

/**
 * https://leetcode.com/problems/xor-operation-in-an-array/
 * 1486. XOR Operation in an Array
 * Given an integer n and an integer start.
 * 
 * Define an array nums where nums[i] = start + 2*i (0-indexed) and n ==
 * nums.length.
 * 
 * Return the bitwise XOR of all elements of nums.
 */
public class XOROpsInArray {
 public static void main(String[] args) {
  int n = 4, start = 3;
  System.out.println(xorOperation(n, start));
 }

 private static int xorOperation(int n, int start) {
  int ans = start, index = 1;
  int val = 0;
  while (n != index) {
   val = start + (2 * index);
   ans ^= val;
   index++;
   // System.out.println(val + " " + ans);
  }
  return ans;
 }
}
