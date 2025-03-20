class Solution {
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        int max = 0;

        for(int i = 0; i < nums.length; i++) {
            max = Math.max(solve(i, nums), max);
        }

        return max;
    }

    private int solve(int i, int[] nums) {
        if(i >= nums.length) return 0;

        if(dp[i] != -1) return dp[i];

        int curr = nums[i];
        int max = 1;

        for(int j = i + 1; j < nums.length; j++) {
            if(nums[j] > curr) {
                max = Math.max(max, solve(j, nums) + 1);
            }
        }

        dp[i] = max;
        return max;
    }
}