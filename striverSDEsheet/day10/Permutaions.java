package striverSDEsheet.day10;

import java.util.ArrayList;
import java.util.List;

public class Permutaions {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3 };
        List<List<Integer>> ans = permute(nums);

        ans.stream().forEach(list -> {
            list.stream().forEach(System.out::print);
            System.out.println();
        });
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, nums, ans);
        return ans;
    }

    /**
     * Time Complexity: N! x N
     * 
     * Space Complexity: O(N)
     * 
     * @param index
     * @param nums
     * @param ans
     */

    private static void recurPermute(int index, int[] nums, List<List<Integer>> ans) {
        if (index == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] += nums[index] - (nums[index] = nums[i]); // One line swap;
            recurPermute(index + 1, nums, ans);
            nums[i] += nums[index] - (nums[index] = nums[i]); // One line swap;
        }
    }
}
