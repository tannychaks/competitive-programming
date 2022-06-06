package striverSDEsheet.day15;

public class MyAtoi {
    public static void main(String[] args) {
        String s = "   -42";
        int ans = myAtoi(s);
        System.out.println(ans);
    }

    private static int myAtoi(String s) {
        if (s.length() == 0)
            return 0;
        s = s.trim();
        int signMultiplier = 1;
        int index = 0;
        // remove white spaces from the string
        while (index < s.length() && s.charAt(index) == ' ')
            index++;

        if (index == s.length()) // All spaces
            return 0;

        // get the sign
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            signMultiplier = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        int ans = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            if (digit < 0 || digit > 9)
                break;

            // check for overflow
            if (Integer.MAX_VALUE / 10 < ans || Integer.MAX_VALUE / 10 == ans && Integer.MAX_VALUE % 10 < digit)
                return signMultiplier == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            ans = ans * 10 + (int) (s.charAt(index) - '0');
            index += 1;
        }

        return ans * signMultiplier;
    }

}
