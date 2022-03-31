package leetCode.string;

/**
 * 
 * 242. Valid Anagram
 * 
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {
    public static void main(String[] args) {
        String s = "rat", t = "car";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        int[] letters = new int[26];
        if (s.length() != t.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letters[c - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (letters[c - 'a'] > 0)
                letters[c - 'a']--;
            else
                return false;
        }
        return true;
    }
}
