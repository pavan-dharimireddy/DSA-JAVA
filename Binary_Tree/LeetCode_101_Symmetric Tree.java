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
 /*
 Time Complexity : O(N)
 Space Complexity : O(H) (≈ O(N) worst)
    Depends on recursion stack.
    Worst case (skewed tree): height = N → O(N)
    Best case (balanced tree): height = log N → O(log N)
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelp(root.left,root.right);
    }
    public boolean isSymmetricHelp(TreeNode root1, TreeNode root2){

        if(root1 == null || root2 == null){ // If one subtree is null, the other
                                            // must also be null for symmetry
            return (root1==root2);
        }
        // Check if the data in the current nodes is equal
        // and recursively check for symmetry in subtrees
        return (root1.val == root2.val) && isSymmetricHelp(root1.left,root2.right) && isSymmetricHelp(root1.right,root2.left);
    }
}