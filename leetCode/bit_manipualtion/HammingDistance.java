package leetCode.bit_manipualtion;

/**
 * https://leetcode.com/problems/hamming-distance/
 * 
 * 461. Hamming Distance
 * The Hamming distance between two integers is the number of positions at which
 * the corresponding bits are different.
 * 
 * Given two integers x and y, return the Hamming distance between them.
 */
public class HammingDistance {
 public static void main(String[] args) {
  int x = 1, y = 4;
  System.out.println(hammingDistance(x, y));
 }

 private static int hammingDistance(int x, int y) {
  int xor = x ^ y;
  int ans = 0;
  while (xor > 0) {
   ans += (xor & 1);
   xor >>= 1;
  }
  return ans;
 }
}
