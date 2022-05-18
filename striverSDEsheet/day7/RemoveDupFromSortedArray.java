package striverSDEsheet.day7;

public class RemoveDupFromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

        System.out.println(removeDuplicates(nums));
    }

    /**
     * Time complexity: O(n)
     * 
     * Space Complexity: O(1)
     * 
     * @param nums
     * @return
     */
    private static int removeDuplicates(int[] nums) {

        if (nums.length == 1)
            return 1;

        int fast = 1, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
