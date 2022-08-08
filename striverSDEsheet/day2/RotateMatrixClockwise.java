package striverSDEsheet.day2;

import java.util.ArrayList;

public class RotateMatrixClockwise {
    public static void main(String[] args) {
        int[][] nums = new int[][] { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int n = 4, m = 4;
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> sub = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                sub.add(nums[i][j]);
            }
            matrix.add(sub);
        }

        rotateMatrix(matrix, n, m);

        matrix.stream().forEach(list -> {
            list.stream().forEach(val -> System.out.print(val + " "));
            System.out.println();
        });

    }

    private static void rotateMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {

        int[][] mat = matrix.stream().map(list -> list.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

        m += n - (n = m);
        int row = 0, col = 0;
        int prev, curr;

        int rows = m, cols = n;
        /*
         * row - Starting row index
         * m - ending row index
         * col - starting column index
         * n - ending column index
         * i - iterator
         */
        while (row < m && col < n) {

            if (row + 1 == m || col + 1 == n)
                break;

            // Store the first element of next
            // row, this element will replace
            // first element of current row
            prev = mat[row + 1][col];

            // Move elements of first row
            // from the remaining rows
            for (int i = col; i < n; i++) {
                curr = mat[row][i];
                mat[row][i] = prev;
                prev = curr;
            }
            row++;

            // Move elements of last column
            // from the remaining columns
            for (int i = row; i < m; i++) {
                curr = mat[i][n - 1];
                mat[i][n - 1] = prev;
                prev = curr;
            }
            n--;

            // Move elements of last row
            // from the remaining rows
            if (row < m) {
                for (int i = n - 1; i >= col; i--) {
                    curr = mat[m - 1][i];
                    mat[m - 1][i] = prev;
                    prev = curr;
                }
            }
            m--;

            // Move elements of first column
            // from the remaining rows
            if (col < n) {
                for (int i = m - 1; i >= row; i--) {
                    curr = mat[i][col];
                    mat[i][col] = prev;
                    prev = curr;
                }
            }
            col++;
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                temp.add(mat[i][j]);
            }
            list.add(temp);
        }
        matrix.removeAll(matrix);
        matrix.addAll(list);
    }
}
