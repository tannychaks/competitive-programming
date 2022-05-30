package striverSDEsheet.day11;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] positions = new int[] { 1, 2, 3, 4, 6 };
        int n = 5, c = 3;
        int focus = maxDist(positions, n, c);
        System.out.println(focus);
    }

    private static int maxDist(int[] positions, int n, int c) {
        int res = -1;
        Arrays.sort(positions);
        int low = 1, high = positions[n - 1] - positions[0];
        while (low <= high) {
            int mid = low + ((high - low) >>> 1);

            if (canPlaceCows(positions, mid, c)) {
                res = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return res;
    }

    private static boolean canPlaceCows(int[] positions, int minDist, int cows) {
        int cnt = 1;
        int lastPlacedCow = positions[0];
        for (int pos : positions) {
            if (pos - lastPlacedCow >= minDist) {

                cnt++;
                lastPlacedCow = pos;
            }
        }
        if (cnt >= cows)
            return true;
        return false;
    }
}
