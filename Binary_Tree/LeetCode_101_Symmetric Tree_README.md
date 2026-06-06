# 101. Symmetric Tree

## Problem Statement

Given the `root` of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

## Examples

### Example 1

**Input:** `root = [1,2,2,3,4,4,3]`  
**Output:** `true`

### Example 2

**Input:** `root = [1,2,2,null,3,null,3]`  
**Output:** `false`

## Constraints

- The number of nodes in the tree is in the range `[1, 1000]`.
- `-100 <= Node.val <= 100`

## Approach: Depth-First Search (Recursion)

A tree is symmetric if the left subtree is a mirror reflection of the right subtree. We can solve this recursively by simultaneously traversing the left and right subtrees.

1. **Base Cases:**
   - If both nodes are `null`, it means we've reached the end of the subtrees symmetrically, so they match (return `true`).
   - If one node is `null` and the other is not, the tree is not symmetric (return `false`). This is concisely handled by `return (root1 == root2)`.
2. **Recursive Step:**
   - Check if the current node values are equal (`root1.val == root2.val`).
   - Recursively check if the left subtree of the first tree is a mirror of the right subtree of the second tree (`isSymmetricHelp(root1.left, root2.right)`).
   - Recursively check if the right subtree of the first tree is a mirror of the left subtree of the second tree (`isSymmetricHelp(root1.right, root2.left)`).
   - The tree is symmetric only if all three conditions hold true.

## Complexity Analysis

- **Time Complexity:** `O(N)` — Where `N` is the number of nodes in the tree. We traverse the entire tree exactly once to check for symmetry.
- **Space Complexity:** `O(H)` — Where `H` is the height of the tree, representing the space used by the recursive call stack.
  - In the worst case (a completely skewed tree), the height `H = N`, resulting in `O(N)` space.
  - In the best/average case (a perfectly balanced tree), the height `H = log(N)`, resulting in `O(log N)` space.

## Solution (Java)

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    public boolean isSymmetricHelp(TreeNode root1, TreeNode root2) {
        // If one subtree is null, the other must also be null for symmetry
        if (root1 == null || root2 == null) {
            return (root1 == root2);
        }

        // Check if the data in the current nodes is equal
        // and recursively check for symmetry in subtrees
        return (root1.val == root2.val)
            && isSymmetricHelp(root1.left, root2.right)
            && isSymmetricHelp(root1.right, root2.left);
    }
}
```
