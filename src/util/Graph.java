package util;

import java.util.Random;

public class Graph {
	
	public Integer numberOfNodes;
	
	public Graph(){
		Random rnd = new Random();
		numberOfNodes = rnd.nextInt(15)+5;
	}

}
