package striverSDEsheet.day10;

import java.util.HashSet;

/**
 * 
 * 6. Valid Sudoku
 * 
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {

    private static final String B = "B";

    private static final String C = "C";

    private static final String R = "R";

    public static void main(String[] args) {
        char[][] mat = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        System.out.println(isValidSudoku(mat));
    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    String row = board[i][j] + R + i;
                    String col = board[i][j] + C + j;
                    String box = board[i][j] + B + i / 3 + j / 3;
                    if (set.contains(row) || set.contains(col) || set.contains(box))
                        return false;
                    set.add(row);
                    set.add(col);
                    set.add(box);
                }

            }
        }
        return true;
    }

}
