package striverSDEsheet.day11;

public class RotatedArraySearch {
    public static void main(String[] args) {
        int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int target = 6;

        System.out.println(search(nums, target));
        System.out.println(searchOptimized(nums, target));
    }

    private static int searchOptimized(int[] nums, int target) {
        if (nums.length == 0 || nums == null)
            return -1;

        int start = 0, end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return mid;

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

        return -1;
    }

    private static int search(int[] nums, int target) {
        int index = findIndex(nums);

        int leftSearch = binarySearch(nums, 0, index - 1, target);
        if (leftSearch != -1)
            return leftSearch;
        else {
            int rightSearch = binarySearch(nums, index, nums.length - 1, target);
            return rightSearch;
        }
    }

    private static int binarySearch(int[] nums, int low, int high, int target) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;

    }

    private static int findIndex(int[] nums) {

        int low = 0, n = nums.length, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int next = (mid + 1) % n;
            int prev = (mid - 1 + n) % n;
            if (nums[mid] <= nums[next] && nums[mid] <= nums[prev])
                return mid;
            else if (nums[mid] <= nums[high])
                high = mid - 1;
            else if (nums[mid] >= nums[low])
                low = mid + 1;

        }
        return 0;
    }
}
