package striverSDEsheet.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> list = groupAnagrams(strs);
        list.stream().forEach(l -> {
            l.stream().forEach(val -> System.out.print(val + " "));
            System.out.println();
        });
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<List<String>>();
        Map<String, List<String>> sortedMap = new HashMap<String, List<String>>();

        for (String curr : strs) {
            createMap(curr, sortedMap);
        }

        for (Map.Entry<String, List<String>> map : sortedMap.entrySet())
            ans.add(map.getValue());
        return ans;
    }

    private static void createMap(String curr, Map<String, List<String>> sortedMap) {
        char[] toChar = curr.toCharArray();

        Arrays.sort(toChar);
        String output = new String(toChar);

        if (sortedMap.containsKey(output))
            sortedMap.get(output).add(curr);
        else {
            List<String> anagramList = new ArrayList<>();
            anagramList.add(curr);
            sortedMap.put(output, anagramList);
        }
    }

}
