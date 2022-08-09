package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.TreeUtilities;

public class ManualTests {
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
}
