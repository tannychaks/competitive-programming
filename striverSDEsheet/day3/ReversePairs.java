package striverSDEsheet.day3;

import java.util.ArrayList;

/**
 * 
 * https://takeuforward.org/data-structure/count-reverse-pairs/
 * 
 * https://leetcode.com/problems/reverse-pairs/
 */
public class ReversePairs {
    public static void main(String[] args) {

        int[] arr = new int[] { 1, 3, 2, 3, 1 };

        System.out.println(reversePairs(arr));
        // Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
    }

    private static int reversePairs(int[] nums) {
        int reversePairs = sort(nums, 0, nums.length - 1);
        return reversePairs;
    }

    private static int sort(int[] nums, int l, int r) {
        int reversePairs = 0;
        if (l < r) {
            int mid = (l + r) / 2;
            reversePairs += sort(nums, l, mid);
            reversePairs += sort(nums, mid + 1, r);
            reversePairs += merge(nums, l, mid, r);
        }
        return reversePairs;
    }

    private static int merge(int[] nums, int low, int mid, int high) {

        int cnt = 0;
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] > (2 * (long) nums[j])) {
                j++;
            }
            cnt += (j - (mid + 1));
        }

        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add((int) nums[left++]);
            } else {
                temp.add((int) nums[right++]);
            }
        }

        while (left <= mid) {
            temp.add((int) nums[left++]);
        }
        while (right <= high) {
            temp.add((int) nums[right++]);
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
        return cnt;
    }
}
