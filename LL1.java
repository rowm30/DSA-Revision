import java.util.*;

public class LL1 {
    

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public Node head = null;
    public Node tail = null;

    public void addNode(int data){
        Node newNode = new Node(data);

        if(head ==  null){
            head = newNode;
            tail = newNode;
        }else{
           tail.next = newNode;
           tail = newNode; 
        }
    }

    public void display(){
        Node current = head;

        if(head == null){
            System.out.println("List is empty");
            return;
        }

        System.out.println("Node of singly linked list: ");

        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes you want ot enter: ");
        int n =sc.nextInt();

        LL1 L1 = new LL1();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            L1.addNode(m);
        }

        L1.display();
    }

}
