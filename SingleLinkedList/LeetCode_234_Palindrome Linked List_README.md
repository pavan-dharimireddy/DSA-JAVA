# 234. Palindrome Linked List

## Problem Statement

Given the `head` of a singly linked list, return `true` if it is a **palindrome** or `false` otherwise.

## Approaches

### Approach 1: Using a Stack
A straightforward way to check for a palindrome is to use a stack. We traverse the linked list and push every node's value onto a stack. Since a stack is a Last-In-First-Out (LIFO) data structure, popping elements off the stack yields the values in reverse order. We then traverse the list a second time, comparing each node's value against the popped stack values.

- **Time Complexity:** `O(N)` — We traverse the linked list twice, which conceptually is `O(2N)`, simplifying to `O(N)`.
- **Space Complexity:** `O(N)` — Extra space is required to store `N` elements in the stack.

### Approach 2: Fast & Slow Pointers with In-Place Reversal (Optimal)
To solve the problem with constant space complexity, we can modify the linked list in place:
1. **Find the middle:** Use the slow and fast pointer technique (Tortoise and Hare). When the fast pointer reaches the end, the slow pointer will be at the middle.
2. **Reverse the second half:** Reverse the pointers of the linked list starting from the node immediately after the middle.
3. **Compare halves:** Use two pointers—one at the head and one at the start of the reversed second half. Iterate and compare their values. If all match, it's a palindrome.

- **Time Complexity:** `O(N)` — We traverse the list to find the middle `O(N/2)`, reverse the second half `O(N/2)`, and compare the halves `O(N/2)`. Overall, it scales linearly as `O(N)`.
- **Space Complexity:** `O(1)` — The reversal is done entirely in place, using only a few extra pointer variables.

## Solution (Java)

```java
/*
 * Approach 1: Using a Stack
 */
// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         Deque<Integer> st = new ArrayDeque<>();
//         ListNode temp = head;
//         while(temp != null){
//             st.push(temp.val);
//             temp = temp.next;
//         }
//         temp = head;
//         while(temp != null){
//             if(temp.val != st.peek()){
//                 return false;
//             }
//             st.pop();
//             temp = temp.next;
//         }
//         return true;
//     }
// }

/*
 * Approach 2: Optimal (Fast & Slow Pointers + Reversal)
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        
        ListNode mid = middle(head);
        ListNode last = reverse(mid.next);
        ListNode first = head;
        
        while(last != null){
            if(first.val != last.val){
                return false;
            }
            first = first.next;
            last = last.next;
        }
        return true;
    }

    public ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode node){
        ListNode curr = node;
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
```
