package loveBabbar.dynamic_programming;

public class PermuationCoefficient {
 public static void main(String[] args) {
  int n = 5, k = 2;
  System.out.println(permutationCoeff(n, k));
 }

 private static int permutationCoeff(int n, int k) {
  int factN = 1, factK = 1;
  for (int i = 1; i <= n; i++) {
   factN *= i;
   if (i == (n - k))
    factK = factN;
  }
  int coeff = factN / factK;
  return coeff;

 }
}
