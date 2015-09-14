import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class MyGraph {

	private TreeSet<Character> nodes;
	private TreeMap<MyEdge, Integer> edges;

	public MyGraph() {
		nodes = new TreeSet<>();
		edges = new TreeMap<>();

	}

	public int edgeWeight(char start, char end) {
		final MyEdge target = new MyEdge(start, end);
		if (!edges.containsKey(target)) {
			return -1;
		} else {
			return edges.get(target);
		}
	}

	public void addEdge(char start, char end, int weight) {
		if (edgeWeight(start, end) != -1) {
			System.out.println("That edge already exists.");
		} else {
			nodes.add(start);
			nodes.add(end);
			final MyEdge e = new MyEdge(start, end);
			edges.put(e, weight);
		}
	}

	public int numEdges() {
		return edges.size();
	}

	public int numNodes() {
		return nodes.size();
	}

	/* START HERE */

	//checks whether the graph contains a node. 
	//returns true if it contains that node, false if not
	public boolean containsNode(char target) {
		if(!nodes.contains(target))
		{
			return false;
		}
		else
		{
			return true;
		}
		//UPDATE WITH YOUR CODE
	}

	//checks whether the graph contains an edge. 
	//returns true if it contains that edge, false if not
	public boolean containsEdge(char start, char end) {
		final MyEdge target = new MyEdge(start, end);
		if(!edges.containsKey(target))
		{
			return false;
		}
		else
		{
			return true;
		}
		//UPDATE WITH YOUR CODE
	}

	//returns a list of all the neighbors of a node
	//(that is, all nodes that node is connected to by a single edge)
	public List<Character> neighbors(char target) {
		List<Character> myList = new ArrayList<>();
		Set<MyEdge> mySet = edges.keySet();
		Iterator<MyEdge> myIterator = mySet.iterator();
		
		while(myIterator.hasNext())
		{
			final MyEdge curEdge = myIterator.next();
			if(curEdge.myStart == target)
			{
				myList.add(curEdge.myEnd);
			}
			else if(curEdge.myEnd == target)
			{
				myList.add(curEdge.myStart);
			}
		}
		
		return myList;
		//UPDATE WITH YOUR CODE
	}

	//checks whether two nodes are connected
	//returns true if they are, false if not
	//not they are connected if a path exists between them, they can still be connected
	//if they aren't neighbors
	public boolean isConnected(char start, char end) {
		final MyEdge target = new MyEdge(start, end);
		Set<MyEdge> mySet = edges.keySet();
		Iterator<MyEdge> myIterator = mySet.iterator();
		
		while(myIterator.hasNext())
		{
			final MyEdge curEdge = myIterator.next();
			if(curEdge.myStart == target.myStart)
			{
				if(curEdge.myEnd == target.myEnd)
				{
					return true;
				}
				else
				{
					while(myIterator.hasNext())
					{
						final MyEdge secondEdge = myIterator.next();
						if(secondEdge.myEnd == target.myEnd)
						{
							return true;
						}
					}
				}
			}
		}
		
		return false;
		//UPDATE WITH YOUR CODE
	}

	//returns the shortest path (in weight) from one node to another
	public int shortestPath(char start, char end) {
		int weight = 0;
		final MyEdge target = new MyEdge(start, end);
		Set<MyEdge> mySet = edges.keySet();
		Iterator<MyEdge> myIterator = mySet.iterator();
		
		while(myIterator.hasNext())
		{
			MyEdge curEdge = myIterator.next();
			weight += edges.get(curEdge);
			if(curEdge.myStart == target.myStart)
			{
				if(curEdge.myEnd == target.myEnd)
				{
					return weight;
				}
				else
				{
					while(myIterator.hasNext())
					{
						curEdge = myIterator.next();
						weight += edges.get(curEdge);
						if(curEdge.myEnd == target.myEnd)
						{
							return weight;
						}
					}
					return 0;
				}
			}
		}
		
		return weight;
		//UPDATE WITH YOUR CODE
	}
	
	//prints out a depth first search of the graph
	//favors edges with lowest weights
	public void depthFirst(char start) {
		System.out.println("Unimplemented.");
		//UPDATE WITH YOUR CODE
	}

	//prints out a bredth first search of the graph
	//favors edges with lowest weights
	public void bredthFirst(char start) {
		System.out.println("Unimplemented.");
		//UPDATE WITH YOUR CODE
	}

	@Override
	public String toString() {
		return "MyGraph [nodes=" + nodes + ", edges=" + edges + "]";
	}



	class MyEdge implements Comparable<MyEdge> {
		public final char myStart;
		public final char myEnd;

		//constructs an edge. Ensures start is always less than end
		public MyEdge(char start, char end) {
			if (start < end) {
				myStart = start;
				myEnd = end;
			} else if (start > end){
				myStart = end;
				myEnd = start;
			} else {
				throw new IllegalArgumentException("Start and end cannot be the same node.");
			}
		}


		@Override
		public int compareTo(MyEdge rhs) {
			int res = 0;

			if (myStart < rhs.myStart) {
				res = -1;
			} else if (myStart > rhs.myStart) {
				res = 1;
			} else if (myEnd < rhs.myEnd) {
				res = -1;
			} else if (myEnd > rhs.myEnd) {
				res = 1;
			}

			return res;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + myEnd;
			result = prime * result + myStart;
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
			MyEdge other = (MyEdge) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (myEnd != other.myEnd)
				return false;
			if (myStart != other.myStart)
				return false;
			return true;
		}


		private MyGraph getOuterType() {
			return MyGraph.this;
		}


		@Override
		public String toString() {
			return "<" + myStart + ", " + myEnd + ">";
		}

	}
}
