package loveBabbar.array;

import java.util.Scanner;

public class CyclicRotateArray {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);

  int n = sc.nextInt();
  int[] arr = new int[n];
  for (int i = 0; i < n; i++) {
   arr[i] = sc.nextInt();
  }

  rotate(arr, n);
  sc.close();
 }

 private static void rotate(int[] arr, int n) {
  int temp = arr[n - 1];
  for (int i = n - 1; i > 0; i--)
   arr[i] = arr[i - 1];
  arr[0] = temp;
 }
}
