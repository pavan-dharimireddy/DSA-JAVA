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
 Time Complexity: O(N)
Space Complexity: O(H),H = height of the tree
Balanced tree --> H = log N
Skewed tree --> H = N
*/
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            return (p==q);
        }
        return (p.val == q.val) && isSameTree(p.left,q.left) &&  isSameTree(p.right,q.right);
    }
}