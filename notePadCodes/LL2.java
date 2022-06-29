import java.util.*;

public class LL2 {

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

	public void addNode(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void display() {
		Node current = head;
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		System.out.println("Node of Singly linked list: ");

		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}

		System.out.println();
	}

	public void insert(int data, Node head, int pos) {

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

	public void delete(int pos,Node head){
		if (pos == 0) {
			head = head.next;
			return;
		}
		Node prev = head;

		for (int i = 0; i < pos-1; i++) {
			prev = prev.next;
		}

		prev.next = prev.next.next;
	}

	Node rev(Node head){
		
		Node cur = head;
		Node prev = null;

		while(cur != null){
			Node temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}

		return prev;
	}

	public void reverseIterate(){
		if(head == null || head.next == null){
			return;
		}

		Node prevNode = head;
		Node currNode = head.next;
		while (currNode != null) {
			Node nextNode = currNode.next;
			currNode.next = prevNode;

			// Update

			prevNode = currNode;
			currNode = nextNode;
		}

		head.next = null;
		head = prevNode;
	}

	public Node reverseRecursive(Node head){
		if (head == null || head.next == null) {
			return head;
		}

		Node newHead = reverseRecursive(head.next);
		head.next.next = head;
		head.next = null;

		return newHead;
	}

	public Node middleNode(Node head){
		Node slow = head, fast = head;

		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of nodes you want to create: ");
		int n = sc.nextInt();

		LL2 L2 = new LL2();

		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			L2.addNode(m);
		}

		L2.display();

		System.out.println("Enter the lcoation you want to insert: ");
		int pos = sc.nextInt();
		System.out.println("Enter the number you want to insert in the afore mentioned location: ");
		int data = sc.nextInt();

		if (pos <= n) {
			L2.insert(data, L2.head, pos);
			L2.display();
		}else{
			System.out.println("Bad input! Run the program again!");
		}

		// System.out.println("Enter the node location which you want to delete:");
		// int k = sc.nextInt();
		// L2.delete(k, L2.head);
		// L2.display();



		// L2.head = L2.reverseRecursive(L2.head);

		System.out.println(L2.middleNode(L2.head).data);

	}

	

}