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
------- My solution ---------- 
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){return null;}
        ListNode odd = new ListNode(-1);
        ListNode odd_temp = odd;
        ListNode even = new ListNode(-1);
        ListNode even_temp = even;
        int count = 1;
        ListNode temp = head;
        while(temp != null){
            if(count%2 == 0){
                even_temp.next = new ListNode(temp.val);
                even_temp = even_temp.next;
            }
            else{
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
*/

/*
Approach -- using ArrayList
T.C --- O(2N)
S.C --- O(N)

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        List<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null && temp.next != null){
            arr.add(temp.val);
            temp = temp.next.next;
        }
        if(temp != null){
            arr.add(temp.val);
        }

        temp = head.next;
        while(temp != null && temp.next != null){
            arr.add(temp.val);
            temp = temp.next.next;
        }
        if(temp != null){
            arr.add(temp.val);
        }

        int i=0;
        temp = head;
        while(temp != null){
            temp.val = arr.get(i);
            i++;
            temp = temp.next;
        }
    return head;
    }
}
*/

/*
Approach 2 --- Link changing
T.C --- O(N)
S.C --- O(1)
*/
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

/*
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
*/