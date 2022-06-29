import java.util.Scanner;

public class Merge2LL {
    
    class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;

    public void addNode(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void printLL(){
        Node current = head;
        if (head ==  null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Nodes of singly linked list: ");

        System.out.print("head->");
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }

        System.out.println("null");
    }

    public void insert(int data, Node head, int pos){
        
        Node toAdd = new Node(data);

        if (pos == 0) {
            toAdd.next = head;
            head = toAdd;
            return;
        }

        Node prev = head;

        for (int i = 0; i < pos - 1; i++) {
            prev = prev.next;
        }

        toAdd.next = prev.next;
        prev.next = toAdd;
    }

    public Node solve(Node first, Node second){
        Node current1 = first;
        Node next1 = current1.next;
        Node current2 = second;
        Node next2 = current2.next;

        while (current1.next != null && current2 != null) {
            
            if (current2.data >= current1.data && current2.data <= next1.data) {
                current1.next = current2;
                next2 = current2.next;
                current2.next = next1;

                current1 = current2;
                current2 = next2;
            }else{
                current1 = next1;
                next1 = next1.next;

                if (next1 == null) {
                    current1.next = current2;
                    return first;
                }
            }
        }
        return first;
    }

    public Node sortMerge2List(Node first, Node second){

        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        if (first.data <= second.data) {
            return solve(first,second);
        }else{
            return solve(second,first);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of Nodes in the Linked List 1: ");
        int n = sc.nextInt();

        System.out.println("Number of Nodes in the Linked List 2: ");
        int m = sc.nextInt();

        Merge2LL LL = new Merge2LL();
        Merge2LL LL2 = new Merge2LL();

        System.out.println();
        System.out.println("Enter the data for LL1");

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            LL.addNode(temp);
        }

        
        System.out.println();
        System.out.println("Enter the data for LL2");

        for (int i = 0; i < m; i++) {
            int temp = sc.nextInt();
            LL2.addNode(temp);
        }

        LL.printLL();
        System.out.println();
        LL2.printLL();

        LL.head = LL.sortMerge2List(LL.head, LL2.head);

        System.out.println();
        LL.printLL();

    }

}
