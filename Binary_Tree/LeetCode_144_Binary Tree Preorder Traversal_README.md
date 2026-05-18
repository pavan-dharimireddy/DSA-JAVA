# 144. Binary Tree Preorder Traversal

## Problem Statement

Given the `root` of a binary tree, return _the preorder traversal of its nodes' values_.

Preorder traversal visits nodes in the following order:

1.  **Root**
2.  **Left** Subtree
3.  **Right** Subtree

## Examples

### Example 1

**Input:** `root = [1,null,2,3]`  
**Output:** `[1,2,3]`

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

### Approach 1: Recursive Preorder Traversal

The most natural way to traverse a tree is using recursion. We define a helper function that takes the current node and the result list. If the node is not null, we add its value to the list, recursively call the function for the left child, and then recursively call the function for the right child.

- **Time Complexity:** `O(N)` — We visit each node exactly once.
- **Space Complexity:** `O(N)` in the worst case (for a completely skewed tree) due to the recursion stack. For a balanced tree, the space complexity is `O(log N)`.

### Approach 2: Iterative Preorder Traversal using Stack

We can simulate the recursion stack using an explicit `Stack` data structure.

1. Push the root node onto the stack.
2. While the stack is not empty:
   - Pop the top node and add its value to our result list.
   - Push its **right** child onto the stack (if it exists).
   - Push its **left** child onto the stack (if it exists).

_Note: We push the right child first so that the left child is processed first (LIFO order of stack)._

- **Time Complexity:** `O(N)` — We visit each node exactly once.
- **Space Complexity:** `O(N)` — In the worst case, the stack will contain all the leaf nodes.

## Solution (Java)

```java
/* Recursive Approach */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);          // Root
        traverse(node.left, result);   // Left
        traverse(node.right, result);  // Right
    }
}
```
