package CrackingTheCodeInterview;

import java.util.LinkedList;

public class LinkedListProblems {

	public static void main(String[] args) {
		/*
		 * LinkedListProblems Linked = new LinkedListProblems(); Linked.nodeTest();
		 */
		var a = new LinkedList<String>();
		a.add("1");
		a.add("2");
		a.add("3");
		a.remove("2");
		// a.removeFirstOccurrence("perro");
		a.toString();
	}

	void removeDuplicates(Node n) {
		Node node = n;
		Node nodeToCheck;
		while (node.next != null) {
			int value = node.data;

			if (node.data == node.next.data)

				node = node.next;
		}

	}

	void nodeTest() {

		// Node [5] --> Next --> Node [10] -- Next --> NULL

		Node node = new Node(5);
		node.appendToTail(10);
		node.appendToTail(25);
		node.appendToTail(50);
		node.appendToTail(75);
		node.appendToTail(100);
	}

	class Node {
		Node next = null;
		int data;

		public Node(int d) {
			data = d;
		}

		void appendToTail(int d) {
			Node end = new Node(d);
			Node n = this;
			while (n.next != null) { // Cuando N sea distinto a nulo
				n = n.next; // Nodo cambia por la base
			}
			n.next = end;
		}
	}

}
