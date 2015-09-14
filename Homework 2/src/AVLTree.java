
/**
 * 
 * @author Brandon Watt and Andrew Gates
 * @version 2
 */
public class AVLTree 
{
	/** The root node of the tree. */
	 private Node root;

	    private class Node
	    {
	    	// These attributes of the Node class will not be sufficient for those attempting the AVL extra credit.
	    	// You are free to add extra attributes as you see fit, but do not remove attributes given as it will mess with help code.
	    	/** The word associated with the information stored. */
	    	String keyword;
	    	/** A stack of information held by the node.*/
	        Record record;
	        /** The number of records stored in the node. */
	        int size;
	        /** The left child of the node. */
	        Node l;
	        /** The right child of the node. */
	        Node r;
	        /** The height of the node from the farthest leaf. */
	        int height;
	        
	        /**
	         * Constructs a node with the given keyword.
	         * @param k The keyword of the node.
	         */
	        private Node(String k)
	        {
	        	// Instantialize a new Node with keyword k.
	        	keyword = k;
	        	size = 0;
	        	height = 0;
	        	record = null;
	        	l = null;
	        	r = null;
	        }
	        
	        /**
	         * Creates a copy of the given node.
	         * @param theNode The node to be copied.
	         */
	        private Node(Node theNode)
	        {
	        	keyword = theNode.keyword;
	        	size = theNode.size;
	        	height = theNode.height;
	        	record = theNode.record;
	        	l = theNode.l;
	        	r = theNode.r;
	        }
	        
	        /**
	         * Adds a record to a node.
	         * @param r the record to be added to the node.
	         */
	        private void update(Record r)
	        {
	        	//Adds the Record r to the linked list of records. You do not have to check if the record is already in the list.
	        	//HINT: Add the Record r to the front of your linked list.
	        	size++;
	        	
	        	// Place the new record at the top of the stack.
	        	r.next = record;
	        	record = r;        	
	        }   
	    }

	    public AVLTree()
	    {
	        this.root = null;
	    }
	     
	    /**
	     * Inserts given file data into the tree either as a new node or a new record.
	     * @param keyword The keyword of the data.
	     * @param fd The data to be inserted to the tree.
	     */
	    public void insert(String keyword, FileData fd)
	    {
	    	 if (keyword.equals(null) || fd == null)
	         {
	         	throw new IllegalArgumentException(); 
	         }
	    	
	    	Record recordToAdd = new Record(fd.id, fd.author, fd.title, null);
	        //Write a recursive insertion that adds recordToAdd to the list of records for the node associated
	        //with keyword. If there is no node, this code should add the node.
	        root = insert(keyword, recordToAdd, root);
	        treeHeights(root);
	        balance(root);
	    }
	    
	    /**
	     * A recursive helper method that will add a node to the tree 
	     * or insert a new record into a pre-existing node.
	     * @param keyword The keyword of the node being searched for.
	     * @param recordToAdd The record to be added to the node.
	     * @param theNode Allows for recursive movement of the method.
	     * @return theNode The child node the method is recursively returning.
	     */
	    private Node insert(String keyword, Record recordToAdd, Node theNode)
	    {
	    	// If the isn't a pre-existing node with the given keyword.
	    	if (theNode == null)
	    	{
	    		// Add the node to the tree and update it's records.
	    		Node addition = new Node(keyword);
	    		addition.update(recordToAdd);
	    		
	    		return addition;
	    	}
	    	
	    	// If there is a pre-existing node.
	    	if (keyword.equals(theNode.keyword))
	    	{
	    		// Update the nodes records. 
	    		theNode.update(recordToAdd);
	    		return theNode;
	    	}
	    	// If the node has yet to located.
	    	else if (keyword.compareTo(theNode.keyword) < 0)
	    	{
	    		// If the keyword value is less than the nodes, it will
	    		// look left.
	    		theNode.l = insert(keyword, recordToAdd, theNode.l);
	    	}
	    	else
	    	{
	    		// If the keyword value is greater than the nodes, it will
	    		// look right.
	    		theNode.r = insert(keyword, recordToAdd, theNode.r);
	    	}
	    	
	    	return theNode;
	    }
	    
	    
	    /**
	     * Checks to see if a node with the given keyword is in the tree.
	     * @param keyword The node keyword being searched for.
	     * @return Whether or not the node is in the tree.
	     */
	    public boolean contains(String keyword)
	    {
	    	if (keyword.equals(null))
	        {
	        	throw new IllegalArgumentException(); 
	        }
	    	//Write a recursive function which returns true if a particular keyword exists in the bst
	    	return contains(keyword, root);
	    }
	    
