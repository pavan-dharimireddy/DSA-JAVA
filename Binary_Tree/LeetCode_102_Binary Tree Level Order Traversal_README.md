# 102. Binary Tree Level Order Traversal

## Problem Statement

Given the `root` of a binary tree, return the *level order traversal* of its nodes' values. (i.e., from left to right, level by level).

## Examples

### Example 1
**Input:** `root = [3,9,20,null,null,15,7]`  
**Output:** `[[3],[9,20],[15,7]]`  

### Example 2
**Input:** `root = [1]`  
**Output:** `[[1]]`  

### Example 3
**Input:** `root = []`  
**Output:** `[]`  

## Constraints

- The number of nodes in the tree is in the range `[0, 2000]`.
- `-1000 <= Node.val <= 1000`

## Approach: Breadth-First Search (BFS)

To perform a level order traversal, we can use a **Queue** data structure to implement a Breadth-First Search (BFS). 

1. **Initialization:** Start by checking if the root is null. If it is, return an empty list. Otherwise, initialize a queue and add the root to it.
2. **Level Traversal:** Use a `while` loop that continues as long as the queue is not empty. Inside the loop, determine the number of nodes at the current level by checking the queue's size (`qsize`).
3. **Process Nodes:** Iterate exactly `qsize` times. In each iteration, dequeue a node, add its value to a temporary `level` list, and enqueue its left and right children (if they exist) for the next level's processing.
4. **Result Gathering:** Once the inner loop completes, an entire level has been processed. Add the `level` list to the final result list and proceed to the next iteration.

## Complexity Analysis

- **Time Complexity:** `O(N)` — Where `N` is the number of nodes in the binary tree. Each node is enqueued and dequeued exactly once, taking `O(1)` time per node, leading to a linear overall time complexity.
- **Space Complexity:** `O(N)` — The queue stores nodes level by level. In the worst-case scenario (e.g., a completely balanced tree), the bottom-most level can hold up to `N/2` nodes, which requires `O(N)` auxiliary space. Additionally, the list storing the result requires `O(N)` memory space.

## Solution (Java)

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        if(root == null){
            return l;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int qsize = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < qsize; i++){
                TreeNode current = q.poll();
                level.add(current.val);
                if(current.left != null) q.add(current.left);
                if(current.right != null) q.add(current.right);
            }
            l.add(level);
        }
        
        return l;
    }
}
```
