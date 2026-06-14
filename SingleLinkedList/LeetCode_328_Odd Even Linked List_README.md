# 328. Odd Even Linked List

## Problem Statement

Given the `head` of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The **first** node is considered odd, and the **second** node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in `O(1)` extra space complexity and `O(n)` time complexity.

## Examples

### Example 1

**Input:** `head = [1,2,3,4,5]`  
**Output:** `[1,3,5,2,4]`

### Example 2

**Input:** `head = [2,1,3,5,6,4,7]`  
**Output:** `[2,3,6,7,1,5,4]`

## Constraints

- The number of nodes in the linked list is in the range `[0, 10^4]`.
- `-10^6 <= Node.val <= 10^6`

## Approaches

### Approach 1: Using ArrayList (Brute Force)

Extract the values from the linked list into an `ArrayList` by skipping nodes to get all odd-indexed node values first, then repeating the process for even-indexed nodes. Finally, iterate through the original linked list to overwrite the node values with the newly sorted values from the array.

- **Time Complexity:** `O(N)` — We traverse the list multiple times, which simplifies to linear time.
- **Space Complexity:** `O(N)` — We use an extra `ArrayList` of size N to store the values.

### Approach 2: Creating New Nodes (Sub-optimal)

Create two dummy nodes (`odd` and `even`). Traverse the list while maintaining an index count. Depending on whether the count is odd or even, append a **newly created node** with the current value to the respective dummy list. Finally, link the tail of the odd list to the head of the even list.

- **Time Complexity:** `O(N)`
- **Space Complexity:** `O(N)` — Because we create completely new nodes instead of manipulating existing ones.

### Approach 3: In-Place Pointer Manipulation (Optimal)

We can group the odd and even nodes in-place by maintaining two pointers, `odd` and `even`.

- `odd` starts at the `head`, and `even` starts at `head.next`.
- We save a reference to the starting node of the even list (`evenHead = even`), so we can attach it to the end of the odd list later.
- In a loop, we bypass the immediate next node to link to the subsequent one (e.g., `odd.next = odd.next.next`), advancing both pointers step-by-step.
- Once the end of the list is reached, we connect `odd.next` to `evenHead`.
- **Time Complexity:** `O(N)` — We process each node exactly once.
- **Space Complexity:** `O(1)` — We only use a few pointers without creating any auxiliary data structures.

## Optimal Solution (Java)

```java
class Solution {
    public ListNode oddEvenList(ListNode head) {
        // Base case: if list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // Store the start of the even list

        // Traverse and rewire the next pointers
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }

        // Connect the end of the odd list to the start of the even list
        odd.next = evenHead;

        return head;
    }
}
```
