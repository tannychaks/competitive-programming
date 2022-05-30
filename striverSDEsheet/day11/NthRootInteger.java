package striverSDEsheet.day11;

public class NthRootInteger {
    public static void main(String[] args) {
        int n = 3, m = 27;
        System.out.println(nthRoot(n, m));
    }

    private static double nthRoot(int n, int m) {
        double low = 1;
        double high = m;
        double eps = 0.000001;

        while (high - low > eps) {
            double mid = low + (high - low) / 2.0;
            if (multiply(mid, n) < m)
                low = mid;
            else
                high = mid;
        }

        return low;
    }

    private static double multiply(double num, int n) {

        double ans = 1.0;
        for (int i = 1; i <= n; i++) {
            ans *= num;
        }
        return ans;
    }

}
