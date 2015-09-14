/***************************************************************************
 * A Linked List class with a private static inner Node class.
 *
 *****************************************************************************/
 
 import java.util.*;

public class LinkedList<AnyType> 
{
   private Node<AnyType> head;

 /**
   *  Constructs an empty list
   */
   public LinkedList()
   {
      head = null;
   }
 /**
   *  Returns true if the list is empty
   *
   */
   public boolean isEmpty()
   {
      return head == null;
   }
  /*******************************************************
 *
 *  The Node class
 *
 ********************************************************/
   private static class Node<AnyType>
   {
      public AnyType data;
      public Node<AnyType> next;

      public Node(AnyType data, Node<AnyType> next)
      {
         this.data = data;
         this.next = next;
      }
   } //end of node class
  /******************************************************* 
  
  /** 
   *  Inserts a new node at the beginning of this list.
   *
   */
   public void addFirst(AnyType item)
   {
      head = new Node<AnyType>(item, head);
   }

   public void printElem()
   {
	   Node<AnyType> tempNode = head;
	   
	   if (tempNode == null)
	   {
		   System.out.println("The list is empty!");
		   return;
	   }
	   System.out.print("[");
	   while(tempNode != null)
	   {
		   if(tempNode.next == null)
		   {
			   System.out.print(tempNode.data + "]");
		   }
		   else
		   {
			   System.out.print(tempNode.data + ", ");
		   }
		   tempNode = tempNode.next;
	   }
   }
   
 /*******************************************************   
  
/***  Inserts a new node to the end of this list.* */
   public void addLast(AnyType item)
   {
	   if (head == null)
	   {
		   Node<AnyType> insertNode = new Node<AnyType>(item, null);
		   head = insertNode;
		   head.next = null;
		   return;
	   }
	   Node<AnyType> tempNode = head;
	   Node<AnyType> insertNode = new Node<AnyType>(item, null);
	   
	   while (tempNode.next != null)
	   {
		   tempNode = tempNode.next;
	   }
	   
	  tempNode.next = insertNode;
   	
   } // end of addLast
   
/*******************************************************    
   /*** Delete the first occurrence of the specified element in this list. **/
   public void removeItem(AnyType key)
   {
	   if(head == null)
	   {
		   System.out.println("The list is empty!");
		   return;
	   }
	   
   	 	Node<AnyType> tempNode = head;
   	 	Node<AnyType> secondNode = tempNode;
   	 
   	 	if(head.data == key)
   	 	{
   	 		head = head.next; 
   	 		return;
   	 	}
   	 
   	 	while(tempNode.data != key)
   	 	{
   	 		if(tempNode.next == null)
   	 		{
   	 			System.out.println("The item to remove was not found");
   	 			return;
   	 		}
   	 		secondNode = tempNode;
   	 		tempNode = tempNode.next;
   	 	}
   	 
   	 	if(tempNode.data == key)
   	 	{
   	 		secondNode.next = tempNode.next;
   	 	}
   	} //  end of remove item
 
/*******************************************************    
  /***  Find a node containing "key" and insert a new node after it.  **/
   
   
public void insertAfter(AnyType key, AnyType toInsert)
{
	Node<AnyType> tempNode = head;
	
	if(head.data == key)
	{
		tempNode = head.next;
		Node<AnyType> newNode = new Node<AnyType>(toInsert, tempNode);
		head = newNode;
	}
	
	while(tempNode.data != key)
  	{
		if(tempNode.next == null)
		{
			System.out.println("Item to insert after was not found");
			return;
		}
  		tempNode = tempNode.next;
  	}
	
	if(tempNode.data == key)
	{
		if (tempNode == head)
		{
			Node<AnyType> newNode = new Node<AnyType>(toInsert, tempNode);
			head.next = newNode;
			return;
		}
		Node<AnyType> newNode = new Node<AnyType>(toInsert, tempNode.next);
		tempNode.next = newNode;
	}
      
} // end of insertAfter

/******************************************************* */
 /***  Find a node containing "key" and insert a new node before it.  **/
public void insertBefore(AnyType key, AnyType toInsert)
{
	if(head == null)
	{
		System.out.println("The list is empty!");
		return;
	}
	
	Node<AnyType> tempNode = head;
	Node<AnyType> insertNode = tempNode;
	
	while(tempNode.data != key)
  	{
		if(tempNode.next == null)
		{
			System.out.println("Item to insert before was not found");
			return;
		}
		insertNode = tempNode;
  		tempNode = tempNode.next;
  	}
	
	if(tempNode.data == key)
	{
		if (tempNode == head)
		{
			Node<AnyType> newNode = new Node<AnyType>(toInsert, tempNode);
			head.next = newNode;
			return;
		}
		Node<AnyType> newNode = new Node<AnyType>(toInsert, tempNode);
		insertNode.next = newNode;
	}
	
}// end of insertBefore

/******************************************************* */

/* Mth-to-Last element of a Linked List*/
public void findMToLastElement(int m)
{
	if(head == null)
	{
		System.out.println("The list is empty!");
		return;
	}
	
	Node<AnyType> tempNode = head;
	Node<AnyType> secondNode = head;
	int count = 0;
	
	do
	{		
		if(tempNode.next == null)
		{
			System.out.println("The " + m + "th last item is: " + secondNode.data);
			return;
		}
		if (count >= m-1)
		{
			secondNode = secondNode.next;
		}
		tempNode = tempNode.next;
		count++;
	}
	while(tempNode != null);
	
} // end of findMToLastElement

