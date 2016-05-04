package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import util.Graph;

public class Main {

	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	
		Integer dimension = 10;
		while(true){
			try {
				System.out.print("Enter the number of the nodes in the graph: ");
				dimension = Integer.valueOf(in.readLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Not a number, try again...");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Integer connections = 1;
		while(true){
			try {
				System.out.print("Enter the maximum number of the node's connections: ");
				connections = Integer.valueOf(in.readLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Not a number, try again...");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Integer weight = 10;
		while(true){
			try {
				System.out.print("Enter the maximum weight of the connections: ");
				weight = Integer.valueOf(in.readLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Not a number, try again...");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Integer threadNumber = 1;
		while(true){
			try {
				System.out.print("You have "+Runtime.getRuntime().availableProcessors()+" cpus, how many thread you want to start: ");
				threadNumber = Integer.valueOf(in.readLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Not a number, try again...");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		Integer[][] matrix = Graph.createRandomMatrix(dimension, connections, weight);
		Node[] nodes = Graph.getGraphFromMatrix(matrix);
		Random rnd = new Random(System.currentTimeMillis());

		Train[] treni = new Train[threadNumber];
		for (int i=0; i<threadNumber;i++){
			treni[i] = new Train(rnd.nextInt(dimension),rnd.nextInt(dimension),nodes, "Train "+(i+1));
		}
		for (int i=0; i<threadNumber; i++){
			treni[i].start();
		}
	}
}
