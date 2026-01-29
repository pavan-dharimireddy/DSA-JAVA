public class Queue_Using_Array {

    public static void main(String[] args) throws Exception {
        Queue q = new Queue(5);
        q.push(5);
        q.push(6);
        q.push(7);
        q.push(8);
        q.print();
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.isEmpty());
        System.out.println(q.size());
    }
}

class Queue{

    int a[];
    int rear;
    int capacity;

    public Queue(int capacity){
        this.capacity = capacity;
        rear = -1;
        a = new int[capacity];
    }

    public void push(int value) throws Exception{
        if(rear == capacity-1){
            throw new Exception();
        }
        rear++;
        a[rear] = value;
    }

    public int pop() throws Exception{
        if(rear == -1){
            throw new Exception();
        }
        int res = a[0];
        for(int i=0;i<rear;i++){
            a[i] = a[i+1];
        }
        rear--;
        return res;
    }

    public int peek() throws Exception{
        if(rear == -1){
            throw new Exception();
        }
        return a[0];
    }

    public boolean isEmpty() throws Exception{
        if(rear == -1){
            throw new Exception();
        }
        return rear==-1;

    }

    public int size(){
        return rear+1;
    }
    
     public void print(){
        for(int x:a){
            System.out.println(x);
        }
    }
   
}