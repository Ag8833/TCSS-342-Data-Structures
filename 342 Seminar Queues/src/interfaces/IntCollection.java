package interfaces;

public interface IntCollection {
	/** Removes all of the elements from this collection */
	public void clear();
	
	/** Returns true if this collection contains the specified element. */
	public boolean contains(int e);
	
	/** Compares the specified object with this collection for equality. */
	public boolean equals(Object o);
	
	/** Returns the hash code value for this collection. */
	public int hashCode();
	
	/** Returns true if this collection contains no elements. */
	public boolean isEmpty();
	
	/** Returns the number of elements in this collection. */
	public int size();
	
	/** Returns an array containing all of the elements in this collection.<br>
	 *  If this collection makes any guarantees as to what order its elements are returned by its iterator,<br>
	 *   this method must return the elements in the same order. */
	public int[] toArray();
}
