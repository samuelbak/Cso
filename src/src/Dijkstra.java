package src;

import java.util.ArrayList;
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
	
	public String solver2(Integer startNode, Integer endNode){
		//Inizializzazione
		Integer currentNode = startNode;
		graph[startNode].definitive = true;					//S={1}
		graph[startNode].potential = 0;						//f(1)=0
		graph[startNode].precNode = 0;						//J(1)=0
		List<Connection> conList = graph[startNode].connectionsList;
		for(Connection con: conList){
			graph[con.toNodeId].potential = con.weigth;		// f(i)=p(1,i)
			graph[con.toNodeId].precNode = startNode;		//J(i)=1
		}
		//Assegnazione etichetta permanente
		conList = graph[currentNode].connectionsList;
		Integer nextNode = conList.get(0).toNodeId;
		for(Connection con: conList){
			if(graph[nextNode].potential < )
		}
		return "";
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
