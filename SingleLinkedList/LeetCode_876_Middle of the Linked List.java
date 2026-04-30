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
1) Brute Force: Store nodes in an array/list
Idea: Traverse once and store each node in a list/array; then index into the middle.

For even n, the middle index should be n/2 (0-based), which gives the second middle.
Time: O(n)
Space: O(n)

class Solution {
    public ListNode middleNode(ListNode head) {
        List<ListNode> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head);
            head = head.next;
        }
        return arr.get(arr.size() / 2); // 0-based: returns second middle for even size
    }
}

*/

/*
2) Better (what you wrote): Two-pass length, then walk to middle
Idea: First count the nodes; then walk length/2 steps from head (0-based) or (length/2)+1 with 1-based counting.

Time: O(n) + O(n/2)
Space: O(1)


class Solution {
    public ListNode middleNode(ListNode head) {
        int length = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) length++;
        int steps = length / 2; // 0-based -> second middle when even
        ListNode cur = head;
        while (steps-- > 0) cur = cur.next;
        return cur;
    }
}


*/

/*
// My solution two -pass length
class Solution {
    public ListNode middleNode(ListNode head) {


// Time: O(n) + O(n/2)(two passes)
// Space: O(1)
        int length = 0;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }

        int midNode =  (length/2)+1;
        cur = head;
        while(cur != null){
            midNode--;
            if(midNode == 0){
                return cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
*/

/*
3) Optimal: Slow/Fast pointers (Tortoise and Hare)
Idea: Use two pointers:

slow advances by 1
fast advances by 2

When fast hits the end, slow is at the middle. For even length, slow ends at the second middle automatically.

Time: O(n) (single pass)
Space: O(1)

*/
class Solution {
    public ListNode middleNode(ListNode head) {
ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
