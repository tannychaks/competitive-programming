package loveBabbar.array;

import java.util.Scanner;

public class MaxContiguousSubArray {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  // -2, -3, 4, -1, -2, 1, 5, -3
  int n = sc.nextInt();
  int[] arr = new int[n];
  for (int i = 0; i < n; i++) {
   arr[i] = sc.nextInt();
  }
  printMaximumSubArray(arr, n);
  sc.close();
 }

 /** Kadane's algorithm to find maximum contiguous subarray */
 private static void printMaximumSubArray(int[] arr, int n) {
  int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0, start = 0, end = 0, tempStart = 0;
  for (int i = 0; i < n; i++) {
   maxEndingHere += arr[i];
   if (maxSoFar < maxEndingHere) {
    maxSoFar = maxEndingHere;
    start = tempStart;
    end = i;
   }
   if (maxEndingHere < 0) {
    tempStart = i + 1;
    maxEndingHere = 0;
   }
  }
  System.out.println(maxSoFar);
  for (int i = start; i <= end; i++) {
   System.out.print(arr[i] + " ");
  }
 }
}
