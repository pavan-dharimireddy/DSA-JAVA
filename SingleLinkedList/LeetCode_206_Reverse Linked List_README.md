# 206. Reverse Linked List

## Problem Statement

Given the `head` of a singly linked list, reverse the list, and return the reversed list.

## Examples

### Example 1

**Input:** `head = [1,2,3,4,5]`  
**Output:** `[5,4,3,2,1]`

### Example 2

**Input:** `head = [1,2]`  
**Output:** `[2,1]`

### Example 3

**Input:** `head = []`  
**Output:** `[]`

## Constraints

- The number of nodes in the list is the range `[0, 5000]`.
- `-5000 <= Node.val <= 5000`

## Approaches

### Approach 1: Iterative / Two Pointers (Optimal)

We maintain two pointers: `current_node` starting at `head`, and `previous_node` starting as `null`. As we iterate through the list, we temporarily store the `next` node, reverse the pointer of `current_node` to point to `previous_node`, and then advance both `previous_node` and `current_node` one step forward.

- **Time Complexity:** `O(N)` — Each node is visited exactly once.
- **Space Complexity:** `O(1)` — In-place reversal using only a few pointers.

### Approach 2: Recursive

The recursive approach assumes the rest of the list is already reversed, and we just need to place the current `head` at the end of the reversed list. The new head will bubble up from the base case (the last node).

- **Time Complexity:** `O(N)` — Each node is visited once.
- **Space Complexity:** `O(N)` — Due to the recursion stack which will go `N` levels deep.

### Approach 3: Using a Stack (Nodes or Values)

We can traverse the list and push either the node references or just their values onto a stack. Then, we either pop the nodes to rebuild the reversed links or pop the values to overwrite the original nodes.
_Note: Overwriting only values might not be acceptable in interviews if the requirement is to reverse the actual pointers._

- **Time Complexity:** `O(N)` — We iterate through the list twice (once to push, once to pop).
- **Space Complexity:** `O(N)` — The stack uses extra memory proportional to the size of the list.

## Solution (Java)

```java
/*
// Approach 1: Iterative (Optimal)
*/
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

/*
// Approach 2: Recursive
class Solution {
    public ListNode reverseList(ListNode head) {
        // Base case: if head is null or we reach the last node
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse the rest of the list
        ListNode newhead = reverseList(head.next);

        // Place current head after its next (reverse the link)
        ListNode headnext = head.next;
        headnext.next = head;

        // Important: terminate the reversed list tail
        head.next = null;

        return newhead;
    }
}
*/
```
