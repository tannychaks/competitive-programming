package striverSDEsheet.day10;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");

        System.out.println(wordBreak(s, wordDict));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        return hasWord(s, wordDict, 0, new Boolean[s.length() + 1]);
    }

    private static boolean hasWord(String s, List<String> word, int i, Boolean[] dp) {

        if (dp[i] != null) {
            return dp[i];
        }

        if (i >= s.length()) {
            dp[i] = true;
            return true;
        }

        boolean result = false;

        for (String temp : word) {
            if (i <= s.length() && s.startsWith(temp, i)) {
                result = true && hasWord(s, word, i + temp.length(), dp);
            }
            if (result) {
                break;
            }
        }
        dp[i] = result;
        return result;
    }

}
