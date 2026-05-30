# 199. Binary Tree Right Side View

## Problem Statement

Given the `root` of a binary tree, imagine yourself standing on the **right side** of it, return the values of the nodes you can see ordered from top to bottom.

## Examples

### Example 1
**Input:** `root = [1,2,3,null,5,null,4]`  
**Output:** `[1,3,4]`

### Example 2
**Input:** `root = [1,null,3]`  
**Output:** `[1,3]`

### Example 3
**Input:** `root = []`  
**Output:** `[]`

## Constraints

- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`

## Approaches

### Approach: Depth-First Search (Reverse PreOrder)

To get the right side view, we can perform a modified Depth-First Search (DFS). Instead of the standard PreOrder traversal (Root -> Left -> Right), we use a **Reverse PreOrder** traversal (Root -> Right -> Left).

- We maintain a result list `res` and track our current depth/level using a `level` variable.
- Whenever we visit a node, we check if `res.size() == level`. If it is, it means this is the *first* node we are visiting at this depth. Because we are traversing the right side first, this first node is guaranteed to be the rightmost node at that level.
- We add the node's value to the result list and recursively call the function on the right child, followed by the left child.

> **Note on Left Side View:** The provided solution also includes a `leftDFS` method, which follows standard PreOrder logic (Root -> Left -> Right). If you wanted to find the Left Side View of the tree, you would swap out `rightDFS` for `leftDFS`.

## Complexity Analysis

- **Time Complexity:** `O(N)` — In the worst case, we may visit every node in the binary tree exactly once. This happens when the tree is completely skewed, or when we must traverse the entire tree to find visible nodes on the left that extend deeper than the right.
- **Space Complexity:** `O(H)` — Auxiliary space for the recursion stack. `H` is the height of the tree. In a balanced tree, `H = O(log N)`. In the worst-case (a skewed tree), `H = O(N)`.

## Solution (Java)

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightDFS(root, 0, res);
        return res;
    }

    public void rightDFS(TreeNode root, int level, List<Integer> res) {
        if (root == null) {  // Base case
            return;
        }
        
        if (res.size() == level) { // If we're visiting this level the first time
            res.add(root.val);
        }
        rightDFS(root.right, level + 1, res); // Recurse right
        rightDFS(root.left, level + 1, res);  // Recurse left
    }

    // Helper method for Left Side View (for reference)
    public void leftDFS(TreeNode root, int level, List<Integer> res) {
        if (root == null) { // Base case
            return;
        }
        
        if (res.size() == level) { // If we're visiting this level the first time
            res.add(root.val);
        }
        leftDFS(root.left, level + 1, res);  // Recurse left
        leftDFS(root.right, level + 1, res); // Recurse right
    }
}
```
