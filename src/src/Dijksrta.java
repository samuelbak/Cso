package src;

import java.util.List;
import util.Connection;

public class Dijksrta extends Thread {
	
	public  static String solver(Integer startNode, Integer endNode, Nodo[] graph){
		Integer currentNode = startNode;
		Integer nextNodePotential = Integer.MAX_VALUE;
		Integer nextNode = 0;
		String solution ="";
		
		graph[currentNode].potential=0;
		
		while(2>1){		
			graph[currentNode].definitive=true;
		
			List<Connection> conList = graph[currentNode].connectionsList;
			for (Connection con: conList){
				if (graph[con.toNodeId].definitive == false)
					graph[con.toNodeId].potential = graph[currentNode].potential+con.weigth;
			}
				
			for (Connection con: conList){
				if (graph[con.toNodeId].definitive == false){
					if (graph[con.toNodeId].potential<nextNodePotential){
						nextNode = con.toNodeId;
						nextNodePotential = graph[con.toNodeId].potential;
					}
				}
			}
				
			currentNode = nextNode;
			nextNodePotential = Integer.MAX_VALUE;
			solution = solution+currentNode+" -> ";
			if (currentNode == endNode)
				break;
				
		}
		
		return solution;
	}

}
