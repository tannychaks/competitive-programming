package striverSDEsheet.day9;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> ans = partition(s);

        ans.stream().forEach(list -> {
            list.stream().forEach(val -> {
                System.out.print(val + " ");
            });
            System.out.println();
        });
    }

    private static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(0, s, ans, new ArrayList<>());

        return ans;
    }

    private static void solve(int ind, String s, List<List<String>> ans, List<String> ds) {

        if (ind == s.length()) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < s.length(); i++) {
            if (isPalin(s, ind, i)) {
                ds.add(s.substring(ind, i + 1));
                solve(i + 1, s, ans, ds);
                ds.remove(ds.size() - 1);
            }
        }
    }

    private static boolean isPalin(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
