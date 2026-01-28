// ===================== NODE CLASS =====================
// Each Node represents one element in the linked list
class Node {
    int data; // Stores the value of the node
    Node next; // Reference (pointer) to the next node

    // Constructor: initializes data and next reference
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    // Constructor: initializes only data, next is null by default
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// ===================== LINKED LIST OPERATIONS =====================
class LinkedListOperations {

    /*
     * =====================================================
     * INSERT OPERATIONS
     * =====================================================
     */

    // Insert a node at the beginning of the linked list
    // Time Complexity: O(1)
    public Node insertAtHead(Node head, int value) {
        // Create a new node
        // New node's next will point to current head
        Node newNode = new Node(value, head);

        // New node becomes the new head
        return newNode;
    }

    // Insert a node at the end of the linked list
    // Time Complexity: O(n)
    public Node insertAtTail(Node head, int value) {
        Node newNode = new Node(value);

        // If list is empty, new node becomes head
        if (head == null) {
            return newNode;
        }

        // Traverse till last node
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Attach new node at the end
        temp.next = newNode;
        return head;
    }

    // Insert a node at a specific position (1-based indexing)
    // Time Complexity: O(n)
    public Node insertAtPosition(Node head, int position, int value) {

        // Invalid position
        if (position <= 0) {
            System.out.println("Invalid position");
            return head;
        }

        // If position is 1, insert at head
        if (position == 1) {
            return insertAtHead(head, value);
        }

        // Traverse till (position - 1)th node
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        // If position is out of bounds
        if (temp == null) {
            System.out.println("Position out of range");
            return head;
        }

        // Create new node and adjust pointers
        Node newNode = new Node(value, temp.next);
        temp.next = newNode;

        return head;
    }

    /*
     * =====================================================
     * DELETE OPERATIONS
     * =====================================================
     */

    // Delete node from beginning
    // Time Complexity: O(1)
    public Node deleteAtHead(Node head) {

        // If list is empty
        if (head == null) {
            return null;
        }

        // Move head to next node
        return head.next;
    }

    // Delete node from end
    // Time Complexity: O(n)
    public Node deleteAtTail(Node head) {

        // If list is empty or has only one node
        if (head == null || head.next == null) {
            return null;
        }

        // Traverse till second-last node
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // Remove reference to last node
        temp.next = null;
        return head;
    }

    // Delete node at a specific position (1-based indexing)
    // Time Complexity: O(n)
    public Node deleteAtPosition(Node head, int position) {

        // Invalid cases
        if (head == null || position <= 0) {
            return head;
        }

        // If deleting first node
        if (position == 1) {
            return deleteAtHead(head);
        }

        // Traverse till (position - 1)th node
        Node temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        // If position is out of bounds
        if (temp.next == null) {
            System.out.println("Position out of range");
            return head;
        }

        // Bypass the node to be deleted
        temp.next = temp.next.next;
        return head;
    }

    // Delete a node by value
    // Time Complexity: O(n)
    public Node deleteByValue(Node head, int value) {

        // If list is empty
        if (head == null) {
            return null;
        }

        // If value is found at head
        if (head.data == value) {
            return head.next;
        }

        // Search for the value
        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        // Value not found
        if (temp.next == null) {
            System.out.println("Value not found");
            return head;
        }

        // Remove the node
        temp.next = temp.next.next;
        return head;
    }

    /*
     * =====================================================
     * SEARCH OPERATION
     * =====================================================
     */

    // Search for a value in the linked list
    // Time Complexity: O(n)
    public boolean search(Node head, int value) {
        Node temp = head;

        // Traverse and compare each node's data
        while (temp != null) {
            if (temp.data == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /*
     * =====================================================
     * TRAVERSAL OPERATION
     * =====================================================
     */

    // Print the linked list
    // Time Complexity: O(n)
    public void traverse(Node head) {
        Node temp = head;

        // Traverse till end of list
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

// ===================== MAIN CLASS =====================
public class SingleLinkedList {
    public static void main(String[] args) {

        LinkedListOperations ll = new LinkedListOperations();
        Node head = null; // Initially list is empty

        // -------- INSERTION --------
        head = ll.insertAtHead(head, 10); // 10
        head = ll.insertAtTail(head, 20); // 10 -> 20
        head = ll.insertAtTail(head, 30); // 10 -> 20 -> 30
        head = ll.insertAtPosition(head, 2, 15); // 10 -> 15 -> 20 -> 30

        System.out.print("After Insertions: ");
        ll.traverse(head);

        // -------- DELETION --------
        head = ll.deleteAtHead(head); // Remove 10
        head = ll.deleteAtTail(head); // Remove 30
        head = ll.deleteAtPosition(head, 2);// Remove 20

        System.out.print("After Deletions: ");
        ll.traverse(head);

        // -------- SEARCH --------
        System.out.println("Search 15: " + ll.search(head, 15));
        System.out.println("Search 100: " + ll.search(head, 100));
    }
}
