package striverSDEsheet.day4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SubArrayWithGivenXor {
    public static void main(String[] args) {
        int[] arr = new int[] { 4, 2, 2, 6, 4 };
        List<Integer> A = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int B = 6;
        System.out.println(solve(A, B));
    }

    private static int solve(List<Integer> a, int b) {
        int count = 0;
        int xorr = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : a) {
            xorr = xorr ^ num;
            if (freq.get(xorr ^ b) != null)
                count += freq.get(xorr ^ b);
            if (xorr == b)
                count++;
            if (freq.get(xorr) != null)
                freq.put(xorr, freq.get(xorr) + 1);
            else
                freq.put(xorr, 1);
        }

        return count;
    }
}
