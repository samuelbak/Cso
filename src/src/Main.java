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
		
		Integer dimension = 200000;

		Integer[][] matrix = Graph.createRandomMatrix(dimension, 1);
		
		Nodo[] nodi = Graph.getGraphFromMatrix(matrix);
		Random rnd = new Random(System.currentTimeMillis());
		Integer overload = 1;
		Integer availableCpu = Runtime.getRuntime().availableProcessors()*overload;
		
		Train[] treni = new Train[availableCpu];
		for (int i=0; i<availableCpu;i++){
			treni[i] = new Train(rnd.nextInt(dimension),rnd.nextInt(dimension),nodi, "Treno "+(i+1));
		}
		for (int i=0; i<availableCpu; i++){
			treni[i].start();
		}
	}
}
