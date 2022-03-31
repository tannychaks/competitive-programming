package leetCode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 * 
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueChar {
    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            seen.put(c, seen.getOrDefault(c, 0) + 1);

        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seen.containsKey(c) && seen.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
