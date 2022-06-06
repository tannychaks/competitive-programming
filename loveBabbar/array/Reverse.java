package loveBabbar.array;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(reverseString(s));
        sc.close();
    }

    private static String reverseString(String s) {
        int length = s.length();
        if (length == 0)
            return "";
        int l = 0;
        int r = length - 1;
        char[] ch = s.toCharArray();
        while (l < r) {
            char c = ch[l];
            ch[l] = ch[r];
            ch[r] = c;
            l++;
            r--;
        }
        return new String(ch);
    }
}
