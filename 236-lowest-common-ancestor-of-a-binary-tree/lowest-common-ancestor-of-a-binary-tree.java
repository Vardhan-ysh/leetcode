/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = root;
        lowest(root, p, q);
        return ans;

    }

    public void lowest(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return;

        if(nodeFound(root.left, p) && nodeFound(root.left, q)) {
            ans = root.left;
            lowest(root.left, p, q);
        }
        else if(nodeFound(root.right, p) && nodeFound(root.right, q)) {
            ans = root.right;
            lowest(root.right, p, q);
        }
        else {
            ans = root;
            return;
        }
    }

    public boolean nodeFound(TreeNode root, TreeNode node) {

        if(root == null) return false;

        boolean isNode = (root == node);
        if(isNode) return true;

        boolean left = nodeFound(root.left, node);
        if(left) return left;

        boolean right = nodeFound(root.right, node);
        if(right) return right;
        

        return false;
    }
}