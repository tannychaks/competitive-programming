package striverSDEsheet.day4;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatChar {
    public static void main(String[] args) {
        String s = "abcabcdbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        int len = 0, l = 0, r = 0;

        Map<Character, Integer> mp = new HashMap<>();

        while (r < s.length()) {
            if (mp.containsKey(s.charAt(r)))
                l = Math.max(l, mp.get(s.charAt(r)) + 1);
            mp.put(s.charAt(r), r);
            len = Math.max(len, r - l + 1);
            r++;
        }
        return len;
    }
}
