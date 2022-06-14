package striverSDEsheet.day22;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestInStream {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[] { 4, 5, 8, 2 });
        System.out.println(kthLargest.add(3)); // return 4
        System.out.println(kthLargest.add(5)); // return 5
        System.out.println(kthLargest.add(10)); // return 5
        System.out.println(kthLargest.add(9)); // return 8
        System.out.println(kthLargest.add(4)); // return 8
    }

    static class KthLargest {
        Queue<Integer> q;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            q = new PriorityQueue<>();
            for (int x : nums)
                q.add(x);
            while (q.size() > k)
                q.remove();
        }

        public int add(int val) {
            q.add(val);
            if (q.size() > k)
                q.remove();
            return q.peek();
        }
    }
}
