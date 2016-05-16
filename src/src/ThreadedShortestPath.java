package src;

public class ThreadedShortestPath implements Runnable {

	//ENUM-LIKE CONSTANT
	private	final Integer NODE_WEIGHT = 0;
	private final Integer NODE_VISITED = 1;
	private final Integer NODE_PRECEDENT = 2;
	private Node[] graph;
	private Integer[][] dijkstraTable;
	public Integer num;
	
	@Override
	public void run() {
		synchronized (this){
			num = 0;
			for (int i = 0;i<10000;i++)
				num++;
			notify();
		}
	}
}
