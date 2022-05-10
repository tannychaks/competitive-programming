package striverSDEsheet.day4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestSubsetWith0Sum {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, -1, 2, -2 };
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(longestSubsetWithZeroSum(list));
    }

    private static int longestSubsetWithZeroSum(List<Integer> arr) {
        Map<Integer, Integer> map = new HashMap<>();

        int maxLen = 0, sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            if (sum == 0)
                maxLen = i + 1;
            else {
                if (map.get(sum) != null)
                    maxLen = Math.max(maxLen, i - map.get(sum));
                else
                    map.put(sum, i);
            }
        }
        return maxLen;
    }
}
