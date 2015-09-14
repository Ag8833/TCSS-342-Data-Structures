package util;

import interfaces.BST;

public class ArrayBST implements BST {
	
	final int MAXTREESIZE = 20;
	/**
	 * USE THIS AS YOUR BACKINGSTORE! Do not use Nodes or linked structures.
	 */
	int[] myTree;
	int size;
	
	public ArrayBST()
	{
		myTree = new int[MAXTREESIZE];
		size = 0;
	}
	
	void fillNegatives()
	{
		for(int i = 0; i < MAXTREESIZE; i++)
		{
			myTree[i] = -1;
		}
	}

	@Override
	public void clear() 
	{
		for(int i = 0; i < MAXTREESIZE; i++)
		{
			myTree[i] = -1;
		}
	}

	@Override
	public boolean contains(int e) 
	{
		for(int i = 0; i < MAXTREESIZE; i++)
		{
			if(myTree[i] == e)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] toArray() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(int e)
	{
		int index = 0;
		
		if(e < 0)
		{
			return false;
		}
		
		return(addHelper(e, index));
	}
	
	private boolean addHelper(int e, int index)
	{
		while(index > myTree.length)
		{
			resizeArray(); 
		}
		
		if(myTree[index] == -1)
		{
			myTree[index] = e;
			return true;
		}
		
		if(myTree[index] == e)
		{
			return false;
		}
		
		if(e > myTree[index])
		{
			return addHelper(e, 2*index+2);
		}
		
		else
		{
			return addHelper(e, 2*index+1);
		}
	}

	@Override
	public int remove(int e) 
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public ArrayBST clone() 
	{
		return null;
	}
	
	private void resizeArray()
	{
		int[] newArray = new int[myTree.length*2 + 1];
		for(int i = 0; i < myTree.length; i++)
		{
			newArray[i] = myTree[i];
		}
		
		for(int j = myTree.length; j < myTree.length*2 + 1; j++)
		{
			newArray[j] = -1;
		}
		myTree = newArray;
	}
}
