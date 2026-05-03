# 142. Linked List Cycle II

## Problem Statement

Given the `head` of a linked list, return the node where the cycle begins. If there is no cycle, return `null`.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to (0-indexed). It is `-1` if there is no cycle. **Note that `pos` is not passed as a parameter**.

**Do not modify** the linked list.

## Examples

### Example 1
**Input:** `head = [3,2,0,-4], pos = 1`  
**Output:** `tail connects to node index 1`  
**Explanation:** There is a cycle in the linked list, where tail connects to the second node.

### Example 2
**Input:** `head = [1,2], pos = 0`  
**Output:** `tail connects to node index 0`  
**Explanation:** There is a cycle in the linked list, where tail connects to the first node.

### Example 3
**Input:** `head = [1], pos = -1`  
**Output:** `no cycle`  
**Explanation:** There is no cycle in the linked list.

## Constraints

- The number of the nodes in the list is in the range `[0, 10^4]`.
- `-10^5 <= Node.val <= 10^5`
- `pos` is `-1` or a **valid index** in the linked-list.

## Approaches

### Approach 1: HashSet
Traverse the linked list and keep track of visited nodes using a `HashSet`. If we encounter a node that is already in the set, that node is the start of the cycle. If we reach the end of the list (`null`), there is no cycle.
- **Time Complexity:** `O(N)` — We visit each node at most once. Adding and checking elements in a HashSet takes `O(1)` time on average.
- **Space Complexity:** `O(N)` — Extra space is required to store the nodes in the `HashSet`.

### Approach 2: Floyd's Cycle Detection (Tortoise and Hare)
This optimal approach uses two pointers, `slow` and `fast`. 
1. Initially, both pointers start at the head. `slow` moves one step at a time, while `fast` moves two steps.
2. If there is a cycle, the two pointers will eventually meet. 
3. When they meet, we reset one of the pointers (e.g., `slow`) back to the `head` and keep the other pointer at the meeting point.
4. Now, both pointers move one step at a time. The node where they meet again is the starting point of the cycle.
- **Time Complexity:** `O(N)` — In the worst case, we traverse the list a constant number of times.
- **Space Complexity:** `O(1)` — We only use two extra pointers, requiring constant space.

## Solution (Java)

```java
/*
// Approach 1: HashSet
import java.util.HashSet;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> s = new HashSet<>();
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        while (temp != null) {
            if (s.contains(temp)) {
                return temp;
            }
            s.add(temp);
            temp = temp.next;
        }
        return null;
    }
}
*/

// Approach 2: Floyd's Cycle Detection
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
```
