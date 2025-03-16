class Solution {
    int dp[][];

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return solve(m - 1, n - 1);
    }

    int solve(int m, int n) {
        if(m == 0) return 1;
        if(n == 0) return 1;

        if(dp[m][n] != -1) return dp[m][n];

        dp[m][n] = solve(m - 1, n) + solve(m, n - 1);
        return dp[m][n];
    }
}