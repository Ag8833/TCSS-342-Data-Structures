/**
 * This class contains an array that will be used as a heap, as well as the size of that array/heap.
 * It contains the methods to construct a new heap, insert an element into the heap, find the minimum
 * element in the heap, delete the minimum element in the heap, double the size of the heap, convert
 * the heap to a string, build a heap from an array, move an element down the heap, and print the
 * heap in a somewhat tree structure.
 * @author ag8833
 *
 */
/*
 * The complexity of my kSmallest method is complexity O(nlogn). It is this because the complexity of
 * building the heap from the array has complexity O(n). The complexity of removeMin k amount of 
 * times is that of complexity O(k) * O(logn). The complexity of reinserting the k amount of elements
 * that were remove is also O(k) * O(logn). Since the complexity is thus O(n) + O(klogn) + O(klogn)
 * the biggest complexity out of the 3 is O(nlogn) at worst case where n is equal to k, and at best case
 * it is O(klogn) where k is smaller than n.
 */
@SuppressWarnings("unchecked")
public class GenericHeap<AnyType extends Comparable<AnyType>>
{
	/** Default capacity for the heap. */
	private static final int CAPACITY = 2;
	/** Size of the heap. */
	private int size;
	/** The array that is the heap itself. */
	private AnyType[] heap;
	
	/**
	 * Default constructor for the heap.
	 */
	public GenericHeap()
	{
		size = 0;
		heap = (AnyType[]) new Comparable[CAPACITY];
	}
	
