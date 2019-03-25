/**
 * Write a description of class Estudiante2 here.
 *
 * Santiago Santacruz && Duvan Andres Ramirez 
 */

import java.util.*;
import java.io.*;

public class MainPunto1
{
    public String archivo;
    public String semestre;

    public ArrayList<Estudiante2> lista = new ArrayList<Estudiante2> ();

    public MainPunto1(String codigoMat, String semestre) {//Complejidad O(1)
        this.archivo = "./" + codigoMat.toUpperCase() + ".txt";
        this.semestre = semestre;
    }

    public void readFile(String fileName, String skipLine) throws IOException {//Complejidad O(n)
        FileReader reader = new FileReader(fileName);
        BufferedReader b = new BufferedReader(reader);

        String line = "";
        while((line = b.readLine()) != null){ 
            if(! line.equals(skipLine)){
                Estudiante2 s =pasar(line, ",");
                lista.add(s);
            }
        }

        b.close();
    }

    public Estudiante2 pasar(String line, String separator) {//Complejidad O(1)

        String[] ayuda = line.split(separator);      
        Estudiante2 s = new Estudiante2(ayuda[1], ayuda[3], ayuda[12]);

        return s;   
    }

    public void buscar(String semester) {//Complejidad O(n)
        for(Estudiante2 student: lista) {
            if(student.getSemestre().equals(semester)){
                student.print();
            }
        }
    }

    public static void main() throws IOException {//Complejidad O(n)
        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese el código de la materia: ");
        String codigoMat = s.nextLine();

        System.out.print("Ingrese el semestre en formato: ");
        String semestre = s.nextLine();

        MainPunto1 busqueda = new MainPunto1(codigoMat, semestre);

        busqueda.readFile(busqueda.archivo, "");
        System.out.println("Los registros que coinciden con la busqueda son:");
        busqueda.buscar(busqueda.semestre);
    }
}