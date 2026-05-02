# 141. Linked List Cycle

## Problem Statement

Given `head`, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer.

Return `true` if there is a cycle in the linked list. Otherwise, return `false`.

## Constraints

- The number of nodes in the list is in the range `[0, 10^4]`.
- `-10^5 <= Node.val <= 10^5`
- `pos` is `-1` or a valid index in the linked list (used internally by LeetCode to represent the cycle).

## Approaches

### Approach 1: HashSet

We can iterate through the linked list and keep track of all the visited nodes using a `HashSet`.

- If we encounter a node that is already present in the `HashSet`, it means we've visited it before, confirming a cycle exists.
- If we reach the end of the list (`null`), there is no cycle.

- **Time Complexity:** `O(N)` on average. We traverse the entire linked list once. HashSet `add()` and `contains()` operations take `O(1)` time on average (though worst-case can be `O(log N)` or `O(N)` due to hash collisions depending on the Java version).
- **Space Complexity:** `O(N)` because we use a `HashSet` to store references to the nodes, requiring extra space proportional to the number of nodes.

### Approach 2: Slow and Fast Pointers (Floyd's Cycle Detection) - Optimal

We can use two pointers, `slow` and `fast`, both starting at the head of the list. The `slow` pointer advances one step at a time, while the `fast` pointer advances two steps at a time.

- If a cycle exists, the `fast` pointer will eventually loop around and catch up to the `slow` pointer, meaning they will equal each other.
- If the `fast` pointer reaches the end of the list (`null` or `fast.next == null`), the list terminates and there is no cycle.

- **Time Complexity:** `O(N)`. We traverse the linked list at most once or twice. If there is a cycle, the maximum number of steps taken before they meet is strictly proportional to the number of nodes.
- **Space Complexity:** `O(1)`. We only use two additional pointer variables, which requires a constant amount of extra memory regardless of list size.

## Solution (Java)

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Traverse until fast pointer reaches the end of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow pointer 1 step
            fast = fast.next.next;     // Move fast pointer 2 steps

            if (fast == slow) {
                return true;           // Pointers met, cycle detected
            }
        }
        return false;                  // Reached end of list, no cycle
    }
}
```
