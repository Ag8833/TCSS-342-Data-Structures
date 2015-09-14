/* Andrew Gates
 * 6/29/2015
 * TCSS 342
 * StackImplementation
 * 
 * This program contains the Node class to be used with the LinkedStack class as well
 * as the Main class for testing. It contains the methods to construct a node, as well
 * as to set the data of that node and the node's next, as well as retrieve the data
 * and the next node.
 */

public class Node<T>
{
	//Members of the Node class.
	private T data;
	private Node<T> next;
	
	//Constructor setting the data to the given data and next to null.
	public Node(T data)
	{
		this.data = data;
		this.next = null;
	}
	
	//Setter to set the data to the given data.
	public void setData(T data)
	{
		this.data = data;
	}
	
	//Setter to set the next node to the given next node.
	public void setNext(Node<T> next)
	{
		this.next = next;
	}
	
	//Getter to retrieve the data.
	public T getData()
	{
		return data;
	}
	
	//Getter to retrieve the next node.
	public Node<T> getNext()
	{
		return next;
	}
}
