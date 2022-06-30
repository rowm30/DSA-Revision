import java.util.Scanner;

public class RemoveNth_nodeLL {
    
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

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void printLL(){
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Nodes of Singly linked list: ");

        System.out.print("head->");

        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }

        System.out.println("null");
    }

    public Node removeNthFromEnd(Node head, int B){
        
        int len = 0;
        Node temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        if (B > len) {
            System.out.println("Invalid Operation");
            return head;
        } else if(B == len) {
            return head.next;
        }else {
            int diff = len - B;
            Node prev = null;
            Node curr = head;
            for (int i = 0; i < diff; i++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
            return head;
        }
    }

    public Node remClever(Node head, int n){
        Node start = head;
        Node fast = start;
        Node slow = start;

        for (int i = 0; i <= n; ++i) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return slow.next;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of nodes in the Linked List: ");
        int sizeOfLL = sc.nextInt();

        RemoveNth_nodeLL LL = new RemoveNth_nodeLL();

        System.out.println();
        System.out.println("Enter the data for LL: ");

        for (int i = 0; i < sizeOfLL; i++) {
            int temp = sc.nextInt();
            LL.addNode(temp);
        }
        int B = sc.nextInt();
        
        LL.remClever(LL.head, B);

        LL.printLL();
    }
}
