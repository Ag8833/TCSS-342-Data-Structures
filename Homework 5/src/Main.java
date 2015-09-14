public class Main {

	public static void main(String[] args) {
		LinkedGraph lg = new LinkedGraph();
		
		
		lg.addNode("A");
		lg.addNode("B");
		lg.addNode("C");
		lg.addNode("D");
		lg.addNode("E");
		lg.addNode("F");
		lg.addNode("G");
		lg.addNode("H");
		
		lg.addEdge("A", "B");
		lg.addEdge("A", "C");
		lg.addEdge("A", "D");
		lg.addEdge("B", "B");
		lg.addEdge("B", "H");
		lg.addEdge("C", "D");
		lg.addEdge("C", "E");
		lg.addEdge("C", "F");
		lg.addEdge("D", "E");
		lg.addEdge("D", "F");
		lg.addEdge("E", "F");
		lg.addEdge("F", "G");
		lg.addEdge("G", "H");
		
		System.out.println(lg);
		System.out.println(lg.shortestPath("A","G"));



	}

}