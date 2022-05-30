package striverSDEsheet.day11;

public class KthElementOf2SortedArray {
    public static void main(String[] args) {
        int[] arr1 = new int[] { 2, 3, 6, 7, 9 };
        int arr2[] = new int[] { 1, 4, 8, 10 };
        int k = 5;
        int m = arr1.length;
        int n = arr2.length;

        System.out.println(kthElement(arr1, arr2, m, n, k));
    }

    private static int kthElement(int[] arr1, int[] arr2, int m, int n, int k) {
        if (n < m)
            return kthElement(arr2, arr1, n, m, k);
        int n1 = arr1.length, n2 = arr2.length;
        int low = Math.max(0, k - m), high = Math.min(k, n);

        while (low <= high) {
            int cut1 = low + ((high - low) >>> 1);
            int cut2 = k - cut1;

            int left1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];

            int right1 = cut1 == n1 ? Integer.MAX_VALUE : arr1[cut1];
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : arr2[cut2];

            if (left1 <= right2 && left2 <= right1) {

                return Math.max(left1, left2);
            } else if (left1 > right2)
                high = cut1 - 1;
            else
                low = cut1 + 1;
        }
        return 0;
    }
}