	    /**
	     * A recursive method that searches the tree to see if it contains a node 
	     * with the given keyword.
	     * @param keyword The keyword being searched for.
	     * @param theNode The location of the search in the tree.
	     * @return theNode Allows recursive traversal of the tree.
	     */
	    private boolean contains(String keyword, Node theNode)
	    {
	    	// If the node isn't found.
	    	if(theNode == null)
	    	{
	    		return false;
	    	}
	    	// If the node is found.
	    	else if(keyword.equals(theNode.keyword))
	    	{
	    		return true;
	    	}
	    	// If the node has yet to be found.
	    	else if (keyword.compareTo(theNode.keyword) < 0)
	    	{
	    		// If the keyword value is less than the nodes, it will
	    		// look left.
	    		return contains(keyword, theNode.l);
	    	}
	    	else
	    	{
	    		// If the keyword value is greater than the nodes, it will
	    		// look right.
	    		return contains(keyword, theNode.r);
	    	}
	    }
	    /**
	     * Returns the first record for a particular keyword. This record will link 
	     * to other records. If the keyword is not in the bst, it should return null.
	     * @param keyword The keyword being searched for.
	     * @return A stack of the records contained at the node, or null if the node doesn't exist.
	     */
	    public Record get_records(String keyword)
	    {
	    	if (keyword.equals(null))
	        {
	        	throw new IllegalArgumentException(); 
	        }
	    	
	    	// Checks if the node is in the list.
	    	if (contains(keyword))
	    	{
	    		Node temp = root;
	    		// Loops until the node is found.
	    		while (!temp.keyword.equals(keyword))
	    		{
	    			if (keyword.compareTo(temp.keyword) < 0)
	    	    	{
	    				// If the keyword value is less than the nodes, it will
	    	    		// look left.
	    				temp = temp.l;
	    	    	}
	    	    	else
	    	    	{
	    	    		// If the keyword value is greater than the nodes, it will
	    	    		// look right.
	    	    		temp = temp.r;
	    	    	}
	    		}
	    		return temp.record;	
	    	}
	    	// If the node isn't in the tree.
	    	else
	    	{
	    		return null;
	    	}
	    }

	    /**
	     * Checks if the keyword exists, then deletes it from the tree.
	     * @param keyword The keyword being searched for.
	     */
	    public void delete(String keyword)
	    {
	    	if (keyword.equals(null))
	        {
	        	throw new IllegalArgumentException(); 
	        }
	    	
	    	//Write a recursive function which removes the Node with keyword from the binary search tree.
	    	//You may not use lazy deletion and if the keyword is not in the bst, the function should do nothing.
	    	
	    	// Checks if the node is in the tree.
	    	if (contains(keyword))
	    	{
	    		delete(keyword, root);
	    		treeHeights(root);
	    		balance(root);
	    	}
	    	
	    }
	    
	    /**
	     * A recursive helper function that finds the node with the given keyword 
	     * and deletes that node.
	     * @param keyword The keyword of the node being deleted.
	     * @param theNode The node the method is currently located at.
	     * @return theNode Allows recursive traversal of the tree.
	     */
	    private Node delete(String keyword, Node theNode)
	    {
	    	
	    	if (theNode == null)
	    	{
	    		return null;
	    	}
	    	// If the node is found.
	    	else if (keyword.equals(theNode.keyword))
	 	    {
	 		   // If the node has no child nodes.
	    	   if (theNode.l == null && theNode.r== null)
	 		   {
	 			   return null;
	 		   }
	    	   // If the node only has a right child.
	 		   else if (theNode.l == null && theNode.r != null)
	 		   {
	 			   return theNode.r;
	 		   }
	    	   // If the node only has a left child.
	 		   else if (theNode.r == null && theNode.l != null)
	 		   {
	 			   return theNode.l;
	 		   }
	    	   // If the node has two child nodes.
	 		   else
	 		   {
	 			   // Find an appropriate replacement node.
	 			   Node temp = findMin(theNode.r);
	 			   // Delete the original replacement node.
	 			   delete(temp.keyword);
	 			   
	 			   // Overwrite the old nodes information with
	 			   // the replacements information.
	 			   theNode.keyword = temp.keyword;
	 			   theNode.size = temp.size;
	 			   theNode.record = temp.record;
	 			   
	 			   return theNode;
	 		   }
	 	   }
	    	// If the node has been located yet.
	 	   else if (keyword.compareTo(theNode.keyword) > 0)
	 	   {
	 		   // If the keyword value is greater than the nodes, it will
	 		   // look right.
	 		   theNode.r = delete(keyword, theNode.r);
	 	   }
	 	   else
	 	   {
	 		   // If the keyword value is less than the nodes, it will
	 		   // look left.
	 		   theNode.l = delete(keyword, theNode.l);
	 	   }
	    	
	    	return theNode;
	    }

