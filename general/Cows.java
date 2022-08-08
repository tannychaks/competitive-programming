package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cows {
    public static void main(String[] args) {
        int N = 7, Q = 4;
        int[][] nums = new int[][] { { 1, -1 }, { 2, 5 }, { 1, -1 }, { 4, 4 } };

        List<List<Integer>> Qry = new ArrayList<>();
        for (int[] arr : nums) {
            Qry.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        }

        System.out.println(queriesSum(N, Q, Qry));
    }

    private static int queriesSum(int N, int Q, List<List<Integer>> Qry) {

        int[] stalls = new int[N];
        int sum = 0;
        for (List<Integer> query : Qry) {
            int l = query.get(0);
            int r = query.get(1);

            if (r == -1) {

                boolean sell = false;
                for (int i = 0; i < stalls.length; i++)
                    if (stalls[i] == l) {
                        // Sell
                        stalls[i] = 0;
                        sell = true;
                        break;
                    }

                if (sell) {
                    continue;
                } else {
                    // Buy
                    int count = 0, maxCount = 0;
                    int start = 0, end = stalls.length - 1, tempStart = 0, tempEnd = 0;
                    boolean flag = true;
                    for (int i = 0; i < stalls.length; i++) {
                        if (stalls[i] == 0) {
                            count++;
                            if (maxCount <= count && !flag) {
                                maxCount = count;
                                tempStart = i;
                                tempEnd = i + 1;
                            }
                            flag = true;
                            start = tempStart;
                            end = tempEnd++;
                        } else {

                            count = 0;
                            flag = false;
                        }
                        if (maxCount <= count) {
                            maxCount = count;
                        }
                    }
                    end = start + (maxCount - 1);
                    int mid = start + ((end - start) >>> 1);
                    if ((start + end) % 2 != 0)
                        mid = mid + 1;

                    if (stalls[mid] == 0)
                        stalls[mid] = l;
                    else
                        continue;
                }

            } else {
                for (int i = l - 1; i <= r - 1; i++)
                    if (stalls[i] != 0)
                        sum++;
            }
        }
        return sum;
    }

}
