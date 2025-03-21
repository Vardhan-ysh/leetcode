class Solution {
    int[][] squares;
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        squares = new int[m][n];
        int sum = 0;

        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 1) {
                // sum++;
                squares[i][0] = 1;
            }
        }
        for(int j = 0; j < n; j++) {
            if(matrix[0][j] == 1) {
                // sum++;
                squares[0][j] = 1;
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 1) {
                    squares[i][j] = Math.min(Math.min(squares[i][j - 1], squares[i - 1][j]), squares[i - 1][j - 1]) + 1;
                    // sum += squares[i][j];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += squares[i][j];
            }
        }

        return sum;
    }
}