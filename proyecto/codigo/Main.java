
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import  java.io.*;
import java.util.Scanner;
public class Main
{
    static LecturaArchivo a = new LecturaArchivo();
    static int number=10000;
    public static void Main(String [] args) throws FileNotFoundException, IOException {
        System.out.println ("Cuantas Abejas compararas");
        Scanner entradaEscaner = new Scanner (System.in);
        number = (int)(entradaEscaner.nextInt()); 
        time_Memory();
    }

    private static void time_Memory()throws FileNotFoundException, IOException{
        long startTime = System.currentTimeMillis();
        double memory = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
        a.arrayListDeDatos("Abejas"+number+".txt");
        a.getSides();
        a.putBeesOnHash();
        a.CuadrantCollisions();
        a.AbejasSolitas();
        long timeWaste = System.currentTimeMillis() -startTime;
        System.out.println("Time that the program takes = "+timeWaste+ " Ms"+", and the memory usage was of "+ memory +" Mb");
        a.writeFile(a.AbejasCol);
    }

    
}
