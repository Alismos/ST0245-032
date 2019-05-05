
/**
 * Write a description of class Punto2 here.
 *
 * @author Santiago Santacuz && Duvan Andres Ramirez
 * @version May
 */
import java.util.LinkedList;
import java.util.Scanner;
public class Punto2
{
    public static void main(String [] args){

        System.out.println("How many Nodes you want: ");
        Scanner in = new Scanner(System.in);
        int nodes=in.nextInt();
        int graph[][]= new int [nodes][nodes];
        System.out.println("How many edges will have: ");
        int edges = in.nextInt();
        System.out.println("Put the Origin and destiny of the edges");
        for(int c=1;c<=edges;c++){
            System.out.println("Edge "+c);
            System.out.print("Origin ");
            int or = in.nextInt();
            System.out.print("Destiny ");
            int des = in.nextInt();
            graph[or][des]=1;
            graph[des][or]=1;
        }
        if(biColorable(graph,nodes)){
            System.out.println("Bicoloreable");
        }else{
            System.out.println("Not Bicoloreable");
        }
    }

    private static boolean biColorable(int [][]matrix,int nodes){

        int [] count = new int [nodes]; 
        for(int i = 0; i < nodes;i++){
            count[i]= -1;
        }
        count[0]=1;
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(0);
        while(list.size()!=0){
            int vertex=list.poll();
            if(matrix[vertex][vertex]==1){
                return false;
            }
            for(int i=0;i<nodes;i++){
                if(matrix[vertex][i]==1 && count[i]==-1){
                    count[i]=1-count[vertex];
                    list.add(i);
                }else if (matrix[vertex][i]==1 && count[i]==count[vertex]) {
                    return false; 
                }
            }
        }
        return true;
    }
}