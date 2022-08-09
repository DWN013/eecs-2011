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
	public void test_task1_01() {
		TreeNode<String> n1 = new TreeNode<>("a");

		TreeUtilities<String> u = new TreeUtilities<>();

		/*
		 * Given a tree node `n` and an integer `d`, 
		 * 	return a list of copies of nodes at level `d`, arranged in the reverse order.
		 * Assume:
		 * 	+ Input node `n` is not null.
		 * 	+ The number of child nodes of each internal node is arbitrary (i.e., the input is a general tree).
		 * 	+ Input value `d` >= 0.
		 * 	+ When the value of `d` is larger than the height of the tree (meaning that no nodes are at Level `d`),
		 * 		then the returned list is null. 
		 */
		SLLNode<TreeNode<String>> list = u.task1(n1, 0); 
		assertTrue(list.getElement().getElement().equals("a"));
		assertNull(list.getNext()); 
		/* No aliasing of TreeNode objects */
		assertFalse(list.getElement() == n1);

		list = u.task1(n1, 1);
		assertNull(list);

		list = u.task1(n1, 2);
		assertNull(list);
	}

	@Test
	public void test_task1_02() {
		TreeNode<String> n1 = new TreeNode<>("a");
		TreeNode<String> n2 = new TreeNode<>("b");
		TreeNode<String> n3 = new TreeNode<>("c");

		n1.addChild(n2);
		n1.addChild(n3);
		n2.setParent(n1);
		n3.setParent(n1);

		TreeUtilities<String> u = new TreeUtilities<>();

		SLLNode<TreeNode<String>> list = u.task1(n1, 0);
		assertTrue(list.getElement().getElement().equals("a"));
		assertNull(list.getNext());
		/* No aliasing of TreeNode objects */
		assertFalse(list.getElement() == n1);

		list = u.task1(n1, 1);
		assertTrue(list.getElement().getElement().equals("c"));
		assertTrue(list.getNext().getElement().getElement().equals("b"));
		assertNull(list.getNext().getNext());
		/* No aliasing of TreeNode objects */
		assertFalse(list.getElement() == n3);
		assertFalse(list.getNext().getElement() == n2);

		list = u.task1(n1, 2);
		assertNull(list);
	}
	
	@Test
	public void test_task1_03() {
		TreeNode<String> n1 = new TreeNode<>("a");
		TreeNode<String> n2 = new TreeNode<>("b");
		TreeNode<String> n3 = new TreeNode<>("c");
		TreeNode<String> n4 = new TreeNode<>("d");
		TreeNode<String> n5 = new TreeNode<>("e");
		TreeNode<String> n6 = new TreeNode<>("f");
		TreeNode<String> n7 = new TreeNode<>("g");

		n1.addChild(n2);
		n1.addChild(n3);
		n2.setParent(n1);
		n3.setParent(n1);

		n2.addChild(n4);
		n2.addChild(n5);
		n4.setParent(n2);
		n5.setParent(n2);

		n3.addChild(n6);
		n3.addChild(n7);
		n6.setParent(n3);
		n7.setParent(n3);

		TreeUtilities<String> u = new TreeUtilities<>();

		SLLNode<TreeNode<String>> list = u.task1(n1, 0);
		assertTrue(list.getElement().getElement().equals("a"));
		assertNull(list.getNext());
		/* No aliasing of TreeNode objects */
		assertFalse(list.getElement() == n1);

		list = u.task1(n1, 1);
		assertTrue(list.getElement().getElement().equals("c"));
		assertTrue(list.getNext().getElement().getElement().equals("b"));
		assertNull(list.getNext().getNext());
		/* No aliasing of TreeNode objects */
		assertFalse(list.getElement() == n3);
		assertFalse(list.getNext().getElement() == n2);
		
		list = u.task1(n1, 2);
		assertTrue(list.getElement().getElement().equals("g"));
		assertTrue(list.getNext().getElement().getElement().equals("f"));
		assertTrue(list.getNext().getNext().getElement().getElement().equals("e"));
		assertTrue(list.getNext().getNext().getNext().getElement().getElement().equals("d"));
		assertNull(list.getNext().getNext().getNext().getNext());
		/* No aliasing of TreeNode objects */
		assertFalse(list.getElement() == n7);
		assertFalse(list.getNext().getElement() == n6);
		assertFalse(list.getNext().getNext().getElement() == n5);
		assertFalse(list.getNext().getNext().getNext().getElement() == n4);

		list = u.task1(n1, 3);
		assertNull(list);
	}

	/*
	 * There is only one problem for you to solve.
	 *  
	 * Jackie's suggestions:
	 * 	+ Your implemented method should be generic and able to handle different types (e.g., String, Integer).
	 * 	+ Write additional tests for more sophisticated tree structures. 
	 */
}