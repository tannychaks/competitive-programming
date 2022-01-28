package dynamicProgramming.matrix_chain_multiplication;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string A, we may represent it as a binary tree by partitioning it to
 * two non-empty substrings recursively.
 * 
 * Below is one possible representation of A = “great”:
 * 
 * 
 * great / \ gr eat / \ / \ g r e at / \ a t
 * 
 * To scramble the string, we may choose any non-leaf node and swap its two
 * children.
 * 
 * For example, if we choose the node “gr” and swap its two children, it
 * produces a scrambled string “rgeat”.
 * 
 * rgeat / \ rg eat / \ / \ r g e at / \ a t We say that “rgeat” is a scrambled
 * string of “great”.
 * 
 * Similarly, if we continue to swap the children of nodes “eat” and “at”, it
 * produces a scrambled string “rgtae”.
 * 
 * rgtae / \ rg tae / \ / \ r g ta e / \ t a We say that “rgtae” is a scrambled
 * string of “great”.
 * 
 * 
 * 
 * Given two strings A and B of the same length, determine if B is a scrambled
 * string of S.
 * 
 * 
 * 
 * Input Format:
 * 
 * The first argument of input contains a string A. The second argument of input
 * contains a string B. Output Format:
 * 
 * Return an integer, 0 or 1: => 0 : False => 1 : True Constraints:
 * 
 * 1 <= len(A), len(B) <= 50
 * 
 * link: https://www.interviewbit.com/problems/scramble-string/#
 */
public class ScrambledString {
 static Map<String, Integer> pairMap = new HashMap<>();

 public static void main(String[] args) {
  String a = "phqtrnilf";
  String b = "ilthnqrpf";
  System.out.println(isScramble(a, b));

 }

 private static int isScramble(String a, String b) {
  String key = a + " " + b;
  if (a.length() != b.length()) {
   pairMap.put(key, 0);
   return 0;
  }

  if (a.compareTo(b) == 0) {
   pairMap.put(key, 1);
   return 1;
  }
  if (a.length() == 0) {
   pairMap.put(key, 1);
   return 1;
  }
  if (pairMap.containsKey(key))
   return pairMap.get(key);
  int n = a.length();
  int flag = 0;

  for (int i = 1; i <= n - 1; i++) {
   if (isScramble(a.substring(0, i), b.substring(0, i)) == 1 && isScramble(a.substring(i, n), b.substring(i, n)) == 1) {
    flag = 1;
    return 1;
   }

   if (isScramble(a.substring(n - i, n), b.substring(0, i)) == 1
     && isScramble(a.substring(0, n - i), b.substring(i, n)) == 1) {
    flag = 1;
    return 1;
   }
  }
  pairMap.put(key, flag);
  return 0;
 }
}
