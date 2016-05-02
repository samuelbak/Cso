package src;

public class Train implements Runnable {

	private Integer start;
	private Integer end;
	private Nodo[] graph;
	
	public Train(Integer startNodeId, Integer endNodeId, Nodo[] graph){
		start 	= startNodeId;
		end 	= endNodeId;
		this.graph = new Nodo[graph.length];
		for (int i=0; i<graph.length;i++)
			this.graph[i] = graph[i].clone();	
	}	
	
	public void run(){
		ShortestPath sp = new ShortestPath(graph);
		System.out.println(sp.dijkstra3(start, end));
	}
}
