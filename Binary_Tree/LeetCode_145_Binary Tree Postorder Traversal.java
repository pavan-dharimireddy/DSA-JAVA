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
 https://youtu.be/COQOU6klsBg?si=Bfek_ewp9nz6ziTU

⏱️ Time Complexity
O(n) where n is the number of nodes in the tree.
Each node is visited exactly once and processed in constant time.


🧠 Space Complexity
Auxiliary space (recursion stack): O(h) where h is the height of the tree.

Worst case (completely skewed): h = n → O(n)
Balanced tree: h = log n → O(log n)
Result list space: O(n) to store the traversal output.
Overall space is O(n) due to the result list, with an additional O(h) call stack.


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

/*
Time Complexity: O(N), where N is the number of nodes in the binary tree. Each node is visited once during the traversal.

Space Complexity: O(2N), where H is the height of the binary tree. The space is used by two stacks to store nodes during traversal.
*/

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
