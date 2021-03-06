package src;

public class Train implements Runnable {

	private Integer start;
	private Integer end;
	private Node[] graph;
	private Thread t;
	private String threadName;
	
	public Train(Integer startNodeId, Integer endNodeId, Node[] graph, String threadName){
		start 	= startNodeId;
		end 	= endNodeId;
		this.graph = graph;
		this.threadName = threadName;
	}	
	
	public void run(){
		ShortestPath sp = new ShortestPath(graph);
		System.out.println(threadName+": "+sp.dijkstra(start, end));
		return;
	}
	
	public void start(){
		if (t==null){
			t = new Thread(this);
			t.start();
		}
	}
}
