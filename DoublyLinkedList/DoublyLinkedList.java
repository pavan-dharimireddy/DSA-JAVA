// ===================== NODE CLASS =====================
// Represents a single node in the doubly linked list
class DNode {
    int data; // Stores the value
    DNode prev; // Pointer to previous node
    DNode next; // Pointer to next node

    // Constructor with data only
    DNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    // Constructor with data, previous and next references
    DNode(int data, DNode prev, DNode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

// ===================== DOUBLY LINKED LIST OPERATIONS =====================
class DoublyLinkedListOperations {

    /*
     * =====================================================
     * INSERT OPERATIONS
     * =====================================================
     */

    // Insert at beginning
    // Time Complexity: O(1)
    public DNode insertAtHead(DNode head, int value) {

        // Create new node
        DNode newNode = new DNode(value);

        // If list is not empty
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }

        // New node becomes the head
        return newNode;
    }

    // Insert at end
    // Time Complexity: O(n)
    public DNode insertAtTail(DNode head, int value) {

        DNode newNode = new DNode(value);

        // If list is empty
        if (head == null) {
            return newNode;
        }

        // Traverse to last node
        DNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Link new node at end
        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }

    // Insert at a specific position (1-based index)
    // Time Complexity: O(n)
    public DNode insertAtPosition(DNode head, int position, int value) {

        // Invalid position
        if (position <= 0) {
            System.out.println("Invalid position");
            return head;
        }

        // Insert at head
        if (position == 1) {
            return insertAtHead(head, value);
        }

        // Traverse to (position - 1)th node
        DNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        // Position out of bounds
        if (temp == null) {
            System.out.println("Position out of range");
            return head;
        }

        // Create new node
        DNode newNode = new DNode(value);

        // Adjust links
        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;

        return head;
    }

    /*
     * =====================================================
     * DELETE OPERATIONS
     * =====================================================
     */

    // Delete from beginning
    // Time Complexity: O(1)
    public DNode deleteAtHead(DNode head) {

        // Empty list
        if (head == null) {
            return null;
        }

        // Move head to next node
        head = head.next;

        // If list is not empty, remove previous link
        if (head != null) {
            head.prev = null;
        }

        return head;
    }

    // Delete from end
    // Time Complexity: O(n)
    public DNode deleteAtTail(DNode head) {

        // Empty list or single node
        if (head == null || head.next == null) {
            return null;
        }

        // Traverse to last node
        DNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Remove last node
        temp.prev.next = null;

        return head;
    }

    // Delete at specific position (1-based index)
    // Time Complexity: O(n)
    public DNode deleteAtPosition(DNode head, int position) {

        // Invalid cases
        if (head == null || position <= 0) {
            return head;
        }

        // Delete head
        if (position == 1) {
            return deleteAtHead(head);
        }

        // Traverse to target node
        DNode temp = head;
        for (int i = 1; i < position && temp != null; i++) {
            temp = temp.next;
        }

        // Position out of bounds
        if (temp == null) {
            System.out.println("Position out of range");
            return head;
        }

        // Adjust links
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }

        return head;
    }

    // Delete a node by value
    // Time Complexity: O(n)
    public DNode deleteByValue(DNode head, int value) {

        DNode temp = head;

        // Search for the value
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        // Value not found
        if (temp == null) {
            System.out.println("Value not found");
            return head;
        }

        // If node is head
        if (temp == head) {
            return deleteAtHead(head);
        }

        // Adjust links
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        temp.prev.next = temp.next;

        return head;
    }

    /*
     * =====================================================
     * SEARCH OPERATION
     * =====================================================
     */

    // Search for a value
    // Time Complexity: O(n)
    public boolean search(DNode head, int value) {

        DNode temp = head;

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
     * TRAVERSAL OPERATIONS
     * =====================================================
     */

    // Forward traversal
    public void traverseForward(DNode head) {

        DNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Backward traversal
    public void traverseBackward(DNode head) {

        if (head == null) {
            return;
        }

        // Go to last node
        DNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Traverse backwards
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {

        DoublyLinkedListOperations dll = new DoublyLinkedListOperations();
        DNode head = null;

        // -------- INSERTION --------
        head = dll.insertAtHead(head, 10);
        head = dll.insertAtTail(head, 20);
        head = dll.insertAtTail(head, 30);
        head = dll.insertAtPosition(head, 2, 15);

        System.out.print("Forward Traversal: ");
        dll.traverseForward(head);

        System.out.print("Backward Traversal: ");
        dll.traverseBackward(head);

        // -------- DELETION --------
        head = dll.deleteAtHead(head);
        head = dll.deleteAtTail(head);
        head = dll.deleteByValue(head, 15);

        System.out.print("After Deletions: ");
        dll.traverseForward(head);

        // -------- SEARCH --------
        System.out.println("Search 20: " + dll.search(head, 20));
        System.out.println("Search 100: " + dll.search(head, 100));
    }
}
