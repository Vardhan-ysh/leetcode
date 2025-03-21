class Solution {
    public int maximalSquare(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] matrix = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == '1') matrix[i][j] = 1;
            }
        }

        int ans = 0;

        int[][] squares = new int[m][n];

        for(int i = 0; i < m; i++) {
            squares[i][0] = matrix[i][0];
        }
        for(int j = 0; j < n; j++) {
            squares[0][j] = matrix[0][j];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 1) {
                    squares[i][j] = Math.min(Math.min(squares[i - 1][j], squares[i][j - 1]), squares[i - 1][j - 1]) + 1;
                    // ans = Math.max(ans, squares[i][j]);
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans = Math.max(ans, squares[i][j]);
            }
        }

        return ans * ans;
    }
}