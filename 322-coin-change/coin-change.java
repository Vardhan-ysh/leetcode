import java.util.*;

class Solution {
    int min = Integer.MAX_VALUE;
    int[] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        solve(coins, amount, 0);

        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    private void solve(int[] coins, int amount, int count) {
        if (amount < 0) return;
        if (amount == 0) {
            min = Math.min(min, count);
            return;
        }
        if (dp[amount] != -1 && dp[amount] <= count) return;

        dp[amount] = count;

        for (int coin : coins) {
            solve(coins, amount - coin, count + 1);
        }
    }
}
