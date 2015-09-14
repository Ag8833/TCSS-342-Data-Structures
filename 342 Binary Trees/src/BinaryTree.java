import java.util.*;

public class BinaryTree<AnyType extends Comparable<AnyType>> 
{
	private Node<AnyType> root;
   	private Comparator<AnyType> comparator;

 /** 
   Creates an empty binary tree -- a null root pointer. 
  */ 
  
   public BinaryTree()
   {
      root = null;
      comparator = null;
   }

   public BinaryTree(Comparator<AnyType> comp)
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
  private static class Node<AnyType> 
  { 
	  private AnyType data;
	  public Node<AnyType> left;
	  public Node<AnyType> right;
  
	  public Node(AnyType newData) 
	  { 
		  left = null; 
		  right = null; 
		  data = newData; 
	  } 
  }

 
/*****************************************************
*
*            INSERT
*
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
   }
/*****************************************************
           In-Order Traversal 
*******************************************************/ 
 public void inOrderTraversal()
   {
      inOrderHelper(root);
   }
   private void inOrderHelper(Node<AnyType> cur)
   {
      if (cur != null)
      {
         inOrderHelper(cur.left);
         System.out.print(cur.data+" ");
         inOrderHelper(cur.right);
      }
   } // end of inOrder
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
           Post Order Traversal 
*******************************************************/ 
public void postOrderTraversal()
{
	postOrderHelper(root);
}
private void postOrderHelper(Node<AnyType> r)
{
	if(r != null)
	{
		postOrderHelper(r.left);
		postOrderHelper(r.right);
		System.out.print(r.data+" ");
	}
}
/*****************************************************
*
*            SIZE()
 Returns the number of nodes in the tree. 
 Uses a recursive helper that recurs 
 down the tree and counts the nodes.  
*
******************************************************/
public int size() 
{ 
	return(size(root)); 
}
private int size(Node<AnyType> node) 
{  
	if(node == null)
	{
		return 0;
	}
	
	return 1 + size(node.left) + size(node.right);
} 
  

/*****************************************************
           maxDepth(): 
 Returns the max root-to-leaf depth of the tree. 
 Uses a recursive helper that recurs down to find 
 the max depth.  
*******************************************************/   
public int height() { 
  return(height(root)); 
}

private int height(Node<AnyType> node)
{
	if(node == null)
	{
		return -1;
	}
	
	return 1 + Math.max(height(node.left), height(node.right));
}  

/*****************************************************
*           doubletree():
******************************************************/  
public void doubleTree() 
{ 
	doubleTree(root); 
}

private void doubleTree(Node<AnyType> node) 
{ 
	Node<AnyType> leftNode;
	
	if(node == null)
	{
		return;
	}
	
	doubleTree(node.left);
	doubleTree(node.right);
	
	leftNode = node.left;
	node.left = new Node<AnyType>(node.data);
	node.left.left = leftNode;
}

/*****************************************************
*           mirror():
******************************************************/ 
public void mirror() 
{ 
	mirror(root); 
}

private void mirror(Node<AnyType> node) 
{ 
	Node<AnyType> tempNode;

	if(node == null)
	{
		return;
	}
	
	mirror(node.left);
	mirror(node.right);
	
	tempNode = node.left;
	node.left = node.right;
	node.right = tempNode;
}	

/*****************************************************
*            Main Method
******************************************************/  
  public static void main(String[] args)
   {
      Integer[] a = {1,5,2,7,4};
      BinaryTree<Integer> bt = new BinaryTree<Integer>();
      for(Integer n : a) bt.insert(n); 
      
      System.out.println("InOrder - ");
      bt.inOrderTraversal();
      System.out.println("\nPreOrder - ");
      bt.preOrderTraversal();
      System.out.println("\nPostOrder - ");
      bt.postOrderTraversal();
      System.out.println();
      
      System.out.println("\nSize of the tree - " + bt.size());
      System.out.println("\nHeight of the tree - " + bt.height());
      
      System.out.println("\nMirror - ");
      bt.mirror();
      bt.preOrderTraversal();
      System.out.println("\nMirror again- ");
      bt.mirror();
      bt.preOrderTraversal();
      
      System.out.println("\nDouble - ");
      bt.doubleTree();
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