package recursion;

import java.util.ArrayList;
import java.util.List;

public class AllSubWithSumK {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 1, 0, 3, 2, 4 };
        int k = 4;
        int sum = 0, ind = 0;
        List<Integer> list = new ArrayList<>();
        int n = 7;
        printSubWithSumK(arr, k, sum, ind, list, n);
    }

    private static void printSubWithSumK(int[] arr, int k, int sum, int ind, List<Integer> list, int n) {

        if (ind == n) {
            if (sum == k) {
                list.stream().forEach(item -> {
                    System.out.print(item + " ");
                });
                System.out.println();
            }
            return;
        }

        // Take
        list.add(arr[ind]);
        sum += arr[ind];
        printSubWithSumK(arr, k, sum, ind + 1, list, n);

        // Not Take
        sum -= arr[ind];
        list.remove(list.size() - 1);

        printSubWithSumK(arr, k, sum, ind + 1, list, n);

    }
}
