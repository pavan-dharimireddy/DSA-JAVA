public class Stack_Using_Array {

    public static void main(String[] args) throws Exception {
    Stack st = new Stack(5);
    st.push(5);
    st.push(6);
    st.push(8);
    st.push(10);
    st.print();
    System.out.println(st.pop());
    st.print();
    System.out.println(st.peek());
    System.out.println(st.isEmpty());
    System.out.println(st.size());
    }
}

class Stack{

    int a[];
    int top;
    int capacity;

    public Stack(int capacity){
        this.capacity = capacity;
        top = -1;
        a = new int[capacity];
    }

    public void push(int value) throws Exception{
        if(top == capacity-1){
            throw new Exception();
        }
        top++;
        a[top] = value;
    }

    public int pop() throws Exception{
        if(top == -1){
            throw new Exception();
        }
        int res = a[top];
        top--;
        return res;
    }

    public int peek() throws Exception{
        if(top == -1){
            throw new Exception();
        }
        return a[top];
    }

    public boolean isEmpty() throws Exception{
        if(top == -1){
            throw new Exception();
        }
        return top==-1;

    }

    public int size(){
        return top+1;
    }
    
     public void print(){
        for(int x:a){
            System.out.println(x);
        }
    }
   
}