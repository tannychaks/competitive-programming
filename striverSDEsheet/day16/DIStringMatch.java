package striverSDEsheet.day16;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/di-string-match/
 */
public class DIStringMatch {
    public static void main(String[] args) {
        String s = "IDID";
        int[] ans = diStringMatch(s);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] diStringMatch(String s) {
        int len = s.length();
        int low = 0, high = len;
        int[] ans = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'I')
                ans[i] = low++;
            else
                ans[i] = high--;
        }
        ans[len] = high;
        return ans;
    }

}
