
public class Stack_Using_LinkedList {
    public static void main(String[] args) {
        
    
    Stack_LL sll = new Stack_LL();
    sll.push(10);
    sll.push(20);
    sll.push(30);
    sll.print();
    System.out.println(sll.isEmpty());
    }
}

class Node{
    int data;
    Node next;

    Node(int data,Node next){
        this.data = data;
        this.next = next;
    }
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class Stack_LL{

    Node head;
    int size;

    public Stack_LL(){
        head = null;
        size = 0;
        }

    public void push(int data){
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
        size++;
    }

    public int peek(){
        return head.data;
    }

    public int pop(){
        int res = head.data;
        head = head.next;
        size--;
        return res;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return size;
    }
    public void print(){
        Node temp = head;
        while (temp!= null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
