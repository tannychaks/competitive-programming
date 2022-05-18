package striverSDEsheet.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> list = threeSum(nums);
        list.stream().forEach(e -> {
            e.stream().forEach(val -> System.out.print(val + " "));
            System.out.println();
        });
    }

    private static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];

                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[lo]);
                        temp.add(nums[hi]);

                        ans.add(temp);

                        while (lo < hi && nums[lo] == nums[lo + 1])
                            lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1])
                            hi--;

                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum)
                        lo++;
                    else
                        hi--;
                }
            }
        }

        return ans;
    }
}
