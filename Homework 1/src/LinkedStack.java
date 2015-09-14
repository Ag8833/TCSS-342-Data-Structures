/* Andrew Gates
 * 6/29/2015
 * TCSS 342
 * StackImplementation
 * 
 * This program contains the LinkedStack class to be used with the Node class as well
 * as the Main class for testing. It contains the methods to construct a LinkedStack,
 * push data to the stack, pop data from the stack, print the contents of the stack,
 * peek at the top element of the stack, check if the stack is empty, check the
 * stack's size, and clear all of the elements in the stack at once.
 */

public class LinkedStack<T> 
{
	//Members of the LinkedStack class.
	private int size;
	private Node<T> top;
	
	//Constructor to initialize top to null and size to 0.
	public LinkedStack()
	{
		top = null;
		size = 0;
	}
	
	//Method to push the given data onto the stack.
	public void push(T pushData)
	{
		Node<T> insertNode = new Node<T>(pushData);
		
		if(top == null)
		{
			top = insertNode;
		}
		else
		{
			if(top.getNext() == null)
			{
				insertNode.setNext(top);
				top = insertNode;
			}
			else
			{
				Node<T> tempNode = top;
				
				top = insertNode;
				insertNode.setNext(tempNode);	
			}
		}
		size++;
	}
	
	//Method to pop the top element in the stack.
	public T pop()
	{
		Node<T> tempNode = top;
		
		if(top.getNext() == null)
		{
			top = null;
		}
		else
		{
			top = top.getNext();		
		}
		return tempNode.getData();
	}
	
	//Method to print the stack.
	public void printStack()
	{
		if(isEmpty())
		{
			System.out.println("The stack is empty!");
			System.out.println();
			return;
		}
		Node<T> tempNode = top;
		
		System.out.print("Top -> ");
		for(int i = 0; i < size; i++)
		{
			if(tempNode.getNext() == null)
			{
				System.out.print(tempNode.getData() + " -> Bottom");
				System.out.println();
				System.out.println();
				return;
			}
			else
			{
				System.out.print(tempNode.getData() + " -> ");
			}
			tempNode = tempNode.getNext();
		}
	}
	
	//Method to return the top element in the stack.
	public T peek()
	{
		return top.getData();
	}
	
	//Method to check if the stack is empty.
	public boolean isEmpty()
	{
		if(top == null)
		{
			return true;
		}
		return false;
	}
	
	//Getter to return the size of the stack. 
	public int getSize()
	{
		return size;
	}
	
	//Method to delete all of the contents in the stack.
	public void clearStack()
	{
		while(top != null)
		{
			pop();
		}
	}
}
