package leetCode.bit_manipualtion;

/**
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 * 
 * 1342. Number of Steps to Reduce a Number to Zero
 * 
 * Given an integer num, return the number of steps to reduce it to zero.
 * 
 * In one step, if the current number is even, you have to divide it by 2,
 * otherwise, you have to subtract 1 from it.
 */
public class NumberOfStepsToZero {
 public static void main(String[] args) {
  int num = 14;
  System.out.println(numberOfSteps(num));
 }

 private static int numberOfSteps(int num) {
  int count = 0;
  while (num != 0) {
   if ((num & 1) != 1) {
    num = num >> 1;
   } else {
    num--;
   }
   count++;
  }
  return count;
 }
}
