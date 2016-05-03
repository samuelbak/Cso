package src;

import java.util.Random;

import util.Graph;

/*
Thread e Processi - Si realizzi, a grandi linee, un simulatore per un sistema di ricerca del tragitto più 
breve in una rete ferroviaria. La rete ferroviaria è composta da stazioni (i nodi) e tratte (gli archi che li collegano).
Da ogni stazione partono 1 o più archi, ognuno diretto ad un nodo e con peso differente. Dato un nodo di partenza e un 
nodo di arrivo, i treni (thread) dovranno percorrere la rete alla ricerca del percorso con peso minore.
Ovviamente, ogni nodo deve essere raggiungibile attraverso più percorsi con peso differente. In caso di percorsi a 
costo uguale, il treno (thread) può scegliere indifferentemente uno o l´altro percorso.
 */

public class Main {

	public static void main(String[] args) {
		
		Integer dimension = 6000;

		Integer[][] matrix = Graph.createRandomMatrix(dimension, 3);
		//Graph.printMatrix(matrix);
		
		Nodo[] nodi = Graph.getGraphFromMatrix(matrix);
		Random rnd = new Random(System.currentTimeMillis());
		Train treno1 = new Train(rnd.nextInt(dimension),rnd.nextInt(dimension),nodi);
		Train treno2 = new Train(rnd.nextInt(dimension),rnd.nextInt(dimension),nodi);
		Train treno3 = new Train(rnd.nextInt(dimension),rnd.nextInt(dimension),nodi);
		Train treno4 = new Train(rnd.nextInt(dimension),rnd.nextInt(dimension),nodi);
		Train treno5 = new Train(rnd.nextInt(dimension),rnd.nextInt(dimension),nodi);
		treno1.run();
		treno2.run();
		treno3.run();
		treno4.run();
		treno5.run();
	}
}
