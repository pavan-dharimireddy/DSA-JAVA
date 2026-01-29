import java.nio.channels.Pipe.SourceChannel;

public class Queue_Using_LinkedList {
    public static void main(String[] args) throws Exception {
        Queue_LL qll = new Queue_LL();
        qll.enqueue(10);
        qll.enqueue(20);
        qll.enqueue(30);
        qll.enqueue(40);
        qll.print();
        System.out.println("************************");
        System.out.println(qll.dequeue());
        qll.print();

        System.out.println(qll.size());
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


class Queue_LL{
    Node front;
    Node rear;
    int size;

    public Queue_LL(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(int data){
        Node newNode = new Node(data);
        if(front == null){
            front = rear = newNode;
            size++;
            return;
        }
        rear.next = newNode;
        rear = newNode;
        size++;
    }

    public int dequeue() throws Exception{
        if(front==null){
            throw new Exception();
        }

        int res = front.data;
        front = front.next;
        size--;
        return res;

    }

    public int size(){
        return size;
    }
    public void print(){
        Node temp = front;
        while (temp!= null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


}

