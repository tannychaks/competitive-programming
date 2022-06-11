package striverSDEsheet.day18;

/**
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 */
public class MinOpsToReduceXto0 {
    public static void main(String[] args) {
        int[] nums = new int[] { 3, 2, 20, 1, 1, 3 };
        int x = 10;

        int ans = minOperations(nums, x);
        System.out.println(ans);
    }

    private static int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums)
            sum += num; // sum of entire array
        int subSum = sum - x; // sub-array sum = entire sum - target value;
        if (subSum == 0) // entire sum will add upto target value
            return nums.length;
        if (subSum < 0) // target value is way too big
            return -1;
        int max = 0, windowSum = 0, windowStart = 0;

        for (int i = 0; i < nums.length; i++) { // sliding window begins
            windowSum += nums[i];
            while (windowSum > subSum)
                windowSum -= nums[windowStart++];
            if (windowSum == subSum && max < (i - windowStart + 1))
                max = i - windowStart + 1;// taking the maximum length whose sum is equal to subarraysum
        }
        if (max == 0)
            return -1; // No window matches the sub array sum
        else
            return nums.length - max; // ans is the length of array apart from the subarray as that would be equal to
                                      // target value
    }
}
