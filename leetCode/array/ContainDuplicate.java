package leetCode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 217. Contains Duplicate
 * 
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */
public class ContainDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4};
        System.out.println(checkDuplicate(nums));
    }

    private static boolean checkDuplicate(int[] nums) {
        Map<Integer, Integer> dupMap = new HashMap<>();
        for(int num : nums) {
            Integer count = dupMap.get(num);
            if(count == null) 
                dupMap.put(num, 1);
            else
                return true;
        }
        return false;
    }
}
