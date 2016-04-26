package src;

import java.util.List;
import util.Connection;

public class Dijksrta extends Thread {
	
	public Dijksrta(Integer startNode, Integer endNode, Nodo[] graph){
		
		graph[startNode].potential=0;
		
		List<Connection> conList = graph[startNode].connectionsList;
		
		for (Connection con: conList){
			graph[con.toNodeId].potential = graph[startNode].potential+con.weigth;
		}
	}

}
