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
	public void test_task2_01() {
		TreeNode<String> n1 = new TreeNode<>("a");

		TreeUtilities<String> u = new TreeUtilities<>();

		/*
		 * Given a tree node `n`, 
		 * 	return a "mirror" of the tree. That is, between the input and output trees:
		 * 		+ Numbers of nodes at each level are the same.
		 * 		+ At each level, nodes in the output tree are copies of those in the input tree,
		 * 			except that the nodes are arranged in the reverse order.  
		 * Assume:
		 * 	+ Input node `n` is not null.
		 * 	+ The number of child nodes of each internal node is arbitrary (i.e., the input is a general tree). 
		 */
		TreeNode<String> rootOfMirror = u.task2(n1); 
		assertTrue(rootOfMirror.getElement().equals("a"));
		assertNull(rootOfMirror.getChildren()); 
		/* No aliasing of TreeNode objects */
		assertFalse(rootOfMirror == n1);
	}
	
	@Test
	public void test_task2_02() {
		TreeNode<String> n1 = new TreeNode<>("a");
		TreeNode<String> n2 = new TreeNode<>("b");
		TreeNode<String> n3 = new TreeNode<>("c");

		n1.addChild(n2);
		n1.addChild(n3);
		n2.setParent(n1);
		n3.setParent(n1);

		TreeUtilities<String> u = new TreeUtilities<>();
		TreeNode<String> rootOfMirror = u.task2(n1);
		
		TreeNode<String> child1Level1 = rootOfMirror.getChildren().getElement();
		TreeNode<String> child2Level1 = rootOfMirror.getChildren().getNext().getElement();
		assertNull(rootOfMirror.getChildren().getNext().getNext());
		
		assertTrue(rootOfMirror.getElement().equals("a"));
		assertTrue(child1Level1.getElement().equals("c"));
		assertTrue(child2Level1.getElement().equals("b"));
		
		assertTrue(child1Level1.getParent() == rootOfMirror);
		assertTrue(child2Level1.getParent() == rootOfMirror);
		
		/* No aliasing of TreeNode objects */
		assertFalse(rootOfMirror == n1);
		assertFalse(child1Level1 == n3);
		assertFalse(child1Level1 == n2);
	}
	
	@Test
	public void test_task2_03() {
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
		TreeNode<String> rootOfMirror = u.task2(n1);
		
		TreeNode<String> child1Level1 = rootOfMirror.getChildren().getElement();
		TreeNode<String> child2Level1 = rootOfMirror.getChildren().getNext().getElement();
		assertNull(rootOfMirror.getChildren().getNext().getNext());
		TreeNode<String> child1Level2 = child1Level1.getChildren().getElement();
		TreeNode<String> child2Level2 = child1Level1.getChildren().getNext().getElement();
		assertNull(child1Level1.getChildren().getNext().getNext());
		TreeNode<String> child3Level2 = child2Level1.getChildren().getElement();
		TreeNode<String> child4Level2 = child2Level1.getChildren().getNext().getElement();
		assertNull(child2Level1.getChildren().getNext().getNext());
		
		assertTrue(rootOfMirror.getElement().equals("a"));
		assertTrue(child1Level1.getElement().equals("c"));
		assertTrue(child2Level1.getElement().equals("b"));
		assertTrue(child1Level2.getElement().equals("g"));
		assertTrue(child2Level2.getElement().equals("f"));
		assertTrue(child3Level2.getElement().equals("e"));
		assertTrue(child4Level2.getElement().equals("d"));
		
		assertTrue(child1Level1.getParent() == rootOfMirror);
		assertTrue(child2Level1.getParent() == rootOfMirror);
		assertTrue(child1Level2.getParent() == child1Level1);
		assertTrue(child2Level2.getParent() == child1Level1);
		assertTrue(child3Level2.getParent() == child2Level1);
		assertTrue(child4Level2.getParent() == child2Level1);
		
		/* No aliasing of TreeNode objects */
		assertFalse(rootOfMirror == n1);
		assertFalse(child1Level1 == n3);
		assertFalse(child1Level1 == n2);
		assertFalse(child1Level2 == n7);
		assertFalse(child1Level2 == n6);
		assertFalse(child3Level2 == n5);
		assertFalse(child4Level2 == n4);
	}

	/*
	 * There is only one problem for you to solve.
	 *  
	 * Jackie's suggestions:
	 * 	+ Your implemented method should be generic and able to handle different types (e.g., String, Integer).
	 * 	+ Write additional tests for more sophisticated tree structures. 
	 */
}