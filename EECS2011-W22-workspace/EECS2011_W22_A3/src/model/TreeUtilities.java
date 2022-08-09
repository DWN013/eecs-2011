package model;

import tests.*;

public class TreeUtilities {

	public TreeNode<Expression> getInfixTree(SLLNode<Expression> postfixExpression){
		//Initialize variables to work with
		SLLNode<Expression> workingNumberSLL = new SLLNode<Expression>(null, null);
		SLLNode<TreeNode<Expression>> workingTreeSLL = new SLLNode<TreeNode<Expression>>(null, null);
		SLLNode<Expression> currentElement = postfixExpression;
		SLLNode<Expression> prevElement = postfixExpression;
		TreeNode<Expression> root = new TreeNode<>(null);
		
		if(currentElement.getElement() instanceof Operand) {
			workingNumberSLL = new SLLNode<Expression>((Operand)currentElement.getElement(), null);
			currentElement = currentElement.getNext();
		}
		if(currentElement != null) {

			while(currentElement != null) {
				if(currentElement.getElement() instanceof Operand) {
					push(workingNumberSLL, (Operand)currentElement.getElement());
				}
				if(currentElement.getElement() instanceof Operator) {
					TreeNode<Expression> leftSide = new TreeNode<>(pop(workingNumberSLL));
					TreeNode<Expression> rightSide = new TreeNode<>(pop(workingNumberSLL));
					if (leftSide.getElement() == null && rightSide.getElement() == null) {
						TreeNode<Expression> tempRootNode = new TreeNode<>(null);
						TreeNode<Expression> tempLeftSide = popTree(workingTreeSLL);;
						TreeNode<Expression> tempRightSide = popTree(workingTreeSLL);;
						tempRootNode.setElement((Operator)currentElement.getElement());
						
						if (tempRightSide != null) {
							tempRootNode.addChild(tempRightSide);
							tempRightSide.setParent(tempRootNode);							
						}		
						tempRootNode.addChild(tempLeftSide);
						tempLeftSide.setParent(tempRootNode);
						
						root = tempRootNode;
					} 

					if (leftSide.getElement() != null && rightSide.getElement() == null) {
						TreeNode<Expression> tempRootNode = new TreeNode<>(null);
						TreeNode<Expression> tempRightSide = popTree(workingTreeSLL);
						tempRootNode.setElement((Operator)currentElement.getElement());
						
						if (prevElement.getElement() instanceof Operator) {
							tempRootNode.addChild(leftSide);
							tempRootNode.addChild(tempRightSide);	
						} else {
							tempRootNode.addChild(tempRightSide);	
							tempRootNode.addChild(leftSide);
						}
					
						leftSide.setParent(tempRootNode);
						tempRightSide.setParent(tempRootNode);
						pushTree(workingTreeSLL, tempRootNode);
						root = tempRootNode;
					}

					if (leftSide.getElement() != null && rightSide.getElement() != null) {
						// push tempRootNode to a stack
						TreeNode<Expression> tempRootNode = new TreeNode<>(null);
						//Tree structure when 2 sides are numbers is built here
						tempRootNode.setElement((Operator)currentElement.getElement());
						tempRootNode.addChild(rightSide);
						tempRootNode.addChild(leftSide);
						leftSide.setParent(tempRootNode);
						rightSide.setParent(tempRootNode);
						//push tempRootNode to a stack
						pushTree(workingTreeSLL, tempRootNode);
						root = tempRootNode;
					}
				}
				prevElement = currentElement;
				currentElement = currentElement.getNext();
			}
		}
		else {
			root = new TreeNode<>(workingNumberSLL.getElement());
		}
		return root;
	}

