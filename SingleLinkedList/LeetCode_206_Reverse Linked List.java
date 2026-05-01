/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 https://youtu.be/D2vI2DNJGd8?si=oVs_h4iR4fUXrYCZ
 */


 /*
 My solution ---- iterative or Two pointer solution

 ✅ Complexity:

Time: O(n) (each node visited once)
Space: O(1) (in-place reversal)

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current_node = head;
        ListNode previous_node = null;
        while(current_node != null){
            
            ListNode temp = current_node.next; // save next
            current_node.next = previous_node; // reverse link
            previous_node = current_node;      // advance prev
            current_node = temp;               // advance curr

        }

        return previous_node;
    }
}

*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 

class Solution {
    public ListNode reverseList(ListNode head) {
        // Small optimization: if the list is empty or has a single node, it's already reversed.
        if (head == null || head.next == null) {
            return head;
        }

        // previous_node will trail behind and becomes the new head at the end.
        ListNode previous_node = null;

        // current_node traverses the original list, flipping pointers as we go.
        ListNode current_node = head;

        // Iterate until we run past the tail.
        while (current_node != null) {
            // Save the next node before we break the link.
            ListNode temp = current_node.next;

            // Reverse the current link: point current back to the already-reversed prefix.
            current_node.next = previous_node;

            // Advance both pointers forward by one step.
            previous_node = current_node;
            current_node = temp;
        }

        // previous_node now points to the new head (the original tail).
        return previous_node;
    }
}

*/

/*
🟩 GOOD (Educational / Alternative): Using a Stack — O(n) time, O(n) space
This uses an explicit stack to reverse the order. It’s simple to grasp but wastes memory compared to the iterative approach.


import java.util.Stack;

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;

        // Push all nodes to the stack
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        // Pop to rebuild reversed list
        ListNode newHead = stack.pop();
        curr = newHead;
        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }
        curr.next = null; // Terminate the new tail

        return newHead;
    }
}
*/

/*
Stack approach 2 :
You’re describing this approach:

Push only the node values (val) onto a stack as you traverse the list.
Then traverse the list again from the head and pop values from the stack to overwrite each node’s val.

Is this valid?

Yes, if the problem allows reversing values instead of actually reversing the node links.
No, if the requirement is to reverse the linked list structure (i.e., next pointers must be reversed). Many interviewers and platforms (including LeetCode 206) expect pointer reversal, not just value rewriting.

✅ Stack (Values-Only) Approach — Code
Complexity: Time O(n), Space O(n)


import java.util.Stack;

class Solution {
    public ListNode reverseList(ListNode head) {
        // Edge cases: empty or single node list → nothing to do
        if (head == null || head.next == null) return head;

        // 1) Push all node values onto a stack
        Stack<Integer> st = new Stack<>();
        for (ListNode curr = head; curr != null; curr = curr.next) {
            st.push(curr.val);
        }

        // 2) Overwrite values by popping from the stack (LIFO → reversed order)
        for (ListNode curr = head; curr != null; curr = curr.next) {
            curr.val = st.pop();
        }

        // Structure unchanged; only values reversed
        return head;
    }
}

When is this acceptable?
The problem explicitly says you can modify node values and doesn’t require preserving object identity order.
The node’s val is the only meaningful field (no other metadata/state to preserve).
You don’t need references to maintain their relative identity positions.

When is this not acceptable?
The task requires reversing pointers (e.g., subsequent algorithms depend on actual next topology).
Nodes carry more than just val (e.g., timestamps, ids, other fields)—overwriting only val will be wrong.
You must preserve node identity order (e.g., if some external map holds references to specific nodes).
The list is immutable (values cannot be modified), or you must avoid side effects.


*/


/*
------------ Recursive algo -------------------------

Complexity:
Time: O(n)
Space: O(n) due to recursion stack

*/


class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newhead = reverseList(head.next);
        ListNode headnext = head.next;  
        headnext.next = head;  // Place current head after its next (reverse the link)
        head.next = null; // Important: terminate the reversed list tail
        return newhead;
    }
}