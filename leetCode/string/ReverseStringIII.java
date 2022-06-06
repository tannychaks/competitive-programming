package leetCode.string;

public class ReverseStringIII {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    private static String reverseWords(String input) {
        char[] s = input.toCharArray();
        int j = 0;
        for (int i = 0; i < s.length && j < s.length;) {

            while (j < s.length && s[j] != ' ') {
                j++;
            }
            for (int p = i, q = j - 1; p < q; p++, q--) {
                char temp = s[q];
                s[q] = s[p];
                s[p] = temp;
            }
            i = j + 1;
            j++;
        }
        return new String(s);
    }
}
