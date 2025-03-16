import java.util.*;

class Solution {
    HashMap<Integer, List<Integer>> map;
    int[][] dp;
    final int MOD = 1_000_000_007;

    public Solution() {
        map = new HashMap<>();
        map.put(0, new ArrayList<>(Arrays.asList(4, 6)));
        map.put(1, new ArrayList<>(Arrays.asList(8, 6)));
        map.put(2, new ArrayList<>(Arrays.asList(9, 7)));
        map.put(3, new ArrayList<>(Arrays.asList(4, 8)));
        map.put(4, new ArrayList<>(Arrays.asList(9, 3, 0)));
        map.put(5, new ArrayList<>());
        map.put(6, new ArrayList<>(Arrays.asList(1, 7, 0)));
        map.put(7, new ArrayList<>(Arrays.asList(2, 6)));
        map.put(8, new ArrayList<>(Arrays.asList(1, 3)));
        map.put(9, new ArrayList<>(Arrays.asList(2, 4)));
    }

    public int knightDialer(int n) {
        int ans = 0;
        dp = new int[n][10];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i <= 9; i++) {
            ans = (ans + solve(i, n - 1)) % MOD;
        }
        return ans;
    }

    private int solve(int start, int remaining) {
        if (remaining == 0) return 1;
        if (dp[remaining][start] != -1) return dp[remaining][start];

        List<Integer> next = map.get(start);
        int ret = 0;

        for (int i : next) {
            ret = (ret + solve(i, remaining - 1)) % MOD;
        }

        dp[remaining][start] = ret;
        return ret;
    }
}
