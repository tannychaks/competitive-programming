package leetCode.array;

import java.util.Arrays;

/**
 * 
 * 566. Reshape the Matrix
 * 
 * https://leetcode.com/problems/reshape-the-matrix/
 */
public class ReshapeMatrix {
    public static void main(String[] args) {
        int[][] mat = new int[][] { { 1, 2 }, { 3, 4 } };
        int r = 1, c = 4;
        printArray(matrixReshape(mat, r, c));
    }

    private static void printArray(int[][] mat) {
        System.out.println(Arrays.deepToString(mat));
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {

        int rows = mat.length;
        int cols = mat[0].length;

        if ((rows * cols) != (r * c))
            return mat;

        int[][] ans = new int[r][c];

        int row_num = 0, col_num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans[row_num][col_num] = mat[i][j];

                col_num++;
                if (col_num == c) {
                    col_num = 0;
                    row_num++;
                }
            }
        }
        return ans;
    }
}
