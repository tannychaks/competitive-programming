package general;

/**
 * Given a number n, write an efficient function to print all prime factors of
 * n. For example, if the input number is 12, then output should be “2 2 3”. And
 * if the input number is 315, then output should be “3 3 5 7”.
 */
public class PrimeFactors {
 public static void main(String[] args) {
  int n = 24;
  System.out.println(largestPrimeFactor(n));
 }

 private static int largestPrimeFactor(int n) {
  int max = 0;
  while (n % 2 == 0) {
   max = 2;
   n /= 2;
  }
  for (int i = 3; i <= Math.sqrt(n); i += 2) {
   while (n % i == 0) {
    max = Math.max(max, i);
    n /= i;
   }
  }
  if (n > 2)
   max = Math.max(max, n);
  return max;
 }
}
