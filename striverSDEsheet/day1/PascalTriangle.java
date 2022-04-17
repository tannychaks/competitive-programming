package striverSDEsheet.day1;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 118. Pascal's Triangle
 * 
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalTriangle {
    public static void main(String[] args) {
        int numRows = 5;

        printList(generate(numRows));
    }

    private static void printList(List<List<Integer>> generate) {

        generate.stream().forEach(list -> {
            list.stream().forEach(System.out::print);
            System.out.println();
        });
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j)
                    curr.add(1);
                else
                    curr.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
            ans.add(curr);
        }

        return ans;
    }
}
