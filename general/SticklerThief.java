package general;

import java.util.Scanner;

public class SticklerThief {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int[] arr = new int[n];
  for (int i = 0; i < n; i++) {
   arr[i] = sc.nextInt();
  }
  System.out.println(findMaxMoney(arr, n));
  sc.close();
 }

 private static int findMaxMoney(int[] arr, int n) {
  if (n == 0)
   return 0;
  int tempMax1 = arr[0];
  if (n == 1)
   return tempMax1;
  int tempMax2 = Math.max(arr[0], arr[1]);
  if (n == 2)
   return tempMax2;
  int max = 0;
  for (int i = 2; i < n; i++) {
   max = Math.max(tempMax2, arr[i] + tempMax1);
   tempMax1 = tempMax2;
   tempMax2 = max;
  }
  return max;
 }
}
