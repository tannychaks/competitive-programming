package striverSDEsheet.day16;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        List<String> list = generateParenthesis(n);
        list.stream().forEach(System.out::println);

    }

    private static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        genPar(n, n, ans, "");
        return ans;
    }

    private static void genPar(int p1, int p2, List<String> ans, String s) {
        // p1 -> number of opening brackets available
        // p2 -> number of closing brackets available
        if (p1 == p2) { // must take only opening bracket
            s += '(';
            p1--;
        }

        if (p1 == 0 && p2 > 0) { // must take only closing bracket
            while (p2 != 0) {
                s += ')';
                p2--;
            }
            ans.add(s);
            return;
        }

        // 2 possibilities
        genPar(p1 - 1, p2, ans, s + '('); // we choose opening bracket
        genPar(p1, p2 - 1, ans, s + ')'); // we choose closing bracket
    }

}
