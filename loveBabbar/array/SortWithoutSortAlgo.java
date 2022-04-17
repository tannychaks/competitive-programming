package loveBabbar.array;

import java.util.Scanner;

/**
 * Given an array of size N containing only 0s, 1s, and 2s; sort the array in
 * ascending order.
 */
public class SortWithoutSortAlgo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    sort012(arr, n);
    for (int i = 0; i < n; i++) {
      System.out.println(arr[i] + " ");
    }
    sc.close();
  }

  /**
   * This is the best approach with i,j,k pointer that reduces time complexity to
   * O(N): TC: O(n) SC: O(1)
   * 
   * @param arr
   * @param n
   */
  private static void sort012(int[] arr, int n) {
    int i, j, k;
    i = j = 0;
    k = n - 1;

    while (j <= k) {
      switch (arr[j]) {
        case 0:
          arr[i] += arr[j] - (arr[j] = arr[i]); // one line swap x+=y - (y=x)
          i++;
          j++;
          break;
        case 1:
          j++;
          break;
        case 2:
          arr[j] += arr[k] - (arr[k] = arr[j]);
          k--;
          break;
      }
    }

  }

  /**
   * This is a naive approach: TC: O(2n) SC: O(1)
   * 
   * @param arr
   * @param n
   */
  private static void sort012Naive(int[] arr, int n) {
    int count0 = 0, count1 = 0, count2 = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] == 0) {
        count0++;
      } else if (arr[i] == 1) {
        count1++;
      } else {
        count2++;
      }
    }

    for (int i = 0; i < count0; i++)
      arr[i] = 0;
    for (int i = count0; i < count0 + count1; i++)
      arr[i] = 1;

    for (int i = count0 + count1; i < count0 + count1 + count2; i++)
      arr[i] = 2;

  }
}
