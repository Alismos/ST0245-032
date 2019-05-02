import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;	
public class lectura{

    public static void main (String [] args)throws FileNotFoundException, IOException{
    	
    	System.out.println(lectura().toString());
    }

    /*Metodo para la lectura y ordenamiento del archivo*/

    public static DigraphAL lectura() throws FileNotFoundException, IOException{
        File archivo = new File("D:/Alismos/Documentos/Eafit/Segundo semestre/Estructuras de datos/Laboratorios/Laboratorio 5/medellin_colombia-grande.txt");
        BufferedReader Lec = new BufferedReader(new FileReader(archivo));
        DigraphAL struct = new DigraphAL(335792);

        String Lec1; Lec.readLine();
        String temp1[];

        for(int i = 1; i <= 310155; i++){
        	Lec.readLine();
        }
        
        while((Lec1 = Lec.readLine())!=null){
         
         temp1 = Lec1.split(" ", 3);

         //struct.addArc(temp1[0],temp1[1],temp1[2]);

        }      
          
       return struct;
    }
}
