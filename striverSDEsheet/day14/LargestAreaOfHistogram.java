package striverSDEsheet.day14;

import java.util.Stack;

public class LargestAreaOfHistogram {
    public static void main(String[] args) {
        int[] heights = new int[] { 2, 1, 5, 6, 2, 3 };
        int ans = largestRectangleArea(heights);
        System.out.println(ans);
        ans = largestRectangleAreaoptimized(heights);
        System.out.println(ans);
    }

    private static int largestRectangleAreaoptimized(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxA = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            while (!st.empty() && (i == n || heights[st.peek()] >= heights[i])) {
                int height = heights[st.peek()];
                st.pop();
                int width;
                if (st.empty())
                    width = i;
                else
                    width = i - st.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            st.push(i);
        }
        return maxA;
    }

    /**
     * Time Complexity: O( N )
     * 
     * Space Complexity: O(3N) where 3 is for the stack, left small array and a
     * right small array
     * 
     * @param heights
     * @return
     */
    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] leftSmallestElement = new int[n];
        int[] rightSmallestElement = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();
            if (!st.isEmpty())
                leftSmallestElement[i] = st.peek() + 1;
            else
                leftSmallestElement[i] = 0;
            st.push(i);
        }

        while (!st.isEmpty())
            st.pop();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();

            if (!st.isEmpty())
                rightSmallestElement[i] = st.peek() - 1;
            else
                rightSmallestElement[i] = n - 1;

            st.push(i);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, heights[i] * (rightSmallestElement[i] - leftSmallestElement[i] + 1));
        }
        return max;
    }

}
