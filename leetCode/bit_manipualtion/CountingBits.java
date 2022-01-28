package leetCode.bit_manipualtion;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/counting-bits/
 * 
 * 338. Counting Bits
 * 
 * Given an integer n, return an array ans of length n + 1 such that for each i
 * (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 */
public class CountingBits {
 public static void main(String[] args) {
  int n = 2;
  System.out.println(Arrays.toString(countBits(n)));
 }

 private static int[] countBits(int n) {
  int[] ans = new int[n + 1];
  for (int i = 0; i < n + 1; i++) {
   int count = 0;
   int num = i;
   while (num != 0) {
    count++;
    num &= (num - 1);
   }
   ans[i] = count;
  }
  return ans;
 }
}
