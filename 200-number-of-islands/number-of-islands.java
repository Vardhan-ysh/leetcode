class Solution {
    public int numIslands(char[][] grid) {
        int l = grid.length;
        int b = grid[0].length;

        int[][] visited = new int[l][b];
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;

        for(int i = 0; i < l; i++) {
            for(int j = 0; j < b; j++) {
                if(visited[i][j] == 1 || grid[i][j] == '0') {
                    visited[i][j] = 1;
                    continue;
                }

                Pair curr = new Pair(i, j);
                q.add(curr);
                visited[i][j] = 1;
                ans++;

                while(!q.isEmpty()) {
                    Pair p = q.poll();

                    boolean up = true;
                    boolean down = true;
                    boolean left = true;
                    boolean right = true;

                    if(p.p1 == 0) up = false;
                    if(p.p1 == l-1) down = false;
                    if(p.p2 == 0) left = false;
                    if(p.p2 == b-1) right = false;

                    if(up && visited[p.p1 - 1][p.p2] == 0 && grid[p.p1 - 1][p.p2] == '1') {
                        visited[p.p1 - 1][p.p2] = 1;
                        Pair c = new Pair(p.p1 - 1, p.p2);
                        q.offer(c);
                    }
                    if(down && visited[p.p1 + 1][p.p2] == 0 && grid[p.p1 + 1][p.p2] == '1') {
                        visited[p.p1 + 1][p.p2] = 1;
                        Pair c = new Pair(p.p1 + 1, p.p2);
                        q.offer(c);
                    }
                    if(left && visited[p.p1][p.p2 - 1] == 0 && grid[p.p1][p.p2 - 1] == '1') {
                        visited[p.p1][p.p2 - 1] = 1;
                        Pair c = new Pair(p.p1, p.p2 - 1);
                        q.offer(c);
                    }
                    if(right && visited[p.p1][p.p2 + 1] == 0 && grid[p.p1][p.p2 + 1] == '1') {
                        visited[p.p1][p.p2 + 1] = 1;
                        Pair c = new Pair(p.p1, p.p2 + 1);
                        q.offer(c);
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