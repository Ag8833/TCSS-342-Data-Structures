/**
 * This class contains a root of type Node that will then link to the rest of the tree
 * information. It contains the methods for a constructor, a method to insert a record
 * into the tree given a keyword, a method to check if the tree contains the given
 * keyword, a method to get the first record of a given keyword, a method to delete the
 * given keyword from the tree, a method to print the tree, and a method to clear the tree. 
 * @author ag8833
 *
 */

class bst
{
	/** Root of the tree. */
    Node root;

    /**
     * This subclass of bst contains the nodes that will be in the bst. Each node has
     * a keyword value associated with it, a record that will contain a linked list
     * of all records that share the same keyword, a size of the linked list of records,
     * and a left and right node. It contains the methods for a constructor, a method to
     * update the list of the keyword with a new record, and a method to get the size
     * of the list of the keyword.
     * @author ag8833
     *
     */
    class Node
    {
    	/** Keyword of the node. */
        String keyword;
        /** The first record of the list of the node. */
        Record record;
        /** The size of the list of the node. */
        int size;
        /** The left child of the node. */
        Node l;
        /** The right child of the node. */
        Node r;
        
        /**
         * Default constructor for Node.
         * @param k Assigns the given String to the keyword of Node.
         */
        private Node(String k)
        {
        	keyword = k;
        	size = 0;
        	record = null;
        	l = null;
        	r = null;
        }
        
        /**
         * Adds the given record to the Node's list that called this method.
         * @param r The record to be added to the Node's list.
         */
        private void update(Record r)
        {
        	if(r == null)
        	{
        		throw new IllegalArgumentException();
        	}
        	
        	else
        	{
        		r.next = this.record;
        		this.record = r;
        		this.size++;
        	}
        }
        
        /**
         * Returns size.
         * @return Returns the size of the record list of the given Node.
         */
        public int getSize()
        {
        	return size;
        }
       
    }

    /**
     * Default constructor for the bst, assigns the root to null.
     */
    public bst()
    {
        this.root = null;
    }
     
    /**
     * This will insert the given keyword to the BST. If it is not found
     * then it will create a new Node with that keyword and add the new record to
     * that given keyword. IF it is found it will link the given record to that keyword.
     * @param keyword The keyword to be checked for and inserted.
     * @param fd The file to be sent to insert from.
     */
    public void insert(String keyword, FileData fd)
    {
    	if(this == null || keyword == null || fd == null)
    	{
    		throw new IllegalArgumentException();
    	}
    	
    	else
    	{
    		insert(keyword, fd, root);
    	}
    }
    
    /**
     * This will insert the given keyword to the BST. If it is not found
     * then it will create a new Node with that keyword and add the new record to
     * that given keyword. IF it is found it will link the given record to that keyword.
     * @param keyword The keyword to be checked for and inserted.
     * @param fd The file to be sent to insert from.
     * @param myNode The node in the bst to compare the given keyword to.
     */
    private void insert(String keyword, FileData fd, Node myNode)
    {
        Record recordToAdd = new Record(fd.id, fd.author, fd.title, null);
    	
        //If there are no nodes yet initialize the root with that record and keyword.
        if(root == null)
        {
        	root = new Node(keyword);
        	root.record = recordToAdd;
        	root.l = null;
        	root.r = null;
        	root.size = 1;
        	return;
        }
        
        //If the node somehow got to be null then there was an error, return.
        if(myNode == null)
        {
        	System.out.println("Error in trying to insert");
        	return;
        }
        
        //If the keyword was found call update on the new record.
        if(keyword.compareTo(myNode.keyword) == 0)
        {
        	myNode.update(recordToAdd);
        	return;
        }
    
        //If the keyword to search for is less than the current node go and the current node's
        //left is null then assign the new keyword to that node.
        if((myNode.l == null) && (keyword.compareTo(myNode.keyword) < 0))
        {
        	myNode.l = new Node(keyword);
        	myNode.l.record = recordToAdd;
        	myNode.size++;
        	return;
        }
        
        //If the keyword to search for is greater than the current node go and the current node's
        //right is null then assign the new keyword to that node.
        else if((myNode.r == null) && (keyword.compareTo(myNode.keyword) > 0))
        {
        	myNode.r = new Node(keyword);
        	myNode.r.record = recordToAdd;
        	myNode.size++;
        	return;
        }
        
        //If the keyword to search for is less than the current node's keyword then recurse left.
        else if(keyword.compareTo(myNode.keyword) < 0)
        {
        	insert(keyword, fd, myNode.l);
        	return;
        }
        
      //If the keyword to search for is greater than the current node's keyword then recurse right.
        else
        {
        	insert(keyword, fd, myNode.r);
        	return;
        }
    }
    
    /**
     * Checks to see if the bst contains the keyword that is given. If it does contain
     * the keyword return true, if not return false.
     * @param keyword The keyword to search the tree for.
     * @return Returns the boolean value depending on the result.
     */
    public boolean contains(String keyword)
    {
    	if(keyword == null)
    	{
    		throw new IllegalArgumentException();
    	}
    	
    	else
    	{
    		return contains(keyword, root);
    	}
    }
    
