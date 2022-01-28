package general;

import java.util.Scanner;

public class StackAndQueue {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int k = sc.nextInt();
  long[] arr = new long[n];
  long sum = 0L, sumK = 0L;
  for (int i = 0; i < n; i++) {
   arr[i] = sc.nextLong();
   if (i >= (n - k)) {
    sumK += arr[i];
   }
  }
  System.out.println("SumK = " + sumK);
  long max = 0L;
  for (int i = 0; i < k; i++) {
   sum += arr[i];
   sumK -= arr[n - k + i];
   System.out.println("Sum = " + sum);
   System.out.println("SumK = " + sumK);
   max = Math.max(sum + sumK, max);
   System.out.println("MAX = " + max);
  }
  System.out.println(max);
  sc.close();
 }
}