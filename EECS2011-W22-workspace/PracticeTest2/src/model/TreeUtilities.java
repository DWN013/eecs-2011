package model;

import tests.SLLNode;
import tests.TreeNode;

public class TreeUtilities<E> {

	public TreeNode<E> copyOf(TreeNode<E> root){

		TreeNode<E> rootNode = new TreeNode<>(null);

		SLLNode<TreeNode<E>> children = root.getChildren();
		//Amounts needed for statistics in the string

		while(children != null) {

			rootNode.setElement(root.getElement());

			TreeNode<E> nextNode = copyOf(children.getElement());
			rootNode.addChild(nextNode);
			nextNode.setParent(rootNode);

			children = children.getNext();
		}
		if(children == null) {
			rootNode.setElement(root.getElement());
		}
		return rootNode;
	}

	public SLLNode<TreeNode<String>> getPreOrderSeq(TreeNode<String> root){

		SLLNode<TreeNode<String>> headNode;
		if(root != null) {
			headNode =  new SLLNode<TreeNode<String>>(root, null);
		}
		else {
			return headNode =  new SLLNode<TreeNode<String>>(null, null);
		}
		
		SLLNode<TreeNode<String>> tail = headNode;
		//Loop through children recursively
		SLLNode<TreeNode<String>> children = root.getChildren();

		while (children != null) {
			
			SLLNode<TreeNode<String>> nextNode = getPreOrderSeq(children.getElement());
			
			tail.setNext(nextNode);
			while (tail.getNext() != null) {
				tail = tail.getNext();
			}
			
			children = children.getNext();
		}

		return headNode;
	}
}
