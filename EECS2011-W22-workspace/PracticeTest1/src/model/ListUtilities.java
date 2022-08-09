package model;

import tests.Node;

public class ListUtilities<E> {
	
	public ListUtilities(){
		
	}
	
	public Node<E> reverseOf(Node<E> input){
		
		if(input == null) {
			return null;
		}
		
		Node<E> reverse = null;
		Node<E> currentNode = input;
		
		while(currentNode != null) {
			//E element = currentNode.getElement();
			Node<E> tempNode = new Node<E>(currentNode.getElement(), null);
			tempNode.setNext(reverse);
			reverse = tempNode;
			currentNode = currentNode.getNext();
		}
		return reverse;
	}
	
	public Node<E> copyOf(Node<E> input){
		if(input == null) {
			return null;
		}
		
		Node<E> temp = null;
		
		Node<E> newNode = new Node<E>(temp.getElement(), null);
		Node<E> next = null;

		temp = temp.getNext();

		while (temp != null) {

			E val = temp.getElement();

			Node<E> temp2 = new Node<E>(val, null);
			if (newNode.getNext() == null) {
				newNode.setNext(temp2);
			}

			if (next != null) {
				next.setNext(temp2);
			}

			next = temp2;
			temp = temp.getNext();
		}
		
		return newNode;
		
	}
	
}
