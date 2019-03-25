import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author: Duvan Ramírez && Santiago Santacruz
 */
public class Main {
    public static int NumeroDeBloques;
    public static Stack <Integer> Bloques[];
    public static int Pos[];
    public static String Exit; 
    public static int A, B;
    
    public static void main(String[] args) throws IOException{
        Scanner console = new Scanner(System.in);
        System.out.println("Digite el número de bloques en el mundo de bloques");
        NumeroDeBloques = console.nextInt();
        Bloques = new Stack[NumeroDeBloques];
        Pos = new int[NumeroDeBloques];
        for(int i = 0; i < NumeroDeBloques; i++) {
            Bloques[i] = new Stack<Integer>();
            Bloques[i].push(i);
            Pos[i] = i;
        }
        //for(int i = 0; i < NumberBloques; i++) {
            
        //}
        
        Exit = "";
        System.out.println("Recuerde que si desea salir debe presionar 'quit'");
        while(!Exit.equals("quit")) {
            System.out.println("Digite move o pila segun quiera:");
            String token1 = console.next();
            System.out.println("Digite el primer (entero) valor:");
            A = console.nextInt();
            System.out.println("Digite over o onto segun quiera:");
            String token2 = console.next();
            B = console.nextInt();
            
           if(Pos[A] == Pos[B] || A == B ){ //continue;
            if(token1.equals("move")) {
                if(token2.equals("onto")) {
                    MoveOnto(A, B);
                } else if(token2.equals("over")) {
                    MoveOver(A, B);
                }
            } else if(token1.equals("pila")) {
                if(token2.equals("onto")) {
                    pilaOnto(A, B);
                } else if(token2.equals("over")) {
                    pilaOver(A, B);
                }
            }
           }
        }
        for(int i = 0; i < Bloques.length; i++)
          System.out.println(print(i));
    }
    
    private static void MoveOnto(int a, int b) {
       ClArr(b);
       MoveOver(a, b);
    }
    
    private static void MoveOver(int a, int b) {   
       ClArr(a);
       Bloques[Pos[b]].push(Bloques[Pos[a]].pop());
       Pos[a] = Pos[b];
    }
    
    private static void pilaOnto(int a, int b) {
       ClArr(b);
       pilaOver(a, b);
    }
    
    private static void pilaOver(int a, int b) {
       Stack<Integer> pila = new Stack<Integer>();
       while(Bloques[Pos[a]].peek() != a) {
           pila.push(Bloques[Pos[a]].pop());
       }
       pila.push(Bloques[Pos[a]].pop());
       while(!pila.isEmpty()) {
          int Temp = pila.pop();
          Bloques[Pos[b]].push(Temp);
          Pos[Temp] = Pos[b];
       }
    }
    
    private static String print(int i) {
        String valores = "";
        while(!Bloques[i].isEmpty())
        valores = " " + Bloques[i].pop() + valores;
        valores = i + ":" + valores;
        return valores;
    }
    
    private static void ClArr(int Bloque) {
        while(Bloques[Pos[Bloque]].peek() != Bloque) {
           Knw(Bloques[Pos[Bloque]].pop());
        }
    }
    
    private static void Knw(int Bloque) {   
        while(!Bloques[Bloque].isEmpty()) {
           Knw(Bloques[Bloque].pop());
        }
        Bloques[Bloque].push(Bloque);
        Pos[Bloque] = Bloque;
    }
    

}
