package loveBabbar.array;

import java.util.Scanner;

public class ShiftNegativePositive {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int[] arr = new int[n];
  for (int i = 0; i < n; i++) {
   arr[i] = sc.nextInt();
  }
  shiftAllTwoPointerAlgo(arr, n);
  printArray(arr);
  sc.close();
 }

 /**
  * This approach uses the 2-pointer algorithm where we simply take two variables
  * like left and right which hold the 0 and N-1 indexes.
  * 
  * Just need to check that :
  * 
  * 1.Check If the left and right pointer elements are negative then simply
  * increment the left pointer.
  * 
  * 2. Otherwise, if the left element is positive and the right element is
  * negative then simply swap the elements, and simultaneously increment and
  * decrement the left and right pointers.
  * 
  * 3.Else if the left element is positive and the right element is also positive
  * then simply decrement the right pointer.
  * 
  * 4.Repeat the above 3 steps until the left pointer ≤ right pointer.
  * 
  * TC: O(n) SC: O(1)
  */
 private static void shiftAllTwoPointerAlgo(int[] arr, int n) {
  int left = 0, right = n - 1;
  while (left <= right) {
   if (arr[left] < 0 && arr[right] < 0) {
    left++;
   } else if (arr[left] > 0 && arr[right] < 0) {
    arr[left] += arr[right] - (arr[right] = arr[left]);
    left++;
    right--;
   } else if (arr[left] > 0 && arr[right] > 0) {
    right--;
   } else {
    left++;
    right--;
   }
  }
 }

 /**
  * This approach uses the partition logic of quick sort(modified)
  * 
  * TC: O(n) SC: O(1)
  */
 private static void shiftAllPartition(int[] arr, int n) {
  int pivotLocation = 0;
  for (int i = 0; i < arr.length; i++) {
   if (arr[i] < 0) {
    if (i != pivotLocation) {
     arr[i] += arr[pivotLocation] - (arr[pivotLocation] = arr[i]);
    }
    pivotLocation++;
   }

  }
 }

 private static void printArray(int[] arr) {
  for (int i = 0; i < arr.length; i++) {
   System.out.print(arr[i] + " ");
  }
 }
}
