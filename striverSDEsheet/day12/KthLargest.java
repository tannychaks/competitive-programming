package striverSDEsheet.day12;

import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {
        int[] nums = new int[] { 3, 2, 1, 5, 6, 4 };
        int k = 4;
        int largest = findKthLargest(nums, k);
        System.out.println(largest);
        int largest2 = findKthLargestOptimum(nums, k);
        System.out.println(largest2);
    }

    private static int findKthLargestOptimum(int[] nums, int k) {
        int left = 0, right = nums.length - 1, kth;
        while (true) {
            int index = partition(nums, left, right);
            if (index == k - 1) {
                kth = nums[index];
                break;
            }
            if (index < k - 1)
                left++;
            else
                right--;
        }
        return kth;
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1, r = right;

        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                nums[l] += nums[r] - (nums[r] = nums[l]);
                l++;
                r--;
            }
            if (nums[l] >= pivot)
                l++;
            if (nums[r] <= pivot)
                r--;
        }
        nums[left] += nums[r] - (nums[r] = nums[left]);
        return r;
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
