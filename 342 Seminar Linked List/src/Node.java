
public class Node
{
	private int data;
	private Node next;
	
	public Node(int inputInfo, Node nextNode)
	{
		data = inputInfo;
		next = nextNode;
	}
	
	public int getData()
	{
		return data;
	}
	
	public Node getNodeNext()
	{
		return next;
	}
	
	public void setData(int newData)
	{
		data = newData;
	}
	
	public void setNodeNext(Node nextNode)
	{
		next = nextNode;
	}
}
