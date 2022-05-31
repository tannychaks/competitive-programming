package striverSDEsheet.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {

        // Step 1: Create a frequency map
        Map<Integer, Integer> map = new HashMap<>();

        // Step 2: Fill the map
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Step 3: Create a bucket
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];

        // Step 4: Fill the bucket
        for (Integer i : map.keySet()) {

            int key = i;
            int value = map.get(i);

            // Step 5: If a bucket is empty, initialize it
            if (bucket[value] == null) {
                bucket[value] = new ArrayList<>();
            }

            // Step 6: Insert the key in the 'value' bucket
            bucket[value].add(key);

        }

        int[] result = new int[k];
        int counter = 0;
        int temp = k;

        // Step 7: Start from right side of the bucket and store 'k' elements
        for (int i = nums.length; i >= 0; i--) {

            if (bucket[i] != null) {

                for (Integer j : bucket[i]) {

                    if (temp == 0) {
                        break;
                    }

                    result[counter] = (int) j;

                    counter++;

                    temp--;

                }
            }
        }

        return result;

    }
}
