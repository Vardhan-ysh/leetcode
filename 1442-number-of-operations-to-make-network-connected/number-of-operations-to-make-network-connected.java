class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int disconnected = 0;

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                disconnected++;
                bfs(n, i, visited, graph);
            }
        }

        return disconnected - 1;
    }

    static void bfs(int n, int i, boolean[] visited, List<List<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neighbor : graph.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
    }
}
