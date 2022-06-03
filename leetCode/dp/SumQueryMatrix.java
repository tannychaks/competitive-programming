package leetCode.dp;

public class SumQueryMatrix {
    public static void main(String[] args) {

    }
}

class NumMatrix {
    int[][] dp; // sum prefix

    public NumMatrix(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        populateArray(matrix, dp);
    }

    private void populateArray(int[][] matrix, int[][] dp) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0)
                    dp[i][j] = matrix[i][j];
                else
                    dp[i][j] = matrix[i][j] + dp[i][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row2 > dp.length || col2 > dp[0].length || row1 < 0 || col1 < 0)
            return -1;
        int sum = 0;
        for (int i = row1; i <= row2; i++)
            sum += dp[i][col2] - (col1 > 0 ? dp[i][col1 - 1] : 0);
        return sum;
    }
}