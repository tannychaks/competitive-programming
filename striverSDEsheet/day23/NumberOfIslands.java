package striverSDEsheet.day23;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][] {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };

        int ans = numIslands(grid);
        System.out.println(ans);

    }

    private static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    callForBFS(i, j, grid);
                }
            }
        }
        return count;
    }

    private static void callForBFS(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        callForBFS(i + 1, j, grid); // up
        callForBFS(i - 1, j, grid); // down
        callForBFS(i, j - 1, grid); // left
        callForBFS(i, j + 1, grid);// right

    }

}
