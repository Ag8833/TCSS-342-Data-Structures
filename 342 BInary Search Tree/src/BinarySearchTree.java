import java.util.*;

public class BinarySearchTree<AnyType extends Comparable<AnyType>> 
{
	private Node<AnyType> root;
   	private Comparator<AnyType> comparator;

 /** 
   Creates an empty binary tree -- a null root pointer. 
  */ 
  
   public BinarySearchTree()
   {
      root = null;
      comparator = null;
   }

   public BinarySearchTree(Comparator<AnyType> comp)
   {
      root = null;
      comparator = comp;
   }

   private int compare(AnyType x, AnyType y)
   {
      if(comparator == null) return x.compareTo(y);
      else
      return comparator.compare(x,y);
   }

  /***************************************************************************
 * private static inner Node class.
 *
 *****************************************************************************/	
  private static class Node<AnyType> { 
	  private AnyType data;
      private Node<AnyType> left;
      private Node<AnyType> right;
  
    public Node(AnyType newData) { 
      left = null; 
      right = null; 
      data = newData; 
    } 
  }
/*****************************************************
*            Size()
******************************************************/
 public int size() { 
  return(size(root)); 
}
private int size(Node<AnyType> node) { 
  
  if (node == null) return(0); 
  else { 
    return(size(node.left) + 1 + size(node.right)); 
  } 
  
} 

/*****************************************************
*            minValue()
******************************************************/

public int minValue() 
{ 
 return( minValue(root) ); 
} 
 
private int minValue(Node<AnyType> node) 
{ 
	int smallest = 0;
	
	while(node.left != null)
	{
		node = node.left;
		smallest = (int) node.data;
	}
	
	return smallest;
} 

/*****************************************************
*            maxValue()
******************************************************/

public int maxValue()
{ 
 return( maxValue(root) ); 
} 
 
private int maxValue(Node<AnyType> node) 
{ 
	int largest = 0;
	
	while(node.right != null)
	{
		node = node.right;
		largest = (int) node.data;
	}
	
	return largest;
}
/*****************************************************
*            findNode()
******************************************************/
public boolean findNode(int key)
{
	return(findNode(root, key));
}

private boolean findNode(Node<AnyType> node, int key)
{
	if(node == null)
	{
		return false;
	}
	
	if(key < (int) node.data)
	{
		return findNode(node.left, key);
	}
	
	if(key > (int) node.data)
	{
		return findNode(node.right, key);
	}
	
	return true;
}
 
/*****************************************************
*            IS BST()
******************************************************/  
private boolean isBST1() 
{
     return isBST(root);
}

public boolean isBST(Node<AnyType> p)
{
	 if(p.left == null && p.right == null)
	 {
		 return true;
	 }
	 
	 if(p.left != null)
	 {
		if((int) p.left.data < (int) p.data)
	 	{
		 	return isBST(p.left);
	 	}
		else
		{
			return false;
		}
	 }
	 
	 if(p.right != null)
	 {
		if((int) p.right.data > (int) p.data)
	 	{
		 	return isBST(p.right);
	 	}
		else
		{
			return false;
		}
	 }
	 
	 else
	 {
		 return(isBST(p.left) && isBST(p.right));
	 }
}     


/*****************************************************
*            INSERT
******************************************************/
   public void insert(AnyType data)
   {
      root = insert(root, data);
   }
   private Node<AnyType> insert(Node<AnyType> p, AnyType toInsert)
   {
      if (p == null)
         return new Node<AnyType>(toInsert);

      if (compare(toInsert, p.data) == 0)
      	return p;

      if (compare(toInsert, p.data) < 0)
         p.left = insert(p.left, toInsert);
      else
         p.right = insert(p.right, toInsert);

      return p;
   } // end of insert method


/*****************************************************
*            DELETE
******************************************************/

   public void delete(AnyType toDelete)
   {
      root = delete(root, toDelete);
   }
   private Node<AnyType> delete(Node<AnyType> p, AnyType toDelete)
   {
	  if(p == null)
	  {
		  return null;
	  }
	  
	  else if(p.left == null && p.right == null)
      {
		  if((int) toDelete != (int) p.data)
		  {
			  return p;
		  }
      }
      
      else if((int) toDelete < (int) p.data)
      {
    	  if(p.left != null)
    	  {
    		  p.left = delete(p.left, toDelete);
    	  }
      }
     
      else if((int) toDelete > (int) p.data)
      {
    	  if(p.right != null)
    	  {
    		  p.right = delete(p.right, toDelete);
    	  }
      }
	  
      else if((int) toDelete == (int) p.data)
      {
    	  if(p.right != null)
    	  {
    		  if(p.left != null)
    		  {
    			  p.right.left = delete(p.left, toDelete);
    		  }
    		  return (delete(p.right, toDelete));
    	  }
    	  return null;
      }
	  
      return p;
   }
  
/*****************************************************
   Pre Order Traversal 
*******************************************************/    
public void preOrderTraversal()
{
	preOrderHelper(root);
}
private void preOrderHelper(Node<AnyType> r)
{
	if(r != null)
	{
		System.out.print(r.data+" ");
		preOrderHelper(r.left);
		preOrderHelper(r.right);
	}
}
/*****************************************************
*            Main Method
******************************************************/  
  public static void main(String[] args)
   {
      //Integer[] a = {1,5,2,7,4};
      Integer[] a = {100,50,25,75,90,150,125,175};
      BinarySearchTree<Integer> bt = new BinarySearchTree<Integer>();
      for(Integer n : a) bt.insert(n); 
   
      System.out.println("Size is - " + bt.size());
      System.out.println();
      
      System.out.println("The smallest value is - " + bt.minValue());
      System.out.println("The largest value is - " + bt.maxValue());
      
      System.out.println();
      System.out.println("Calling findNode on 75 results in - " + bt.findNode(75));
      System.out.println("Calling findNode on 300 results in - " + bt.findNode(300));
      
      System.out.println();
      System.out.println("isBST returns the value - " + bt.isBST1());
      
      System.out.println();
      System.out.println("Tree before deletetion of 50 - ");
      bt.preOrderTraversal();
      bt.delete(90);
      System.out.println();
      System.out.println("Tree after deletetion of 50 - ");
      bt.preOrderTraversal();
   }// end of main method
   
}// end of BinaryTree Class

class MyComp1 implements Comparator<Integer>
{
   public int compare(Integer x, Integer y)
   {
        return y-x;
   }
}