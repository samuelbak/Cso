package util;

import java.util.Random;
import src.Nodo;

public class Graph {
	
	public static Nodo[] createRandomNodes(Integer limit){
		Random rnd = new Random();
		Integer numberOfNodes = rnd.nextInt(limit);
		Nodo[] nodi = new Nodo[numberOfNodes];
		for (int j = 0; j < nodi.length; j++) {
			nodi[j] = new Nodo(j++);
		}
		return nodi;
	}
	
	public static Integer[][] createRandomMatrix(Integer numberOfNodes, Integer maxNodeConnections){
		Random rnd = new Random(System.currentTimeMillis());
		Integer limit = rnd.nextInt(numberOfNodes);
		if (limit<5)
			limit=5;
		Integer[][] matrix = new Integer[limit][limit];
		
		return matrix;
	}
	
	public static Nodo[] getGraphFromMatrix(Integer[][] matrix){
		return new Nodo[1];
	}

}
