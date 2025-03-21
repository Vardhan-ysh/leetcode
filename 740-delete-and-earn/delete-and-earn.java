class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int freq[] = new int[max + 1];
        for (int num : nums) {
            ++freq[num];
        }
        int dp[] = new int[max + 1];
        dp[1] = freq[1];
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 2] + i * freq[i], dp[i - 1]);

        }
        return dp[max];

    }
}