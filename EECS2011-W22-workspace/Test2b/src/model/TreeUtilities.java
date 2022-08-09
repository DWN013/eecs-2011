package model;

import tests.SLLNode;
import tests.TreeNode;

public class TreeUtilities<E> {

	public TreeNode<E> task2(TreeNode<E> root){

		TreeNode<E> rootNode = new TreeNode<>(root.getElement());
		SLLNode<TreeNode<E>> reverseList = reversedOfTreeChildren(root);

		while (reverseList != null) {
			TreeNode<E> cur = reverseList.getElement();
			TreeNode<E> temp = new TreeNode<E>(cur.getElement());

			if (cur.getChildren() != null) {
				TreeNode<E> temp1 = task2(cur);
				SLLNode<TreeNode<E>> childrenOfTemp1 = temp1.getChildren();

				while (childrenOfTemp1 != null) {
					TreeNode<E> temp2 = childrenOfTemp1.getElement();
					TreeNode<E> temp3 = new TreeNode<E>(temp2.getElement());

					temp.addChild(temp3);
					temp3.setParent(temp);
					childrenOfTemp1 = childrenOfTemp1.getNext();
				}
			}
			rootNode.addChild(temp);
			temp.setParent(rootNode);

			reverseList = reverseList.getNext();
		}
		return rootNode;
	}

	public SLLNode<TreeNode<E>> reversedOfTreeChildren(TreeNode<E> root) {

		SLLNode<TreeNode<E>> previous = null;
		SLLNode<TreeNode<E>> current = root.getChildren();
		SLLNode<TreeNode<E>> next = null;
		while (current != null) {
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}

		return previous;
	}
}