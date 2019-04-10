import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Implementacion de un grafo dirigido usando matrices de adyacencia
 *
 * @author Santiago Santacruz && Duvan Andres Ramirez
 */
public class DigraphAM extends Digraph {

    private int[][] matriz;
    private ArrayList<Integer> successor= new ArrayList<Integer>();
    /**
     * Constructor para el grafo dirigido
     * @param vertices el numero de vertices que tendra el grafo dirigido
     *
     */
    public DigraphAM(int size) {
        super(size);
        matriz = new int[size][size];
    }

    /**
     * Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
     * y se le asigna un peso a la longitud entre un nodo fuente y uno destino	
     * @param source desde donde se hara el arco
     * @param destination hacia donde va el arco
     * @param weight el peso de la longitud entre source y destination
     */
    public void addArc(int source, int destination, int weight) {
        matriz[source][destination] = weight;
    }

    public int getWeight(int source, int destination){
        return matriz[source][destination];
    }

    public ArrayList<Integer> getSuccessors(int vertex){
        for(int j=0; j < matriz.length; j++){
            if(matriz[vertex][j]!=0){
                successor.add(j);
            }
        }
        return successor;
    }
    
    public int size() {
		return size;
	}
}