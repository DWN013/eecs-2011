package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import model.*;

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
	public void test_reverseOf_string_list_1() {
		ListUtilities<String> util = new ListUtilities<>();
		
		Node<String> input = null; // empty chain
		Node<String> output = util.reverseOf(input);
		assertNull(output);
	}
	
	@Test
	public void test_reverseOf_int_list_1() {
		ListUtilities<Integer> util = new ListUtilities<>();
		
		Node<Integer> input = null; // empty chain
		Node<Integer> output = util.reverseOf(input);
		assertNull(output);
	}
	
	@Test
	public void test_reverseOf_string_list_2() {
		ListUtilities<String> util = new ListUtilities<>();
		
		Node<String> input = new Node<>("Alan", new Node<>("Mark", new Node<>("Tom", null)));
		// Return a separate chain of nodes reversing the order of that in the input chain. 
		Node<String> output = util.reverseOf(input);
		
		assertEquals("Tom", output.getElement());
		assertEquals("Mark", output.getNext().getElement());
		assertEquals("Alan", output.getNext().getNext().getElement());
		assertNull(output.getNext().getNext().getNext());
		
		assertTrue(noAliasing(input, output));
	}
	
	@Test
	public void test_reverseOf_int_list_2() {
		ListUtilities<Integer> util = new ListUtilities<>();
		
		Node<Integer> input = new Node<>(46, new Node<>(23, new Node<>(68, null)));
		// Return a separate chain of nodes reversing the order of that in the input chain. 
		Node<Integer> output = util.reverseOf(input);
		
		assertTrue(68 == output.getElement());
		assertTrue(23 == output.getNext().getElement());
		assertTrue(46 == output.getNext().getNext().getElement());
		assertNull(output.getNext().getNext().getNext());
		
		assertTrue(noAliasing(input, output));
	}
	
	@Test
	public void test_copyOf_string_list_1() {
		ListUtilities<String> util = new ListUtilities<>();
		
		Node<String> input = null; // empty chain
		Node<String> output = util.copyOf(input);
		assertNull(output);
	}
	
	@Test
	public void test_copyOf_int_list_1() {
		ListUtilities<Integer> util = new ListUtilities<>();
		
		Node<Integer> input = null; // empty chain
		Node<Integer> output = util.copyOf(input);
		assertNull(output);
	}
	
	@Test
	public void test_copyOf_string_list_2() {
		ListUtilities<String> util = new ListUtilities<>();
		
		Node<String> input = new Node<>("Alan", new Node<>("Mark", new Node<>("Tom", null)));
		// Return a separate chain of nodes maintaining the order of that in the input chain. 
		Node<String> output = util.copyOf(input);
		
		assertEquals("Alan", output.getElement());
		assertEquals("Mark", output.getNext().getElement());
		assertEquals("Tom", output.getNext().getNext().getElement());
		assertNull(output.getNext().getNext().getNext());
		
		assertTrue(noAliasing(input, output));
	}
	
	@Test
	public void test_copyOf_int_list_2() {
		ListUtilities<Integer> util = new ListUtilities<>();
		
		Node<Integer> input = new Node<>(46, new Node<>(23, new Node<>(68, null)));
		// Return a separate chain of nodes maintaining the order of that in the input chain. 
		Node<Integer> output = util.copyOf(input);
		
		assertTrue(46 == output.getElement());
		assertTrue(23 == output.getNext().getElement());
		assertTrue(68 == output.getNext().getNext().getElement());
		assertNull(output.getNext().getNext().getNext());
		
		assertTrue(noAliasing(input, output));
	} 
	
	@Test
	public void test_removeNthFromEnd_string_list_1() {
		ListUtilities<String> util = new ListUtilities<>();
		
		Node<String> input = 
			new Node<String>("a", 
			new Node<String>("b", 
			new Node<String>("c", 
			new Node<String>("d", 
			new Node<String>("e", null)))));
		
		/*
		 * Remove the last n^th node from the list (assuming that n <= size of the chain).
		 * In the case below, remove the 2nd last node from the list.
		 * No new list should be created.  
		 */
		Node<String> output = util.removeNthFromEnd(input, 2);
		
		assertTrue(input == output);
		assertEquals("a", output.getElement());
		assertEquals("b", output.getNext().getElement());
		assertEquals("c", output.getNext().getNext().getElement());
		assertEquals("e", output.getNext().getNext().getNext().getElement());
	}
	
	@Test
	public void test_removeNthFromEnd_int_list_1() {
		ListUtilities<Integer> util = new ListUtilities<>();
		
		Node<Integer> input = 
			new Node<Integer>(1, 
			new Node<Integer>(2, 
			new Node<Integer>(3, 
			new Node<Integer>(4, 
			new Node<Integer>(5, null)))));
		
		/*
		 * Remove the last n^th node from the list (assuming that n <= size of the chain).
		 * In the case below, remove the 2nd last node from the list.
		 * No new list should be created.  
		 */
		Node<Integer> output = util.removeNthFromEnd(input, 2);
		
		assertTrue(input == output);
		assertTrue(output.getElement() == 1);
		assertTrue(output.getNext().getElement() == 2);
		assertTrue(output.getNext().getNext().getElement() == 3);
		assertTrue(output.getNext().getNext().getNext().getElement() == 5);
	}
	
	@Test
	public void test_removeNthFromEnd_string_list_2() {
		ListUtilities<String> util = new ListUtilities<>();
		
		Node<String> input = 
			new Node<String>("a", 
			new Node<String>("b", 
			new Node<String>("c", 
			new Node<String>("d", 
			new Node<String>("e", null)))));
		
		/*
		 * Remove the last n^th node from the list (assuming that n <= size of the chain).
		 * In the case below, remove the 5th last node (i.e., the first node) from the list.
		 * No new list should be created.  
		 */
		Node<String> output = util.removeNthFromEnd(input, 5);
		
		assertEquals("b", output.getElement());
		assertEquals("c", output.getNext().getElement());
		assertEquals("d", output.getNext().getNext().getElement());
		assertEquals("e", output.getNext().getNext().getNext().getElement());
	}
	
	@Test
	public void test_removeNthFromEnd_int_list_2() {
		ListUtilities<Integer> util = new ListUtilities<>();
		
		Node<Integer> input = 
			new Node<Integer>(1, 
			new Node<Integer>(2, 
			new Node<Integer>(3, 
			new Node<Integer>(4, 
			new Node<Integer>(5, null)))));
		
		/*
		 * Remove the last n^th node from the list (assuming that n <= size of the chain).
		 * In the case below, remove the 5th last node (i.e., the first node) from the list.
		 * No new list should be created.  
		 */
		Node<Integer> output = util.removeNthFromEnd(input, 5);
		
		assertTrue(output.getElement() == 2);
		assertTrue(output.getNext().getElement() == 3);
		assertTrue(output.getNext().getNext().getElement() == 4);
		assertTrue(output.getNext().getNext().getNext().getElement() == 5);
	}
	
	@Test
	public void test_removeNthFromEnd_string_list_3() {
		ListUtilities<String> util = new ListUtilities<>();
		
		Node<String> input = new Node<>("a", null);
		
		/*
		 * The input chain might become empty after the removal.
		 */
		Node<String> output = util.removeNthFromEnd(input, 1);
		
		assertTrue(output == null); 
	}
	
	@Test
	public void test_removeNthFromEnd_int_list_3() {
		ListUtilities<Integer> util = new ListUtilities<>();
		
		Node<Integer> input = new Node<>(1, null);
		
		/*
		 * The input chain might become empty after the removal.
		 */
		Node<Integer> output = util.removeNthFromEnd(input, 1);
		
		assertTrue(output == null); 
	}
	
	/*
	 * A generic helper method used by some JUnit tests methods.
	 * This method makes sure that the two chains of nodes, starting at `n1` and `n2`,
	 * 	do not overlap in their node references,
	 * i.e., The reference of each node in chain 1 (starting at `n1`)
	 * 			is not equal to the reference of any node in chain 2 (starting at `n2`).
	 */
	private <E> boolean noAliasing(Node<E> n1, Node<E> n2) {
		Node<E> current1 = n1;
		Node<E> current2 = n2;
		boolean found = false;
		while(current1 != null && !found) {
			while(current2 != null && !found) {
				found = current1 == current2;
				current2 = current2.getNext();
			}
			current1 = current1.getNext();
			current2 = n2;
		}
		return !found;
	}
}