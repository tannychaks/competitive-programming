package striverSDEsheet.day10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> ans = solveNQueens(n);
        IntStream.range(0, ans.size()).forEach(i -> {
            System.out.println("Arrangement " + (i + 1) + ":");
            ans.get(i).forEach(System.out::println);
            System.out.println();
        });

        List<List<String>> res = solveNQueensOptimized(n);
        IntStream.range(0, ans.size()).forEach(i -> {
            System.out.println("Arrangement " + (i + 1) + ":");
            res.get(i).forEach(System.out::println);
            System.out.println();
        });
    }

    /**
     * Paradigm : Backtracking
     * 
     * TC: O(N^2)
     * SC: O(N^2)
     * 
     * @param n
     * @return
     */
    private static List<List<String>> solveNQueensOptimized(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        int[] leftRow = new int[n];
        int[] upperDiag = new int[2 * n - 1];
        int[] lowerDiag = new int[2 * n - 1];
        solveBackTrack(0, board, ans, n, leftRow, upperDiag, lowerDiag);
        return ans;
    }

    private static void solveBackTrack(int col, char[][] board, List<List<String>> ans, int n, int[] leftRow,
            int[] upperDiag, int[] lowerDiag) {

        if (col == n) {
            ans.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && upperDiag[n - 1 + col - row] == 0 && lowerDiag[row + col] == 0) {

                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiag[row + col] = 1;
                upperDiag[n - 1 + col - row] = 1;

                solveBackTrack(col + 1, board, ans, n, leftRow, upperDiag, lowerDiag);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiag[row + col] = 0;
                upperDiag[n - 1 + col - row] = 0;

            }
        }
    }

    /**
     * Paradigm : Recursion
     * 
     * TC: O(N^3)
     * SC: O(N^2)
     * 
     * @param n
     * @return
     */
    private static List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        solve(0, board, ans, n);
        return ans;
    }

    private static void solve(int col, char[][] board, List<List<String>> ans, int n) {
        if (col == n) {
            ans.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col + 1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }

    private static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    private static boolean isSafe(int row, int col, char[][] board, int n) {

        int dupRow = row;
        int dupCol = col;

        // Upper left diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;

        // left Row

        while (col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            col--;
        }

        row = dupRow;
        col = dupCol;

        // Lower left diagonal

        while (row < board.length && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row++;
            col--;
        }

        return true;
    }

}
