package loveBabbar.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthMaxAndMinElement {
  static class Pair {
    int max;
    int min;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int k = sc.nextInt();
    Pair pair = findKthMaxAndMinHeapApproach(arr, n, k);
    System.out.println(pair.max + "\n" + pair.min);
    sc.close();
  }

  /**
   * This is a naive approach. TC = O(nlogn) SC = O(1)
   */
  private static Pair findKthMaxAndMinNaive(int[] arr, int n, int k) {
    Pair pair = new Pair();
    Arrays.sort(arr);
    pair.max = arr[n - k];
    pair.min = arr[k - 1];
    return pair;
  }

  /**
   * This is a heap approach. For largest number minHeap and for minimum number
   * maxHeap TC = O(nlogk) SC = O(1)
   * 
   * PS: It passed in GFG.
   */
  private static Pair findKthMaxAndMinHeapApproach(int[] arr, int n, int k) {
    Pair pair = new Pair();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < n; i++) {
      minHeap.add(arr[i]);
      if (minHeap.size() > k)
        minHeap.poll();
      maxHeap.add(arr[i]);
      if (maxHeap.size() > k)
        maxHeap.poll();
    }
    pair.min = maxHeap.peek();
    pair.max = minHeap.peek();
    return pair;
  }

  /**
   * This is a quick select approach. Works on Quick sort algorithm itself.
   * 
   * TC =O(n) SC = O(1)
   * 
   * PS: It got a TLE in GFG. Cross-check once
   */
  private static Pair findKthMaxAndMinQuickSelect(int[] arr, int n, int k) {
    Pair pair = new Pair();
    pair.min = kthSmallestElement(arr, 0, n - 1, k);
    pair.max = kthLargestElement(arr, 0, n - 1, k);
    return pair;
  }

  private static int kthLargestElement(int[] arr, int low, int high, int k) {
    int partition = partition(arr, low, high);
    if (partition == (arr.length - k))
      return arr[partition];
    else if (partition < (arr.length - k))
      return kthSmallestElement(arr, partition + 1, high, k);
    else
      return kthSmallestElement(arr, low, partition - 1, k);
  }

  private static int kthSmallestElement(int[] arr, int low, int high, int k) {
    int partition = partition(arr, low, high);
    if (partition == (k - 1))
      return arr[partition];
    else if (partition < (k - 1))
      return kthSmallestElement(arr, partition + 1, high, k);
    else
      return kthSmallestElement(arr, low, partition - 1, k);
  }

  /**
   * partition function similar to quick sort . Considers last element as pivot
   * and adds elements with less value to the left and high value to the right and
   * also changes the pivot position to its respective position in the final
   * array.
   */
  private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high], pivotLocation = low;
    for (int i = low; i <= high; i++) {
      if (arr[i] < pivot) {
        // one line swap
        arr[i] += arr[pivotLocation] - (arr[pivotLocation] = arr[i]);
        pivotLocation++;
      }
    }
    // one line swapping pivot to the final pivot location
    arr[high] += arr[pivotLocation] - (arr[pivotLocation] = arr[high]);
    return pivotLocation;
  }
}
