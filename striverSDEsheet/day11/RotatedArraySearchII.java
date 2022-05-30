package striverSDEsheet.day11;

public class RotatedArraySearchII {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 2, 2, 2, 0, 0 };

        int target = 0;

        System.out.println(search(nums, target));
    }

    private static boolean search(int[] nums, int target) {
        if (nums.length == 0 || nums == null)
            return false;

        int start = 0, end = nums.length - 1;

        while (start <= end) {

            // move pointers if we see same numbers
            while (start < end && nums[start] == nums[start + 1])
                start++;

            while (start < end && nums[end] == nums[end - 1])
                end--;

            // rest of the code is same as Search in Rotated Sorted Array - I
            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return true;

            else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }
}
