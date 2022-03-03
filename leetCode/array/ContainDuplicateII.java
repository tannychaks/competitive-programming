package leetCode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. Contains Duplicate II
 * 
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */
public class ContainDuplicateII {
    public static void main(String[] args) {
        int nums[] = new int[] {1,2,3,1,2,3};
        int k =2;
        System.out.println(containsNearbyDuplicateOptimized(nums, k));
    }
private static boolean containsNearbyDuplicateOptimized(int[] nums, int k) {
        HashMap<Integer,Integer> mapa = new HashMap<>();
        for(int i =0; i<nums.length;i++){
            if(mapa.containsKey(nums[i]) && Math.abs((i-mapa.get(nums[i])))<=k){
                return true;
            }
            mapa.put(nums[i],i);
        }
        return false;
    }

    //Sliding window approach
    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> dupMap = new HashMap<>();
        int i  = 0, j=0;
        boolean check = false;
        while(j < nums.length) {
            Integer count = dupMap.get(nums[j]);
            if(j-i <= k){
                if(count == null) {
                dupMap.put(nums[j], 1);
                } else {
                    check = true;
                    break;
                }
                 j++;
            } else {
                // dupMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
                count = dupMap.get(nums[i]);
                dupMap.put(nums[i], null);
                i++;
            }
        }
        return check;
    }
}
