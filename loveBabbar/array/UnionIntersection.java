package loveBabbar.array;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UnionIntersection {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[n];
    int[] b = new int[m];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    for (int i = 0; i < m; i++) {
      b[i] = sc.nextInt();
    }
    doUnion(a, n, b, m);
    System.out.println();
    doIntersection(a, n, b, m);
    sc.close();
  }

  private static void doIntersection(int[] a, int n, int[] b, int m) {
    int i = 0, j = 0;
    Set<Integer> intersection = new HashSet<>();
    while (i < n && j < m) {
      if (a[i] < b[j]) {
        i++;
      } else if (a[i] > b[j]) {
        j++;
      } else {
        intersection.add(a[i]);
        i++;
        j++;
      }
    }
    for (int ele : intersection)
      System.out.print(ele + " ");
  }

  private static void doUnion(int[] a, int n, int[] b, int m) {
    Set<Integer> union = new HashSet<>();
    for (int i = 0; i < n; i++) {
      union.add(a[i]);
    }
    for (int i = 0; i < m; i++) {
      union.add(b[i]);
    }
    for (int ele : union)
      System.out.print(ele + " ");
  }
}
