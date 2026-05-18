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
 https://youtu.be/RlUu72JrOCQ?si=MuGLQ6DNmUuQu9xz

 ⏱️ Time Complexity --- O(n), where n is the number of nodes in the tree. Each node is visited exactly once.


Space Complexity
Auxiliary space (recursion stack): O(h), where h is the height of the tree.
Worst case (skewed tree): h = n ⇒ O(n)
Best/average (balanced tree): h = log n ⇒ O(log n)


Result list space: O(n) to store the traversal output (this is necessary space, not auxiliary).


Overall space usage is O(n) due to the output list, with O(h) extra space due to recursion.

 */

 /* recursive 
class Solution {
    List<Integer> l = new ArrayList<>();
     public List<Integer> preorderTraversal(TreeNode root) {
        // Base case: if the current node is null, return the accumulated list.
        if (root == null) {
            return l;
        }

        // Preorder = Visit Root -> Left -> Right
        l.add(root.val);              // 1) Visit root (process current node)
        preorderTraversal(root.left); // 2) Recurse on left subtree
        preorderTraversal(root.right);// 3) Recurse on right subtree

        // Return the accumulated result list
        return l;
    }

}

*/
/*
Time Complexity: O(N), where N is the number of nodes in the binary tree. Each node is visited once during the traversal.

Space Complexity: O(H), where H is the height of the binary tree. The space is used by the stack to store nodes during traversal.
*/

class Solution {
    
     public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if(root == null){
            return l;
        }
        Deque<TreeNode> s = new LinkedList<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode current = s.poll();
            l.add(current.val);
            if(current.right != null){
                s.push(current.right);
            }
            if(current.left != null){
                s.push(current.left);
            }
        }
    return l;
     }
}


   