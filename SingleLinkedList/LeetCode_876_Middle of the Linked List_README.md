# 876. Middle of the Linked List

## Problem Statement

Given the `head` of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the **second middle** node.

## Examples

### Example 1

**Input:** `head = [1,2,3,4,5]`  
**Output:** `[3,4,5]`  
**Explanation:** The middle node of the list is node 3.

### Example 2

**Input:** `head = [1,2,3,4,5,6]`  
**Output:** `[4,5,6]`  
**Explanation:** Since the list has two middle nodes with values 3 and 4, we return the second one.

## Constraints

- The number of nodes in the list is in the range `[1, 100]`.
- `1 <= Node.val <= 100`

## Approaches

### Approach 1: Array/List Storage (Brute Force)

Traverse the linked list and store each node in an `ArrayList`. Once all nodes are stored, return the node at index `length / 2`.

- **Time Complexity:** `O(N)` — We visit each node exactly once.
- **Space Complexity:** `O(N)` — We use an external array/list to store the nodes.

### Approach 2: Two-Pass Length Count

First, traverse the linked list to count the total number of nodes (`length`). Then, traverse the list a second time, stopping at `length / 2` steps to find the middle node.

- **Time Complexity:** `O(N) + O(N/2) = O(N)` — We traverse the list one and a half times.
- **Space Complexity:** `O(1)` — No extra space is required.

### Approach 3: Slow and Fast Pointers (Optimal / Tortoise and Hare)

Use two pointers: `slow` and `fast`. Both start at the `head` of the list. The `slow` pointer advances one step at a time, while the `fast` pointer advances two steps at a time. When the `fast` pointer reaches the end of the list (or `fast.next` is null), the `slow` pointer will be exactly at the middle node.

- **Time Complexity:** `O(N)` — Single pass. The `fast` pointer traverses the list once.
- **Space Complexity:** `O(1)` — Only two pointer variables are used.

## Solution (Java)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        // Optimal Approach: Slow & Fast Pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
```
