package model;


import tests.SLLNode;
import tests.TreeNode;

public class TreeUtilities {

	/*
	 * For this method we need to return the head node of a SLL of nodes that sorts from the ith smallest to the jth smallest number
	 */
	public SLLNode<Integer> getElementsOfRanks(TreeNode<Integer> treeRoot, int lowerBound, int upperBound) {

		SLLNode<Integer> headNode = null;
		SLLNode<Integer> tail = null;
		//SLLNode<Integer> headNode = null;

		//Gets a linked list of everything in the tree
		SLLNode<Integer> sllNodeOfAllNumbersHead = linkedListOfAllNumbers(treeRoot);


		for (int i = 1; i < upperBound + 1; i++) {
			SLLNode<Integer> lowestRemoved = getLowest(sllNodeOfAllNumbersHead);
			sllNodeOfAllNumbersHead = remove(sllNodeOfAllNumbersHead, lowestRemoved);

			if (i >= lowerBound) {
				//if the i value is greater than our lower bound, add that number to a singly linked list
				if (headNode == null) {
					headNode = lowestRemoved;
				} else {

					if (tail == null) {
						tail = lowestRemoved;
						headNode.setNext(tail);
					} else {
						tail.setNext(lowestRemoved);
						tail = tail.getNext();
					}
				}
			}
		}
		return headNode;
	}

	private SLLNode<Integer> getLowest(SLLNode<Integer> input) {
		SLLNode<Integer> lowest = null;
		SLLNode<Integer> loop = input;

		while (loop != null) {
			if (lowest == null || loop.getElement() < lowest.getElement()) {
				lowest = loop;
			}
			loop = loop.getNext();
		}
		return lowest;
	}

	private SLLNode<Integer> remove(SLLNode<Integer> input, SLLNode<Integer> remove) {
		//(23) -> (69) -> (92)
		SLLNode<Integer> head = input;
		SLLNode<Integer> loop = input;
		SLLNode<Integer> prev = null;

		while (loop != null) {

			if (loop == remove) {

				if (loop.getNext() == null) { // tail
					if (prev != null) {
						prev.setNext(null);
					}
				} else if (loop == input) { // head
					head = head.getNext();
					loop.setNext(null);
				} else { // not head or tail
					prev.setNext(loop.getNext());
				}
			}
			prev = loop;
			loop = loop.getNext();
		}
		remove.setNext(null);
		return head;
	}

	public SLLNode<Integer> linkedListOfAllNumbers(TreeNode<Integer> treeRoot) {

		SLLNode<Integer> head = new SLLNode<Integer>(treeRoot.getElement(), null);
		SLLNode<Integer> tail = head;

		SLLNode<TreeNode<Integer>> children = treeRoot.getChildren();
		//((92, etc)
		while (children != null) {

			TreeNode<Integer> element = children.getElement();
			SLLNode<Integer> returnNode = linkedListOfAllNumbers(element);
			//(46) -> (23) -> (69) -> (92)
			tail.setNext(returnNode);
			while (tail.getNext() != null) {
				tail = tail.getNext();
			}
			children = children.getNext();
		}

		return head;
	}

	public TreeNode<String> getStats(TreeNode<Integer> treeNode) {

		TreeNode<String> rootNode = new TreeNode<>(null);

		SLLNode<TreeNode<Integer>> children = treeNode.getChildren();
		//Amounts needed for statistics in the string
		int totalDescendants = getTotalDescendants(treeNode);
		int totalSum = getTotalSum(treeNode);

		while(children != null) {

			rootNode.setElement("Number of descendants: " + totalDescendants + "; Sum of descendants: " + totalSum);

			TreeNode<String> nextNode = getStats(children.getElement());
			rootNode.addChild(nextNode);
			nextNode.setParent(rootNode);

			children = children.getNext();
		}
		if(children == null) {
			rootNode.setElement("Number of descendants: " + totalDescendants + "; Sum of descendants: " + totalSum);
		}
		return rootNode;
	}

	public int getTotalDescendants(TreeNode<Integer> treeRoot) {
		int counter = 1;
		if(treeRoot == null) {
			counter = 0;
		}
		SLLNode<TreeNode<Integer>> children = treeRoot.getChildren();

		while(children != null) {
			counter = counter + getTotalDescendants(children.getElement());
			children = children.getNext();
		}
		return counter;
	}

	public int getTotalSum(TreeNode<Integer> treeRoot) {

		int counter = treeRoot.getElement();
		SLLNode<TreeNode<Integer>> children = treeRoot.getChildren();

		while(children != null) {
			counter = counter + getTotalSum(children.getElement());
			children = children.getNext();
		}
		return counter;
	}
}
