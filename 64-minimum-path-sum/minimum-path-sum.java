import java.util.*;

class Solution {
    int dp[][];

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return solve(0, 0, grid);
    }

    int solve(int i, int j, int[][] grid) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != -1) return dp[i][j];

        int minNext = Math.min(solve(i, j + 1, grid), solve(i + 1, j, grid));
        dp[i][j] = minNext + grid[i][j];
        return dp[i][j];
    }
}
