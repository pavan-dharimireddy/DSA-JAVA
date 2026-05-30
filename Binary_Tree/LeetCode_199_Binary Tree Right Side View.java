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
 Approach --- Reverse PreOrder (Recurrsion)
 Time Complexity: O(N) In the worst case, we may visit every node in the binary tree exactly once. This happens when the tree is skewed (i.e., every node has only one child), effectively forming a linear structure. Hence, the time complexity becomes O(N), where N is the total number of nodes in the tree.

Space Complexity: O(H),The space complexity depends on the height (H) of the binary tree due to the recursion stack in depth-first traversal (like preorder, inorder, postorder). In a balanced binary tree, the height is log₂N, leading to O(log N) space. However, in the worst case (a skewed tree), the height is N, resulting in O(N) space. So the space complexity is O(H), where H is the height of the tree.
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightDFS(root,0,res);
        return res;
    }

    public void rightDFS(TreeNode root,int level,List<Integer> res){
       
        if(root == null){  // Base case
            return;
        }
        
        if(res.size() == level){ // If we're visiting this level the first time
            res.add(root.val);
        }
        rightDFS(root.right,level+1,res); // Recurse right
        rightDFS(root.left,level+1,res); // Recurse left
    }

    public void leftDFS(TreeNode root,int level,List<Integer> res){

        if(root == null){ // Base case
            return;
        }
        
        if(res.size() == level){ // If we're visiting this level the first time
            res.add(root.val);
        }
        leftDFS(root.left,level+1,res); // Recurse left
        leftDFS(root.right,level+1,res); // Recurse right
    }

}