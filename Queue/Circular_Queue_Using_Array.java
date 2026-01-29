public class Circular_Queue_Using_Array {
    public static void main(String[] args) {
        Circular_Queue cq = new Circular_Queue(5);
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.print();
        System.out.println(cq.isEmpty());
        System.out.println(cq.isFull());
        System.out.println(cq.size());


    }
}

class Circular_Queue {

    int a[];              // Array to store queue elements
    int capacity;         // Maximum size of the queue
    int front = -1;       // Points to the first element
    int rear = -1;        // Points to the last element
    // int size = 0;
    // Constructor to initialize queue with given capacity
    public Circular_Queue(int capacity) {
        this.capacity = capacity;
        a = new int[capacity];
    }

    // ENQUEUE: Insert element into circular queue
    public void enqueue(int data) {

        // ❌ Queue FULL condition
        // If next position of rear comes to front, queue is full
        if ((rear + 1) % capacity == front) {
            return; // No space, insertion not allowed
        }

        // ✅ Queue EMPTY condition (first insertion)
        if (front == -1) {
            front = 0;  }                              // Initialize front
            rear = (rear + 1) % capacity; // Move rear circularly
            a[rear] = data;               // Insert data
            // size++;
        
    }

    // DEQUEUE: Remove element from circular queue
    public int dequeue() throws Exception {

        // ❌ Queue EMPTY condition
        if (front == -1) {
            throw new Exception("Queue is empty");
        }

        int result = a[front]; // Store element to return

        // ✅ Only ONE element in queue
        if (front == rear) {
            front = rear = -1; // Reset queue to empty state
        } 
        // ✅ More than one element
        else {
            front = (front + 1) % capacity; // Move front circularly
        }
        // size--;
        return result; // Return removed element
    }

    public boolean isEmpty(){
        return front == -1;
    }

    public boolean isFull(){
        return (rear+1)%capacity == front;
    }

    public int size(){
        if (front == -1) {
        return 0;
    }

    return (rear - front + capacity) % capacity + 1;
    }

    /*
capacity = 5
front = 1
rear  = 3
Queue: [ ][10][20][30][ ] 

size = (3 - 1 + 5) % 5 + 1
     = 7 % 5 + 1
     = 2 + 1
     = 3

single element size
front = 2
rear  = 2
size = (2 - 2 + 5) % 5 + 1 = 1
     */

    public void print(){
        for(int x:a){
            System.out.println(x);
        }
    }
}
