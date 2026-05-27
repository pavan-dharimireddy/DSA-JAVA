# 110. Balanced Binary Tree

## Problem Statement

Given a binary tree, determine if it is **height-balanced**.

A height-balanced binary tree is defined as:
> A binary tree in which the left and right subtrees of *every* node differ in height by no more than `1`.

## Approaches

### Approach 1: Brute Force (Top-Down)
In this approach, we calculate the height of the left and right subtrees for every single node using a separate `getHeight` function. We then check if the absolute difference between these heights is `<= 1`. This check is performed recursively for all nodes in the tree.
- **Time Complexity:** `O(N^2)` — In the worst-case scenario (e.g., a skewed tree), calculating the height for each node takes `O(N)` time. Doing this for `N` nodes leads to quadratic time complexity `O(N * N)`.
- **Space Complexity:** `O(H)` — Where `H` is the height of the tree. This accounts for the space used by the recursive call stack.

### Approach 2: Optimal DFS (Bottom-Up)
Instead of calculating the height repeatedly, we can compute the height and check for balance simultaneously in a single bottom-up DFS (Depth First Search) pass. 
- We create a modified height function `dfsHeight`.
- If a subtree is found to be unbalanced (i.e., the difference between left and right heights is strictly greater than `1`), we return `-1`.
- If `dfsHeight` receives `-1` from any child recursive call, it immediately propagates the `-1` upwards, effectively short-circuiting unnecessary calculations.
- Ultimately, if the root call returns `-1`, the tree is unbalanced. Otherwise, it is balanced.

- **Time Complexity:** `O(N)` — Every node in the tree is visited exactly once.
- **Space Complexity:** `O(H)` — Auxiliary space for the recursion stack, where `H` is the height of the tree. In the worst case (skewed tree) `H = N`, and in the best case (perfectly balanced tree) `H = log(N)`.

## Optimal Solution (Java)

```java
class Solution {
    // Function to check if a binary tree is balanced
    public boolean isBalanced(TreeNode root) {
        // If dfsHeight returns -1, it means the tree is not balanced
        return dfsHeight(root) != -1;
    }

    public int dfsHeight(TreeNode root){
        // Base case: an empty tree has a height of 0
        if(root == null) return 0;
        
        int leftHeight = dfsHeight(root.left);
        if(leftHeight == -1) return -1; // Propagate imbalance up
        
        int rightHeight = dfsHeight(root.right);
        if(rightHeight == -1) return -1; // Propagate imbalance up

        // If current node is unbalanced, return -1
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;

        // Return height of the current subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
```
