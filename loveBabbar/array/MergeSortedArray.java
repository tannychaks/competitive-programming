package loveBabbar.array;

import java.util.Scanner;

public class MergeSortedArray {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int m = sc.nextInt();
  int[] arr1 = new int[n];
  int[] arr2 = new int[m];
  for (int i = 0; i < n; i++) {
   arr1[i] = sc.nextInt();
  }
  for (int i = 0; i < m; i++) {
   arr2[i] = sc.nextInt();
  }
  mergeSortedArray(arr1, arr2, n, m);
  for (int i = 0; i < n; i++) {
   System.out.print(arr1[i] + " ");
  }
  for (int i = 0; i < m; i++) {
   System.out.print(arr2[i] + " ");
  }
  sc.close();
 }

 private static void mergeSortedArray(int[] arr1, int[] arr2, int n, int m) {
  int gap = n + m, i = 0, j = 0;
  for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
   for (i = 0; i + gap < n; i++) {
    if (arr1[i] > arr1[i + gap]) {
     arr1[i] += arr1[i + gap] - (arr1[i + gap] = arr1[i]);
    }
   }

   for (j = (gap > n) ? (gap - n) : 0; i < n && j < m; i++, j++) {
    if (arr1[i] > arr2[j]) {
     arr1[i] += arr2[j] - (arr2[j] = arr1[i]);
    }
   }

   if (j < m) {
    for (j = 0; j + gap < m; j++) {
     if (arr2[j] > arr2[j + gap]) {
      arr2[j] += arr2[j + gap] - (arr2[j + gap] = arr2[j]);
     }
    }
   }
  }
 }

 private static int nextGap(int gap) {
  if (gap <= 1)
   return 0;
  return (gap / 2 + gap % 2);
 }
}
