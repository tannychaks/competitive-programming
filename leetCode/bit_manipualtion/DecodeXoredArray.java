package leetCode.bit_manipualtion;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/decode-xored-array/
 * 
 * 1720. Decode XORed Array
 * 
 * There is a hidden integer array arr that consists of n non-negative integers.
 * 
 * It was encoded into another integer array encoded of length n - 1, such that
 * encoded[i] = arr[i] XOR arr[i + 1]. For example, if arr = [1,0,2,1], then
 * encoded = [1,2,3].
 * 
 * You are given the encoded array. You are also given an integer first, that is
 * the first element of arr, i.e. arr[0].
 * 
 * Return the original array arr. It can be proved that the answer exists and is
 * unique.
 */
public class DecodeXoredArray {
 public static void main(String[] args) {
  int[] encoded = new int[] { 1, 2, 3 };
  int first = 1;
  System.out.println(Arrays.toString(decode(encoded, first)));
 }

 private static int[] decode(int[] encoded, int first) {
  int[] arr = new int[encoded.length + 1];
  arr[0] = first;
  int pointer = 1;
  for (int n : encoded) {
   // System.out.println(1 ^ n);
   arr[pointer] = arr[pointer - 1] ^ n;
   pointer++;
  }
  return arr;
 }
}
