package striverSDEsheet.day16;

public class ImplementStrStr {
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        int ans = strStr(haystack, needle);
        System.out.println(ans);
    }

    private static int strStr(String haystack, String needle) {
        int index = haystack.indexOf(needle);
        if (index != -1)
            return index;
        return -1;
    }

}
