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
 * 	+ Do ***not*** create any new class that is not required by the starter tests.
 * 		All such classes will be ***disregarded*** when grading. 
 *   
 * 	+ Any classes you create must reside in the `model` package and be imported properly.
 * 		For example, creating a new class `Foo` in the `model` package should result in:
 * 			import model.Foo;
 * 
 * 	+ For this assignment, you should not need to declare attributes. 
 * 		But if you really want to, all attributes you declare in the model classes must be private.
 * 
 * 	+ If necessary, you may define private helper methods. 
 */

public class ManualTests {
	/* 
	 * Programming Requirements:
	 * 
	 * 	- This assignment focuses on the manipulation of: 
	 * 		+ linked-node based trees (see the given TreeNode class) 
	 * 		+ singly-linked nodes (see the given SLLNode class)
	 * 
	 * 	  Therefore, you are forbidden to use primitive arrays (e.g., Integer[], int[], String[]) 
	 * 		for declaring attributes or local variables. Use only the TreeNode and SLLNode classes given to you.
	 * 
	 * 	- In addition, any use of a Java library class or method is also forbidden 
	 * 		(that is, use selections and loops to build your solution from scratch instead):
	 * 
	 * 	- Here are some examples of forbidden classes/methods: 
	 * 		- Arrays class (e.g., Arrays.copyOf)
	 * 		- System class (e.g., System.arrayCopy)
	 * 		- ArrayList class
	 * 		- String class (e.g., substring).
	 * 
	 * 	- The use of some library classes does not require an import statement, 
	 * 		but these classes are also forbidden to be used.
	 * 	- Here are the exceptions (library methods which you are allowed to use if needed):
	 * 		- String class (equals, format, length, charAt)
	 * 
	 * Violating the above programming requirements will result in a penalty (see the assignment instructions for details). 
	 * 
	 * Tests included in this class serve as documentation on how instances of Tree Utilities operate.
	 * 
	 * Before attempting this assignment, 
	 * 	it is expected that you already completed background study materials as outlined in the assignment instructions. 
	 * 
	 * Be sure to also read the following sections from your Assignment 1 instructions PDF:
	 * 	- The `Requirements of this Assignment` section (page 3) 
	 * 	- Sections 0 and 1 on the background studies
	 * 	- Section 2 on the programming tasks (particularly the hints on tasks on page 7). 
	 */ 
	
	/*
	 * Be sure to study how the TreeNode and SLLNode classes are supposed to work together
	 * 	as illustrated in the TestGeneralTrees JUnit class.
	 */
	
	/*
	 * Tests related to getElementsOfRanks
	 */
	
	@Test 
	public void test_getElementsOfRanks_1() {
		TreeNode<Integer> n1 = new TreeNode<>(23);
		TreeNode<Integer> n2 = new TreeNode<>(46);
		TreeNode<Integer> n3 = new TreeNode<>(69);
		TreeNode<Integer> n4 = new TreeNode<>(92);
		TreeNode<Integer> n5 = new TreeNode<>(115);
		TreeNode<Integer> n6 = new TreeNode<>(138);
		TreeNode<Integer> n7 = new TreeNode<>(161);
		
		n2.addChild(n1); n1.setParent(n2);
		n2.addChild(n5); n5.setParent(n2);
		n2.addChild(n7); n7.setParent(n2);
		n1.addChild(n4); n4.setParent(n1);
		n1.addChild(n3); n3.setParent(n1);
		n5.addChild(n6); n6.setParent(n5);
		
		/*
		 * Hint: Visualize the tree constructed from the above nodes.
		 */
		
		TreeUtilities u = new TreeUtilities();
		
		/*
		 * Input:
		 * 	+ The root node `n` of some general tree (see the TreeNode class) storing integers.
		 * 	+ An integer `i` denoting some lower bound.
		 * 	+ An integer `j` denoting some upper bound.
		 * Assumptions:
		 * 	1. Input `n` is not null.
		 *  2. The organization of nodes in the input tree rooted at `n` is arbitrary: 
		 *  	no ordering among child node elements can be assumed.
		 * 	3. Input `i` is larger than or equal to 1.
		 * 	4. Input `j` is less than or equal to the size of the tree rooted at `n`.
		 * 	5. i <= j
		 * Output:
		 * 	Return the head node (see the SLLNode class) of a sorted list enumerating
		 * 		from the (i)th smallest value to the (j)th smallest value in the input tree rooted at `n`.    
		 */
		SLLNode<Integer> output = u.getElementsOfRanks(n2, 1, 1);
		assertTrue(output.getElement() == 23);
		assertNull(output.getNext());
		
		output = u.getElementsOfRanks(n2, 4, 4);
		assertTrue(output.getElement() == 92);
		assertNull(output.getNext());
		
		output = u.getElementsOfRanks(n2, 7, 7);
		assertTrue(output.getElement() == 161);
		assertNull(output.getNext());
	}
}