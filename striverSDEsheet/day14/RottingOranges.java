package striverSDEsheet.day14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        int ans = orangesRotting(grid);
        System.out.println(ans);
        ans = orangesRottingOptimized(grid);
        System.out.println(ans);
    }

    private static int orangesRottingOptimized(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int count = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    list.add(new int[] { i, j });
                }
            }
        }

        count = bfs(grid, list);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }

    private static int bfs(int[][] grid, List<int[]> list) {
        if (list.isEmpty()) {
            return 0;
        }

        List<int[]> nextList = new ArrayList<>();

        for (int[] arr : list) {
            int i = arr[0];
            int j = arr[1];
            addIfCan(nextList, grid, i + 1, j);
            addIfCan(nextList, grid, i - 1, j);
            addIfCan(nextList, grid, i, j + 1);
            addIfCan(nextList, grid, i, j - 1);
        }
        int count = nextList.isEmpty() ? 0 : 1;
        return count + bfs(grid, nextList);
    }

    private static void addIfCan(List<int[]> list, int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 1) {
            grid[i][j] = 2;
            list.add(new int[] { i, j });
        }
    }

    private static int orangesRotting(int[][] grid) {

        int rows = grid.length, cols = grid[0].length;
        int countFresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2)
                    q.offer(new int[] { i, j });
                if (grid[i][j] != 0)
                    countFresh++;
            }
        }

        if (countFresh == 0)
            return 0;
        int countMinutes = 0, count = 0;
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        // bfs
        while (!q.isEmpty()) {
            int size = q.size();
            count += size;

            for (int i = 0; i < size; i++) {
                int[] point = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 2 || grid[x][y] == 0)
                        continue;
                    grid[x][y] = 2;
                    q.offer(new int[] { x, y });
                }
            }

            if (q.size() != 0)
                countMinutes++;
        }
        return countFresh == count ? countMinutes : -1;
    }
}
