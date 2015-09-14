
public class MyList
{
	public Node head;
	private static int size;
	
	public MyList()
	{
		head = null;
		size = 0;
	}
	
	public static int getSize()
	{
		return size;
	}
	
	public void addNumber(int numberAdd)
	{
		Node newNode = new Node(numberAdd, null);
		Node tempNode = head;
		
		if(head == null)
		{
			head = newNode;
			size++;
			return;
		}
		
		while(tempNode.getNodeNext() != null)
		{
			tempNode = tempNode.getNodeNext();
		}
		
		tempNode.setNodeNext(newNode);
		size++;
	}
	
	public void printList()
	{
		Node tempNode = head;
		
		if(head == null)
		{
			System.out.println("The list is empty!");
			return;
		}
		
		System.out.print("Head -> ");
		while(tempNode != null)
		{
			System.out.print(tempNode.getData());
			tempNode = tempNode.getNodeNext();
			
			if(tempNode != null)
			{
				System.out.print(" -> ");
			}
			else
			{
				System.out.print(" -> null");
			}
		}
		System.out.println();
		System.out.println();
	}
	
	public MyList(int[] newList)
	{
		int arrayLength = newList.length;
		
		for(int i = 0; i < arrayLength; i++)
		{
			addNumber(newList[i]);
		}
	}
	
	public int countNumber(int numberCount)
	{
		int numberTotal = 0;
		Node tempNode = head;
		
		if(head == null)
		{
			return 0;
		}
		
		while(tempNode != null)
		{
			if (tempNode.getData() == numberCount)
			{
				numberTotal++;
			}
			tempNode = tempNode.getNodeNext();
		}
		
		return numberTotal;
	}
	
	public boolean deleteFirst(int target)
	{
		Node tempNode = head;

		if(head == null)
		{
			return false;
		}
		
		else
		{
			if(head.getData() == target)
			{
				head = head.getNodeNext();
				return true;
			}
			else
			{
				while(tempNode.getNodeNext() != null && (tempNode.getNodeNext()).getData() != target)
				{
					tempNode = tempNode.getNodeNext();
				}
				
				if(tempNode.getNodeNext() == null)
				{
					return false;
				}
				else
				{
					tempNode.setNodeNext((tempNode.getNodeNext()).getNodeNext());
					return true;
				}
			}
		}
	}
	
	public int deleteAll(int target)
	{
		int numberTotal = 0;
		
		while(this.deleteFirst(target) != false)
		{
			numberTotal++;
		}
		
		return numberTotal;
	}
	
	public void clearList()
	{
		head = null;
	}

	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		if(head == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((head == null) ? 0 : head.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyList other = (MyList) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		return true;
	}
}
