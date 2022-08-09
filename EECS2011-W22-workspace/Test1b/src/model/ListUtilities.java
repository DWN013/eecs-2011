package model;

import tests.Node;

public class ListUtilities<E> {
	
	public Node<E> task(Node<E> inputNode, E element){
		
		if(inputNode == null || (inputNode.getElement() == element && inputNode.getNext() == null)) {
			return null;
		}
        
        Node<E> copyNode = inputNode;
        
        //removes first element if it's equal to element
        while (copyNode != null && copyNode.getElement() == element) {
            copyNode = copyNode.getNext();
        }
        
        Node<E> trimmedNode = copyNode;
        Node<E> tempNode = null;
        
        if (copyNode != null) {
            copyNode = copyNode.getNext();
        }
        
        while (copyNode != null) {
            
            if (copyNode.getElement() == element) {
                if (tempNode != null) {
                    tempNode.setNext(copyNode.getNext());
                }
                if (trimmedNode.getNext() == copyNode) {
                    if (copyNode.getNext().getElement() != element) {
                        trimmedNode.setNext(copyNode.getNext());        
                    }
                }
            }
            
            if (tempNode == null) {
                tempNode = copyNode;
            }
            
            copyNode = copyNode.getNext();
        }
        
        Node<E> finalTrimmedNode = trimmedNode;
        
        while (finalTrimmedNode != null) {
            if (finalTrimmedNode.getNext() != null && finalTrimmedNode.getNext().getElement() == element) {
                finalTrimmedNode.setNext(null);
            }
            finalTrimmedNode = finalTrimmedNode.getNext();
        }
        
        return trimmedNode;
    }
	
}
