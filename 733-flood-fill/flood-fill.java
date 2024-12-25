class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r = image.length;
        int c = image[0].length;
        int originalColor = image[sr][sc];

        if (originalColor == color) return image;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];

            image[row][col] = color;

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < r && newCol >= 0 && newCol < c && image[newRow][newCol] == originalColor) {
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
        return image;
    }
}