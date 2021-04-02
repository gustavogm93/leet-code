package CrackingTheCodeInterview;

class Node {
	Node next;
	int data;

	public Node(int data) {
		this.data = data;
	}

}

public class MyLinkedList {

	Node head;

	
	public static void main(String[] args) {
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.append(10);
		linkedList.append(25);
		linkedList.append(45);
		linkedList.append(55);
	
		System.out.print("a");
	}
	
	//Change Tail --> Add Last place
	public void append(int data) {
		
		if (head == null) {
			head = new Node(data);
			return;
		}

		Node CurrentNode = head;
		while (CurrentNode.next != null) {
			CurrentNode = CurrentNode.next;
		}
		CurrentNode.next = new Node(data);

	}

	//Change Head --> Add first place
	public void prepend(int data) {

		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;	
	}
	
	
	
	
	public void delete(int data) {

		if (head == null) return;
		if (head.data == data) {
			head = head.next;
			return;
		}
		

		Node currentNode = head;
		while (currentNode.next != null) {

			if (currentNode.next.data == data) {
				currentNode.next = currentNode.next.next;
				return;
			}
			currentNode = currentNode.next;
		}
	}
	
}
