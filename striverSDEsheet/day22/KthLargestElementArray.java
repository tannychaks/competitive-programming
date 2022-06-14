package striverSDEsheet.day22;

import java.util.PriorityQueue;

public class KthLargestElementArray {
    public static void main(String[] args) {
        int[] nums = new int[] { 3, 2, 1, 5, 6, 4 };
        int k = 2;

        int ans = findKthLargest(nums, k);
        System.out.println(ans);
    }

    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // max heap
        for (int num : nums)
            pq.add(num);
        int it = k - 1;
        while (it > 0) {
            pq.poll();
            it--;
        }
        return pq.peek();
    }

}
