/**
* La siguiente clase contiene la solucion al punto #1 del
* Laboratorio #1 del curso de estructura de datos y algoritmos 1
* @author Mauricio Toro, Daniel Mesa
* @version 1.0
*/
public class Punto1
{
    private static int Puerto(int a){ 		        //C1
        if(a<=2)     			              	    //C2
            return a;				                //C3
        return Puerto(a-1)+Puerto(a-2);		        //C4 + (n-1)(n-2)
    }					   	                        // 1 + n + n

    public static void main(String [] args){
        int longitud;
        int ayuda;
        Random numero = new Random();
        Scanner console = new Scanner(System.in);
        System.out.println("Digite el n");
        longitud=console.nextInt();
        //long start = System.nanoTime();
        ayuda=Puerto(50);
        //long end = System.nanoTime();
        //System.out.println(end-start);
        System.out.print("Se puede arreglar de" +" " +ayuda+" "+"formas.");
    }
    
}
