package loveBabbar.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MergeIntervals {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int[][] arr = new int[n][2];
  for (int i = 0; i < n; i++) {
   for (int j = 0; j < 2; j++) {
    arr[i][j] = sc.nextInt();
   }
  }
  int[][] intervals = mergeIntervals(arr);
  for (int i = 0; i < intervals.length; i++) {
   for (int j = 0; j < 2; j++) {
    System.out.print(intervals[i][j] + " ");
   }
   System.out.println();
  }

  sc.close();
 }

 private static int[][] mergeIntervals(int[][] intervals) {
  if (intervals.length == 0)
   return new int[0][2];

  List<List<Integer>> result = new ArrayList<>();
  Arrays.sort(intervals, new Comparator<int[]>() {
   public int compare(final int[] a, final int[] b) {
    if (a[0] != b[0])
     return a[0] - b[0];
    return a[1] - b[1];
   }
  });
  int start = intervals[0][0];
  int end = intervals[0][1];
  for (int i = 1; i < intervals.length; i++) {
   if (intervals[i][0] <= end && intervals[i][0] >= start) {
    end = Math.max(intervals[i][1], end);
   } else {
    result.add(Arrays.asList(start, end));
    start = intervals[i][0];
    end = intervals[i][1];
   }
  }
  result.add(Arrays.asList(start, end));
  int[][] ans = new int[result.size()][2];
  for (int i = 0; i < result.size(); i++) {
   ans[i][0] = result.get(i).get(0);
   ans[i][1] = result.get(i).get(1);
  }
  return ans;
 }
}
