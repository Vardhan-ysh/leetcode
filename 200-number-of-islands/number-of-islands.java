class Solution {
    public int numIslands(char[][] grid) {
        int l = grid.length;
        int b = grid[0].length;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int[][] visited = new int[l][b];
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        
        for(int i = 0; i < l; i++) {
            for(int j = 0; j < b; j++) {
                if(visited[i][j] == 1 || grid[i][j] == '0') {
                    continue;
                }
                
                q.add(new Pair(i, j));
                visited[i][j] = 1;
                ans++;
                
                while(!q.isEmpty()) {
                    Pair p = q.poll();
                    
                    for(int dir = 0; dir < 4; dir++) {
                        int newX = p.p1 + dx[dir];
                        int newY = p.p2 + dy[dir];
                        
                        if(newX >= 0 && newX < l && newY >= 0 && newY < b 
                           && visited[newX][newY] == 0 && grid[newX][newY] == '1') {
                            visited[newX][newY] = 1;
                            q.offer(new Pair(newX, newY));
                        }
                    }
                }
            }
        }
        return ans;
    }
}

public class Pair {
    int p1;
    int p2;

    Pair(int p1, int p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}