package loveBabbar.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Pair {
  private int value;
  private int index;

  Pair(int value, int index) {
    this.value = value;
    this.index = index;
  }

  public int getValue() {
    return value;
  }

  public int getIndex() {
    return index;
  }
}

public class MinimizeHeight {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int k = sc.nextInt();
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(printMinimizedHeight(arr, k, n));
    sc.close();
  }

  private static int printMinimizedHeight(int[] arr, int k, int n) {
    List<Pair> possibleHeights = new ArrayList<>();
    int[] visited = new int[n];
    for (int i = 0; i < n; i++) {
      if (arr[i] - k >= 0)
        possibleHeights.add(new Pair(arr[i] - k, i));
      possibleHeights.add(new Pair(arr[i] + k, i));
      visited[i] = 0;
    }

    // Sort by Value
    Collections.sort(possibleHeights, new Comparator<Pair>() {
      public int compare(Pair p1, Pair p2) {
        return p1.getValue() - p2.getValue();
      }
    });
    int el = 0, left = 0, right = 0, size = possibleHeights.size();
    while (el < n && right < size) {
      if (visited[possibleHeights.get(right).getIndex()] == 0)
        el++;
      visited[possibleHeights.get(right).getIndex()]++;
      right++;
    }

    int ans = possibleHeights.get(right - 1).getValue() - possibleHeights.get(left).getValue();
    while (right < size) {
      if (visited[possibleHeights.get(left).getIndex()] == 1)
        el--;
      visited[possibleHeights.get(left).getIndex()]--;
      left++;
      while (el < n && right < size) {
        if (visited[possibleHeights.get(right).getIndex()] == 0)
          el++;
        visited[possibleHeights.get(right).getIndex()]++;
        right++;
      }
      if (el == n)
        ans = Math.min(ans, possibleHeights.get(right - 1).getValue() - possibleHeights.get(left).getValue());
      else
        break;
    }

    return ans;
  }

}
