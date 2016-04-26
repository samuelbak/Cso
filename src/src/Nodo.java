package src;

import java.util.ArrayList;
import java.util.List;
import util.Connection;

public class Nodo {
	
	public Integer nodeId;
	public Integer potential;
	public Boolean definitive;
	private NodeStructure[] nodeConnectionsWeigth;
	public List<Connection> connectionsList;
	
	public Nodo(Integer nodeId, Integer numberOfNodes){
		this.nodeId = nodeId;
		this.nodeConnectionsWeigth = new NodeStructure[numberOfNodes];
		this.connectionsList = new ArrayList<Connection>();
		this.potential = Integer.MAX_VALUE;
		this.definitive = false;
	}
	
	/*
	public boolean addNodeConnection(Integer nodeId, Integer weight){
		for (int i = 0; i<this.nodeConnectionsWeigth.length; i++){
			if (this.nodeConnectionsWeigth[i] != null){
				this.nodeConnectionsWeigth[i] = new NodeStructure(nodeId, weight);
				return true;
			}
		}
		return false;
	}
	*/
	
	public boolean addNodeConnection(Integer nodeId, Integer weight){
		if(!connectionsList.contains(new Connection(nodeId, weight))){
			connectionsList.add(new Connection(nodeId, weight));
			return true;
		}
		return false;
	}
	/*
	public Integer getNodeConnectionWeigthTo(Integer nodeId){
		for (int i=0; i<this.nodeConnectionsWeigth.length;i++){
			if (this.nodeConnectionsWeigth[i].connectionToNodeId == nodeId)
				return this.nodeConnectionsWeigth[i].connectionWeight;
		}
		return 0;
	}
	*/

	public Integer getNodeConnectionWeigthTo(Integer nodeId){
		for(Connection con: connectionsList){
			if (con.toNodeId == nodeId)
				return con.weigth;
		}
		return -1;
	}
	
	
	@Override
	public String toString(){
		String obj = "[nodeId: "+this.nodeId+"]";
		return obj;
	}

}
