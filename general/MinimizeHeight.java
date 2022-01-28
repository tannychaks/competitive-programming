package general;

import java.util.Arrays;
import java.util.Scanner;

public class MinimizeHeight {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int k = sc.nextInt();
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    printMinimizedHeight(arr, k, n);
  }

  private static void printMinimizedHeight(int[] arr, int k, int n) {

    Arrays.sort(arr);
    int smallNumber = arr[0] + k;
    int bigNumber = arr[n - 1] - k;
    int temp = 0;
    if (smallNumber > bigNumber) {
      temp = smallNumber;
      smallNumber = bigNumber;
      bigNumber = temp;
    }
    int minimumHeight = arr[n - 1] - arr[0];
    for (int i = 0; i < (n - 1); i++) {
      int subtract = arr[i] - k;
      int add = arr[i] + k;

      if (subtract >= smallNumber || add <= bigNumber)
        continue;

      if ((bigNumber - subtract) <= (add - smallNumber))
        smallNumber = subtract;
      else
        bigNumber = add;

    }
    System.out.println(bigNumber);
    System.out.println(smallNumber);
    minimumHeight = Math.min(minimumHeight, (bigNumber - smallNumber));
    System.out.println(minimumHeight);
  }

}
