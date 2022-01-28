package loveBabbar.array;

import java.util.Scanner;

public class MaxMinElementArray {
  static class Pair {
    int max;
    int min;
  }

  private static Pair getMinMaxElement(int[] arr, int n) {
    Pair pair = new Pair();
    int i;
    if (isEven(n)) {
      if (arr[0] > arr[1]) {
        pair.max = arr[0];
        pair.min = arr[1];
      } else {
        pair.max = arr[1];
        pair.min = arr[0];
      }
      i = 2;
    } else {
      pair.max = arr[0];
      pair.min = arr[0];
      i = 1;
    }
    while (i < n - 1) {
      if (arr[i] > arr[i + 1]) {
        if (arr[i] > pair.max)
          pair.max = arr[i];
        if (arr[i + 1] < pair.min)
          pair.min = arr[i + 1];
      } else {
        if (arr[i + 1] > pair.max)
          pair.max = arr[i + 1];
        if (arr[i] < pair.min)
          pair.min = arr[i];
      }
      i += 2;
    }
    return pair;
  }

  /**
   * n&1 is 1, then odd,else even
   */
  private static boolean isEven(int n) {
    return (n & 1) != 1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    Pair pair = getMinMaxElement(arr, n);
    System.out.println(pair.max);
    System.out.println(pair.min);
    sc.close();
  }
}
