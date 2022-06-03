package striverSDEsheet.day13;

import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        String s = "( )[ { } ( ) ]";
        System.out.println(isValidParentheses(s));
    }

    private static boolean isValidParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                st.push(c);
            else if (c == ')' || c == '}' || c == ']') {
                if (st.isEmpty())
                    return false;
                char popped = st.pop();
                if ((popped == '(' && c == ')') || (popped == '{' && c == '}') || (popped == '[' && c == ']'))
                    continue;
                else
                    return false;
            } else
                continue;
        }
        if (st.isEmpty())
            return true;
        return false;
    }
}
