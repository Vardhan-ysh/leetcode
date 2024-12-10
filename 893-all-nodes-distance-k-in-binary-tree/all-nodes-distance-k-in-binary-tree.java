public class GraphNode {
    int val;
    GraphNode left;
    GraphNode right;
    GraphNode parent;

    GraphNode(int x) {
        val = x;
    }
}

class Solution {
    GraphNode t;

    GraphNode graphifyTree(TreeNode troot, TreeNode target) {
        if (troot == null)
            return null;

        GraphNode groot = new GraphNode(troot.val);

        if (troot == target)
            t = groot;

        groot.left = graphifyTree(troot.left, target);
        if (groot.left != null)
            groot.left.parent = groot;

        groot.right = graphifyTree(troot.right, target);
        if (groot.right != null)
            groot.right.parent = groot;

        return groot;
    }

    public static List<Integer> findNodesAtDistanceK(GraphNode node, int k) {
        if (node == null || k < 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Set<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();

        queue.offer(node);
        visited.add(node);
        int currentDistance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currentDistance == k) {
                for (GraphNode n : queue) {
                    result.add(n.val);
                }
                return result;
            }

            for (int i = 0; i < size; i++) {
                GraphNode current = queue.poll();
                if (current.left != null && !visited.contains(current.left)) {
                    queue.offer(current.left);
                    visited.add(current.left);
                }
                if (current.right != null && !visited.contains(current.right)) {
                    queue.offer(current.right);
                    visited.add(current.right);
                }
                if (current.parent != null && !visited.contains(current.parent)) {
                    queue.offer(current.parent);
                    visited.add(current.parent);
                }
            }
            currentDistance++;
        }
        return result;
    }

    public List<Integer> distanceK(TreeNode troot, TreeNode target, int k) {
        GraphNode groot = graphifyTree(troot, target);
        List<Integer> ans = findNodesAtDistanceK(t, k);

        System.out.println(ans);
        return ans;

    }
}