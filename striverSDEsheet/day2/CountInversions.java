package striverSDEsheet.day2;

/**
 * https://www.codingninjas.com/codestudio/problems/615
 * 
 * https://takeuforward.org/data-structure/count-inversions-in-an-array/
 */
public class CountInversions {
    public static void main(String[] args) {

        long[] arr = new long[] { 2, 5, 1, 3, 4 };
        int n = arr.length;

        System.out.println(getInversions(arr, n));
        // Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
    }

    private static long getInversions(long[] arr, int n) {
        long inversionCount = sort(arr, 0, n - 1);
        return inversionCount;
    }

    private static long sort(long[] arr, int l, int r) {
        long inversionCount = 0;
        if (l < r) {
            int mid = (l + r) / 2;
            inversionCount += sort(arr, l, mid);
            inversionCount += sort(arr, mid + 1, r);
            inversionCount += merge(arr, l, mid, r);
        }
        return inversionCount;
    }

    private static long merge(long[] arr, int l, int mid, int r) {

        int n1 = mid - l + 1;
        int n2 = r - mid;

        long[] left = new long[n1];
        long[] right = new long[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i)
            left[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            right[j] = arr[mid + 1 + j];
        long inversionCount = 0;
        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                inversionCount += n1 - i;
            }
        }
        while (i < n1)
            arr[k++] = left[i++];
        while (j < n2)
            arr[k++] = right[j++];

        return inversionCount;
    }
}
