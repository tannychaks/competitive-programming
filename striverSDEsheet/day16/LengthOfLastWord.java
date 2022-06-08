package striverSDEsheet.day16;

/**
 * https://leetcode.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello Worlds";
        int ans = lengthOfLastWord(s);
        System.out.println(ans);
    }

    private static int lengthOfLastWord(String s) {
        s = s.trim();
        int indexOfLastSpace = s.lastIndexOf(' ');

        return s.substring(indexOfLastSpace + 1, s.length()).length();
    }

}
