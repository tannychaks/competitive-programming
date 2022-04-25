package striverSDEsheet.day3;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/majority-element-ii
 */
public class MajorityElement2 {
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElementOptimal(nums));
    }

    private static List<Integer> majorityElementOptimal(int[] nums) {
        /*
         * since it is ceil of n/3,at most there will be 2 elements Math.ceil(10/4) -->
         * 2
         */
        List<Integer> list = new ArrayList<>();
        int count1 = 0, count2 = 0, ele1 = 0, ele2 = 0;
        for (int num : nums) {
            if (num == ele1)
                count1++;
            else if (num == ele2)
                count2++;
            else if (count1 == 0) {
                count1++;
                ele1 = num;
            } else if (count2 == 0) {
                count2++;
                ele2 = num;
            } else {
                count1 -= 1;
                count2 -= 1;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == ele1)
                count1++;
            else if (num == ele2)
                count2++;
        }

        if (count1 > nums.length / 3)
            list.add(ele1);
        if (count2 > nums.length / 3)
            list.add(ele2);
        return list;
    }
}
