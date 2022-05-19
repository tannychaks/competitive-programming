package striverSDEsheet.day9;

import java.util.ArrayList;

import java.util.Collections;

public class SubsetSums {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);

        int n = 2;

        ArrayList<Integer> ans = subsetSums(arr, n);

        ans.stream().forEach(System.out::println);
    }

    private static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {

        ArrayList<Integer> subsetSumList = new ArrayList<>();
        solve(0, 0, arr, n, subsetSumList);
        Collections.sort(subsetSumList);
        return subsetSumList;
    }

    private static void solve(int ind, int sum, ArrayList<Integer> arr, int n, ArrayList<Integer> subsetSumList) {
        if (ind == n) {
            subsetSumList.add(sum);
            return;
        }
        // Take
        solve(ind + 1, sum + arr.get(ind), arr, n, subsetSumList);
        // Not Take
        solve(ind + 1, sum, arr, n, subsetSumList);
    }
}
