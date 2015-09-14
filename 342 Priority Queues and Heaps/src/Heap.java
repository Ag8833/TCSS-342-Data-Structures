
import java.util.*;

@SuppressWarnings("unchecked")
public class Heap<AnyType extends Comparable<AnyType>>
{
   private static final int CAPACITY = 2;

   private int size;            // Number of elements in heap
   private AnyType[] heap;     // The heap array

   public Heap()
   {
      size = 0;
      heap = (AnyType[]) new Comparable[CAPACITY];
   }

/**
  * Inserts a new item
  */
   public void insert(AnyType x)
   {
      if(heap.length == size+1)
      {
    	  doubleSize();
      }
      
      heap[size+1] = x;
      
      int i = size+1;
      AnyType temp;
      
      while(heap[i].compareTo(heap[i/2]) < 0 && i >= 1)
      {
    	  temp = heap[i/2];
    	  heap[i/2] = heap[i];
    	  heap[i] = temp;
    	  i = i/2;
    	  
    	  if(i/2 < 1)
    	  {
    		  break;
    	  }
      }
      size++;
   }

 /**
  * Deletes the top item
  */
   public AnyType removeMin() throws RuntimeException
   {
	   	if(size == 0)
	   	{
		   	throw new RuntimeException();
	   	}
	   	AnyType  min = heap[1];
   	 	heap[1] = heap[size];
   	 
   	 	percolatingDown(1);
   	 	heap[size] = null;
   	 	size--;
   	 	return min; 
	}

    private void doubleSize()
   {
      AnyType [] old = heap;
      heap = (AnyType []) new Comparable[heap.length * 2];
      System.arraycopy(old, 1, heap, 1, size);
   }

   public String toString()
   {
      String out = "";
      for(int k = 1; k <= size; k++) out += heap[k]+" ";
      return out;
   }
/**
  * Construct the binary heap given an array of items.
  */
public void buildHeap(AnyType[] array)
   {
       size = array.length;
      heap = (AnyType[]) new Comparable[size+1];
      System.arraycopy(array, 0, heap, 1, size);
      buildHeap();

   }
 
 /**
  *   runs at O(size)
  */
  private void buildHeap()
   {
      for (int k = size/2; k > 0; k--)
      {
         percolatingDown(k);
      }
   } 
   
   
   
  private void percolatingDown(int k)
   {
      AnyType tmp = heap[k];
      int child;

      for(; 2*k <= size; k = child)
      {
         child = 2*k;

         if(child != size &&
            heap[child].compareTo(heap[child + 1]) > 0) child++;

         if(tmp.compareTo(heap[child]) > 0)  heap[k] = heap[child];
         else
                break;
      }
      heap[k] = tmp;
   }   

  public void printTree()
  {
	  printTreeHelper(1);
  }
  
  private void printTreeHelper(int index)
  {
	  if(index*2 < heap.length && heap[index*2] != null && heap[index*2+1] != null)
	  {
		  System.out.println("The node is - " + heap[index] + " and it's children are - "
			  + heap[index*2] + " and " + heap[index*2+1]);
	  }
	  else
	  {
		  System.out.println("The node is - " + heap[index] + " and it has no children");
	  }
	  if(index*2+1 < size)
	  {
		  printTreeHelper(index*2);
		  printTreeHelper(index*2+1);
	  }
  }

public static void main(String[] args)
   {
      
      Heap<Integer> h = new Heap<Integer>();
      Integer[] a = {2,5,3,9,6,11,4,17,10,8}; 
    
      h.buildHeap(a);  // build a heap from a given array     
      System.out.println(h);
      	
      h.insert(20);
      h.insert(2);
      h.insert(1);
      System.out.println(h);
      
      h.removeMin();
      System.out.println(h);
      
      h.printTree();
   }
}