	public String getInfixSequence(SLLNode<Expression> input) {

		TreeNode<Expression> structuredTree = getInfixTree(input);
		String outputResult = "";

		if (structuredTree.getElement() instanceof Operand) {
			return "" + ((Operand) structuredTree.getElement()).getValue();
		}

		SLLNode<TreeNode<Expression>> children = structuredTree.getChildren();

		while (children != null) {
			TreeNode<Expression> treeExpression = children.getElement();
			Expression expressionElement = treeExpression.getElement();
			if (expressionElement instanceof Operator) {
				SLLNode<TreeNode<Expression>> childrenOfChildren = treeExpression.getChildren();
				SLLNode<Expression> childrenCombined = new SLLNode<>(childrenOfChildren.getElement().getElement(),
				new SLLNode<>(childrenOfChildren.getNext().getElement().getElement(), new SLLNode<>(expressionElement, null)));

				if (children.getNext() != null && children.getNext().getElement().getElement() instanceof Operator) {
					outputResult += "(";
				}

				outputResult += getInfixSequence(childrenCombined);

				if (children.getNext() != null) {
					outputResult += " " + ((Operator) structuredTree.getElement()).getOperator() + " ";
				} else {
					outputResult += ")";
				}
				children = children.getNext();
			} else if (expressionElement instanceof Operand) {

				String next = null;
				if (children.getNext() != null) {
					if (children.getNext().getElement().getElement() instanceof Operator) {
						SLLNode<TreeNode<Expression>> childrenOfChildren = children.getNext().getElement().getChildren();
						SLLNode<Expression> childrenCombined = new SLLNode<>(
								childrenOfChildren.getElement().getElement(),
								new SLLNode<>(childrenOfChildren.getNext().getElement().getElement(),
										new SLLNode<>(children.getNext().getElement().getElement(), null)));
						next = " " + ((Operator) structuredTree.getElement()).getOperator() + " " + getInfixSequence(childrenCombined);

					} else {
						next = " " + ((Operator) structuredTree.getElement()).getOperator() + " " + ((Operand) children.getNext().getElement().getElement()).getValue();
					}
				} else {
					outputResult = "(" + outputResult;
					outputResult += ((Operand) expressionElement).getValue() + ")";
				}
				if (next != null) {
					outputResult += "(" + ((Operand) expressionElement).getValue() + next + ")";
				}
				children = children.getNext();
				if (children != null && children.getNext() != null) {
					children = children.getNext();
				} else {
					children = null;
				}
			}
		}
		return outputResult;
	}
	
	public Expression pop(SLLNode<Expression> fullList) {

		SLLNode<Expression> prevNode = fullList;
		SLLNode<Expression> currentNode = fullList;
		while (currentNode.getNext() != null) {
			prevNode = currentNode;
			currentNode = currentNode.getNext();
		}

		if (currentNode == fullList) {
			Expression e = fullList.getElement();
			fullList.setElement(null);	
			return e;
		}
		
		prevNode.setNext(null);
		return currentNode.getElement();
	}

	public void push(SLLNode<Expression> prevNode, Expression element) {
		//Adds to end of linked list
		SLLNode<Expression> newTempNode = new SLLNode<Expression>(element, null);
		
		if(prevNode.getElement() == null) {
			prevNode.setElement(element);
			//prevNode.setNext(newTempNode);
		}
		else if(prevNode.getNext() == null){
			prevNode.setNext(newTempNode);
		}
		else {
			SLLNode<Expression> temp = prevNode;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			if(temp != null) {
				temp.setNext(newTempNode);
			}
		}
	}	
	
	public TreeNode<Expression> popTree(SLLNode<TreeNode<Expression>> treeNode) {
		//Expression resultNum;
		SLLNode<TreeNode<Expression>> prevNode = treeNode;
		SLLNode<TreeNode<Expression>> currentNode = treeNode;
		while(currentNode.getNext() != null) {
			prevNode = currentNode;
			currentNode = currentNode.getNext();
		}
		
		if (currentNode == treeNode) {
			TreeNode<Expression> e = treeNode.getElement();
			treeNode.setElement(null);	
			return e;
		}
		
		//Returns the Operand at the top of the stack
		prevNode.setNext(null);
		return currentNode.getElement();
	}
	public void pushTree(SLLNode<TreeNode<Expression>> prevSLLTreeNode, TreeNode<Expression> element) {
		//Adds to end of linked list
		SLLNode<TreeNode<Expression>> newTempNode = new SLLNode<TreeNode<Expression>>(element, null);
		if(prevSLLTreeNode.getElement() == null) {
			prevSLLTreeNode.setElement(element);
		}
		else if(prevSLLTreeNode.getNext() == null){
			prevSLLTreeNode.setNext(newTempNode);
		}
		else {
			SLLNode<TreeNode<Expression>> temp = prevSLLTreeNode;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			if(temp != null) {
				temp.setNext(newTempNode);
			}
		}
	}
}
