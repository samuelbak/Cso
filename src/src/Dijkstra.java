package src;

import java.util.List;
import util.Connection;

public class Dijkstra{
	
	private Nodo[] graph;
	
	public Dijkstra(Nodo[] graph){
		this.graph = graph;
	}
	
	public String solver(Integer startNode, Integer endNode){
		Integer currentNode = startNode;
		Integer nextNodePotential = Integer.MAX_VALUE;
		Integer nextNode = 0;
		String solution = String.valueOf(startNode)+" -> ";
		
		graph[currentNode].potential=0;
		
		//Evaluate shortest path tree
		while(2>1){		
			graph[currentNode].definitive=true;	
			List<Connection> conList = graph[currentNode].connectionsList;
			for (Connection con: conList){
				if (graph[con.toNodeId].definitive == false){
						if (graph[currentNode].potential+con.weigth <= graph[con.toNodeId].potential)
							graph[con.toNodeId].potential = graph[currentNode].potential+con.weigth;
				}
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
			//solution = solution+currentNode+" -> ";
			if (areAllNodesDefinitive())
				break;		
		}
		//Evaluate shortest path to the end node
		solution = " -> "+String.valueOf(endNode)+"  Total weigth: "+graph[endNode].potential;
		currentNode = endNode;
		Integer weigth = graph[currentNode].potential;
		while(weigth>0){
			List<Connection> conList = graph[currentNode].connectionsList;
			for (Connection con: conList){
				if(graph[currentNode].potential-con.weigth == graph[con.toNodeId].potential){
					nextNode = con.toNodeId;
				}
			}
			currentNode = nextNode;
			weigth = graph[currentNode].potential;
			solution = " -> "+currentNode+solution;
		}
		
		return solution.substring(4, solution.length());
	}
	
	public void resetShortestPathTree(){
		for(Nodo nodo: graph){
			nodo.definitive = false;
			nodo.potential = Integer.MAX_VALUE;
		}
	}
	
	private boolean areAllNodesDefinitive(){
		for(Nodo nodo: graph){
			if (nodo.definitive == false)
				return false;
		}
		return true;
	}
}