	public LinkedList<Integer> mergeList(Node<Integer> h1, Node<Integer> h2)
	{
		LinkedList<Integer> sortedList = new LinkedList<Integer>();
		
		if(h1 == null && h2 == null)
		{
			return sortedList;
		}
		
		else if(h1 == null && h2 != null)
		{
			while(h2 != null)
			{
				sortedList.addLast(h2.data);
				h2 = h2.next;
			}
			return sortedList;
		}
		
		else if(h2 == null && h1 != null)
		{
			while(h1 != null)
			{
				sortedList.addLast(h1.data);
				h1 = h1.next;
			}
			return sortedList;
		}
		
		while(h1 != null && h2 != null)
		{
			while(h1.next != null && h1.data == h1.next.data)
			{
				h1 = h1.next;
			}
			
			while(h2.next != null && h2.data == h2.next.data)
			{
				h2 = h2.next;
			}
			
			if(h1.data < h2.data)
			{
				sortedList.addLast(h1.data);
				h1 = h1.next;
			}
			
			else if(h2.data < h1.data)
			{
				sortedList.addLast(h2.data);
				h2 = h2.next;
			}
			
			else
			{
				sortedList.addLast(h1.data);
				h1 = h1.next;
				h2 = h2.next;
			}
			
			if(h1 == null || h2 == null)
			{
				break;
			}
		}
		
		if(h1 == null)
		{
			while(h2 != null)
			{
				sortedList.addLast(h2.data);
				h2 = h2.next;
			}
			return sortedList;
		}
		else
		{
			while(h1 != null)
			{
				sortedList.addLast(h1.data);
				h1 = h1.next;
			}
			return sortedList;
		}
	}

 /***** *************   Include the main() for testing and debugging  ***********/

   public static void main(String[] args)
   {
      LinkedList<String> list = new LinkedList <String>();
      list.addFirst("o");
      list.addFirst("l");
      list.addFirst("l");
      list.addFirst("e");
      list.addFirst("h");
      list.printElem();
      System.out.println();
      System.out.println();
      
      list.addLast("Testing");
      list.printElem();
      System.out.println();
      
      System.out.println("Removing something that does not exist - ");
      list.removeItem("Testing Remove Item Method");
      System.out.println("Removing testing - ");
      list.removeItem("Testing");
      list.printElem();
  
      System.out.println();
      System.out.println();
      
      list.insertAfter("n", "InsertingAfterE");
      list.insertAfter("e", "InsertingAfterE");
      list.printElem();
      System.out.println();
      System.out.println();
      
      list.insertBefore("n", "InsertingBeforeE");
      list.insertBefore("e", "InsertingBeforeE");
      list.printElem();
      System.out.println();
      System.out.println();
      
      list.findMToLastElement(0);
      list.findMToLastElement(2);
      list.findMToLastElement(3);
      list.findMToLastElement(4);

      
      System.out.println();
      LinkedList<Integer> listToSort = new LinkedList <Integer>();
      listToSort.addFirst(9);
      listToSort.addFirst(7);
      listToSort.addFirst(4);
      listToSort.addFirst(4);
      listToSort.addFirst(1);
      listToSort.printElem();
      
      System.out.println();
      LinkedList<Integer> listToSort2 = new LinkedList <Integer>();
      listToSort2.addFirst(10);
      listToSort2.addFirst(9);
      listToSort2.addFirst(9);
      listToSort2.addFirst(4);
      listToSort2.addFirst(2);
      listToSort2.printElem();
      
      System.out.println();
      System.out.println("After merge - ");
      LinkedList<Integer> mergedList = new LinkedList <Integer>();
      mergedList = mergedList.mergeList(listToSort.head, listToSort2.head);
      mergedList.printElem();
	} // end of main method
} //end of LinkedList class