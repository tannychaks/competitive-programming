package striverSDEsheet.day16;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 * Given a string s, return true if the s can be palindrome after deleting at
 * most one character from it.
 */
public class ValidPalindromeII {
    public static void main(String[] args) {
        String s = "mlcuppuculm";
        boolean ans = validPalindrome(s);
        System.out.println(ans);

    }

    private static boolean validPalindrome(String s) {
        int lo = 0, hi = s.length() - 1, flag = 0;
        return isPalin(s, lo, hi, flag);

    }

    private static boolean isPalin(String s, int lo, int hi, int flag) {
        while (lo <= hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                if (flag < 1 && isPalin(s, lo + 1, hi, 1))
                    return true;
                else if (flag < 1 && isPalin(s, lo, hi - 1, 1))
                    return true;
                else
                    return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
