package striverSDEsheet.day11;

public class BitonicSearch {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
                100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75,
                74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51 };
        int b = 21;

        System.out.println(solve(arr, b));
    }

    private static int solve(int[] arr, int b) {
        int n = arr.length;
        int l = 0, r = n - 1;
        // find peak element
        int index = findBitonicPoint(arr, n, l, r);

        return bitonicSearch(arr, n, b, index);
    }

    private static int bitonicSearch(int[] arr, int n, int key, int index) {

        if (key > arr[index])
            return -1;
        else if (key == arr[index])
            return index;
        else {
            int temp = ascendingBinarySearch(arr, 0, index - 1, key);
            if (temp != -1)
                return temp;
            return descendingBinarySearch(arr, index + 1, n - 1, key);
        }
    }

    private static int descendingBinarySearch(int[] arr, int low,
            int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] < key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int ascendingBinarySearch(int[] arr, int low,
            int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int findBitonicPoint(int[] arr, int n, int l, int r) {

        int mid;
        int bitonicPoint = 0;
        mid = (r + l) >>> 1;
        if (arr[mid] > arr[mid - 1]
                && arr[mid] > arr[mid + 1]) {
            return mid;
        } else {
            if (arr[mid] > arr[mid - 1]
                    && arr[mid] < arr[mid + 1]) {
                bitonicPoint = findBitonicPoint(arr, n, mid, r);
            } else {
                if (arr[mid] < arr[mid - 1]
                        && arr[mid] > arr[mid + 1]) {
                    bitonicPoint = findBitonicPoint(arr, n, l, mid);
                }
            }
        }
        return bitonicPoint;
    }
}
