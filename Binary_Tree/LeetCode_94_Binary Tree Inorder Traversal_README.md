# 94. Binary Tree Inorder Traversal

## Problem Statement

Given the `root` of a binary tree, return the inorder traversal of its nodes' values.

## Examples

### Example 1
**Input:** `root = [1,null,2,3]`  
**Output:** `[1,3,2]`

### Example 2
**Input:** `root = []`  
**Output:** `[]`

### Example 3
**Input:** `root = [1]`  
**Output:** `[1]`

## Constraints

- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`

## Approaches

### Approach 1: Recursive Inorder Traversal
The recursive approach follows the standard Depth-First Search (DFS) pattern for an inorder traversal (Left -> Root -> Right):
1. Recursively traverse the left subtree.
2. Visit (process) the current root node.
3. Recursively traverse the right subtree.
- **Time Complexity:** `O(N)`, where `N` is the number of nodes in the tree. Each node is visited exactly once.
- **Space Complexity:** `O(H)`, where `H` is the height of the tree, representing the auxiliary recursion stack space. In the worst-case scenario (a skewed tree), the space complexity is `O(N)`. In the best-case (a balanced tree), it is `O(log N)`.

### Approach 2: Iterative Inorder Traversal (Using Stack)
To traverse the tree iteratively without relying on the system's call stack, we can use a Stack (or `Deque`) data structure to simulate the recursion. 
1. Start from the root and continuously push the left child onto the stack until reaching a `null` node.
2. Once a `null` node is reached, pop the top node from the stack and add its value to the result list.
3. Move to the right child of the popped node and repeat the process.
- **Time Complexity:** `O(N)` — Every node is pushed and popped exactly once.
- **Space Complexity:** `O(H)` — The stack will hold at most `H` nodes at any given time, where `H` is the height of the tree. 

## Solution (Java)

```java
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// Iterative Approach
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if (root == null) {
            return l;
        }
        
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                node = stack.pop();
                l.add(node.val);
                node = node.right;
            }
        }
        return l;
    }
}

/*
// Recursive Approach
class Solution {
    List<Integer> l = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return l;
        }

        inorderTraversal(root.left);
        l.add(root.val);
        inorderTraversal(root.right);

        return l;
    }
}
*/
```
