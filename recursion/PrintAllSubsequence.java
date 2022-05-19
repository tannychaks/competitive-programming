package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequence {
    public static void main(String[] args) {
        int n = 3;
        int[] arr = new int[] { 3, 1, 2 };
        List<Integer> list = new ArrayList<>();
        int ind = 0;

        printSubsequence(ind, list, arr, n);
    }

    /**
     * TC: O(2^N)
     * SC: O(N)
     * 
     * @param ind
     * @param list
     * @param arr
     * @param n
     */
    private static void printSubsequence(int ind, List<Integer> list, int[] arr, int n) {
        if (ind == n) {
            list.stream().forEach(item -> {
                System.out.print(item + " ");
            });
            if (list.size() == 0)
                System.out.print("{}");
            System.out.println();
            return;
        }
        // Take the subsequence
        list.add(arr[ind]);
        printSubsequence(ind + 1, list, arr, n);

        // Not Take the subsequence
        list.remove(list.size() - 1);
        printSubsequence(ind + 1, list, arr, n);

    }
}
