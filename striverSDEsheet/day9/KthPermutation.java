package striverSDEsheet.day9;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {
    public static void main(String[] args) {
        int n = 3;
        var k = 3;
        System.out.println(getPermutation(n, k));
    }

    /**
     * TC: O(N^2)
     * SC: O(N)
     * 
     * @param n
     * @param k
     * @return
     */
    private static String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        String ans = "";
        k = k - 1;
        while (true) {
            ans += numbers.get(k / fact);
            numbers.remove(k / fact);
            if (numbers.size() == 0)
                break;
            k %= fact;
            fact /= numbers.size();
        }

        return ans;
    }
}
