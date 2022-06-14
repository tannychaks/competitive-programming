package striverSDEsheet.day22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/distinct-numbers-in-window/
 * 
 * https://www.youtube.com/watch?v=j48e8ac7r20
 */
public class DistinctNumbersInWindow {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(1);
        A.add(3);
        A.add(4);
        A.add(3);
        int B = 3;

        ArrayList<Integer> ans = dNums(A, B);
        ans.stream().forEach(val -> System.out.print(val + " "));
    }

    private static ArrayList<Integer> dNums(ArrayList<Integer> a, int b) {
        Map<Integer, Integer> mp = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < b; i++)
            mp.put(a.get(i), mp.getOrDefault(a.get(i), 0) + 1);
        ans.add(mp.size());
        int n = a.size();
        for (int i = b; i < n; i++) {
            if (mp.get(a.get(i - b)) == 1)
                mp.remove(a.get(i - b));
            else
                mp.put(a.get(i - b), mp.get(a.get(i - b)) - 1);
            mp.put(a.get(i), mp.getOrDefault(a.get(i), 0) + 1);
            ans.add(mp.size());
        }
        return ans;
    }

}
