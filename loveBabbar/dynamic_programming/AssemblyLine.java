package loveBabbar.dynamic_programming;

/**
 * https://www.geeksforgeeks.org/assembly-line-scheduling-dp-34/
 */
public class AssemblyLine {
 public static void main(String[] args) {
  int a[][] = { { 4, 5, 3, 2 }, { 2, 10, 1, 4 } };
  int t[][] = { { 0, 7, 4, 5 }, { 0, 9, 2, 8 } };
  int e[] = { 10, 12 }, x[] = { 18, 7 };

  System.out.println(carAssembly(a, t, e, x));
 }

 private static int carAssembly(int[][] a, int[][] t, int[] e, int[] x) {
  int n = a[0].length;
  // int[] t1 = new int[n];
  // int[] t2 = new int[n];

  int i;

  int firstLine = e[0] + a[0][0];
  int secondLine = e[1] + a[1][0];

  for (i = 1; i < n; i++) {
   int up = Math.min(firstLine + a[0][i], secondLine + a[0][i] + t[1][i]);
   int down = Math.min(secondLine + a[1][i], firstLine + a[1][i] + t[0][i]);
   firstLine = up;
   secondLine = down;
  }
  return Math.min(firstLine + x[0], secondLine + x[1]);
 }
}
