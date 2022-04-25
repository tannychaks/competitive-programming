package striverSDEsheet.day3;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class Search2DMatrix {
    public static void main(String[] args) {
        int target = 3;
        int[][] mat = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        System.out.println(searchMatrix(mat, target));
    }

    private static boolean searchMatrix(int[][] mat, int target) {
        int row = mat.length, col = mat[0].length;
        int start = 0, end = (row * col - 1);
        while (start <= end) {
            int mid = (start + end) / 2;
            int midVal = mat[mid / col][mid % col];
            if (midVal == target)
                return true;
            else if (midVal > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }
}
