package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import util.Graph;

public class Main {

	public static void main(String[] args) {	    
		BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));
		
		String testMatrix = "n";
		System.out.print("Do you want use the sample matrix [y\\"+"n]: ");
		try {
			if (consoleIn.readLine().equals("y"))
				testMatrix="y";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!testMatrix.equals("y")){
			Integer dimension = 10;
			Integer connections = 1;
			Integer weight = 10;
			Integer threadNumber = 1;
			while(true){
				try {
					System.out.print("Enter the number of the nodes in the graph: ");
					dimension = Integer.valueOf(consoleIn.readLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("Not a number, try again...");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
			while(true){
				try {
					System.out.print("Enter the maximum number of the node's connections: ");
					connections = Integer.valueOf(consoleIn.readLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("Not a number, try again...");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
			while(true){
				try {
					System.out.print("Enter the maximum weight of the connections: ");
					weight = Integer.valueOf(consoleIn.readLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("Not a number, try again...");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
			while(true){
				try {
					System.out.print("You have "+Runtime.getRuntime().availableProcessors()+" cpus, how many thread you want to start: ");
					threadNumber = Integer.valueOf(consoleIn.readLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("Not a number, try again...");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println();
			Integer[][] matrix = Graph.createRandomMatrix(dimension, connections, weight);
			Node[] graph = Graph.getGraphFromMatrix(matrix);
			Random rnd = new Random(System.currentTimeMillis());
	
			Train[] treni = new Train[threadNumber];
			for (int i=0; i<threadNumber;i++){
				treni[i] = new Train(rnd.nextInt(dimension),rnd.nextInt(dimension),graph, "Train "+(i+1));
			}
			for (int i=0; i<threadNumber; i++){
				treni[i].start();
			}
		}
		else{
			Node[] graph = null;
			try {
				graph = Graph.getGraphFromMatrix(Graph.getMatrixFromFile("matrix.txt"));
			} catch (FileNotFoundException e1) {
				System.out.println("File not found");
			} catch (IOException e1) {
				System.out.println("Can't read from file");
			}
			while(true){
				Integer startNode = 0;
				Integer endNode = 6;
				while(true){
					try {
						System.out.print("Enter the start node: ");
						startNode = Integer.valueOf(consoleIn.readLine());
						break;
					} catch (NumberFormatException e) {
						System.out.println("Not a number, try again...");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				while(true){
					try {
						System.out.print("Enter the end node: ");
						endNode = Integer.valueOf(consoleIn.readLine());
						break;
					} catch (NumberFormatException e) {
						System.out.println("Not a number, try again...");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				Train train = new Train(startNode, endNode, graph, "Train 1");
				train.run();
				System.out.println();
				
			}
		}
	}
}
