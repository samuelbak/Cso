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
	
	public static void printMatrix(Integer[][] matrix){
		for (int i=0; i<matrix.length; i++){
			for (int j=0; j<matrix.length; j++){
				if(matrix[i][j] != null)
					System.out.print("["+matrix[i][j]+"]");
				else
					System.out.print("[ ]");
			}
			System.out.println("");
		}
	}
	
	public static Integer[][] createRandomMatrix(final Integer numberOfNodes,final Integer maxNodeConnections){
		Random rnd = new Random(System.currentTimeMillis());
		Integer[][] matrix = new Integer[numberOfNodes][numberOfNodes];
		for (int i=0;i<numberOfNodes-1; i++){
			int limit = numberOfNodes-i-1;
			if (limit > maxNodeConnections)
				limit = maxNodeConnections;
			int connections = rnd.nextInt(limit)+1;
			for (int j=0;j<connections;j++){
				while(true){
					int random = rnd.ints(i+1, numberOfNodes).limit(1).findFirst().getAsInt();
					if (matrix[i][random] == null){
						matrix[i][random] = rnd.nextInt(9)+1;
						break;

					}
				}
			}
		}
		
		return matrix;
	}
	
	public static Nodo[] getGraphFromMatrix(Integer[][] matrix){
		Nodo[] nodi = new Nodo[matrix.length];
		for (int i=0; i<nodi.length; i++)
			nodi[i] = new Nodo(i);
		for (int i=0; i<nodi.length; i++){
			for(int j=i+1; j<nodi.length; j++){
				if (matrix[i][j]!=null){
					nodi[i].addNodeConnection(j, matrix[i][j]);
					nodi[j].addNodeConnection(i, matrix[i][j]);
				}
			}
		}
		return nodi;
	}

}
