package striverSDEsheet.day16;

/**
 * https://leetcode.com/problems/add-binary/
 */
public class BinaryAddition {
    public static void main(String[] args) {
        String a = "1010", b = "1011";
        String ans = addBinary(a, b);
        System.out.println(ans);
    }

    /**
     * Time Complexity: O(max(L1, L2)), where L1 and L2 are the lengths of strings a
     * and b respectively.
     * 
     * Auxiliary Space: O(max(L1, L2)), where L1 and L2 are the lengths of strings a
     * and b respectively.
     * 
     * @param a
     * @param b
     * @return
     */
    private static String addBinary(String a, String b) {
        if (a.equals("0") && b.equals("0"))
            return "0";
        StringBuilder ans = new StringBuilder("");

        int i = a.length() - 1, j = b.length() - 1, sum = 0;

        while (i >= 0 || j >= 0 || sum == 1) {
            sum += ((i >= 0) ? a.charAt(i) - '0' : 0);
            sum += ((j >= 0) ? b.charAt(j) - '0' : 0);

            ans.append((char) (sum % 2 + '0'));

            sum /= 2;
            i--;
            j--;
        }

        int start = ans.length() - 1;

        while (start >= 0 && ans.charAt(start) == '0')
            start--;

        if (start != ans.length() - 1)
            ans.delete(start + 1, ans.length());
        return ans.reverse().toString();
    }
}
