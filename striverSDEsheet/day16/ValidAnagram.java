package striverSDEsheet.day16;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {
    public static void main(String[] args) {
        String s = "ratc", t = "cart";
        System.out.println(isAnagram(s, t));
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] letters = new int[26];

        for (int i = 0; i < s.length(); i++)
            letters[s.charAt(i) - 'a']++;

        for (int i = 0; i < t.length(); i++)
            if (letters[t.charAt(i) - 'a'] > 0)
                letters[t.charAt(i) - 'a']--;
            else
                return false;
        return true;
    }

}
