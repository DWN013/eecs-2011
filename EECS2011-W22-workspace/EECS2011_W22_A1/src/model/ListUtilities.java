package model;

import tests.Node;

public class ListUtilities {

	public ListUtilities() {

	}


	public Node<String> getAllPrefixes(Node<Integer> node, int minAmount, int maxAmount) {

		//Creates a starting temp string (for example, the number "23")
		String temp = "" + node.getElement();
		//Counter to keep track of position in the node
		int counter = 1;

		//Creates a node variable for our "next" node
		Node<String> next = null;
		//Checks our given Singly Linked List (node) for what the next element is from out first node
		Node<Integer> nextInputNode = node.getNext();

		if(counter != minAmount) {
			for(int i = counter; i < minAmount; i++) {
				temp += ", " + nextInputNode.getElement();
				nextInputNode = nextInputNode.getNext();
				counter++;
			}
		}

		Node<String> headNode = new Node<String>("[" + temp + "]", null);
		//creates a head node (or, in this case the starting node for our output variable)
		//Meaning our output variable (in the junit tests) will look like this:
		// Node<>(["23"], Node<>(["23, 46"], Node<>(["23, 46, 19"], Node<>(["23, 46, 19, -9"], ))))
		//keep in mind that each Node<> after the comma of the number between the brackets
		//is essentially just pointing to "next" (node) rather than being a list per se.

		//while loop runs while the next node is not a null result
		while (nextInputNode != null && counter != maxAmount) {

			counter++;
			//sets adds to temp string if next node from our initial node is not null
			temp += ", " + nextInputNode.getElement();
			//Creates new node
			Node<String> tempNodeNext = new Node<String>("[" + temp + "]", null);
			if(headNode.getNext() == null) {
				headNode.setNext(tempNodeNext);
			}
			if(next != null) {
				next.setNext(tempNodeNext);
			}
			next = tempNodeNext;
			nextInputNode = nextInputNode.getNext();
		}

		return headNode;
	}

	public Node<Integer> getMergedChain(Node<Integer> firstNode, Node<Integer> lastNode) {

		//check if our elements are null and copy elements from SLL if only one is null
		if(firstNode == null && lastNode == null) {
			return null;
		}

		Node<Integer> temp1 = null;

		if (firstNode == null || lastNode == null) {

			if (firstNode == null) {
				temp1 = lastNode;
			} else {
				temp1 = firstNode;
			}

			Node<Integer> newNode = new Node<Integer>(temp1.getElement(), null);
			Node<Integer> next = null;

			temp1 = temp1.getNext();

			while (temp1 != null) {

				int val = temp1.getElement();

				Node<Integer> temp2 = new Node<Integer>(val, null);
				if (newNode.getNext() == null) {
					newNode.setNext(temp2);
				}

				if (next != null) {
					next.setNext(temp2);
				}

				next = temp2;
				temp1 = temp1.getNext();
			}

			return newNode;
		}

		//create initial elements
		Node<Integer> nextInputNode1 = firstNode;
		Node<Integer> nextInputNode2 = lastNode;

		int temp = 0;

		Node<Integer> headNode = new Node<Integer>(null, null);
		Node<Integer> next = null;

		if(nextInputNode1.getElement() <= nextInputNode2.getElement()) {
			headNode.setElement(nextInputNode1.getElement());
			nextInputNode1 = nextInputNode1.getNext();
		}
		else{	
			headNode.setElement(nextInputNode2.getElement());
			nextInputNode2 = nextInputNode2.getNext();
		}

		//may need to remove or statement
		while (nextInputNode1 != null || nextInputNode2 != null) {

			if(nextInputNode2 == null || nextInputNode1.getElement() <= nextInputNode2.getElement()) {

				temp = nextInputNode1.getElement();
				nextInputNode1 = nextInputNode1.getNext();
				if (nextInputNode1 != null) {
				}
			}
			else if (nextInputNode2 != null){	
				temp = nextInputNode2.getElement();
				nextInputNode2 = nextInputNode2.getNext();
				if (nextInputNode2 != null) {
				}
			}

			Node<Integer> tempNodeNext = new Node<Integer>(temp, null);	

			if(headNode.getNext() == null) {
				headNode.setNext(tempNodeNext);
			}
			if(next != null) {
				next.setNext(tempNodeNext);
			}

			next = tempNodeNext;
		}

		return headNode;
	}


