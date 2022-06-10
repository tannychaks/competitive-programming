package striverSDEsheet.day17;

/**
 * https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "adc", s2 = "dcda";
        boolean isPermute = checkInclusion(s1, s2);
        System.out.println(isPermute);
    }

    /**
     * Sliding window technique:
     * 
     * 1. Check whether pre - computation is required
     * 
     * 2. Decide on what condition will you increase the width of the window (only
     * if
     * char from s1 is part of s2)
     * 
     * 3. Decide on what condition will you decrease the width of the window (if we
     * ran
     * out of chars while expanding or if the char doesn't exist while expanding)
     * 
     * 4. Look for edge cases
     * 
     * 
     * @param s1
     * @param s2
     * @return
     */
    private static boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        if (s1Len > s2Len)
            return false;

        if (s2Len == 1)
            return s1.charAt(0) == s2.charAt(0);

        int charArr[] = new int[26];

        for (char c : s1.toCharArray())
            charArr[c - 'a']++;

        int i = 0;
        int j = 0;

        char ch1 = 'a';

        char[] charArr2 = s2.toCharArray();

        while (i < s2Len) {

            while (i < s2Len && j == i && charArr[(ch1 = charArr2[i]) - 'a'] == 0) {
                i++;
                j = i;
            }

            if (s2Len - i < s1Len)
                break;

            while (j < s2Len && charArr[(ch1 = charArr2[j]) - 'a'] != 0) {
                charArr[ch1 - 'a']--;
                j++;
            }
            if (j - i == s1Len)
                return true;

            if (j >= s2Len)
                break;

            while (i < j && charArr[ch1 - 'a'] == 0) {
                charArr[charArr2[i] - 'a']++;
                i++;
            }

        }
        return false;
    }
}
