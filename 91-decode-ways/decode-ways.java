class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(s, 0);
    }

    int solve(String s, int i) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        
        if (dp[i] != -1) return dp[i];

        int first = solve(s, i + 1);
        int second = 0;
        
        if (i + 1 < s.length() && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
            second = solve(s, i + 2);
        }

        dp[i] = first + second;
        return dp[i];
    }
}
