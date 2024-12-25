class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Pair> q = new LinkedList<>();
        int r = image.length;
        int c = image[0].length;
        boolean[][] visited = new boolean[r][c];
        int original = image[sr][sc];

        q.add(new Pair(sr, sc));

        while(!q.isEmpty()) {
            Pair p = q.poll();
            visited[p.a][p.b] = true;
            image[p.a][p.b] = color;

            boolean up = !(p.a == 0);
            boolean down = !(p.a == (r - 1));
            boolean left = !(p.b == 0);
            boolean right = !(p.b == (c - 1));

            if(up && !visited[p.a - 1][p.b] && image[p.a - 1][p.b] == original) {
                q.offer(new Pair(p.a - 1, p.b));
            }
            if(down && !visited[p.a + 1][p.b] && image[p.a + 1][p.b] == original) {
                q.offer(new Pair(p.a + 1, p.b));
            }
            if(left && !visited[p.a][p.b - 1] && image[p.a][p.b - 1] == original) {
                q.offer(new Pair(p.a, p.b - 1));
            }
            if(right && !visited[p.a][p.b + 1] && image[p.a][p.b + 1] == original) {
                q.offer(new Pair(p.a, p.b + 1));
            }
        }
        return image;
    }
}

class Pair {
    int a; 
    int b;
    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}