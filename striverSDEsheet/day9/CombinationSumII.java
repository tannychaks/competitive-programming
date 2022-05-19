package striverSDEsheet.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = new int[] { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;

        combinationSum(candidates, target).stream().forEach(list -> {
            list.stream().forEach(System.out::print);
            System.out.println();
        });
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0, target, candidates, ans, new ArrayList<>());
        return ans;
    }

    private static void solve(int ind, int target, int[] candidates, List<List<Integer>> ans, List<Integer> ds) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < candidates.length; i++) {
            if (i > ind && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] > target)
                break;

            ds.add(candidates[i]);
            solve(i + 1, target - candidates[i], candidates, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}
