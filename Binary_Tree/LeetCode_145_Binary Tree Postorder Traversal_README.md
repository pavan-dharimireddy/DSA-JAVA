# 145. Binary Tree Postorder Traversal

## Problem Statement

Given the `root` of a binary tree, return the postorder traversal of its nodes' values.

In a **postorder traversal**, the nodes are visited in the following order:
1. Traverse the **Left** Subtree
2. Traverse the **Right** Subtree
3. Visit the **Root** Node

## Examples

### Example 1
**Input:** `root = [1,null,2,3]`  
**Output:** `[3,2,1]`  

### Example 2
**Input:** `root = []`  
**Output:** `[]`  

### Example 3
**Input:** `root = [1]`  
**Output:** `[1]`  

## Approaches

### Approach 1: Recursive Traversal
The recursive approach is straightforward. We define a helper function that recursively calls itself for the left child, then the right child, and finally processes the current node by appending its value to the result list.

- **Time Complexity:** `O(N)` — Each node is visited exactly once and processed in constant time.
- **Space Complexity:** `O(H)` — Where `H` is the height of the tree. This accounts for the space used by the recursion call stack. 
  - **Worst case (skewed tree):** `O(N)`
  - **Best case (balanced tree):** `O(log N)`
  - *(Note: the resulting list takes `O(N)` space to store the traversal sequence).*

### Approach 2: Iterative Traversal (Using Two Stacks)
The iterative approach can be implemented using two stacks to simulate the postorder traversal without using the system's recursive call stack.
1. Push the root node to the first stack (`s1`).
2. While `s1` is not empty, pop a node, push it to the second stack (`s2`), and then push its left and right children (if any) to `s1`.
3. The nodes in `s2` will now be in the correct postorder sequence (Left -> Right -> Root) when popped.
4. Pop all nodes from `s2` and add their values to the result list.

- **Time Complexity:** `O(N)` — Every node is pushed and popped exactly once from both stacks.
- **Space Complexity:** `O(2N)` — We use two stacks to store the nodes, which could theoretically hold all nodes in the worst case, simplifying to `O(N)`. 

## Solution (Java)

```java
import java.util.*;

/*
// Approach 1: Recursive 
class Solution {
    List<Integer> l = new ArrayList<>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
        // Base case: if the current node is null, return the list as-is.
        if (root == null) {
            return l;
        }

        // Postorder = Left -> Right -> Root
        postorderTraversal(root.left);   // 1) Traverse left subtree
        postorderTraversal(root.right);  // 2) Traverse right subtree
        l.add(root.val);                 // 3) Visit/process current node (root)

        // Return the accumulated result
        return l;
    }
}
*/

// Approach 2: Iterative (Two Stacks)
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        if(root == null){
            return postOrder;
        }
        Deque<TreeNode> s1 = new LinkedList<>();
        Deque<TreeNode> s2 = new LinkedList<>();
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode node = s1.pop();
            s2.push(node);
            if(node.left != null) s1.push(node.left);
            if(node.right != null) s1.push(node.right);
        }
        while(!s2.isEmpty()){
            postOrder.add((s2.pop().val));
        }
        return postOrder;
    }
}
```
