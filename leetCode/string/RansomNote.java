package leetCode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 383. Ransom Note
 * 
 * https://leetcode.com/problems/ransom-note/
 */
public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "a", magazine = "b";
        System.out.println(canConstruct(ransomNote, magazine));
        System.out.println(canConstructFreqArray(ransomNote, magazine));
    }

    /**
     * Using Frequency Array
     * 
     * @param ransomNote
     * @param magazine
     * @return
     */
    private static boolean canConstructFreqArray(String ransomNote, String magazine) {
        int[] letters = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            letters[c - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (letters[c - 'a'] > 0)
                letters[c - 'a']--;
            else
                return false;
        }
        return true;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char m = magazine.charAt(i);
            map.put(m, map.getOrDefault(m, 0) + 1);
        }
        boolean flag = false;

        for (int i = 0; i < ransomNote.length(); i++) {
            char r = ransomNote.charAt(i);
            Integer count = map.get(r);
            if (count != null) {
                flag = true;
                if (count == 1)
                    map.put(r, null);
                else
                    map.put(r, count - 1);
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
