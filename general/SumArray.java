package general;

import java.util.Arrays;

public class SumArray {
 public static void main(String[] args) {
  int[] arr = new int[] { 10, -3, -4, 5, -2, 8 };
  int[] sumArray = new int[6];
  sumArray[0] = arr[0];
  for (int i = 1; i < 6; i++)
   sumArray[i] = sumArray[i - 1] + arr[i];

  System.out.println(Arrays.toString(sumArray));
 }
}