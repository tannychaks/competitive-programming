package striverSDEsheet.day15;

/**
 * https://leetcode.com/problems/custom-sort-string/
 */
public class CustomSortString {
    public static void main(String[] args) {
        String order = "cba", s = "abcd";
        String ans = customSortString(order, s);
        System.out.println(ans);
    }

    private static String customSortString(String order, String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            while (freq[order.charAt(i) - 'a'] > 0) {
                sb.append(order.charAt(i));
                freq[order.charAt(i) - 'a']--;
            }
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                while (freq[i] != 0) {
                    sb.append((char) (97 + i));
                    freq[i]--;
                }
            }
        }
        return sb.toString();
    }
}
