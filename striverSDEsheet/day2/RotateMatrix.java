package striverSDEsheet.day2;

public class RotateMatrix {
    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotate(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Step1: Transpose of the matrix. (transposing means changing columns to rows
     * and rows to columns)
     * 
     * Step2: Reverse each row of the matrix.
     * 
     * @param arr
     */
    private static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                matrix[i][j] += matrix[j][i] - (matrix[j][i] = matrix[i][j]);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                matrix[i][j] += matrix[i][matrix.length - 1 - j] - (matrix[i][matrix.length - 1 - j] = matrix[i][j]);
            }
        }
    }
}
