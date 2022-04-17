package striverSDEsheet.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] arr = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] intervals = mergeIntervals(arr);
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(intervals[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] mergeIntervals(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();

        if (intervals.length == 0 || intervals == null)
            return ans.toArray(new int[0][]);

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] i : intervals) {
            if (i[0] <= end)
                end = Math.max(i[1], end);
            else {
                ans.add(new int[] { start, end });
                start = i[0];
                end = i[1];
            }
        }
        ans.add(new int[] { start, end });
        return ans.toArray(new int[0][]);
    }
}
