package dynamicProgramming.longest_common_subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s and an array of strings words, return the number of words[i]
 * that is a subsequence of s.
 * 
 * Leet code link :
 * https://leetcode.com/problems/number-of-matching-subsequences/
 * 
 * 792. Number of Matching Subsequences
 */
public class NumberOfMatchingSequence {
 public static void main(String[] args) {
  String s = "abcde";
  String[] words = new String[] { "a", "bb", "acd", "ace" };
  System.out.println(numMatchingSubseq(s, words));
 }

 /**
  * We will take the optimized 2-pointer approach instead of LCS approach here.
  * For details check SequencePatternMatching.java .
  * 
  * @param s
  * @param words
  * @return
  */
 private static int numMatchingSubseq(String s, String[] words) {
  int count = 0;
  Map<String, Boolean> cache = new HashMap<>();
  for (String word : words) {
   if (word.length() > s.length())
    continue;
   if (isSubsequence(word, s, cache))
    count++;
  }
  return count;
 }

 private static boolean isSubsequence(String word, String s, Map<String, Boolean> cache) {
  if (cache.get(word) != null)
   return cache.get(word);
  int index = -1;
  for (char c : word.toCharArray()) {
   index = s.indexOf(c, index + 1);

   if (index == -1) {
    cache.put(word, false);
    return false;
   }
  }
  cache.put(word, true);
  return true;
 }
}
