package striverSDEsheet.day15;

/**
 * Given a string s, return the longest palindromic substring in s.
 * 
 * Leet code link:https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * 5. Longest Palindromic Substring
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindromeBrute(s));
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindromeOptimized(s));
        System.out.println(longestPalindromeOExpandFromCenter(s));

    }

    private static String longestPalindromeOExpandFromCenter(String s) {
        if (s == null || s.length() <= 1)
            return s;
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromMid(s, i, i); // for string like "racecar"
            int len2 = expandFromMid(s, i, i + 1); // for string like "aabbaa"

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandFromMid(String s, int l, int r) {
        if (s == null || l > r)
            return 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r - l - 1;
    }

    private static String longestPalindromeOptimized(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        int sameCnt = 1;
        int left = 0, right = 0, max = 1, end = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < s.length(); ++i) {
            if (chars[i] == chars[i - 1]) {
                ++sameCnt;
                if (max < sameCnt) {
                    max = sameCnt;
                    end = i;
                }
                continue;
            }
            right = i;
            left = i - sameCnt - 1;
            while (right < s.length() && left >= 0) {
                if (chars[left] != chars[right]) {
                    break;
                }
                ++right;
                --left;
            }
            if (max < right - left - 1) {
                end = right - 1;
                max = right - left - 1;
            }
            sameCnt = 1;
        }

        return s.substring(end - max + 1, end + 1);
    }

    private static String longestPalindrome(String s) {
        int n = s.length();
        String ans = null;

        boolean[][] dp = new boolean[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }

                if (dp[i][j] && (ans == null || j - i + 1 > ans.length())) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    /** Brute force approach: O(n^3) */
    private static String longestPalindromeBrute(String s) {
        String bestS = "";
        int bestLen = 0;
        int n = s.length();
        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                int len = right - left + 1;
                if (len < left)
                    break;
                // System.out.println("Left ---->" + left);
                // System.out.println("Right ---->" + right);
                // System.out.println("substring ---->" + s.substring(left, len));
                String substr = s.substring(left, len);
                if (len - left > bestLen && isPalindrome(substr)) {
                    bestLen = len;
                    bestS = substr;
                    // System.out.println("Best String ---->" + bestLen);
                }
            }
        }
        return bestS;
    }

    private static boolean isPalindrome(String s) {
        String reverse = reverseString(s);
        return s.equals(reverse);
    }

    private static String reverseString(String s) {
        int length = s.length();
        if (length == 0)
            return "";
        int l = 0;
        int r = length - 1;
        char[] ch = s.toCharArray();
        while (l < r) {
            char c = ch[l];
            ch[l] = ch[r];
            ch[r] = c;
            l++;
            r--;
        }
        return new String(ch);
    }
}
