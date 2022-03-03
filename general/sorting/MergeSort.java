package general.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 5, -1, 0, 1, 2, 6, -4, 8 };
        int n = arr.length;

        sort(arr, 0, n - 1);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
    }

    private static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            sort(arr, l, mid);
            sort(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i)
            left[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            right[j] = arr[mid + 1 + j];
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

}
