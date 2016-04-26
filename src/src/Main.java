package src;
import java.util.Random;

import gui.Graph;

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
		Random rnd = new Random();
		Integer numberOfNodes = rnd.nextInt(15)+5;
		Nodo[] nodi = new Nodo[numberOfNodes];
		for (int i=0;i<numberOfNodes;i++){
			nodi[i] = new Nodo(i, numberOfNodes);
		}
		System.out.println("Creati "+numberOfNodes.toString()+" nodi");
		for (int i=0;i<numberOfNodes;i++){
			System.out.println(nodi[i].toString());
		}
		Graph frame = new Graph();
		frame.setVisible(true);
	}
}
