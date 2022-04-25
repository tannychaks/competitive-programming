package striverSDEsheet.day3;

import java.util.HashMap;
import java.util.Map;

/**
 * https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/
 * 
 * https://leetcode.com/problems/majority-element/
 */
public class Majorityelement {
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElementHashMap(nums));
        System.out.println(majorityElementOptimal(nums));
    }

    /**
     * Moore’s Voting Algorithm
     * 
     * Intuition: The question clearly states that the nums array has a majority
     * element. Since it has a majority element we can say definitely the count is
     * more than N/2.
     * 
     * Majority element count = N/2 + x;
     * 
     * Minority/Other elements = N/2 – x;
     * 
     * Where x is the number of times it occurs after reaching the minimum value
     * N/2.
     * 
     * Now, we can say that count of minority elements and majority element are
     * equal upto certain point of time in the array. So when we traverse through
     * the array we try to keep track of the count of elements and which element we
     * are tracking. Since the majority element appears more than N/2 times, we can
     * say that at some point in array traversal we find the majority element.
     * 
     * @param nums
     * @return
     */
    private static int majorityElementOptimal(int[] nums) {
        int count = 0, major = 0;
        for (int num : nums) {
            if (count == 0)
                major = num;
            if (major == num)
                count += 1;
            else
                count -= 1;
        }
        return major;
    }

    /**
     * Hashmap method
     * 
     * @param nums
     * @return
     */
    private static int majorityElementHashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            if (count == 0)
                map.put(num, 1);
            else {
                map.put(num, count + 1);
            }
        }
        int majorCriteria = (int) Math.floor(nums.length / 2);
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            int count = map.get(num);
            if (count > majorCriteria) {
                max = Math.max(max, num);
            }
        }
        return max;
    }
}
