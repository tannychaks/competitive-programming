package loveBabbar.array;

import java.util.Scanner;

public class DuplicateNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(findDuplicateNumber(arr, n));
    sc.close();
  }

  private static int findDuplicateNumber(int[] nums, int n) {
    if (n == 0)
      return n;
    int i = nums[0], j = nums[0];
    while (true) {
      i = nums[i];
      j = nums[nums[j]];
      if (i == j)
        break;
    }

    i = nums[0];
    while (true) {
      if (i == j)
        return i;
      i = nums[i];
      j = nums[j];
    }
  }
}
