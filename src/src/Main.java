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
		/*Random rnd = new Random();
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
		*/
		Nodo[] nodi = new Nodo[7];

		for (int j = 0; j < nodi.length; j++) {
			nodi[j] = new Nodo(j,7);
		}
		for (Nodo a: nodi){
			System.out.println(a.toString());
		}
		
		nodi[0].addNodeConnection(1, 2);
		nodi[0].addNodeConnection(4, 8);
		nodi[1].addNodeConnection(0, 2);
		nodi[1].addNodeConnection(2, 6);
		nodi[1].addNodeConnection(3, 2);
		nodi[2].addNodeConnection(1, 6);
		nodi[2].addNodeConnection(6, 5);
		nodi[3].addNodeConnection(1, 2);
		nodi[3].addNodeConnection(5, 9);
		nodi[3].addNodeConnection(4, 2);
		nodi[4].addNodeConnection(0, 8);
		nodi[4].addNodeConnection(3, 2);
		nodi[4].addNodeConnection(5, 3);
		nodi[5].addNodeConnection(4, 3);
		nodi[5].addNodeConnection(3, 9);
		nodi[5].addNodeConnection(6, 1);
		nodi[6].addNodeConnection(2, 5);
		nodi[6].addNodeConnection(5, 1);
		
		System.out.println(Dijksrta.solver(0,6,nodi));
	}
}
