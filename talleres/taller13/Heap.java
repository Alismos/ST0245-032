/**
 * 
 * @author Duvan Ramirez && Santiago Santacruz
 * @version (0.0)
 */
public class Monticulo
{
    public int [] monticulo;
    int size;
    int maxSize;

    /* Constructor de la clase Monticulo que genera un objeto de tipo Monticulo pasando por parametro
    /   el numero de aos y el numero maximo
    */
    public Monticulo(int maxSize)
    {
        this.size = 0;
        this.maxSize = maxSize;
        monticulo = new int[maxSize + 1];
        monticulo[0] = Integer.MAX_VALUE;
    }

    private int HijoDer(int a){
        return (a *2)+1;
    }

    private int HijoIzq(int a){
        return a*2;
    }

    private int padre(int a){
        return a/2;
    }

    

    private boolean esHoja(int a){
        if(a >= (size/2) && a <= size )
            return true;
        
        return false;   
    } 

        
    private void flotar(int a, int b) 
    { 
        int temp; 
        temp = monticulo[a]; 
        monticulo[a] = monticulo[b]; 
        monticulo[b] = temp; 
    } 

     private void hundir(int a) 
    { 
        if (!esHoja(a)) {
            if (monticulo[a] < monticulo[HijoIzq(a)] || monticulo[a] < monticulo[HijoDer(a)]) {
                if (monticulo[HijoIzq(a)] > monticulo[HijoDer(a)]) {
                    flotar(a, HijoIzq(a));
                    hundir(HijoIzq(a));
                } else {
                    flotar(a, HijoDer(a));
                    hundir(HijoDer(a));
                }
            }
        }
    } 
    
    public boolean isEmpty(){
        return (size == 0)? true:false; 
    }
    
     public void insert(int a) 
     { 
        monticulo[++size] = a; 
        int temp = size; 
        while (monticulo[temp] > monticulo[padre(temp)]) { 
            flotar (temp, padre(temp)); 
            temp = padre(temp); 
        } 
     }  
  
    public void print() 
    { 
         System.out.print("\nmonticulo = ");
            for (int i = 1; i <= size; i++)
                System.out.print(monticulo[i] +" ");
            System.out.println();
    } 
  
    
    public int first() 
    {  
        return monticulo[1]; 
    } 


    
    public int peek(){
        int peek = monticulo[1]; 
        monticulo[1] = monticulo[size--];
        hundir(1); 
        return peek; 
    }
}