    /**
     * Checks to see if the bst contains the keyword that is given. If it does contain
     * the keyword return true, if not return false.
     * @param keyword The keyword to search the tree for.
     * @param myNode The node in the bst to compare the given keyword to.
     * @return Returns the boolean value depending on the result.
     */
    private boolean contains(String keyword, Node myNode)
    { 	
    	//If it reaches a null node then it was not found.
    	if(myNode == null)
    	{
    		return false;
    	}
    	
    	//If the keyword was found.
    	if(keyword.compareTo(myNode.keyword) == 0)
    	{
    		return true;
    	}
    
    	//If the keyword is less than the current node's keyword recurse left.
    	else if(keyword.compareTo(myNode.keyword) < 0)
    	{
    		return contains(keyword, myNode.l);
    	}
          
    	//If the keyword is greater than the current node's keyword recurse right.
    	else
    	{
    		return contains(keyword, myNode.r);
    	}
    }

    /**
     * Checks to see if the bst contains the keyword that is given. IF it does then 
     * the first record of that keyword is returned. If not then a null pointer is 
     * returned.
     * @param keyword The keyword to search the tree for.
     * @return Returns the record at the given keyword if found, or null if not.
     */
    public Record get_records(String keyword)
    {	
    	if(keyword == null)
    	{
    		throw new IllegalArgumentException();
    	}
    	
    	else
    	{
    		return get_records(keyword, root);
    	}	
    }
    
    /**
     * Checks to see if the bst contains the keyword that is given. If it does then 
     * the first record of that keyword is returned. If not then a null pointer is 
     * returned.
     * @param keyword The keyword to search the tree for.
     * @param myNode The node in the bst to compare the given keyword to.
     * @return Returns the record at the given keyword if found, or null if not.
     */
    private Record get_records(String keyword, Node myNode)
    {
    	//If it reaches a null node then the keyword was not found.
    	if(myNode == null)
    	{
    		System.out.println("The tree is empty or keyword was not found!");
    		return null;
    	}
    	
    	//If the keyword was found.
    	if(keyword.compareTo(myNode.keyword) == 0)
    	{
    		return myNode.record;
    	}
    
    	//If the keyword is less than the current node's keyword recurse left.
    	else if(keyword.compareTo(myNode.keyword) < 0)
    	{
    		return get_records(keyword, myNode.l);
    	}
    	
    	//If the keyword is greater than the current node's keyword recurse right.
    	else
    	{
    		return get_records(keyword, myNode.r);
    	}
    }

    /**
     * Checks to see if the bst contains the keyword that is given. If it does then
     * it will delete that keyword and then move the minimum value of that node's
     * right subtree to the current node. If it does not contain the keyword then 
     * nothing will be deleted.
     * @param keyword The keyword to search the tree for.
     */
    public void delete(String keyword)
    {
    	if(keyword == null)
    	{
    		throw new IllegalArgumentException();
    	}
    	
    	else
    	{
    		root = delete(keyword, root);
    	}
    }
    
    /**
     * Checks to see if the bst contains the keyword that is given. If it does then
     * it will delete that keyword and then move the minimum value of that node's
     * right subtree to the current node. If it does not contain the keyword then 
     * nothing will be deleted.
     * @param keyword The keyword to search the tree for.
     * @param myNode The node in the bst to compare the given keyword to.
     */
    private Node delete(String keyword, Node myNode)
    {
    	//If it reaches a null node then the keyword was not found.
        if(myNode == null)
        {
        	System.out.println("The tree is empty or keyword was not found!");
        	return myNode;  
        }
        
        //If the keyword is less than the current node's keyword recurse left.
        if(keyword.compareTo(myNode.keyword) < 0)
        {
        	myNode.l = delete(keyword, myNode.l);
        }
          
        //If the keyword is greater than the current node's keyword recurse right.
        else if(keyword.compareTo(myNode.keyword) > 0)
        {
        	myNode.r = delete(keyword, myNode.r);
        }
            
        //If the keyword was found and the right and left are both not null (2 children), then copy the information
        //from the minimum node in the call findMin(myNode.r) onto myNode. Then recall delete with findMin(myNode.r)'s 
        //keyword and myNode.r as the new node to delete. 
        else if(keyword.compareTo(myNode.keyword) == 0 && myNode.l != null && myNode.r != null) 
        {
        	myNode.keyword = (findMin(myNode.r)).keyword;
        	myNode.record = (findMin(myNode.r)).record;
        	myNode.size = (findMin(myNode.r)).size;
        	myNode.r = delete(findMin(myNode.r).keyword, myNode.r);
        	return myNode;
        }
        
        //Reassigning myNode in the case of 0 or 1 children.
        else
        {
        	myNode = (myNode.l != null) ? myNode.l : myNode.r;
        }
            
        return myNode;
    }

    /**
     * Used with delete to find the minimum node of the node that calls this method.
     * @param myNode The node in the bst to find the smallest keyword for.
     * @return Returns myNode whenever it reaches the smallest keyword.
     */
    private Node findMin(Node myNode)
    {
        if(myNode == null)
        {
        	return null;
        }
        
        //Return myNode as the smallest Node.
        else if(myNode.l == null)
        {
        	return myNode;
        }
     
        //Keep recursing until myNode.l becomes the smallest node.
        return findMin(myNode.l);
    }
    
    /**
     * Prints the bst.
     */
    public void print()
    {
    	if(root == null)
        {
        	System.out.println("The tree is empty!");
        }
    	
    	else
    	{
    		print(root);
    	}
    }
    
    /**
     * Prints the bst.
     * @param t The node to print the keyword and records at.
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
                System.out.printf("\t%s\n", r.author);
                r = r.next;
            }
            print(t.r);
        }
    }
    
    /**
     * Clears the tree by setting the root to null.
     */
    public void clearTree()
    {
    	root = null;
    }
}
