# 543. Diameter of Binary Tree

## Problem Statement

Given the `root` of a binary tree, return the length of the **diameter** of the tree.

The **diameter** of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the `root`.

The length of a path between two nodes is represented by the number of edges between them.

## Examples

### Example 1

**Input:** `root = [1,2,3,4,5]`  
**Output:** `3`  
**Explanation:** 3 is the length of the path `[4,2,1,3]` or `[5,2,1,3]`.

### Example 2

**Input:** `root = [1,2]`  
**Output:** `1`

## Constraints

- The number of nodes in the tree is in the range `[1, 10^4]`.
- `-100 <= Node.val <= 100`

## Approaches

### Approach 1: Brute Force (Top-Down)

In this approach, we calculate the diameter passing through the current node (which is `leftHeight + rightHeight`). We then recursively calculate the diameter of the left subtree and the right subtree. The overall diameter is the maximum of these three values.

- **Time Complexity:** `O(N^2)` — In the worst-case scenario (a skewed tree), calculating the height takes `O(N)` time for each node. Doing this for `N` nodes leads to a quadratic time complexity.
- **Space Complexity:** `O(H)` — Auxiliary space for the recursion stack, where `H` is the height of the tree.

### Approach 2: Optimal DFS (Bottom-Up)

To optimize, we can calculate the height and the maximum diameter simultaneously in a single Depth-First Search (DFS) pass.

- We maintain a global or instance variable `ans` initialized to `0`.
- We write a `height` function that returns the height of a given subtree.
- During the height calculation at any given node, the longest path passing through that node is `left_height + right_height`. We update our global `ans` with this value if it's greater than the current `ans`.
- Finally, the function returns the height of the subtree to the parent node.

- **Time Complexity:** `O(N)` — Every node in the tree is visited exactly once.
- **Space Complexity:** `O(H)` — Auxiliary space for the recursion stack, where `H` is the height of the tree. In a balanced tree, `H = O(log N)`. In a skewed tree, `H = O(N)`.

## Optimal Solution (Java)

```java
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
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return ans;
    }

    public int height(TreeNode root){
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);
        ans = Math.max(ans, lh + rh); // Update the maximum diameter

        return 1 + Math.max(lh, rh);  // Return height of current node
    }
}
```
