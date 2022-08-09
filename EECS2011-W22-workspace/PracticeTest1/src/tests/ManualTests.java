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

public class ManualTests {
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
	}
	
}