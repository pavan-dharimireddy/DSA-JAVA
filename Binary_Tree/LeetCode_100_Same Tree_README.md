# 100. Same Tree

## Problem Statement

Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

## Examples

### Example 1
**Input:** `p = [1,2,3]`, `q = [1,2,3]`  
**Output:** `true`  

### Example 2
**Input:** `p = [1,2]`, `q = [1,null,2]`  
**Output:** `false`  

### Example 3
**Input:** `p = [1,2,1]`, `q = [1,1,2]`  
**Output:** `false`  

## Constraints

- The number of nodes in both trees is in the range `[0, 100]`.
- `-10^4 <= Node.val <= 10^4`

## Approach: Depth-First Search (Recursion)

The most straightforward way to solve this problem is using recursion (Depth-First Search). We can simultaneously traverse both trees and compare the nodes at each step.

1. **Base Cases:**
   - If both `p` and `q` are `null`, it means we've reached the end of the branches identically, so they match (return `true`).
   - If one of them is `null` while the other is not, the trees are structurally different (return `false`). This is handled elegantly by `return (p == q)` when either is `null`.
2. **Recursive Step:**
   - Check if the current node values are equal (`p.val == q.val`).
   - Recursively check if the left subtrees are identical.
   - Recursively check if the right subtrees are identical.
   - The trees are the same only if all three conditions are met.

## Complexity Analysis

- **Time Complexity:** `O(N)` — Where `N` is the number of nodes in the tree. In the worst-case scenario, we have to visit every single node in both trees to confirm they are identical.
- **Space Complexity:** `O(H)` — Where `H` is the height of the tree. This accounts for the space used by the recursive call stack.
  - In the worst case (a completely skewed tree), the height `H = N`, resulting in `O(N)` space.
  - In the best/average case (a perfectly balanced tree), the height `H = log(N)`, resulting in `O(log N)` space.

## Solution (Java)

```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If either node is null, check if both are null
        if(p == null || q == null){
            return (p == q);
        }
        
        // Check if current values match and recurse for left and right subtrees
        return (p.val == q.val) 
            && isSameTree(p.left, q.left) 
            && isSameTree(p.right, q.right);
    }
}
```
