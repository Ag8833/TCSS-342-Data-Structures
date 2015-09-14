package tests;

import util.ArrayBST;
import interfaces.BST;
import junit.framework.TestCase;

public class ArrayBSTTest extends TestCase {
	BST tree;

	protected void setUp() throws Exception {
		super.setUp();
		tree = new ArrayBST();
	}
	
	public void testContains() {
		assertFalse(tree.contains(5));
		tree.add(3);
		assertFalse(tree.contains(5));
		tree.add(5);
		assertTrue(tree.contains(5));
	}

	public void testIsEmpty() {
		assertTrue(tree.isEmpty());
		tree.add(5);
		assertFalse(tree.isEmpty());
		tree.clear();
		assertTrue(tree.isEmpty());
	}

	public void testSize() {
		assertEquals(0, tree.size());
		tree.add(3);
		assertEquals(1, tree.size());
		tree.add(5);
		assertEquals(2, tree.size());
		tree.remove((5));
		assertEquals(1, tree.size());
		tree.clear();
		assertEquals(0, tree.size());
	}

	public void testToArray() {
		tree.add(5);
		tree.add(2);
		int[] arrr = tree.toArray();
		assertEquals(2, arrr.length);
		assertEquals(2, arrr[0]);
		assertEquals(5, arrr[1]);
	}

	public void testAdd() {
		assertTrue(tree.add(5));
		assertFalse(tree.add(5));
	}

	public void testRemove() {
		tree.add(5);
		assertEquals(5, tree.remove(5));
		assertEquals(-1, tree.remove(5));
	}

	public void testHashCodeDiff() {
		tree.add(5);
		final int firstCode = tree.hashCode();
		tree.add(6);
		final int nextCode = tree.hashCode();
		assertFalse(firstCode == nextCode);
	}
	
	public void testHashCodeSame() {
		tree.add(5);
		BST newTree = new ArrayBST();
		newTree.add(5);
		assertTrue(tree.hashCode() == newTree.hashCode());
	}

	public void testEquals() {
		BST newTree = new ArrayBST();
		tree.add(5);
		tree.add(1);
		tree.add(7);
		newTree.add(5);
		newTree.add(1);
		newTree.add(7);
		assertTrue(tree.equals(newTree));
	}
	
	public void testEqualsDiff() {
		BST newTree = new ArrayBST();
		tree.add(5);
		tree.add(1);
		tree.add(7);
		newTree.add(5);
		newTree.add(1);
		newTree.add(8);
		assertFalse(tree.equals(newTree));
	}

	public void testClone() {
		tree.add(5);
		BST newTree = tree.clone();
		tree.add(6);
		assertFalse(tree.size() == newTree.size());
	}

	public void testToString() {
		final String emptyTo = tree.toString();
		tree.add(5);
		final String oneE = tree.toString();
		assertFalse(emptyTo.equals(oneE));
	}

}
