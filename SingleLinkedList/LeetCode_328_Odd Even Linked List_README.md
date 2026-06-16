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

### Approach 1: Creating New Nodes (Sub-optimal)

Create two dummy nodes (`odd` and `even`). Traverse the list while maintaining an index count. Depending on whether the count is odd or even, append a **newly created node** with the current value to the respective dummy list. Finally, link the tail of the odd list to the head of the even list.

- **Time Complexity:** `O(N)`
- **Space Complexity:** `O(N)` — Because we create completely new nodes instead of manipulating existing ones.

```java
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = new ListNode(-1);
        ListNode odd_temp = odd;
        ListNode even = new ListNode(-1);
        ListNode even_temp = even;
        int count = 1;
        ListNode temp = head;

        while (temp != null) {
            if (count % 2 == 0) {
                even_temp.next = new ListNode(temp.val);
                even_temp = even_temp.next;
            } else {
                odd_temp.next = new ListNode(temp.val);
                odd_temp = odd_temp.next;
            }
            temp = temp.next;
            count++;
        }

        odd_temp.next = even.next;
        return odd.next;
    }
}
```

### Approach 2: Using ArrayList (Brute Force)

Extract the values from the linked list into an `ArrayList` by skipping nodes to get all odd-indexed node values first, then repeating the process for even-indexed nodes. Finally, iterate through the original linked list to overwrite the node values with the newly sorted values from the array.

- **Time Complexity:** `O(2N)` — We traverse the list multiple times.
- **Space Complexity:** `O(N)` — We use an extra `ArrayList` of size N to store the values.

```java
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        List<Integer> arr = new ArrayList<>();

        // Add odd-indexed nodes
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            arr.add(temp.val);
            temp = temp.next.next;
        }
        if (temp != null) arr.add(temp.val);

        // Add even-indexed nodes
        temp = head.next;
        while (temp != null && temp.next != null) {
            arr.add(temp.val);
            temp = temp.next.next;
        }
        if (temp != null) arr.add(temp.val);

        // Overwrite original list
        int i = 0;
        temp = head;
        while (temp != null) {
            temp.val = arr.get(i);
            i++;
            temp = temp.next;
        }
        return head;
    }
}
```

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
