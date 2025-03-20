class NumMatrix {
    int [][] prefix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // hum log prefix sum calculate kar rahe hain.
        // explanation neetcode se dekha ==> https://www.youtube.com/watch?v=KE8MQuwE2yA
        // used 2d prefix sum for range questions.

        prefix = new int[m + 1][n + 1];

        for(int i = 0; i < m; i++) {
            int prefixForRow = 0;
            for(int j = 0; j < n; j++) {
                prefixForRow += matrix[i][j];

                prefix[i + 1][j + 1] = prefixForRow + prefix[i][j + 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;

        int big = prefix[row2][col2];
        int left = prefix[row2][col1 - 1];
        int top = prefix[row1 - 1][col2];
        int remain = big - (left + top);
        int topRight = prefix[row1 - 1][col1 - 1];

        remain += topRight;

        return remain;

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */