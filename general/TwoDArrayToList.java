package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoDArrayToList {
    public static void main(String[] args) {
        int[][] nums = new int[][] { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
        List<List<Integer>> output = new ArrayList<>();
        for (int[] arr : nums) {
            output.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        }

        output.stream().forEach(list -> {
            list.stream().forEach(val -> {
                System.out.print(val + " ");
            });
            System.out.println();
        });
    }

}
