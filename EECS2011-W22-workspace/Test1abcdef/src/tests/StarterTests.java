package tests;

import static org.junit.Assert.*;
import org.junit.Test;

/*
 * Study carefully the test methods below. They suggest:
 * 	- the required class(es) and method(s) to be implement in the `model` package
 * 	- how the required class(es) and method(s) should be implemented
 * 
 * Requirements:
 * 	+ Do not create any new class that is not required by the starter tests.
 *   
 * 	+ Any classes you create must reside in the `model` package and be imported properly.
 * 		For example, creating a new class `Foo` in the `model` package should result in:
 * 			import model.Foo;
 * 
 * 	+ For this test, you should not need to declare attributes. 
 * 		But if you really want to, all attributes you declare in the model classes must be private.
 * 
 * 	+ If necessary, you may define private helper methods. 
 */

public class StarterTests {
	/* 
	 * Programming Requirements:
	 * 
	 * 	- This test focuses on the manipulation of singly-linked nodes.
	 * 		Therefore, you are forbidden to use primitive arrays (e.g., Integer[], int[], String[]) 
	 * 		for declaring attributes or local variables.
	 * 	- In addition, any use of a Java library class or method is also forbidden 
	 * 		(that is, use selections and loops to build your solution from scratch instead):
	 * 	- Here are some examples of forbidden classes/methods: 
	 * 		- Arrays class (e.g., Arrays.copyOf)
	 * 		- System class (e.g., System.arrayCopy)
	 * 		- ArrayList class
	 * 		- String class (e.g., substring).
	 * 	- The use of some library classes does not require an import statement, 
	 * 		but these classes are also forbidden to be used.
	 * 	- Here are the exceptions (library methods which you are allowed to use if needed):
	 * 		- String class (equals, format, length)
	 * 
	 * Violating the above programming requirements will result in a penalty (see the test guide for details). 
	 */ 

	@Test
	public void test0() {
		ListUtilities<String> util = new ListUtilities<>();
		Node<String> n4 = new Node<>("Lists", null);
		Node<String> n3 = new Node<>("Linked", n4);
		Node<String> n2 = new Node<>("Love", n3);
		Node<String> n1 = new Node<>("I", n2);

		/*
		 * For this method, the inputs are:	 
		 *	- `n1`: the head of a non-empty chain of singly-linked nodes 
		 *	- `n`: a non-negative integer value 
		 *
		 * Assumptions:
		 * 	- Input `n1` is not null.
		 * 	- Input integer `n` is non-negative (>= 0) and may be arbitrarily large.
		 *  
		 * What does the method do?
		 *  - Return the head node of a chain whose nodes correspond to those in the input chain by 
		 *  	shifting every node to the right by `n` positions. 
		 *  - The shifts are ***circular***: 
		 *  	any nodes that would "go off the boundary" are 
		 *  	wrapped around to the beginning of the chain.
		 *  
		 * Requirements:
		 * 	- References of the returned chain of nodes should be the same as
		 * 		those contained in the input chain, except that their order may be re-arranged.
		 * 	  That is, your implemented algorithm should not create new nodes.   
		 */
		Node<String> output = util.task(n1, 0); 
		assertTrue(output == n1);
		assertTrue(output.getNext() == n2);
		assertTrue(output.getNext().getNext() == n3);
		assertTrue(output.getNext().getNext().getNext() == n4);
		assertNull(output.getNext().getNext().getNext().getNext());

		assertTrue(output.getElement().equals("I"));
		assertTrue(output.getNext().getElement().equals("Love"));
		assertTrue(output.getNext().getNext().getElement().equals("Linked"));
		assertTrue(output.getNext().getNext().getNext().getElement().equals("Lists"));
	}

	@Test
	public void test1() {
		ListUtilities<String> util = new ListUtilities<>();
		Node<String> n4 = new Node<>("Lists", null);
		Node<String> n3 = new Node<>("Linked", n4);
		Node<String> n2 = new Node<>("Love", n3);
		Node<String> n1 = new Node<>("I", n2);

		/*
		 * See the above description of the method. 
		 */

		Node<String> output = util.task(n1, 1); 
		assertTrue(output == n4);
		assertTrue(output.getNext() == n1);
		assertTrue(output.getNext().getNext() == n2);
		assertTrue(output.getNext().getNext().getNext() == n3);
		assertNull(output.getNext().getNext().getNext().getNext());

		assertTrue(output.getElement().equals("Lists"));
		assertTrue(output.getNext().getElement().equals("I"));
		assertTrue(output.getNext().getNext().getElement().equals("Love"));
		assertTrue(output.getNext().getNext().getNext().getElement().equals("Linked"));
	}

