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

/* approach 1 --- using HashSet
Time Complexity: O(N*LogN), we traverse the entire linked list once and store and retrieve nodes from the hash Set. Set operations have a worst time space complexiy of O(LogN).
Space Complexity: O(N) , additional amount of extra space is used to store nodes in a hash Set.

HashSet add() and contains() Complexity
Average Case:
add() → O(1)
contains() → O(1)  
Because hashing allows direct access to the bucket where the element should be.

Worst Case:
Before Java 8: O(n) if all elements collide into the same bucket.
Since Java 8: Collisions are handled with balanced trees (Red-Black Trees), so worst case is O(log n).

*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode temp = head;
        Set<ListNode> s = new HashSet<>();
        while(temp != null){
            if(s.contains(temp)){
                return true;
            }
            s.add(temp);
            temp = temp.next;
        }
    return false;
    }
}

 /* approach 2  --- using slow and fast pointers
 Time Complexity: O(N), we traverse the entire linked list once. The fast pointer either reaches the end of the list or meets the slow pointer in linear time.
Space Complexity: O(1) , constant amount of extra space is used detect a cycle using Floyd's Cycle Detection Algorithm.

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
    return false;
    }
}
 */ {
    
}
