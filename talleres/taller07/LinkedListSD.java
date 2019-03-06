
/**
 * Write a description of class LinkedListSD here.
 *
 * @author Santiago Santacruz && Duvan Andres Ramirez
 * @version (a version number or a date)
 */
import java.lang.IndexOutOfBoundsException; 
import java.util.LinkedList;
public class LinkedListSD
{   private Node first;
    private int size;
    private Node temp; 
    private Node anterior;
    public LinkedListSD()
    {
        temp=null;
        size = 0;
        first = null;    
    }
    public void addsize(){
     size+=1;
     
    }
    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public int get(int index) throws IndexOutOfBoundsException {
        temp = getNode(index);
        return temp.data;
    }

    // Retorna el tamaño actual de la lista
    public int size()
    {
        return size;   
    }

    // Inserta un dato en la posición index
    public void insert(int data, int index) throws IndexOutOfBoundsException
    {
        if(index < 0 || index >= size){
            System.out.println("Indice incorrecto");
        }
        temp = getNode(index);
        temp.data = data;

        size += 1;
    }

    //Busca el parametro anterior
    public Node pararmeEnElAnterior(int index){
        Node temp= first;
        for (int i = 0; i < index; i++) {
            temp= temp.next;
        }
        temp.next = temp.next.next;
        return temp;
    }
    
    // Borra el dato en la posición index
    public void remove(int index)
    {
        if (index == 0){
            first = first.next;
        }
        else{
            anterior = pararmeEnElAnterior(index);
            anterior.next = anterior.next.next;
        }
    }

    private boolean containsAux(int data, Node nodo){
        if(nodo == null){
            return false;
        }else if(nodo.data == data){
            return true;
        }else
            return containsAux(data,nodo.next);
    }
    // Verifica si está un dato en la lista
    public boolean contains(int data){
        // Si el dato está a partir del primero
        return containsAux(data, first); 
    }

}
