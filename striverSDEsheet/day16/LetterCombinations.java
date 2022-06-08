package striverSDEsheet.day16;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {
    public static void main(String[] args) {
        String digits = "2347";
        List<String> list = letterCombinations(digits);
        list.stream().forEach(System.out::println);
    }

    private static final char[][] LETTER_ARR = {
            { 'a', 'b', 'c' },
            { 'd', 'e', 'f' },
            { 'g', 'h', 'i' },
            { 'j', 'k', 'l' },
            { 'm', 'n', 'o' },
            { 'p', 'q', 'r', 's' },
            { 't', 'u', 'v' },
            { 'w', 'x', 'y', 'z' } };

    private static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans;
        findAns(digits, ans, new StringBuilder());
        return ans;
    }

    private static void findAns(String digits, List<String> ans, StringBuilder sb) {
        if (digits.length() == 0) {
            ans.add(sb.toString());
            return;
        }

        for (char c : LETTER_ARR[digits.charAt(0) - '2']) {
            findAns(digits.substring(1), ans, sb.append(c));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
