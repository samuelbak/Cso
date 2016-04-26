package util;

import java.util.Random;
import src.Nodo;

public class Graph {
	
	public Graph(){
		
	}
	
	public static Nodo[] createRandomNodes(Integer limit){
		Random rnd = new Random();
		Integer numberOfNodes = rnd.nextInt(limit);
		Nodo[] nodi = new Nodo[numberOfNodes];
		for (int j = 0; j < nodi.length; j++) {
			nodi[j] = new Nodo(j++);
		}
		return nodi;
	}

}
