package src;

public class Nodo {
	
	public Integer nodeId;
	private NodeStructure[] nodeConnectionsWeigth;
	
	public Nodo(Integer nodeId, Integer numberOfNodes){
		this.nodeId = nodeId;
		this.nodeConnectionsWeigth = new NodeStructure[numberOfNodes];
	}
	
	public boolean addNodeConnection(Integer nodeId, Integer weight){
		for (int i = 0; i<this.nodeConnectionsWeigth.length; i++){
			if (this.nodeConnectionsWeigth[i] != null){
				this.nodeConnectionsWeigth[i] = new NodeStructure(nodeId, weight);
				return true;
			}
		}
		return false;
	}
	
	public Integer getNodeConnectionWeigthTo(Integer nodeId){
		for (int i=0; i<this.nodeConnectionsWeigth.length;i++){
			if (this.nodeConnectionsWeigth[i].connectionToNodeId == nodeId)
				return this.nodeConnectionsWeigth[i].connectionWeight;
		}
		return 0;
	}

}
