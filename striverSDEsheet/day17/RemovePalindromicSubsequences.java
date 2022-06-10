package striverSDEsheet.day17;

/**
 * https://leetcode.com/problems/remove-palindromic-subsequences/
 */
public class RemovePalindromicSubsequences {
    public static void main(String[] args) {
        String s = "ababa";
        int ans = removePalindromeSub(s);
        System.out.println(ans);
    }

    private static int removePalindromeSub(String s) {
        if (isPalindrome(s))
            return 1;
        else
            return 2;
    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }

}
