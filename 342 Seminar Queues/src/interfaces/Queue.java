package interfaces;

public interface Queue extends IntCollection{
	
	/** Add a POSITIVE number element to the queue
		return false if passed a negative number (and don't add it to the queue) */
	public boolean offer(int e);
	/** Add a POSITIVE number element to the queue
		throw IllegalArgumentException if passed a negative number (and don't add it to the queue) */
	public void add(int e);
	
	/** Return, but don't remove, the next element.
		return -1 if queue is empty */
	public int peek();
	/** Return, but don't remove, the next element.
		throw NoSuchElementException if queue is empty */
	public int element();
	
	/** Return and remove the next element
		return -1 if the queue is empty */
	public int poll();
	/** Return and remove the next element.
		throw NoSuchElementException if queue is empty */
	public int remove();

}
