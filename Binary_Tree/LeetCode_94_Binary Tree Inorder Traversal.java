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
 https://youtu.be/Z_NEgBgbRVI?si=ZhTYE4_PBm2BPurK

 ⏱️ Time Complexity --- O(n), where n is the number of nodes. Each node is visited exactly once to add its value.


🧠 Space Complexity

Auxiliary space (recursion stack): O(h), where h is the tree height.

Worst case (skewed tree): h = n ⇒ O(n)
Balanced tree: h = log n ⇒ O(log n)
Result list space: O(n) to store the output.
Overall space usage is O(n) (due to the output list) with O(h) extra space for recursion.

 

class Solution {
    List<Integer> l = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        // Base case: if the current node is null, return whatever is accumulated so far.
        if (root == null) {
            return l;
        }

        // Inorder traversal = Left -> Root -> Right

        inorderTraversal(root.left); // 1) Traverse the left subtree
        

        l.add(root.val); // 2) Visit (process) the current node
        

        inorderTraversal(root.right); // 3) Traverse the right subtree

        // Return the accumulated result
        return l;
    }
}
 */

/*
Time Complexity: O(n), where n is the number of nodes in the binary tree. Each node is visited exactly once.

Space Complexity: O(h), where h is the height of the binary tree. This is the space required for the stack to store the nodes during traversal.
*/

 class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if(root == null){
            return l;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while(true){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()){
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
 