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
 Time Complexity: O(N2), where N is the number of nodes in the binary tree. For each node, we calculate the height of its left and right subtrees, and height calculation takes O(N) in the worst case, leading to an overall O(N × N) = O(N²).

Space Complexity: O(H), where H is the height of the tree. This space is used by the recursive call stack of the getHeight function. In the worst case (skewed tree), H = N, and in the best case (balanced tree), H = log N. No additional data structures are used, so auxiliary space remains constant.


class Solution {
    // Function to check if a binary tree is balanced
    public boolean isBalanced(TreeNode root) {
        // If the tree is empty, it's balanced
        if (root == null) {
            return true;
        }

        // Calculate the height of left and right subtrees
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // Check if the absolute difference in heights of left and right subtrees is <= 1
        if (Math.abs(leftHeight - rightHeight) <= 1 &&
            isBalanced(root.left) &&  // Recursively check the left subtree
            isBalanced(root.right)) { // Recursively check the right subtree
            return true;
        }

        // If any condition fails, the tree is unbalanced
        return false;
    }

    // Function to calculate the height of a subtree
    public int getHeight(TreeNode root) {
        // Base case: if the current node is NULL, return 0 (height of an empty tree)
        if (root == null) {
            return 0;
        }

        // Return the maximum height of left and right subtrees plus 1 (for the current node)
        return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
    }
}
*/

/*
T.C --- O(N)
S.C --- O(H)
*/

class Solution {
    // Function to check if a binary tree is balanced
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    public int dfsHeight(TreeNode root){
        if(root == null) return 0;
        int leftHeight = dfsHeight(root.left);
        if(leftHeight == -1) return -1;
        int rightHeight = dfsHeight(root.right);
        if(rightHeight == -1) return -1;

        if(Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight,rightHeight) + 1;
    }
}