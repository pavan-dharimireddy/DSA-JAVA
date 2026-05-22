/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

/*
 * Time Complexity: O(N), each node is visited exactly once.
 * Space Complexity: O(H), where H is the height of the tree. This accounts for
 * the space used by the recursive call stack.
 * In the worst case (skewed tree), H = N, leading to O(N) space.
 * In the best/average case (balanced tree), H = log(N), leading to O(log N)
 * space.
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}