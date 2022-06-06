package striverSDEsheet.day15;

import java.util.Arrays;

public class RepeatedStringMatch {
    public static void main(String[] args) {
        String a = "abcd", b = "cdabcdab";
        int ans = repeatedStringMatch(a, b);
        System.out.println(ans);
        ans = repeatedStringMatchOptimized(a, b);
        System.out.println(ans);
    }

    private static int repeatedStringMatchOptimized(String a, String b) {
        if (a.equals(b))
            return 1;
        if (a.length() > b.length()) {
            if (a.indexOf(b) != -1)
                return 1;
            else if (a.concat(a).indexOf(b) != -1)
                return 2;
            return -1;
        }
        int[] aMap = new int[26];
        int[] bMap = new int[26];

        char[] aCharArr = a.toCharArray();
        char[] bCharArr = b.toCharArray();

        for (int i = 0; i < aCharArr.length; i++) {
            aMap[aCharArr[i] - 'a']++;
            bMap[bCharArr[i] - 'a']++;
        }

        if (!Arrays.equals(aMap, bMap))
            return -1;
        int left = 0;
        int right = a.length();
        while (right < bCharArr.length) {
            if (bCharArr[left++] != bCharArr[right++])
                return -1;
        }

        int index = b.indexOf(a);
        int diff = index - 0;
        int count = b.length() / a.length();
        int rem = b.length() % a.length();
        if (diff > 0)
            count++;
        if ((rem - diff) > 0)
            count++;
        return count;
    }

    private static int repeatedStringMatch(String a, String b) {
        if (a.equals(b))
            return 1;

        StringBuilder sb = new StringBuilder(a);
        int cnt = 1;
        while (sb.length() < b.length()) {
            sb.append(a);
            cnt++;
        }

        String temp = sb.toString();
        if (temp.contains(b))
            return cnt;

        temp += a;

        if (temp.contains(b))
            return ++cnt;
        return -1;
    }

}