	public Node<String> getGroupedStrings(Node<String> inputNode, int firstLength, int secondLength){

		if(inputNode == null) {
			return null;
		}

		Node<String> next = null;

		Node<String> inputNodeTracker = inputNode;

		Node<String> stringHeadNode = new Node<String>(null, null);
		//Node<String> stringNodeNext = new Node<String>(null, null);

		while(inputNodeTracker != null) {
			if(inputNodeTracker.getElement().length() < firstLength) {
				//check if our firstLength is greater than the length of each element
				if(stringHeadNode.getElement() == null) {
					stringHeadNode.setElement(inputNodeTracker.getElement());
				}
				else {
					//keep going until end of list
					Node<String>temp = new Node<String>(inputNodeTracker.getElement(), null);


					if(stringHeadNode.getNext() == null) {
						stringHeadNode.setNext(temp);
					}
					if(next != null) {
						next.setNext(temp); //this one creates the problem
					}
					next = temp;
				}
			}
			inputNodeTracker = inputNodeTracker.getNext();
		}

		inputNodeTracker = inputNode;

		while(inputNodeTracker != null) {
			if(inputNodeTracker.getElement().length() >= firstLength && inputNodeTracker.getElement().length() < secondLength) {
				//check if our firstLength is greater than the length of each element
				if(stringHeadNode.getElement() == null) {
					stringHeadNode.setElement(inputNodeTracker.getElement());
				}
				else {
					//keep going until end of list
					Node<String>temp = new Node<String>(inputNodeTracker.getElement(), null);


					if(stringHeadNode.getNext() == null) {
						stringHeadNode.setNext(temp);
					}
					if(next != null) {
						next.setNext(temp); //this one creates the problem
					}
					next = temp;
				}
			}
			inputNodeTracker = inputNodeTracker.getNext();
		}

		inputNodeTracker = inputNode;

		while(inputNodeTracker != null) {
			if(inputNodeTracker.getElement().length() >= secondLength) {
				//check if our firstLength is greater than the length of each element
				if(stringHeadNode.getElement() == null) {
					stringHeadNode.setElement(inputNodeTracker.getElement());
				}
				else {
					//keep going until end of list
					Node<String>temp = new Node<String>(inputNodeTracker.getElement(), null);


					if(stringHeadNode.getNext() == null) {
						stringHeadNode.setNext(temp);
					}
					if(next != null) {
						next.setNext(temp); //this one creates the problem
					}
					next = temp;
				}
			}
			inputNodeTracker = inputNodeTracker.getNext();
		}
		return stringHeadNode;
	}



	public Node<Integer> getInterleavedArithmeticFibonacciSequences(int startNum, int difference, int arrSize, int fibSize){
		//   Start with 1.then 2.
		//1. calculate the arithmetic seq.										 
		//2. calc. fib. sequence
		//3. need a counter for how many arr. seq and fib. seq. added            
		//4. need a way to track which one is gonna be added (fib. or arr.)
		if(arrSize == 0 && fibSize == 0) {
			return null;
		}

		//Every variable associated with Arithmetic Sequence
		int arrCounter = 0;

		//Every variable associated with Arithmetic Sequence
		int fibCounter = 0;
		int number1 = 0;
		int number2 = 1;

		//Generic Variables
		Node<Integer> headNode = new Node<Integer>(null, null);
		Node<Integer> next = null;

		for(int i = 0; i < (arrSize + fibSize); i++) {
			Node<Integer> nextNode = new Node<Integer>(null, null);

			if(arrSize > 0 && arrCounter != arrSize) {
				if(headNode.getElement() == null) {
					headNode.setElement(getArrSequenceNum(startNum, difference, arrCounter));
					arrCounter++;
				}
				else {
					if(headNode.getNext() == null) {
						nextNode.setElement(getArrSequenceNum(startNum, difference, arrCounter));
						headNode.setNext(nextNode);
					}
					else {
						nextNode.setElement(getArrSequenceNum(startNum, difference, arrCounter));
						next.setNext(nextNode);
					}
					next = nextNode;
					arrCounter++;
				}
			}
			
			//resets nextNode
			nextNode = new Node<Integer>(null, null);
			
			if(fibSize > 0 && fibCounter != fibSize) {
				int tempFibResult;
				if(fibCounter == 0) {
					if(headNode.getElement() == null) {
						headNode.setElement(1);
					}
					else if (headNode.getNext() == null){
						nextNode.setElement(1);
						headNode.setNext(nextNode);
						//next = nextNode;
					}
					else {
						nextNode.setElement(1);
						next.setNext(nextNode);
						//next = nextNode;
					}
					next = nextNode;
					fibCounter++;
				}
				else {
					tempFibResult = getFibSequenceNum(number1, number2);
					if (headNode.getNext() == null){
						nextNode.setElement(tempFibResult);
						headNode.setNext(nextNode);
					}
					else {
						nextNode.setElement(tempFibResult);
					}
					next.setNext(nextNode);
					
					number1 = number2;
					number2 = tempFibResult;
					next = nextNode;
					fibCounter++;
				}
			}
		}


		return headNode;
	}

	public int getArrSequenceNum(int startNum, int commonDif, int counter) {
		//This method 
		int result = startNum + (commonDif*counter);
		return result;
	}

	public int getFibSequenceNum(int fibNum1, int fibNum2) {
		int result = fibNum1 + fibNum2;
		return result;
	}

}
