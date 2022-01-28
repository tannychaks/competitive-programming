package slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class MaxSubArray {
 public static void main(String[] args) {
  int n = 4;
  List<Integer> arr = new ArrayList<>();
  arr.add(100);
  arr.add(200);
  arr.add(300);
  arr.add(400);

  int k = 2;

  System.out.println(maximumSumSubarray(k, arr, n));
 }

 private static int maximumSumSubarray(int k, List<Integer> arr, int n) {
  int start = 0, end = 0;
  int sum = 0, mx = Integer.MIN_VALUE;
  while (end < n) {
   sum += arr.get(end);
   if (end - start + 1 < k) {
    end++;
   } else if (end - start + 1 == k) {
    mx = Integer.max(mx, sum);
    sum -= arr.get(start);
    start++;
    end++;
   }
  }
  return mx;
 }
}
