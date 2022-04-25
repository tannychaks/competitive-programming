package striverSDEsheet.day3;

public class PowOfX {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
    }

    private static double myPow(double x, int n) {
        double ans = 1.00000;
        long temp = n;
        if (temp < 0)
            temp = -1 * temp;
        while (temp > 0) {
            if ((temp & 1) != 1) {
                x *= x;
                temp >>= 1;
            } else {
                ans *= x;
                temp--;
            }
        }
        if (n < 0)
            return (double) (1.00000) / (double) ans;
        return ans;
    }
}
