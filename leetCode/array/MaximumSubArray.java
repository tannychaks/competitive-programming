package leetCode.array;

/**
 * 
 * 53. Maximum Subarray
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 */
public class MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE, maxEndHere = 0;
        for( int num : nums) {
            maxEndHere += num;
            if(maxSoFar < maxEndHere) 
                maxSoFar = maxEndHere;
            if(maxEndHere < 0)
                maxEndHere = 0;
        }
        return maxSoFar;
    }
}
