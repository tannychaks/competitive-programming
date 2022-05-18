package striverSDEsheet.day8;

import java.util.Arrays;

public class JobSequencing {
    static class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    public static void main(String[] args) {
        Job[] arr = new Job[] { new Job(1, 4, 20), new Job(2, 1, 10), new Job(3, 1, 40), new Job(4, 1, 30) };
        int n = 4;

        System.out.println(Arrays.toString(jobScheduling(arr, n)));
    }

    private static int[] jobScheduling(Job[] arr, int n) {

        Arrays.sort(arr, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxDeadline)
                maxDeadline = arr[i].deadline;
        }

        int[] res = new int[maxDeadline + 1];
        Arrays.fill(res, -1);

        int countJobs = 0, maxProfit = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {

                if (res[j] == -1) {
                    res[j] = i;
                    countJobs++;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }
        return new int[] { countJobs, maxProfit };
    }
}
