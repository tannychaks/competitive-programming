package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoDListToArray {
    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> temp1 = Arrays.asList(10, 20, 30);
        List<Integer> temp2 = Arrays.asList(50, 60, 70);
        List<Integer> temp3 = Arrays.asList(100, 150, 200);

        input.add(temp1);
        input.add(temp2);
        input.add(temp3);

        int n = input.size();

        input.stream().forEach(list -> {
            list.stream().forEach(val -> {
                System.out.print(val + " ");
            });
            System.out.println();
        });

        System.out.println("N = " + n);

        int[][] m = input.stream().map(list -> list.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

        for (int i[] : m) {
            for (int val : i) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
