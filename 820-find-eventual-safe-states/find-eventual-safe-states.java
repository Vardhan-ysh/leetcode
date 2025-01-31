class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> terminals = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                terminals.add(i);
                ans.add(i);
            }
        }
        
        boolean newAdded = true;
        while (newAdded) {
            newAdded = false;
            List<Integer> newSafeNodes = new ArrayList<>();
            
            for (int i = 0; i < graph.length; i++) {
                if (terminals.contains(i)) continue;
                
                boolean check = true;
                for (int vertex : graph[i]) {
                    if (!terminals.contains(vertex)) {
                        check = false;
                        break;
                    }
                }
                
                if (check) {
                    newSafeNodes.add(i);
                    newAdded = true;
                }
            }
            
            ans.addAll(newSafeNodes);
            terminals.addAll(newSafeNodes);
        }
        
        Collections.sort(ans);
        return ans;
    }
}
