package general.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 4, 1, 1, 5, -2 };
        int n = arr.length;
        sort(arr, n);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private static void sort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] += arr[j + 1] - (arr[j + 1] = arr[j]); // One-Liner Swap
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }
}
