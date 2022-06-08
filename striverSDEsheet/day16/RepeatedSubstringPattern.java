package striverSDEsheet.day16;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 * 
 * Given a string s, check if it can be constructed by taking a substring of it
 * and appending multiple copies of the substring together.
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "abab";

        System.out.println(repeatedSubstringPattern(s));
    }

    /**
     * explanation : https://www.youtube.com/watch?v=bClIZj66dVE
     * 
     * @param s
     * @return
     */

    private static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = len / 2; i >= 1; i--) {
            if (len % i == 0) {
                int repeat = len / i;
                String substr = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < repeat; j++)
                    sb.append(substr);
                if (sb.toString().equals(s))
                    return true;
            }
        }
        return false;
    }

}
