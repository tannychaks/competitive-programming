package loveBabbar.array;

import java.util.Arrays;
import java.util.Scanner;

public class InversionCount {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int N = sc.nextInt();
  int[] arr = new int[N];
  for (int i = 0; i < N; i++)
   arr[i] = sc.nextInt();
  System.out.println(sort(arr, 0, N - 1));
  sc.close();
 }

 private static long sort(int[] arr, int l, int r) {
  if (l >= r)
   return 0;
  int m = (l + r) / 2;
  long count = sort(arr, l, m);
  count += sort(arr, m + 1, r);
  count += merge(arr, l, m, r);
  return count;
 }

 private static long merge(int[] arr, int l, int m, int r) {

  int[] left = Arrays.copyOfRange(arr, l, m + 1);
  int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
  int i = 0, j = 0, k = l;
  long count = 0;
  while (i < left.length && j < right.length) {
   if (left[i] <= right[j])
    arr[k++] = left[i++];
   else {
    arr[k++] = right[j++];
    count += (m + 1) - (l + i);
   }
  }
  while (i < left.length)
   arr[k++] = left[i++];
  while (j < right.length)
   arr[k++] = right[j++];

  System.out.println(Arrays.toString(arr));
  return count;
 }
}