	/**
	 * Method to insert the given element x into the heap. It will double the heap size if necessary, 
	 * otherwise it will insert the new element into the heap at the last index and then it will 
	 * compare that element to it's parent, swapping the elements if necessary.
	 * @param x Element to be inserted into the heap.
	 */
	public void insert(AnyType x)
	{	
		//Doubling the size if necessary.
		if(heap.length == size + 1)
		{
			doubleSize();
		}
	      
	    heap[size + 1] = x;
	      
	    //Checking to see if the only element in the heap is the new element x.
	    if(size == 0)
	    {
	    	size++;
	    	return;
	    }
	    
	    int i = size + 1;
	    AnyType temp;
	      
	    //Percolating up if the heap is not empty.
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
	 * Method to find the minimum value in the heap.
	 * @return Returns the value at position 1 of the heap which is the minimum value.
	 */
	public AnyType findMin()
	{
		return heap[1];
	}
	
	/**
	 * Method to remove the minimum value of the heap. Once it removes that value it will then reassign 
	 * the new minimum element to the last element in the array. It will then percolate down the new
	 * minimum element until it reaches the correct spot in the heap.
	 * @return Returns the minimum value of the heap after it removes it.
	 * @throws RuntimeException Throws an error message if the size of the heap is 0.
	 */
	public AnyType removeMin() throws RuntimeException
	{
		if(size == 0)
		{
			throw new RuntimeException();
		}
		
		//Assign the smallest element to min, and then reassign the last element as the smallest element.
		AnyType min = heap[1];
	   	heap[1] = heap[size];
	   	 
	   	//Calling percolatingDown on the new element at index 1 and then reassigning the last spot in the array
	   	//to 0 and then decreasing the size of the array.
	   	percolatingDown(1);
	   	heap[size] = null;
	   	size--;
	   	return min; 
	}
	
	/**
	 * Method to double the size of the heap by creating a new array with double the size of the 
	 * previous array's length, it will then copy the old array onto the new array.
	 */
	private void doubleSize()
	{
		if(size == 0)
		{
			throw new IllegalArgumentException();
		}
		
		else
		{
			//Creating a new array with double the size of old array and then copying old onto new.
			AnyType [] old = heap;
			heap = (AnyType []) new Comparable[heap.length * 2];
			System.arraycopy(old, 1, heap, 1, size);
		}	
	}

	/**
	 * Method to convert the heap into a string, if the heap is empty it will print that instead.
	 */
	public String toString()
	{
		if(size <= 0)
		{
			String errorMessage = "The heap is empty!";
			return errorMessage;
		}
		String out = "";
		
	    for(int k = 1; k <= size; k++)
	    {
	    	out += heap[k]+" ";
	    }
	    
	    return out;
	}
	
	/**
	 * Method to build a heap from a given array by assigning the length of the array to the size of
	 * the heap and copying the values of the array onto the heap starting at index 1 of the heap.
	 * It will then call the other buildHeap() method.
	 * @param array The array to be converted into a heap.
	 */
	public void buildHeap(AnyType[] array)
	{
		if(array.length <= 0)
		{
			throw new IllegalArgumentException();
		}
		
		else
		{
			//Copying the array length onto the size variable and then copying the original array onto heap array.
			size = array.length;
			heap = (AnyType[]) new Comparable[size+1];
			System.arraycopy(array, 0, heap, 1, size);
			buildHeap();
		}
	}
	
	/**
	 * Method to be used with the other buildHeap() method that will percolate down each element until
	 * the heap is in correct order.
	 */
	private void buildHeap()
	{
		if(size <= 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			for (int k = size/2; k > 0; k--)
			{
				percolatingDown(k);
			}
		}
	} 
	
	/**
	 * Method to be used with buildHeap() that will compare the element to it's children and swap them
	 * if necessary until it creates correct heap order.
	 * @param k The index to percolate down from.
	 */
	private void percolatingDown(int k)
	{
		if(size <= 0)
		{
			throw new IllegalArgumentException();
		}
		
		AnyType tmp = heap[k];
	    int child;

	    for(; 2*k <= size; k = child)
	    {
	    	child = 2*k;

	    	if(child != size && heap[child].compareTo(heap[child + 1]) > 0) 
	    	{
	    		child++;
	    	}

	    	if(tmp.compareTo(heap[child]) > 0)  
	    	{
	    		heap[k] = heap[child];
	    	}
	       
	    	else
	    	{
	    		break;
	    	}       
	    }
	    heap[k] = tmp;
	}   
	
	/**
	 * Method to be used with printHeapHelper that will print the heap in somewhat tree fashion
	 * by printing the nodes and then printing the children of those nodes for each node in the tree.
	 */
	public void printHeap()
	{
		printHeapHelper(1);
	}
	  
	/**
	 * Method to be used with printHeap that will print the heap in somewhat tree fashion
	 * by printing the nodes and then printing the children of those nodes for each node in the tree.
	 */
	private void printHeapHelper(int index)
	{
		if(size == 0 || index < 1)
		{
			throw new IllegalArgumentException();
		}
		
		//If the element has 2 children.
		if(index * 2 < heap.length && heap[index * 2] != null && heap[index * 2 + 1] != null)
		{
			System.out.println("The element is - " + heap[index] + " and it's children are - "
					+ heap[index * 2] + " and " + heap[index * 2 + 1]);
		}
		
		//If the element has 1 child.
		else if(index * 2 < heap.length && heap[index * 2] != null)
		{
			System.out.println("The element is - " + heap[index] + " and it's children are - "
					+ heap[index * 2]);
			
			printHeapHelper(index * 2);
		}
		
		//If the element has 0 children.
		else
		{
			System.out.println("The element is - " + heap[index] + " and it has no children");
		}
		
		//Recursing on the element's left and right children.
		if(index * 2 < size)
		{
			printHeapHelper(index * 2);
			printHeapHelper(index * 2 + 1);
		}
	}
	
	/**
	 * Method to take an array, convert it into a heap and then use that heap to return the k smallest
	 * elements as an array that is filled in order with those elements. The method will then attempt
	 * to restructure the heap by reinserting the smallest elements that were removed.
	 * @param myArray The array to find the smallest k elements in.
	 * @param k The amount of smallest elements to find from myArray.
	 * @return Returns a new array that contains the smallest k elements from the array it was given.
	 */
	public AnyType[] kSmallest(AnyType[] myArray , int k)
	{
		if(myArray == null || myArray.length < 1 || k < 0 || myArray.length < k)
		{
			throw new IllegalArgumentException();
		}

		//Create a new array with size k to store k smallest elements.
		AnyType[] smallestArray = (AnyType[]) new Comparable[k];

		//Building a heap with the array that was sent to this method.
		this.buildHeap(myArray); 
		
		System.out.println("Heap after being built in kSmallest - " + this);
		
		//Calling removeMin() k amount of times and assigning those to the smallestArray.
		for(int i = 1; i <= k; i++)
		{
			smallestArray[i - 1] = this.removeMin();
		}
		
		//Reinserting back into the built heap, will not be in the same order as before. This is not needed
		//but I added it for fun to mess around with reinsertions.
		for(int i = 0; i < k; i++)
		{
			this.insert((AnyType) smallestArray[i]);
		}
		
		return smallestArray;
	}
	
	public static void main(String[] args) 
	{
		//Testing of various methods.
		GenericHeap<Integer> h = new GenericHeap<Integer>();
		Integer[] a = {2,5,3,9,6,11,4,17,10,8}; 
	    
	    h.buildHeap(a);    
	    System.out.println(h);
	      	
	    h.insert(20);
	    System.out.println(h);
	    h.removeMin();
	    System.out.println(h);
	    h.insert(2);
	    System.out.println(h);
	    h.removeMin();
	    System.out.println(h);
	    h.insert(0);
	    System.out.println(h);
  
	    h.printHeap();
	    
	    //Testing of kSmallest method.
	    System.out.println("\n Testing of kSmallest on integers - ");
	    Integer[] myArray = {1,23,12,9,30,2,50};
	    GenericHeap<Integer> myHeap = new GenericHeap<Integer>();
	    
	    Object[] smallestArray = myHeap.kSmallest(myArray, 3);
	    
	    System.out.println(myHeap);
	    myHeap.printHeap();
	    
	    Integer[] fixedArray = new Integer[smallestArray.length];
	    
	    for(int i = 0; i < fixedArray.length; i++)
	    {
	    	fixedArray[i] = (Integer) smallestArray[i];
	    }
	    System.out.println("Smallest elements are - ");
	    for(int i = 0; i < fixedArray.length; i++)
	    {
	    	System.out.print(fixedArray[i]);
	    }
	    
	    //Testing of kSmallest on strings.
	    System.out.println("\n\n Testing of kSmallest on strings - ");
	    String[] myStringArray = {"C", "A", "D", "B", "G", "E", "F"};
	    GenericHeap<String> myStringHeap = new GenericHeap<String>();
	    
	    Object[] smallestStringArray = myStringHeap.kSmallest(myStringArray, 2);
	    
	    myStringHeap.kSmallest(myStringArray, 2);
	    System.out.println(myStringHeap);
	    
	    String[] fixedStringArray = new String[smallestStringArray.length];
	    
	    for(int i = 0; i < fixedStringArray.length; i++)
	    {
	    	fixedStringArray[i] = (String) smallestStringArray[i];
	    }
	    System.out.println("Smallest elements are - ");
	    for(int i = 0; i < fixedStringArray.length; i++)
	    {
	    	System.out.print(fixedStringArray[i]);
	    }
	    
	    //Testing of broken array. Type casting from generic array to another type results in an error and it
	    //says "[Ljava.lang.Comparable; cannot be cast to [Ljava.lang.Integer;". 
//	    System.out.println("Testing of broken array - ");
//	    Integer[] myArrayBroken = {1,23,12,9,30,2,50};
//	    GenericHeap<Integer> myHeapBroken = new GenericHeap<Integer>();
//	    
//	    Integer[] smallestArrayBroken = (Integer[]) myHeapBroken.kSmallest(myArrayBroken, 3);
//	    
//	    System.out.println(myHeap);
//	    myHeap.printHeap();
//	    
//	    for(int i = 0; i < smallestArrayBroken.length; i++)
//	    {
//	    	System.out.print(smallestArrayBroken[i]);
//	    }
	}
}
