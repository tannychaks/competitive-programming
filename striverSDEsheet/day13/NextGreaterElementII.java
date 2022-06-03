package striverSDEsheet.day13;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 1 };
        int[] ans = nextGreaterElement(nums);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] nextGreaterElement(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] nge = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i % n])
                st.pop();
            if (i < n) {
                if (!st.isEmpty())
                    nge[i] = st.peek();
                else
                    nge[i] = -1;
            }

            st.push(nums[i % n]);
        }

        return nge;
    }
}
