package leetCode.bit_manipualtion;

/**
 * https://leetcode.com/problems/count-the-number-of-consistent-strings/
 * 
 * 1684. Count the Number of Consistent Strings
 * You are given a string allowed consisting of distinct characters and an array
 * of strings words. A string is consistent if all characters in the string
 * appear in the string allowed.
 * 
 * Return the number of consistent strings in the array words.
 */
public class ConsistentStrings {
 public static void main(String[] args) {
  String allowed = "ab";
  String[] words = new String[] { "ad", "bd", "aaab", "baa", "badab" };
  System.out.println(countConsistentStrings(allowed, words));
 }

 private static int countConsistentStrings(String allowed, String[] words) {
  int ans = words.length;
  int[] alpha = new int[26];
  char[] allowedArr = allowed.toCharArray();
  for (char c : allowedArr) {
   alpha[c - 'a']++;
  }
  for (String word : words) {
   char[] wordArr = word.toCharArray();
   for (char c : wordArr) {
    if (alpha[c - 'a'] == 0) {
     ans--;
     break;
    }
   }
  }
  return ans;
 }
}
