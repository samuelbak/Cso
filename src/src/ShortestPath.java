package src;

import java.util.List;

import util.Connection;

public class ShortestPath{
	
	//ENUM-LIKE CONSTANT
	private	final Integer NODE_WEIGHT = 0;
	private final Integer NODE_VISITED = 1;
	private final Integer NODE_PRECEDENT = 2;
	private Nodo[] graph;
	private Integer[][] dijkstraTable;
	
	public ShortestPath(Nodo[] graph){
		this.graph = graph;
	}
	
	public String dijkstra(Integer startNode, Integer endNode){
			
		dijkstraTable = new Integer[graph.length][3];
		for(int i=0;i<graph.length;i++){
			dijkstraTable[i][NODE_WEIGHT] = Integer.MAX_VALUE;		//peso
			dijkstraTable[i][NODE_VISITED] = 0;						//non visitato
		}
		
		Integer currentNode = startNode;
		Integer previousNode = startNode;
		dijkstraTable[currentNode][NODE_WEIGHT] = 0;					//Inizializzazione nodo di partenza
		dijkstraTable[currentNode][NODE_VISITED] = 1;
		dijkstraTable[currentNode][NODE_PRECEDENT] = 0;
		
		while(2>1){
			//Calcolo percorsi nodi vicini
			List<Connection> conList = graph[currentNode].connectionsList;
			for(Connection con: conList){
				if((dijkstraTable[con.toNodeId][NODE_WEIGHT] > con.weight + dijkstraTable[currentNode][NODE_WEIGHT]) 
						&& dijkstraTable[con.toNodeId][NODE_VISITED] == 0)
					dijkstraTable[con.toNodeId][NODE_WEIGHT] = con.weight + dijkstraTable[currentNode][NODE_WEIGHT];
			}

			dijkstraTable[currentNode][NODE_VISITED] = 1;
			dijkstraTable[currentNode][NODE_PRECEDENT] = previousNode;
			
			if (areAllNodesDefinitive() || dijkstraTable[endNode][NODE_VISITED] == 1)
				break;
			
			//nodo con peso minore
			Integer ligtherNodeWeigth = Integer.MAX_VALUE;
			for(int i=0;i<graph.length;i++){
				if(dijkstraTable[i][NODE_VISITED] == 0 && dijkstraTable[i][NODE_WEIGHT]<ligtherNodeWeigth){
					ligtherNodeWeigth = dijkstraTable[i][NODE_WEIGHT];
					currentNode = i;
				}
			}
		}
		
		String solution = " -> "+endNode;
		Integer remainingWeight = dijkstraTable[endNode][NODE_WEIGHT];
		Integer precedentNode = endNode;
		while (remainingWeight != 0){
			List<Connection> conList = graph[precedentNode].connectionsList;
			for(Connection con: conList){
				if(dijkstraTable[con.toNodeId][NODE_WEIGHT] == dijkstraTable[precedentNode][NODE_WEIGHT] - con.weight){
					solution = " -> "+con.toNodeId+solution;
					remainingWeight = dijkstraTable[con.toNodeId][NODE_WEIGHT];
					precedentNode = con.toNodeId;
				}
			}
		}
		return "\tTotal weight: "+dijkstraTable[endNode][NODE_WEIGHT]+"\t"+solution.substring(4, solution.length());
	}
		
	private boolean areAllNodesDefinitive(){
		for(int i=0; i<graph.length; i++){
			if(dijkstraTable[i][1] == 0)
				return false;
		}
		return true;
	}
}
