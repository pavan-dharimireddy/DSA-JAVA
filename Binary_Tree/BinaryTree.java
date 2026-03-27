

import java.util.Scanner;

public class BinaryTree {
    
    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = TreeCreation();
        inOrder(root);
    }

    public static Node TreeCreation(){
        System.out.print("Enter the data : ");
        int data = sc.nextInt();
        if(data == -1){
            return null;
        }
        Node root = new Node(data);
        System.out.println("enter the data for left " + data);
        root.left = TreeCreation();
        System.out.println("enter the data for right " + data);
        root.right = TreeCreation();
        return root;
    }

    static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
}

class Node{
    Node left;
    Node right;
    int data;

    public Node(int data){
        this.data = data;
    }
}
