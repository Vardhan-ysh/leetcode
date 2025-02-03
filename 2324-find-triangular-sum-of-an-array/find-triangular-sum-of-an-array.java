class Solution {
    int[] arr;
    public int triangularSum(int[] nums) {
        arr = nums;
        int n = nums.length;
        return solve(n);
    }

    private int solve(int n) {
        if(n == 1) {
            return arr[0];
        }
        int[] temp = new int[n - 1];
        int j = 0;

        for(int i = 0; i < n - 1; i++) {
            temp[j] = (arr[i] + arr[i + 1]) % 10;
            j++;
        }
        arr = temp;
        
        return solve(n - 1);
    }
}