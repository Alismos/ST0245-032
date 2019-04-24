import java.util.ArrayList;
import java.util.LinkedList;
import javafx. util. Pair;
import java.util.Queue; 
/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Santiago Santacruz && Duvan Andres Ramirez
 */
public class DigraphAL extends Digraph {

    private ArrayList<LinkedList<Pair<Integer, Integer>>> grafoConListas;
    /**
     * Constructor para el grafo dirigido
     * @param vertices el numero de vertices que tendra el grafo dirigido
     *
     */
    public DigraphAL(int size) {
        super(size);
        grafoConListas = new ArrayList<LinkedList<Pair<Integer, Integer>>> ();
        for(int i = 1; i<=size;i++){
            grafoConListas.add(new LinkedList<Pair<Integer,Integer>>() );
        }
    }

    /**
     * Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
     * y se le asigna un peso a la longitud entre un nodo fuente y uno destino   
     * @param source desde donde se hara el arco
     * @param destination hacia donde va el arco
     * @param weight el peso de la longitud entre source y destination
     */
    public void addArc(int source, int destination, int weight) {
        grafoConListas.get(source).add(new Pair(destination, weight));
    }

    /**
     * Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
     * asociados al nodo pasado como argumento
     * @param vertex nodo al cual se le busca los asociados o hijos
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
     * Para más información de las clases:
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
     */
    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> successors= new ArrayList<Integer>();
        LinkedList<Pair<Integer,Integer>> temp=grafoConListas.get(vertex);
        for(int i =0; i <temp.size(); i++){
            successors.add(temp.get(i).getKey());
        }
        return successors;
    }

    /**
     * Metodo para obtener el peso o longitud entre dos nodos
     * 
     * @param source desde donde inicia el arco
     * @param destination  donde termina el arco
     * @return un entero con dicho peso
     */  
    public int getWeight(int source, int destination) {
        int total = 0;
        LinkedList<Pair<Integer,Integer>> temp=grafoConListas.get(source);
        for(int i =0; i <temp.size(); i++){
            total+=temp.get(i).getValue();
        }
        return total;
    }

    public boolean hayCaminoDFS(Digraph g, int origen, int destino){
        boolean [] visitados = new boolean [g.size()];
        return hayCaminoAuxDFS(g, origen, destino, visitados);
    }

    private boolean hayCaminoAuxDFS(Digraph g, int origen, int destino, boolean[] visitados){
        visitados[origen] = true;
        boolean respuesta = false;
        
        ArrayList<Integer> vecinos = g.getSuccessors(origen);
        
        if(destino == origen){
            respuesta = true;
        }

        for(int vecino: vecinos){
            if(visitados[vecino] == false){
                respuesta = respuesta || hayCaminoAuxDFS(g, vecino, destino, visitados);
            }
        }
        return respuesta;
    }

    public boolean hayCamino2(Digraph g, int origen, int destino){
        Queue<Integer> q = new LinkedList<>(); 
        ArrayList<Integer> vecinos = g.getSuccessors(origen);
        while(!vecinos.isEmpty()){
            int help = q.remove();
            if(help== destino){
                return true;
            }

            if(vecinos.contains(help)){
                continue;
            }
            vecinos.add(help);
            for(Integer help2: q){
                q.add(help2);
            }
        }
        return false;
    }
}