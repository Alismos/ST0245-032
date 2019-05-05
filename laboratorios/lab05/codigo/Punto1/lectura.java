import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;	
import java.util.LinkedList;
import javafx.util.Pair;
import java.util.HashMap;

public class lectura{

     LinkedList <String> ub;
    public lectura(){

      ub = new LinkedList<String>();
    }

    public void imprimir () throws FileNotFoundException, IOException{
       sucessors a= new sucessors();

       a = lectura();
        
       for(int i = 0; i < ub.size(); i++){
           a.printS(ub.get(i));
        }
    }

    public sucessors lectura() throws FileNotFoundException, IOException{

        BufferedReader Lec = new BufferedReader (new FileReader ("medellin_colombia-grande.txt"));
        sucessors struct = new sucessors();

        String Lec1; Lec.readLine();
        String temp1[];

        while((Lec1 = Lec.readLine())!=null){
            temp1= Lec1.split(" ");

           if(temp1[0].equals("Arcos."))
           	break;
        }

        while((Lec1 = Lec.readLine())!=null){
         temp1 = Lec1.split(" ");
         ub.add(temp1[0]);
         struct.addS(temp1[0],temp1[2], temp1[1]);
        } 
        return struct;
    }

    public static void main(String[]args)throws FileNotFoundException, IOException{
       lectura a = new lectura();
       a.imprimir();
    }
}
