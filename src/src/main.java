package src;
import java.util.Random;
public class main {

	public static void main(String[] args) {
		Random rnd = new Random();
		Integer numberOfNodes = rnd.nextInt(15)+5;
		Nodo[] nodi = new Nodo[numberOfNodes];
		for (int i=0;i<numberOfNodes;i++){
			nodi[i] = new Nodo(i, numberOfNodes);
		}
		System.out.println("ciao");
	}
}
