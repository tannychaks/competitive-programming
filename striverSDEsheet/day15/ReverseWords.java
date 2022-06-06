package striverSDEsheet.day15;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "The sky is blue";
        String ans = reverseWords(s);
        System.out.println(ans);
        ans = reverseWordsOptimized(s);
        System.out.println(ans);
    }

    private static String reverseWordsOptimized(String s) {
        char[] origStrArr = s.toCharArray();
        char[] newStrArr = new char[origStrArr.length + 1];
        int pos = 0, left = origStrArr.length - 1;

        while (left >= 0) {
            while (left >= 0 && origStrArr[left] == ' ')
                left--;

            int right = left;

            while (left >= 0 && origStrArr[left] != ' ')
                left--;

            for (int i = left + 1; i <= right; i++) {
                newStrArr[pos++] = origStrArr[i];
                if (i == right)
                    newStrArr[pos++] = ' ';
            }
        }

        if (pos == 0)
            return " ";
        else
            return new String(newStrArr, 0, pos - 1);
    }

    /**
     * Time Complexity: O(N), N~length of string
     * 
     * Space Complexity: O(1), Constant Space
     * 
     * 2-pointer approach
     * 
     * @param s
     * @return
     */
    private static String reverseWords(String s) {

        int left = 0, right = s.length() - 1;
        String temp = "", ans = "";
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ')
                temp += c;
            else {
                if (ans != "")
                    ans = temp + " " + ans;
                else
                    ans = temp;
                temp = "";
            }
            left++;
        }

        // Adding last word
        if (temp != "") {
            if (ans != "")
                ans = temp + " " + ans;
            else
                ans = temp;
        }
        return ans.trim();
    }

}
