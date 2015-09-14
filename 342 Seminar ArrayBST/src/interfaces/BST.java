package interfaces;

import util.ArrayBST;

public interface BST extends IntCollection{
	/**
	 * Only add positive numbers. No duplicates.<br>
	 * Return false if passed a negative number or if the number is already in the list.<br>
	 * Return true if number was added.
	 * @param e Number to be added.
	 */
	public boolean add(int e);
	
	/**
	 * Finds and removes given number.<br>
	 * If number isn't in list, return -1
	 * @param e Target number
	 * @return Number found or -1
	 */
	public int remove(int e);
	
	/**
	 * Creates a deep copy of the BST
	 * @return Deep copy of BST
	 */
	public ArrayBST clone();
	
}
