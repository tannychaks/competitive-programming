package loveBabbar.dynamic_programming;

/** https://www.geeksforgeeks.org/friends-pairing-problem/ */
public class FriendsPairing {
 public static void main(String[] args) {
  int n = 100000;
  System.out.println(countFriendsPairings(n));
 }

 /**
  * TC: O(n) SC: O(1) Kind of fibonacci approach
  * 
  * @param n
  * @return
  */
 private static long countFriendsPairings(int n) {
  long a = 1, b = 2;
  long c = 0;
  if (n <= 2)
   return n;
  for (long i = 3; i <= n; i++) {
   c = (b % 1000000007 + (i - 1) % 1000000007 * a % 1000000007) % 1000000007;
   a = b;
   b = c;
  }

  return c % 1000000007;
 }

 /** TC: O(n ) SC: O(n) */
 private static int countFriendsPairingsNaive(int n) {
  int[] dp = new int[n + 1];

  for (int i = 0; i <= n; i++) {
   if (i <= 2)
    dp[i] = i;

   else
    dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
  }
  return dp[n];
 }
}
