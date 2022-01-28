package dynamicProgramming.longest_common_subsequence;

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
  System.out.println(longestPalindrome(s));
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
