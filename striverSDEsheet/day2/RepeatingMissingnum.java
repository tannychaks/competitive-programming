package striverSDEsheet.day2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.codingninjas.com/codestudio/problems/873366?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/
 */
public class RepeatingMissingnum {

    static class Pair<U, V> {
        private final U key;
        private final V value;

        public U getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        Pair(U key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        Pair<Integer, Integer> ans = missingAndRepeating(arr, n);
        System.out.println(ans.getKey() + " : " + ans.getValue());
        ans = missingAndRepeatingUsingXOR(arr, n);
        System.out.println(ans.getKey() + " : " + ans.getValue());
        sc.close();
    }

    private static Pair<Integer, Integer> missingAndRepeating(ArrayList<Integer> arr, int n) {
        int repeatingNum = 0, missingNum = 0;

        long S = 0L, P = 0L;
        S = (n * (n + 1)) / 2;
        P = (n * (n + 1) * (2 * n + 1)) / 6;
        for (int num : arr) {
            S -= num;
            P -= Math.pow(num, 2);
        }
        missingNum = (int) (S + P / S) / 2;

        repeatingNum = (int) (missingNum - S);

        Pair<Integer, Integer> p = new Pair<>(missingNum, repeatingNum);
        return p;
    }

    private static Pair<Integer, Integer> missingAndRepeatingUsingXOR(ArrayList<Integer> arr, int n) {
        int xor = arr.get(0);
        for (int i = 1; i < n; i++)
            xor ^= arr.get(i);

        for (int i = 1; i <= n; i++)
            xor ^= i;

        int setBit = xor & ~(xor - 1);
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if ((arr.get(i) & setBit) != 0)
                x = x ^ arr.get(i);
            else
                y ^= arr.get(i);
        }
        for (int i = 1; i <= n; i++) {
            if ((i & setBit) != 0)
                x = x ^ i;
            else
                y ^= i;
        }

        int countX = 0;
        for (int num : arr) {
            if (num != x && num != y)
                continue;
            else if (num == x)
                countX++;
        }

        if (countX == 0) {
            Pair<Integer, Integer> p = new Pair<>(x, y);
            return p;
        } else {
            Pair<Integer, Integer> p = new Pair<>(y, x);
            return p;
        }
    }

}
