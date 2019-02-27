
/**
 * Write a description of class practica here.
 * 
 * @author Santiago Santacruz Duvan Andres Ramirez
 * 
 * @version (a version number or a date)
 *respuesta b) si permitiria que esta sea usada en un editor de texto, ya que cuando este este lleno se agregaria mas espacios de 
 *memoria para que se pueda continuar añadiendo valores
 *respuesta c) la complejidad de agregar n caracteres en el peor de los casos seria de 0(n)
 */
public class MiArrayList {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[]; 
    private int suma;

    /**``   ``
     * El metodo constructor se utiliza para incializar
     * variables a valores neutros como 0 o null.
     * El contructor no lleva parámetros en este caso.
     */
    public MiArrayList() {
        size = 0;
        suma = DEFAULT_CAPACITY;
        elements = new int[DEFAULT_CAPACITY];
    }     

    /**
     * Tiene la intención de retornar la longitud del objeto
     * @return longitud del objeto
     *
     * El size esta influenciado por las funciones add y del
     */
    public int size() {
        return size;
    }   

    /** 
     * @param e el elemento a guardar
     * Agrega un elemento e a la última posición de la lista
     *
     */
    public void add(int e) {
        int posicion=0;
        elements[size]=e;
        size += 1;
        
        if(size==elements.length)
        ampliar();
    }    

    public void ampliar()    {
        suma *= 2;
        int [] ar = new int[suma];
        for(int i = 0; i < elements.length; i++){
            ar [i] = elements[i];
        }
        
        elements = ar;
    }
    
    /** 
     * @param i es un íncide donde se encuentra el elemento posicionado
     * Retorna el elemento que se encuentra en la posición i de la lista.
     *
     */
    public int get(int i) throws ArrayIndexOutOfBoundsException {
        if (i < 0 || i >= size)
            throw new ArrayIndexOutOfBoundsException("perdon usuario, pero i= " + i + " , size = " + size);
        else
            return elements[i];
    }

    /**
     * @param index es la posicion en la cual se va agregar el elemento
     * @param e el elemento a guardar
     * Agrega un elemento e en la posición index de la lista
     *
     */
    public void add(int index, int e) {
        if(index < 0 && index > elements.length-1)
            throw new ArrayIndexOutOfBoundsException("perdon usuario, pero index= " + index); 
        int vari = 0, temp;
        vari =elements[index];
        elements[index]=e; 
         for(int i = index+1; i <= elements.length-1; i++){
           //int x= i-1;
           temp = elements[i];
           elements[i] = vari;
           vari = temp;
    
        }
        size+=1;
    } 

    /**
     * @param index es la posicion en la cual se va agregar el elemento
     *
     * ELimina el elemento  en la posición index de la lista
     *
     */
    public void del(int index){
        if(index < 0 && index > elements.length-1)
            throw new ArrayIndexOutOfBoundsException("perdon usuario, pero index= " + index);

        for(int i = index; i <= elements.length-2; i++){
           //int x= i-1;
           elements[i]=elements[i+1]; 
        }
        size -=1;
    }
}

