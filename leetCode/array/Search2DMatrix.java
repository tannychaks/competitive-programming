package leetCode.array;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * 
 * 74. Search a 2D Matrix
 */
public class Search2DMatrix {
    public static void main(String[] args) {
        int target = 3;
        int[][] mat = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        System.out.println(searchMatrix(mat, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;
        while (end >= start) {
            int mid = (start + end) / 2;
            int midVal = matrix[mid / col][mid % col];
            if (midVal == target)
                return true;
            if (midVal > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }

}
