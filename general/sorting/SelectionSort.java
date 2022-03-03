package general.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 5, -2, -2, 3, 4 };
        int n = arr.length;

        /**** Unstable Selection Sort */
        sort(arr, n);
        printArray(arr);
        System.out.println(); // For a new line
        /**** Stable Selection Sort */
        stableSelectionSort(arr, n);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
    }

    /**
     * Stable Selction Sort
     * Note: Subscripts are only used for understanding the concept.
     * 
     * Input : 4A 5 3 2 4B 1
     * Output : 1 2 3 4B 4A 5
     * 
     * Stable Selection Sort would have produced
     * Output : 1 2 3 4A 4B 5
     */
    private static void stableSelectionSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[min] > arr[j])
                    min = j;
            }
            int key = arr[min];
            while (min > i) {
                arr[min] = arr[min - 1];
                min--;
            }
            arr[i] = key;
        }
    }

    // Unstable due to swapping
    private static void sort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[min] > arr[j])
                    min = j;
            }
            arr[min] += arr[i] - (arr[i] = arr[min]); // One-Liner Swap
        }
    }
}
