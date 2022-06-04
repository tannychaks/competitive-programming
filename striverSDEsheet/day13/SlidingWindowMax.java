package striverSDEsheet.day13;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMax {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] ans = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int c = 0;
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && q.peek() == i - k) // out of bound values
                q.poll();
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i])
                q.pollLast();
            q.offer(i);
            if (i >= k - 1)
                ans[c++] = nums[q.peek()];
        }
        return ans;
    }

}
