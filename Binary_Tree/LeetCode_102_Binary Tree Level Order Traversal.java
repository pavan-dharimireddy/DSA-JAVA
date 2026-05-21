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

 /*
 https://youtu.be/EoAsWbO7sqg?si=uXruVt1GW6z4tq0D

Binary Tree Level Order Traversal
  
  Performs a breadth-first search (BFS) to traverse the tree level by level
  and returns the node values grouped by level.

 Time Complexity: O(N), where N is the number of nodes in the binary tree. Each node is visited once during the level-order traversal, each node is enqueued and dequeued exactly once.

Space Complexity: O(N), where N is the number of nodes in the binary tree. The space is used by the queue to store nodes at each level, and in the worst case, it can hold all nodes at the last level.

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Result list to store values level by level.
        List<List<Integer>> l = new ArrayList<>();

        // Edge case: if the tree is empty, return an empty list.
        if (root == null) {
            return l;
        }

        // Queue for BFS traversal; holds nodes to visit.
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root); // Start with the root node.

        // Process nodes level by level until the queue is empty.
        while (!q.isEmpty()) {
            int qsize = q.size(); // Number of nodes at the current level.
            List<Integer> level = new ArrayList<>(qsize); // List to collect this level's values.

            // Iterate exactly over the nodes in the current level.
            for (int i = 0; i < qsize; i++) {
                TreeNode current = q.poll(); // Dequeue next node in the level.
                level.add(current.val);      // Record its value.

                // Enqueue children for the next level (if present).
                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
            }

            // After processing one full level, add its values to the result.
            l.add(level);
        }

        // Return the list of levels.
        return l;
    }
}
*/

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
            for(int i=0;i<qsize;i++){
            TreeNode current = q.poll();
            level.add(current.val);
            if(current.left != null){
                q.add(current.left);
            }
            if(current.right != null){
                q.add(current.right);
            }
            }
            l.add(level);
        }
    return l;
    }
}