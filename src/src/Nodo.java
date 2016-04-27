package src;

import java.util.ArrayList;
import java.util.List;
import util.Connection;

public class Nodo {
	
	public Integer nodeId;
	public Integer potential;
	public Integer precNode;
	public Boolean definitive;
	public List<Connection> connectionsList;
	
	public Nodo(Integer nodeId){
		this.nodeId = nodeId;
		this.connectionsList = new ArrayList<Connection>();
		this.potential = Integer.MAX_VALUE;
		this.definitive = false;
	}
	
	public boolean addNodeConnection(Integer nodeId, Integer weight){
		if(!connectionsList.contains(new Connection(nodeId, weight))){
			connectionsList.add(new Connection(nodeId, weight));
			return true;
		}
		return false;
	}

	public Integer getNodeConnectionWeigthTo(Integer nodeId){
		for(Connection con: connectionsList){
			if (con.toNodeId == nodeId)
				return con.weigth;
		}
		return -1;
	}
	@Override
	public Nodo clone(){
		Nodo ret = new Nodo(this.nodeId);
		ret.potential = this.potential;
		ret.definitive = this.definitive;
		ret.connectionsList = this.connectionsList; 
		return ret;
		
	}
	@Override
	public String toString(){
		String obj = "[nodeId: "+this.nodeId+", Potential: "+this.potential+", Definitife: "+this.definitive+"]";
		return obj;
	}

}
