package loveBabbar.dynamic_programming;

import java.math.BigInteger;

/**
 * Very Important:
 * 
 * https://www.geeksforgeeks.org/program-nth-catalan-number/
 * 
 * https://www.geeksforgeeks.org/applications-of-catalan-numbers/
 */
public class Catalan {
 public static void main(String[] args) {
  int n = 23;
  System.out.println(findCatalan(n));
 }

 private static int findCatalanFormula(int n) {
  int cat = 1;
  for (int i = 1; i <= n; i++) {
   cat *= 4 * i - 2;
   cat /= i + 1;
  }
  return cat;
 }

 /**
  * Finding values of catalan numbers for N>80 is not possible even by using long
  * in java, so we use BigInteger
  */
 private static BigInteger findCatalan(int n) {
  // using BigInteger to calculate large factorials
  BigInteger b = new BigInteger("1");

  // calculating n!
  for (int i = 1; i <= n; i++) {
   b = b.multiply(BigInteger.valueOf(i));
  }

  // calculating n! * n!
  b = b.multiply(b);

  BigInteger d = new BigInteger("1");

  // calculating (2n)!
  for (int i = 1; i <= 2 * n; i++) {
   d = d.multiply(BigInteger.valueOf(i));
  }

  // calculating (2n)! / (n! * n!)
  BigInteger ans = d.divide(b);

  // calculating (2n)! / ((n! * n!) * (n+1))
  ans = ans.divide(BigInteger.valueOf(n + 1));
  // System.out.println(ans);
  return ans;
 }
}
