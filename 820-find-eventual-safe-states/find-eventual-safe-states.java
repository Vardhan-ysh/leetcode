import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] status = new int[n];
        List<Integer> safeNodes = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (isSafe(i, graph, status)) {
                safeNodes.add(i);
            }
        }
        
        return safeNodes;
    }
    
    private boolean isSafe(int node, int[][] graph, int[] status) {
        if (status[node] != 0) {
            return status[node] == 2;
        }
        
        status[node] = 1;
        for (int neighbor : graph[node]) {
            if (status[neighbor] == 2) continue;
            if (status[neighbor] == 1 || !isSafe(neighbor, graph, status)) {
                return false;
            }
        }
        
        status[node] = 2;
        return true;
    }
}
