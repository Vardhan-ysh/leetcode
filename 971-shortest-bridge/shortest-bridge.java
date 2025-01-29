import java.util.*;

class Solution {
    public int shortestBridge(int[][] grid) {
        int[] firstIsland = searchFirstIsland(grid);

        Queue<int[]> queue = new LinkedList<>();
        colorFirstIslandAndFindBorder(grid, firstIsland, queue);

        return bfs(grid, queue);
    }

    static int[] searchFirstIsland(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 2;
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    static void colorFirstIslandAndFindBorder(int[][] grid, int[] firstIsland, Queue<int[]> queue) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int n = grid.length;

        Queue<int[]> q = new LinkedList<>();
        q.add(firstIsland);

        while(!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];

            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 1) {
                    grid[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                }
                else if(nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 0) {
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }

    int bfs(int[][] grid, Queue<int[]> queue) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int n = grid.length;
        int dist = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] p = queue.poll();
                int x = p[0];
                int y = p[1];

                for(int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if(grid[nx][ny] == 0) {
                            grid[nx][ny] = 2;
                            queue.offer(new int[]{nx, ny});
                        } 
                        else if(grid[nx][ny] == 1) {
                            return dist;
                        }
                    }
                }
            }
            dist++;
        }

        return dist;
    }
}
