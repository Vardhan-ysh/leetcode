class Solution {
    int[][] dp;
    int max = 0;

    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 || j == 0) {
                    if(nums1[i] == nums2[j]) {
                        dp[i][j]++;
                        max = Math.max(max, dp[i][j]);
                        continue;
                    }
                }

                if(nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}