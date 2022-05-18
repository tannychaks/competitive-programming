package striverSDEsheet.day7;

public class CountMaxConsecutiveOne {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 0, 1, 1, 1 };
        int ans = findMaxConsecutiveOnes(nums);

        System.out.println(ans);

        int res = slidingwindowSolution(nums);

        System.out.println(res);
    }

    /**
     * is sliding window?
     * 1) subarray/substring->correct(subarray with max consecutive ones)
     * 2) maximize/minimize subarray->correct(subarray with max consecutive ones)
     * 3) fixed/variable size sliding window?
     * fixed size window given in question->no
     * variable size condition given? yes-> all ones to be consecutive
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * @param nums
     * @return
     */
    private static int slidingwindowSolution(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        int max = Integer.MIN_VALUE;
        while (j < n) {
            if (nums[j] == 1) {
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                i = j + 1;
                j++;
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    /**
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * @param nums
     * @return
     */
    private static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, maxCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                count++;
            else
                count = 0;
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
