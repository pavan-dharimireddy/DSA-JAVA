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
 /*
 Approach --- using stack
 T.C --- O(2N)
 S.C --- O(N)
 
class Solution {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> st = new ArrayDeque<>();
        ListNode temp = head;
        while(temp != null){
            st.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            if(temp.val != st.peek()){
                return false;
            }
            st.pop();
            temp = temp.next;
        }
    return true;
    }
}
*/

/*
Time Complexity: O(N), we traverse the list twice, once to reverse half of it and once to compare, each taking O(N/2), which simplifies to O(N).

Space Complexity: O(1), no extra space is used apart from a few pointers; operations are done in-place.
*/
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode mid = middle(head);
        ListNode  last = reverse(mid.next);
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