package src;

public class Train extends Thread {

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
		Dijkstra alg = new Dijkstra(graph);
		System.out.println(alg.solver2(start, end));
	}
}
