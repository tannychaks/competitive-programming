package loveBabbar.array;

import java.util.Arrays;

public class Solution {
 public static void main(String[] args) {
  int[] arr = new int[] { 4, 2, 3, 1, 4 };
  System.out.println(prod(arr));
 }

 private static int prod(int[] arr) {
  Arrays.sort(arr);
  int sum = 0;
  for (int i = 0; i < arr.length; i++)
   sum += arr[i];
  int flag = arr[0];
  int count = 0;
  for (int i = 1; i < arr.length; i++) {
   System.out.println(flag);
   if (flag + arr[i] <= sum) {
    flag = flag + arr[i];
    count++;
   } else
    break;
  }
  return count;
 }
}
