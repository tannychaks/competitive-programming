package loveBabbar.array;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int[] arr = new int[n];
  for (int i = 0; i < n; i++) {
   arr[i] = sc.nextInt();
  }
  findNextPermutation(arr, n);
  System.out.println(Arrays.toString(arr));
  sc.close();
 }

 private static void findNextPermutation(int[] arr, int n) {
  int i = n - 2, j;
  while (i >= 0 && arr[i] >= arr[i + 1])
   i--;
  if (i >= 0) {
   j = n - 1;
   while (j >= 0 && arr[j] <= arr[i])
    j--;
   arr[i] += arr[j] - (arr[j] = arr[i]);
  }
  reverse(arr, i + 1, n - 1);
 }

 private static void reverse(int[] arr, int i, int j) {
  while (i <= j) {
   arr[i] += arr[j] - (arr[j] = arr[i]);
   i++;
   j--;
  }
 }

}
