package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Random;
import src.Node;

public class Graph {
	
	public static Node[] createRandomNodes(Integer limit){
		Random rnd = new Random();
		Integer numberOfNodes = rnd.nextInt(limit);
		Node[] nodes = new Node[numberOfNodes];
		for (int j = 0; j < nodes.length; j++) {
			nodes[j] = new Node(j++);
		}
		return nodes;
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
	
	public static Integer[][] createRandomMatrix(Integer numberOfNodes,Integer maxNodeConnections, Integer maxWeight){
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
						matrix[i][random] = rnd.nextInt(maxWeight)+1;
						break;
					}
				}
			}
		}
		
		return matrix;
	}
	
	public static Node[] getGraphFromMatrix(Integer[][] matrix){
		Node[] nodes = new Node[matrix.length];
		for (int i=0; i<nodes.length; i++)
			nodes[i] = new Node(i);
		for (int i=0; i<nodes.length; i++){
			for(int j=i+1; j<nodes.length; j++){
				if (matrix[i][j]!=null){
					nodes[i].addNodeConnection(j, matrix[i][j]);
					nodes[j].addNodeConnection(i, matrix[i][j]);
				}
			}
		}
		return nodes;
	}

	public static Integer[][] getMatrixFromFile(String textFile) throws FileNotFoundException, IOException{
		InputStream inFile = new FileInputStream(textFile);
		InputStreamReader streamerReader = new InputStreamReader(inFile, Charset.forName("UTF-8"));
	    BufferedReader fileBufferedReader = new BufferedReader(streamerReader);
	    String row = fileBufferedReader.readLine();
	    row = row.substring(1, row.length());
	    String[] elementArray = row.split("-");
	    Integer[][] matrix = new Integer[elementArray.length][elementArray.length];
	    for (int i=0;i<matrix.length;i++){
	    	if(elementArray[i].equals(" "))
	    		matrix[0][i] = null;
	    	else
	    		matrix[0][i] = Integer.valueOf(elementArray[i]);
	    }

	    for(int i=1;i<matrix.length;i++){
	    	row = fileBufferedReader.readLine();
		    row = row.substring(1, row.length());
		    elementArray = row.split("-");
	    	for (int j=0;j<matrix.length;j++){
	    		if(elementArray[j].equals(" "))
	    			matrix[i][j] = null;
	    		else
	    			matrix[i][j] = Integer.valueOf(elementArray[j]);
	    	}
	    }
	    fileBufferedReader.close();
	    return matrix;
	}
	
}
