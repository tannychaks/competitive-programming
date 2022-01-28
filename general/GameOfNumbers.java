package general;

import java.io.IOException;
import java.util.Scanner;

public class GameOfNumbers {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();
    int[] arr = new int[n];
    int i, j, k;
    for (i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    for (i = 0; i < n; i++) {
      for (j = i + 1; i < n; i++) {
        if (arr[i] < arr[j])
          break;
      }
      if (j != n) {
        for (k = j + 1; k < n; k++) {
          if (arr[j] > arr[k])
            break;
        }
        if (k != n)
          System.out.print(arr[k] + " ");
        else
          System.out.print(-1 + " ");
      } else
        System.out.print(-1 + " ");
    }
  }

}
