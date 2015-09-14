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
      private AnyType data;
      private Node<AnyType> next;

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
		   head.next = insertNode;
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

	} // end of main method
} //end of LinkedList class