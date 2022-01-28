package loveBabbar.array;

import java.util.Scanner;

public class MaxSumWithoutAdjacent {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int[] arr = new int[n];
  for (int i = 0; i < n; i++) {
   arr[i] = sc.nextInt();
  }
  System.out.println(findMaxSum(arr, n));
  sc.close();
 }

 private static int findMaxSum(int arr[], int n) {
  int in = arr[0];
  int ex = 0;
  int ex_new;
  int i;

  for (i = 1; i < n; i++) {
   ex_new = (in > ex) ? in : ex;

   in = ex + arr[i];
   ex = ex_new;
  }

  return ((in > ex) ? in : ex);
 }

}
