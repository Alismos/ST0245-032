import java.util.Random;
/**
 * @author Santiago Santacruz R, Duvan Andres Ramirez
 * Taller 5
 */
public class galler5

{
    public static void main(String[] args){
        for (int i = 1; i <= 300; i++){
            long start = System.nanoTime(); 
            suma(new int[i]);
            long end = System.nanoTime();
            System.out.println(end-start);
        }
        
        for(int i = 0; i<300;i++ ){
            int[]n=Rellenar(i);
            long start = System.nanoTime();
            insertionSort(n);
            long end = System.nanoTime();
            System.out.println(end-start);
        }
    }

    private static int[] Rellenar(int n){
        int [] array= new int[n];
        Random generator= new Random();
        for(int i =0;i<n;i++){
            array[i]= generator.nextInt(400);
        }
        return array;
    }

    /**
    * @param array es un arreglo de números desordenados
    * El método insertionSort tiene la intención ordenar los números
    * del arreglo array por el método insertion:
    * mediante la anidación de funcion ciclica (for)
    * 
    */
    public static void insertionSort(int[] a){
        for (int i=1; i < a.length; i++) {
            int temp = a[i];
            int o;
            for (o=i-1; o >=0 && a[o] > temp; o--){
                a[o+1] = a[o];
            }
            a[o+1] = temp;
        }
    }

    /**
     * @param array es una arreglo de numeros enteros.
     * El método suma tiene la intención de hacer el proceso de suma
     * mediante una funcion cíclico (for)
     * @return la suma de todos los numeros sumados.
     */
    public static int suma (int[]array){
        int suma = 0; // C1
        for (int i=0; i<array.length;i++)  //C2 * n     
            suma += array[i];// C3 * n
        return suma;// C4
        // T(n) = C1 + C2 * n + C3 * n + C4
        // T(n) = O(n)
    }
}