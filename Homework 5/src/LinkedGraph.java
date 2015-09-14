import java.util.*;
public class LinkedGraph 
{
	private class Node
	{
		List<Node> adjacencyList;
		String label;
		//Path included to be used for shortestDistance.
		int path;
		
		public Node(String lbl)
		{
			label = lbl;
			adjacencyList = new ArrayList<Node>();
			path = 0;
		}
		
		public String toString()
		{
			return label;
		}
	}
	
	Map<String, Node> nodeList;
	boolean directed;
	
	/**
	 * Creates empty LinkedGraph.  Default is undirected.
	 */
	public LinkedGraph()
	{
		directed = false;
		nodeList = new TreeMap<String,Node>();
	}
	
	/**
	 * Adds a new node to the LinkedGraph.
	 * 
	 * @param label The label of the new node.
	 */
	public void addNode(String label)
	{
		nodeList.put(label, new Node(label));
	}
	
	/**
	 * Adds a new edge to the LinkedGraph.
	 * @param source The source endpoint of the edge.
	 * @param dest The destination endpoint of the edge.
	 */
	public void addEdge(String source, String dest)
	{
		Node src = nodeList.get(source);
		Node dst = nodeList.get(dest);
		if(src != null && dst != null)
		{
			src.adjacencyList.add(dst);
			if(!directed && src != dst)
			{
				dst.adjacencyList.add(src);
			}
		}	
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		for(Node nde : nodeList.values())
		{
			sb.append(nde.toString());
			sb.append(" : ");
			for(Node oth : nde.adjacencyList)
			{
				sb.append('(');
				sb.append(nde.toString());
				sb.append(", ");
				sb.append(oth.toString());
				sb.append(')');
				sb.append(' ');
			}
			sb.append('\n');
		}
		
		return sb.toString();
	}
	
	/**
	 * This method will take 2 Strings, one for the source to start at and one for the destination to end on. The method will return the
	 * shortest path available as an integer from the source to the destination. Or -1 if the destination was not in the graph.
	 * @param source The Node to start at.
	 * @param dest The Node to end at.
	 * @return Returns the shortest path between source and destination.
	 */
	public int shortestPath(String source, String dest)
	{
		Node src = nodeList.get(source);
		Node dst = nodeList.get(dest);
		
		//Initializing one queue to handle nodes that need to be visited still and one to handle nodes that have already been visited.
		Queue<Node> myQueue = new LinkedList<Node>();
		Queue<Node> visitedQueue = new LinkedList<Node>();
		
		if(src == null || dst == null)
		{
			throw new IllegalArgumentException();
		}
		
		else
		{
			//Add source to the queue and then set it's path to 0.
			myQueue.add(src);
			src.path = 0;
			
			//If the source and the destination are the same node then the shortest path is 0.
			if(src == dst)
			{
				return 0;
			}
			
			while(!myQueue.isEmpty())
			{
				//Remove the first node and add it to the visited queue.
				Node v = myQueue.remove();
				visitedQueue.add(v);
				
				for(int i = 0; i < v.adjacencyList.size(); i++)
				{
					//Assign the first node of v's list to u.
					Node u = v.adjacencyList.get(i);
					
					if(visitedQueue.contains(u) == true)
					{
						System.out.println("Visited already contains " + u);
					}
					
					else
					{
						//Add u to the queue that has already been visited and to the queue that needs to be processed.
						System.out.println("Adding - " + u);
						visitedQueue.add(u);
						myQueue.add(u);
						
						//Update u's path to be the path of the previous node + 1.
						u.path = v.path + 1;
						
						System.out.println(u + " path is - " + u.path);
						
						//If the visited queue contains the destination then return it's path.
						if(visitedQueue.contains(dst) == true)
						{
							return u.path;
						}
					}
				}
			}
		}
		
		//Returning -1 if the destination is not in the graph.
		System.out.println("The destination was not found!");
		return -1;
	}
}