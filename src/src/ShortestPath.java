package src;

import java.util.List;

import util.Connection;

public class ShortestPath{
	
	private Nodo[] graph;
	private Integer[][] dijkstraTable;
	
	public ShortestPath(Nodo[] graph){
		this.graph = graph;
	}
	
	public String dijkstra(Integer startNode, Integer endNode){
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
	
	public String dijkstra2(Integer startNode, Integer endNode){
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
		while(2>1){
			conList = graph[currentNode].connectionsList;
			Integer nextNode = conList.get(0).toNodeId;
			Integer nextNodePotential = Integer.MAX_VALUE;
			for(Connection con: conList){					//Troviamo j in T tale che f(j)=min f(i) con i appartenente a T
				if((graph[con.toNodeId].potential < nextNodePotential) && !graph[con.toNodeId].definitive){
					nextNode = con.toNodeId;
					nextNodePotential = graph[con.toNodeId].potential;	
				}
			}
			graph[nextNode].definitive = true;				//T=T\{j} e S=S∪{j}
			if (areAllNodesDefinitive())					//Se T=Ø STOP
				break;
			if (nextNodePotential == Integer.MAX_VALUE)		//Se f(i)= ∞ per ogni i in T STOP
				break;
			conList = graph[nextNode].connectionsList;	//Per ogni i in T, adiacente a j e tale che f(i)>f(j)+p(j,i)
			for(Connection con: conList){
				if((graph[con.toNodeId].potential > (graph[nextNode].potential+con.weigth) && !graph[con.toNodeId].definitive)){
					graph[con.toNodeId].potential = graph[nextNode].potential+con.weigth;	//f(i)=f(j)+p(j,i)
					graph[con.toNodeId].precNode = nextNode;								//J(i)=j
				}
			}
			currentNode = nextNode;
			nextNodePotential = Integer.MAX_VALUE;
		}
		String solution = " -> "+endNode;
		currentNode = endNode;
		while (graph[currentNode].precNode != 0){
			solution = " -> " + graph[currentNode].precNode + solution;
			currentNode = graph[currentNode].precNode;
		}
		return solution.substring(4,solution.length());
	}
	
	public String dijkstra3(Integer startNode, Integer endNode){
		dijkstraTable = new Integer[graph.length][3];
		for(int i=0;i<graph.length;i++){
			dijkstraTable[i][0] = Integer.MAX_VALUE;		//peso
			dijkstraTable[i][1] = 0;						//non visitato
		}
		
		Integer currentNode = startNode;
		Integer previousNode = startNode;
		dijkstraTable[currentNode][0] = 0;					//Inizializzazione nodo di partenza
		dijkstraTable[currentNode][1] = 1;
		dijkstraTable[currentNode][2] = 0;
		while(2>1){
			//Calcolo percorsi nodi vicini
			List<Connection> conList = graph[currentNode].connectionsList;
			for(Connection con: conList){
				dijkstraTable[con.toNodeId][0] = con.weigth + dijkstraTable[currentNode][0];
			}
			//nodo con peso minore
			Integer lighterNodeId = conList.get(0).toNodeId;
			Integer ligtherNodeWeigth = conList.get(0).weigth;
			for (Connection con: conList){
				if((dijkstraTable[con.toNodeId][0] < ligtherNodeWeigth) && dijkstraTable[con.toNodeId][1] == 0){
					lighterNodeId = con.toNodeId;
					ligtherNodeWeigth = dijkstraTable[con.toNodeId][0];
				}
			}
			dijkstraTable[currentNode][1] = 1;
			dijkstraTable[currentNode][2] = previousNode;
			if (areAllNodesDefinitive())
				break;
			
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
		/*
		for(Nodo nodo: graph){
			if (nodo.definitive == false)
				return false;
		}
		return true;
		*/
		for(int i=0; i<graph.length; i++){
			if(dijkstraTable[i][1] == 0)
				return false;
		}
		return true;
	}
}
