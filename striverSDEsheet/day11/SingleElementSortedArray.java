package striverSDEsheet.day11;

public class SingleElementSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[] { 3, 3, 7, 7, 10, 11, 11 };
        System.out.println(singleNonDuplicate(nums));
    }

    private static int singleNonDuplicate(int[] nums) {

        int low = 0, high = nums.length - 1;
        if (nums.length == 1)
            return nums[0];
        if (nums[low] != nums[low + 1])
            return nums[low];
        if (nums[high] != nums[high - 1])
            return nums[high];
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];
            else if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) ||
                    (mid % 2 == 0 && nums[mid] == nums[mid + 1]))
                low = mid + 1;
            else
                high = mid;
        }
        return -1;
    }

}
