
import java.lang.IndexOutOfBoundsException; 
public class LinkedListSD {
    private Node first;
    private int size;
    public LinkedListSD()
    {
        first = null;   
        size = 0;
    }

    public boolean isNull(){
        return(first==null)?true:false;
    }

    public void addFirst(int data){
        if(first == null)
            first = new Node(data);

        else{
            Node temp = first;
            Node agregar = new Node(data);
            agregar.linkNext(temp);
            first = agregar;
        }
        size += 1;
    }

    public void addEnd(int data){
        if(first == null)
            first = new Node(data);

        else{
            Node temp = getNode(size-1);
            Node agregar = new Node(data);
            temp.linkNext(agregar);
        }
        size += 1;
    }

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

    public int get(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Indice incorrecto");
        }
        Node temp = getNode(index);
        return temp.getData();
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
            throw new IndexOutOfBoundsException("Indice incorrecto");
        }

        Node temp = getNode(index);
        temp.data = data;
    }

    // Borra el dato en la posición index
    public void remove(int index)
    {
        Node temp;
        if (index == 0){
            first = first.getNext();
        }
        else{
            temp = first; 
            int contador = 0;
            while(contador < index -1){
                temp = temp.getNext();
                contador++;
            }

            temp.linkNext(temp.getNext().getNext());
        }

        size -=1;
    }

    // Verifica si está un dato en la lista
    public boolean contains(int data)
    {
        return containsAux(data, first); 
    }

    private boolean containsAux(int ElDato, Node nodo){
        if (nodo == null) // Condicion de parada
            return false;
        //else
        if (nodo.data == ElDato) // Otra condicion de parada
            return true;
        else  // Caso inductivo T(n) = T(n-1) + C = O(n)
            return containsAux(ElDato, nodo.next);
    }
}
