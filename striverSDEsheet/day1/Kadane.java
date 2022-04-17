package striverSDEsheet.day1;

public class Kadane {
    public static void main(String[] args) {
        int arr[] = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println(maxSumsubArray(arr));
    }

    private static int maxSumsubArray(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE, maxEndHere = 0;
        for (int num : arr) {
            maxEndHere += num;
            if (maxSoFar < maxEndHere)
                maxSoFar = maxEndHere;
            if (maxEndHere < 0)
                maxEndHere = 0;
        }
        return maxSoFar;
    }
}
