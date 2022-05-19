package striverSDEsheet.day9;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {
    public static void main(String[] args) {
        int[] candidates = new int[] { 2, 3, 6, 7 };
        int target = 7;

        combinationSum(candidates, target).stream().forEach(list -> {
            list.stream().forEach(System.out::print);
            System.out.println();
        });
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, candidates, ans, target, new ArrayList<>());
        return ans;
    }

    private static void solve(int ind, int[] candidates, List<List<Integer>> ans, int target, List<Integer> ds) {

        if (ind == candidates.length) {
            if (target == 0)
                ans.add(new ArrayList<>(ds));
            return;
        }
        // Take
        if (candidates[ind] <= target) {
            ds.add(candidates[ind]);
            solve(ind, candidates, ans, target - candidates[ind], ds);
            ds.remove(ds.size() - 1);
        }
        // Not Take
        solve(ind + 1, candidates, ans, target, ds);
    }
}
