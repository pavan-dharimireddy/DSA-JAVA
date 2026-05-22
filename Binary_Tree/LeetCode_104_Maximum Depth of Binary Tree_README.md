# 104. Maximum Depth of Binary Tree

## Problem Statement

Given the `root` of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

## Examples

### Example 1

**Input:** `root = [3,9,20,null,null,15,7]`  
**Output:** `3`

### Example 2

**Input:** `root = [1,null,2]`  
**Output:** `2`

## Constraints

- The number of nodes in the tree is in the range `[0, 10^4]`.
- `-100 <= Node.val <= 100`

## Approaches

### Approach: Recursive Depth-First Search (DFS)

This is the most straightforward approach. The maximum depth of a binary tree is `1` plus the maximum depth of its left and right subtrees. We can solve this recursively.

- The base case is when the `root` is `null`, representing a depth of `0`.
- Otherwise, we recursively find the depth of the left and right subtrees and return the maximum of the two, plus `1` for the current node.

## Complexity Analysis

- **Time Complexity:** `O(N)` — We visit every node in the tree exactly once to calculate its depth.
- **Space Complexity:** `O(H)` — The space complexity is determined by the maximum depth of the call stack during recursion, where `H` is the height of the tree.
  - In the worst case (a completely skewed tree), the height is `N`, resulting in an `O(N)` space complexity.
  - In the best/average case (a balanced tree), the height is `log(N)`, resulting in an `O(log N)` space complexity.

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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
```
