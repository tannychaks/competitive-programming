package striverSDEsheet.day16;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean ans = isPalindrome(s);
        System.out.println(ans);
        s = " .";
        ans = isPalindromeOptimized(s);
        System.out.println(ans);
    }

    private static boolean isPalindromeOptimized(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char sC = s.charAt(start);
            char eC = s.charAt(end);
            if (sC >= 'A' && sC <= 'Z') {
                sC = (char) (sC - 'A' + 'a');
            }
            if (eC >= 'A' && eC <= 'Z') {
                eC = (char) (eC - 'A' + 'a');
            }
            if ((sC < 'a' || sC > 'z') && (sC < '0' || sC > '9')) {
                start++;
            } else if ((eC < 'a' || eC > 'z') && (eC < '0' || eC > '9')) {
                end--;
            } else if (sC != eC) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

    private static boolean isPalindrome(String s) {
        if (s == null)
            return false;
        if (s.trim().length() == 0)
            return true;
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
                sb.append(c);
        }

        return isPalin(sb.toString());
    }

    private static boolean isPalin(String s) {
        if (s.length() == 0)
            return true;
        int lo = 0, hi = s.length() - 1;

        while (lo <= hi && s.charAt(lo) == s.charAt(hi)) {
            lo++;
            hi--;
        }
        if (lo >= hi)
            return true;
        return false;
    }

}
