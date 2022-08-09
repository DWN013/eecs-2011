package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import model.TreeUtilities;

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
	public void test_copyOf_01() {
		TreeNode<String> n1 = new TreeNode<>("a");
		
		TreeUtilities<String> u = new TreeUtilities<>();
		
		/*
		 * Given a tree node `n`, 
		 * 	return a copy of the tree rooted at `n`. 
		 */
		TreeNode<String> copy = u.copyOf(n1);
		
		assertTrue(copy.getElement().equals("a"));
		assertNull(copy.getChildren());
		
		/* No aliasing of TreeNode objects */
		assertFalse(copy == n1);
	}
	
	@Test
	public void test_copyOf_02() {
		TreeNode<String> n1 = new TreeNode<>("a");
		TreeNode<String> n2 = new TreeNode<>("b");
		TreeNode<String> n3 = new TreeNode<>("c");
		
		n1.addChild(n2);
		n1.addChild(n3);
		n2.setParent(n1);
		n3.setParent(n1);
		
		TreeUtilities<String> u = new TreeUtilities<>();
		TreeNode<String> copy = u.copyOf(n1);
		
		TreeNode<String> child1Level1 = copy.getChildren().getElement();
		TreeNode<String> child2Level1 = copy.getChildren().getNext().getElement();
		assertNull(copy.getChildren().getNext().getNext());
		
		assertTrue(copy.getElement().equals("a"));
		assertTrue(child1Level1.getElement().equals("b"));
		assertTrue(child2Level1.getElement().equals("c"));
		
		assertTrue(child1Level1.getParent() == copy);
		assertTrue(child2Level1.getParent() == copy);
		
		/* No aliasing of TreeNode objects */
		assertFalse(copy == n1);
		assertFalse(child1Level1 == n2);
		assertFalse(child1Level1 == n3);
	}
	
	@Test
	public void test_copyOf_03() {
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
		TreeNode<String> copy = u.copyOf(n1);
		
		TreeNode<String> child1Level1 = copy.getChildren().getElement();
		TreeNode<String> child2Level1 = copy.getChildren().getNext().getElement();
		assertNull(copy.getChildren().getNext().getNext());
		TreeNode<String> child1Level2 = child1Level1.getChildren().getElement();
		TreeNode<String> child2Level2 = child1Level1.getChildren().getNext().getElement();
		assertNull(child1Level1.getChildren().getNext().getNext());
		TreeNode<String> child3Level2 = child2Level1.getChildren().getElement();
		TreeNode<String> child4Level2 = child2Level1.getChildren().getNext().getElement();
		assertNull(child2Level1.getChildren().getNext().getNext());
		
		assertTrue(copy.getElement().equals("a"));
		assertTrue(child1Level1.getElement().equals("b"));
		assertTrue(child2Level1.getElement().equals("c"));
		assertTrue(child1Level2.getElement().equals("d"));
		assertTrue(child2Level2.getElement().equals("e"));
		assertTrue(child3Level2.getElement().equals("f"));
		assertTrue(child4Level2.getElement().equals("g"));
		
		assertTrue(child1Level1.getParent() == copy);
		assertTrue(child2Level1.getParent() == copy);
		assertTrue(child1Level2.getParent() == child1Level1);
		assertTrue(child2Level2.getParent() == child1Level1);
		assertTrue(child3Level2.getParent() == child2Level1);
		assertTrue(child4Level2.getParent() == child2Level1);
		
		/* No aliasing of TreeNode objects */
		assertFalse(copy == n1);
		assertFalse(child1Level1 == n2);
		assertFalse(child1Level1 == n3);
		assertFalse(child1Level2 == n4);
		assertFalse(child1Level2 == n5);
		assertFalse(child3Level2 == n6);
		assertFalse(child4Level2 == n7);
	}
	
	@Test
	public void test_getPreOrderSeq_01() {
		TreeNode<String> n1 = new TreeNode<>("a");
		
		TreeUtilities<String> u = new TreeUtilities<>();
		
		/*
		 * Given a tree node `n`, 
		 * 	return the sequence of nodes resulted from performing a pre-order traversal on the tree rooted at `n`. 
		 */
		SLLNode<TreeNode<String>> seq = u.getPreOrderSeq(n1);
		
		assertTrue(seq.getElement() == n1);
	}
	
	@Test
	public void test_getPreOrderSeq_02() {
		TreeNode<String> n1 = new TreeNode<>("a");
		TreeNode<String> n2 = new TreeNode<>("b");
		TreeNode<String> n3 = new TreeNode<>("c");
		
		n1.addChild(n2);
		n1.addChild(n3);
		n2.setParent(n1);
		n3.setParent(n1);
		
		TreeUtilities<String> u = new TreeUtilities<>();
		SLLNode<TreeNode<String>> seq = u.getPreOrderSeq(n1);
		
		assertTrue(seq.getElement() == n1);
		assertTrue(seq.getNext().getElement() == n2);
		assertTrue(seq.getNext().getNext().getElement() == n3);
	}
	
	@Test
	public void test_getPreOrderSeq_03() {
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
		SLLNode<TreeNode<String>> seq = u.getPreOrderSeq(n1);
		
		assertTrue(seq.getElement() == n1);
		assertTrue(seq.getNext().getElement() == n2);
		assertTrue(seq.getNext().getNext().getElement() == n4);
		assertTrue(seq.getNext().getNext().getNext().getElement() == n5);
		assertTrue(seq.getNext().getNext().getNext().getNext().getElement() == n3);
		assertTrue(seq.getNext().getNext().getNext().getNext().getNext().getElement() == n6);
		assertTrue(seq.getNext().getNext().getNext().getNext().getNext().getNext().getElement() == n7);
	}
	
	/*
	 * Jackie's suggestion: 
	 * 	+ Your implemented method should be generic and able to handle different types (e.g., String, Integer).
	 * 	+ Write additional tests for more sophisticated tree structures. 
	 */
}