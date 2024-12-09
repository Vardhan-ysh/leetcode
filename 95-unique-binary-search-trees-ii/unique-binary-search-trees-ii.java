/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        LinkedList<Integer> lst = new LinkedList<>();
        
        return child(1, n);
    }

    public List<TreeNode> child(int left, int right) {
        if(left > right) {
            List<TreeNode> temp = new ArrayList<TreeNode>();
            temp.add(null);
            return temp;
        }

        if(left == right) {
            List<TreeNode> temp = new ArrayList<TreeNode>();
            temp.add(new TreeNode(left));
            return temp;
        }

        List<TreeNode> ans = new ArrayList<>();

        for(int i = left; i <= right; i++) {
            List<TreeNode> leftChild = child(left, i - 1);
            List<TreeNode> rightChild = child(i + 1, right);

            for(TreeNode l : leftChild) {
                for(TreeNode r : rightChild) {
                    TreeNode curr = new TreeNode(i);

                    curr.left = l;
                    curr.right = r;
                    ans.add(curr);
                }
            }
        }

        return ans;
    }
}