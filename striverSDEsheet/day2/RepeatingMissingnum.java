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

}