	@Test
	public void test2() {
		ListUtilities<String> util = new ListUtilities<>();
		Node<String> n4 = new Node<>("Lists", null);
		Node<String> n3 = new Node<>("Linked", n4);
		Node<String> n2 = new Node<>("Love", n3);
		Node<String> n1 = new Node<>("I", n2);

		/*
		 * See the above description of the method. 
		 */

		Node<String> output = util.task(n1, 2); 
		assertTrue(output == n3);
		assertTrue(output.getNext() == n4);
		assertTrue(output.getNext().getNext() == n1);
		assertTrue(output.getNext().getNext().getNext() == n2);
		assertNull(output.getNext().getNext().getNext().getNext());

		assertTrue(output.getElement().equals("Linked"));
		assertTrue(output.getNext().getElement().equals("Lists"));
		assertTrue(output.getNext().getNext().getElement().equals("I"));
		assertTrue(output.getNext().getNext().getNext().getElement().equals("Love"));
	}

	@Test
	public void test3() {
		ListUtilities<String> util = new ListUtilities<>();
		Node<String> n4 = new Node<>("Lists", null);
		Node<String> n3 = new Node<>("Linked", n4);
		Node<String> n2 = new Node<>("Love", n3);
		Node<String> n1 = new Node<>("I", n2);

		/*
		 * See the above description of the method. 
		 */

		Node<String> output = util.task(n1, 3); 
		assertTrue(output == n2);
		assertTrue(output.getNext() == n3);
		assertTrue(output.getNext().getNext() == n4);
		assertTrue(output.getNext().getNext().getNext() == n1);
		assertNull(output.getNext().getNext().getNext().getNext());

		assertTrue(output.getElement().equals("Love"));
		assertTrue(output.getNext().getElement().equals("Linked"));
		assertTrue(output.getNext().getNext().getElement().equals("Lists"));
		assertTrue(output.getNext().getNext().getNext().getElement().equals("I"));
	}

	@Test
	public void test4() {
		ListUtilities<String> util = new ListUtilities<>();
		Node<String> n4 = new Node<>("Lists", null);
		Node<String> n3 = new Node<>("Linked", n4);
		Node<String> n2 = new Node<>("Love", n3);
		Node<String> n1 = new Node<>("I", n2);

		/*
		 * See the above description of the method. 
		 */

		Node<String> output = util.task(n1, 4); 
		assertTrue(output == n1);
		assertTrue(output.getNext() == n2);
		assertTrue(output.getNext().getNext() == n3);
		assertTrue(output.getNext().getNext().getNext() == n4);
		assertNull(output.getNext().getNext().getNext().getNext());

		assertTrue(output.getElement().equals("I"));
		assertTrue(output.getNext().getElement().equals("Love"));
		assertTrue(output.getNext().getNext().getElement().equals("Linked"));
		assertTrue(output.getNext().getNext().getNext().getElement().equals("Lists"));
	}

	@Test
	public void test5() {
		ListUtilities<String> util = new ListUtilities<>();
		Node<String> n4 = new Node<>("Lists", null);
		Node<String> n3 = new Node<>("Linked", n4);
		Node<String> n2 = new Node<>("Love", n3);
		Node<String> n1 = new Node<>("I", n2);

		/*
		 * See the above description of the method. 
		 */

		Node<String> output = util.task(n1, 5); 
		assertTrue(output == n4);
		assertTrue(output.getNext() == n1);
		assertTrue(output.getNext().getNext() == n2);
		assertTrue(output.getNext().getNext().getNext() == n3);
		assertNull(output.getNext().getNext().getNext().getNext());

		assertTrue(output.getElement().equals("Lists"));
		assertTrue(output.getNext().getElement().equals("I"));
		assertTrue(output.getNext().getNext().getElement().equals("Love"));
		assertTrue(output.getNext().getNext().getNext().getElement().equals("Linked"));
	}
	
	/*
	 * Jackie's suggestions:
	 * 	+ Test more input values of your implemented methods, as they will be graded by additional tests.
	 * 	+ The given starter tests only test string values. Try integer values too.
	 */
}