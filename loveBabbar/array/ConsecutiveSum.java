package loveBabbar.array;

import java.util.Scanner;

public class ConsecutiveSum {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int[] arr = new int[n];
  for (int i = 0; i < n; i++) {
   arr[i] = sc.nextInt();
  }
  int k = sc.nextInt();
  if (isSumPossible(arr, n, k) == 0)
   System.out.println("TRUE");
  else
   System.out.println("FALSE");
  sc.close();
 }

 private static int isSumPossible(int[] arr, int n, int k) {
  int flag = 1, sum = 0;
  for (int i = 0; i < n; i++) {
   sum = arr[i];
   if (arr[i] == k) {
    flag = 0;
    break;
   }
   for (int j = i + 1; j < n; j++) {
    sum += arr[j];
    if (sum == k) {
     flag = 0;
     break;
    }
   }
   if (flag == 0)
    break;
  }

  return flag;
 }
}
