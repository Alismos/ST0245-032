/**
 * Write a description of class Monticulo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monticulo
{
    public int [] monticulo;
    int size;
    int maxSize;
    /**
     * Constructor for objects of class Monticulo
     */
    public Monticulo(int maxSize)
    {
        this.size = 0;
        this.maxSize = maxSize;
        monticulo = new int[maxSize + 1];
        monticulo[0] = Integer.MAX_VALUE;
    }

    private int rightChild(int a){
        return a *2;
    }

    private int leftChild(int a){
        return (a*2+1);
    }

    private int parent(int a){
        return a/2;
    }

    private boolean isHoja(int a){
        if(size >= (a/2) && a <= size ){
            return true;
        }
        return false;   
    } 
    
    private void flotar(int Apos, int Bpos) 
    { 
        int tmp; 
        tmp = monticulo[Apos]; 
        monticulo[Apos] = monticulo[Bpos]; 
        monticulo[Bpos] = tmp; 
    } 
    
    
    
     public void insert(int element) 
     { 
        monticulo[++size] = element; 
        int current = size; 
        while (monticulo[current] > monticulo[parent(current)]) { 
            flotar (current, parent(current)); 
            current = parent(current); 
        } 
     } 
  
    public void print() 
    { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" Padres : " + monticulo[i] + "\n Hijo izquierdo : " + monticulo[2 * i] + "\n Hijo derecho :" + monticulo[2 * i + 1]); 
            System.out.println(); 
        } 
    } 
  
    
    public int first() 
    {  
        return monticulo[1]; 
    } 
    
    public int peek(){return 0;}
}
