import javax.swing.JOptionPane;
import java.util.Scanner;
/**
 *
 * @author Alismo
 */
public class Main {

    public static void main (String [] args){

        Scanner console = new Scanner(System.in);
        ArbolBinario in = new  ArbolBinario();
        int opcion=1;
        String nombre, temp ="", genero;

        System.out.println("Este programa solicita el nombre del descendiente y del descendido." );
        System.out.println();
        System.out.println("Por ejemplo: Pedro es desciende de Juan.");
        System.out.println("Pedro es el deciente y Juan el descendido.");
        System.out.println();
        System.out.println("Recuerde que para salir debe presionar 2 cuando se lo indique.");
        System.out.println();
        System.out.println("Digite su nombre:");
        nombre = console.next();
        System.out.println("Digite su genero (Masculino o Femenino):");
        genero = console.next();
        in.agregar(nombre, genero, temp); //Agrego la raiz del arbol
        System.out.println("valor agregado correctamente");

        while(opcion != 2){
            System.out.println("Ingrese el nombre del descendido");
            System.out.println();
            temp = console.next().toLowerCase();
            System.out.println(" Ingrese el nombre del descendiente:");
            System.out.println();
            nombre = console.next().toLowerCase();
            System.out.println("Indique el genero(Masculino o Femenino):");
            System.out.println();
            genero = console.next().toLowerCase();
            in.agregar(nombre, genero, temp);
            System.out.println("Valor Agregado correctamente.");
            System.out.println();
            System.out.println("Presione dos si desea salir, sino presione otro numero");
            opcion = console.nextInt();
            if(opcion == 2)
                break;

           
        }
        
        in.recursivePrint();

        //Dibuja el árbol familiar
        dibujarArbol(in);
    }
    
    public static void dibujarArbol(ArbolBinario a)
   {
       System.out.println("/* arbolito para http://www.webgraphviz.com/ */"); 
       System.out.println("digraph arbolito {");
       System.out.println("size=\"6,6\";");
       System.out.println("node [color=aquamarine, style=filled];");
       dibujarArbolAux(a.raiz);
       System.out.println("}");
   }
   
   public static void dibujarArbolAux(NodoArbol nodo)
   {
      if (nodo != null)
         //"x_\n__" -> "xo\n__";
         for(NodoArbol n: new NodoArbol[] {nodo.Hizq, nodo.Hder} ){
            if (n != null)
               System.out.println("\"" + nodo.nombre + "\" -> \"" + n.nombre + "\";");
            dibujarArbolAux(n);
        }
   }
}
