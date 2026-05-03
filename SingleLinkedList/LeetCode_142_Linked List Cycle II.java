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

 /*
 Approach --- Hashing
 T.C --- O(N*2*(T.C of HashSet))
 S.S --- O(N)

public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> s = new HashSet<>();
        if(head == null){
            return null;
        }
        ListNode temp = head;
        while(temp != null){
            if(s.contains(temp)){
                return temp;
            }
            s.add(temp);
            temp = temp.next;
        }
        return null;
    }
}
*/

/*
Approach -- Floyd's detection
Time Complexity: O(N) where N is the number of nodes in the linked list. In the worst case, we traverse the entire list once with the slow and fast pointers, and then again to find the entry point of the loop.

Space Complexity: O(1) constant extra space. No additional data structures are used, only two pointers.
*/

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
    return null;
    }
}