package striverSDEsheet.day8;

import java.util.Arrays;

public class MinimumPlatforms {
    public static void main(String[] args) {
        int[] arr = new int[] { 900, 940, 950, 1100, 1500, 1800 };
        int[] dep = new int[] { 910, 1200, 1120, 1130, 1900, 2000 };
        int n = 6;

        int ans = findPlatform(arr, dep, n);

        System.out.println(ans);

        int res = findPlatformOptimal(arr, dep, n);

        System.out.println(res);
    }

    private static int findPlatformOptimal(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platNeeded = 1, res = 1, i = 1, j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platNeeded++;
                i++;
            } else if (arr[i] > dep[j]) {
                platNeeded--;
                j++;
            }

            if (platNeeded > res)
                res = platNeeded;
        }

        return res;
    }

    private static int findPlatform(int[] arr, int[] dep, int n) {

        int ans = 1;

        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if ((arr[i] >= arr[j] && arr[i] <= dep[j]) ||
                        (arr[j] >= arr[i] && arr[j] <= dep[i]))
                    count++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
