package loveBabbar.array;

import java.util.Scanner;

public class MinimumJumps {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(minimumStepsPerfect(arr, n));
    sc.close();
  }

  private static int minimumStepsPerfect(int[] arr, int n) {
    if (n <= 1)
      return 0;
    if (arr[0] == 0)
      return -1;

    int maxReach = arr[0];
    int jumps = 1;
    int steps = arr[0];

    for (int i = 1; i < n; i++) {
      if (i == (n - 1))
        return jumps;

      steps--;
      maxReach = Math.max(maxReach, i + arr[i]);
      if (steps == 0) {
        jumps += 1;
        if (maxReach <= i)
          return -1;

        steps = maxReach - i;
      }
    }
    return -1;
  }

  private static int minimumStepsDynamic(int[] arr, int n) {

    int[] jumps = new int[n];
    if (n == 0 && arr[0] == 0)
      return Integer.MAX_VALUE;

    jumps[0] = 0;

    for (int i = 1; i < n; i++) {
      jumps[i] = Integer.MAX_VALUE;
      for (int j = 0; j < i; j++) {
        if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
          jumps[i] = Math.min(jumps[i], jumps[j] + 1);
          break;
        }
      }
    }

    return jumps[n - 1];
  }

  /**
   * A naive approach is to start from the first element and recursively call for
   * all the elements reachable from first element. The minimum number of jumps to
   * reach end from first can be calculated using minimum number of jumps needed
   * to reach end from the elements reachable from first.
   */
  private static int minimumStepsNaive(int[] arr, int low, int high) {
    if (low == high)
      return 0;
    if (arr[0] == 0)
      return Integer.MAX_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = low + 1; i <= high && i <= (low + arr[low]); i++) {
      int jumps = minimumStepsNaive(arr, i, high);
      if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
        min = jumps + 1;
    }
    return min;
  }
}
