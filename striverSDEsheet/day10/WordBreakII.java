package striverSDEsheet.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");

        wordBreak(s, wordDict).forEach(System.out::println);

    }

    static HashMap<String, List<String>> memo = new HashMap<>();

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> lists = getLists(set, s);
        return lists;
    }

    private static List<String> getLists(Set<String> set, String s) {
        List<String> res = new ArrayList<>();
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        if (s.equals("")) {
            res.add("");
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            String right = s.substring(i);
            if (set.contains(right)) {
                List<String> lefts = getLists(set, s.substring(0, i));
                for (String left : lefts) {
                    if (left.equals("")) {
                        res.add(right);
                    } else {
                        // StringBuilder improves performance a lot
                        StringBuilder sb = new StringBuilder();
                        sb.append(left);
                        sb.append(" ");
                        sb.append(right);
                        res.add(sb.toString());
                    }
                }
            }
        }
        memo.put(s, res);
        return res;
    }
}
