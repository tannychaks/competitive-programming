package loveBabbar.dynamic_programming;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StringCutter {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int t;
  t = sc.nextInt();
  int[] a = new int[t];
  for (int i = 0; i < t; i++)
   a[i] = sc.nextInt();
  for (int i = 0; i < t; i++) {
   int n = a[i];

   System.out.println(sieve((int) (Math.floor(Math.sqrt(n)))));
  }
  sc.close();
 }

 private static int sieve(int n) {
  boolean[] p = new boolean[n + 1];
  Arrays.fill(p, true);
  int c = 0;
  for (int i = 2; i < n + 1; i++) {
   for (int j = i * i; j < n + 1; j += i) {
    p[j] = false;
   }
  }
  for (int i = 2; i < n + 1; i++) {
   if (p[i] == true)
    c++;
  }
  return c;
 }

}
