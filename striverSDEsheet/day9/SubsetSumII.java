package striverSDEsheet.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSumII {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 2 };

        List<List<Integer>> ans = subsetsWithDup(nums);
        ans.stream().forEach(list -> {
            list.stream().forEach(item -> System.out.print(item + " "));
            System.out.println();
        });

    }

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private static void solve(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(ds));

        for (int i = ind; i < nums.length; i++) {
            if (i != ind && nums[i] == nums[i - 1])
                continue;
            ds.add(nums[i]);
            solve(i + 1, nums, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
}