	    /**
	     * A helper method used to find the minimum value in a subtree.
	     * @param theNode The root node of the subtree to be searched.
	     * @return The node that is the minimum of the subtree.
	     */
	    private Node findMin(Node theNode)
	    {
	    	if (theNode.equals(null))
	        {
	        	throw new IllegalArgumentException(); 
	        }
	    	
	    	while(theNode.l != null)
	    	{
	    		theNode = theNode.l;
	    	}
	    	
	    	return theNode;
	    }
	    
	    /**
	     * Finds the height of a node in the tree.
	     * @param theNode The node who's height is needed.
	     * @return The height of the node.
	     */
	    private int getHeight(Node theNode)
	    {
	    	if (theNode == null)
	    		return -1;
	    	
	    	return 1 + Math.max(getHeight(theNode.l), getHeight(theNode.r));
	    }
	    
	    /**
	     * Traverses through the tree and assigns the nodes their heights.
	     * @param theNode The node the method is currently located.
	     */
	    private void treeHeights(Node theNode)
	    {
	    	if (theNode == null)
	    	{
	    		return;
	    	}
	    	
	    	treeHeights(theNode.l);
	    	treeHeights(theNode.r);
	    	theNode.height = getHeight(theNode);
	    }
	    
	    /**
	     * A method that will rotate a subtree clockwise while keeping it the nodes in
	     * sorted order. Used for left-left insertions.
	     * @param theNode The root node of the subtree being rotated.
	     */
	    private void rightRotation(Node theNode)
	    {
	    	Node temp = theNode.l;
	    	Node original = new Node(theNode);
	    	
	    	// Swap the data between the parent and left child node.
	    	theNode.keyword = temp.keyword;
			theNode.size = temp.size;
			theNode.record = temp.record;
			
			temp.keyword = original.keyword;
			temp.size = original.size;
			temp.record = original.record;
			
			// Remove the node.
			theNode.l = temp.l;
			// Move the right child node to the left.
			temp.l = temp.r;
			// Point the temps right child to the right side of the parent node.
			temp.r = theNode.r;
			// Reinsert the node on the right side.
			theNode.r = temp;
			treeHeights(root);
	    }
	    
	    /**
	     * A method that will rotate a subtree counter-clockwise while keeping it the nodes in
	     * sorted order. Used for right-right insertions.
	     * @param theNode The root node of the subtree being rotated.
	     */
	    private void leftRotation(Node theNode)
	    {
	    	Node temp = theNode.r;
	    	Node original = new Node(theNode);
	    	
	    	// Swap the data between the parent and right child node.
	    	theNode.keyword = temp.keyword;
			theNode.size = temp.size;
			theNode.record = temp.record;
			
			temp.keyword = original.keyword;
			temp.size = original.size;
			temp.record = original.record;
			
			theNode.r = temp.r;
			temp.r = temp.l;
			temp.l = theNode.l;
			theNode.l = temp;
			treeHeights(root);
	    }
	    
	    /**
	     * Looks through the tree and balances sub-trees so that the height of child nodes
	     * are with in +/- 1
	     * @param theNode the node of the tree currently being checked.
	     */
	    private void balance(Node theNode)
	    {
	    	if (theNode == null)
	    		return;
	    	
	    	// Recurses to the leaves of the tree.
	    	balance(theNode.l);
	    	balance(theNode.r);
	    	
	    	if (theNode.l == null && theNode.r == null)
	    		return;
	    	// If on of the child nodes is null.
	    	else if (theNode.l == null || theNode.r == null)
	    	{
	    		// If the left child is null.
	    		if (theNode.l == null)
	    		{
	    			if (theNode.r.height >= 1)
	    			{
	    				leftRotation(theNode);
	    			}
	    			else
	    			{
	    				balance(theNode.r);
	    			}
	    		}
	    		// If the right child is null.
	    		else
	    		{
	    			if (theNode.l.height >= 1)
	    			{
	    				rightRotation(theNode);
	    			}
	    			else
	    			{
	    				balance(theNode.l);
	    			}
	    		}
	    	}
	    	// If the node has two children.
	    	else
	    	{
	    		int difference = theNode.l.height - theNode.r.height;
	    		if (difference > 1)
	    		{
	    			rightRotation(theNode);
	    		}
	    		else if (difference < -1)
	    		{
	    			leftRotation(theNode);
	    		}
	    	}
	    }
	    
	    /**
	     * Prints the nodes of the tree, and the records contained.
	     */
	    public void print()
	    {
	        print(root);
	    }

	    /**
	     * Prints the nodes of the tree, and the records contained.
	     * @param t The nod the method is currently located at.
	     */
	    private void print(Node t)
	    {
	        if (t!=null)
	        {
	            print(t.l);
	            System.out.println(t.keyword);
	            Record r = t.record;
	            while(r != null)
	            {
	                System.out.printf("\t%s\n",r.title);
	                r = r.next;
	            }
	            print(t.r);
	        } 
	    }
	
	
}
