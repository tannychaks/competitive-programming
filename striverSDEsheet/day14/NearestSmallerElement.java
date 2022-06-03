package striverSDEsheet.day14;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 3, 0, 2, 5 };
        int[] ans = nextSmallerElement(nums);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] nextSmallerElement(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] nse = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek() >= nums[i])
                st.pop();

            if (st.isEmpty())
                nse[i] = -1;
            else
                nse[i] = st.peek();
            st.push(nums[i]);
        }
        return nse;
    }
}
