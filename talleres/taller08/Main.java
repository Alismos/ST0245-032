
/**
 * Santiago Santacruz R && Duvan Andres Ramirez
 * 20/03/2019
 */

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class Main
{    
    public static void main(String[] args){
        
        Queue<Solicitud> solicitud =  new LinkedList<>(); 
        Stack<Neveras> nevera = new Stack();
        
        Neveras n1 = new Neveras(1,"haceb");
        Neveras n2 = new Neveras(2,"lg");
        Neveras n3 = new Neveras(1,"haceb");
        Neveras n4 = new Neveras(2,"lg");
        
        nevera.push(n1);
        nevera.push(n2);
        nevera.push(n3);
        nevera.push(n4);

        Solicitud s1 = new Solicitud("Casa",1);
        Solicitud s2 = new Solicitud("Finca",3);

        solicitud.add(s1);
        solicitud.add(s2);

        Tienda t = new Tienda(nevera, solicitud);

        t.imprimir();
    }

}
