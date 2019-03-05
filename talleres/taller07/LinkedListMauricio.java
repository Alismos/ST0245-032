

import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada
public class LinkedListMauricio {
    private Node first;
    private int size;
    private Node temp;
    public LinkedListMauricio()
    {
        size = 0;
        first = null;   
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
    public void insert(int data, int index)
    {

    }

    // Borra el dato en la posición index
    public void remove(int index)
    {
        if(index == 0){
         first = first.next;   
        }else{
            //Node anterior = pararmeEnElAnterior(index);
            //anterior.next =anterior.next.next;
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
