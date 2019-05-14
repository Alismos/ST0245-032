/**
 * @author  Santiago Santacruz && Duvan Andres Ramirez
 * @version 4
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import  java.io.*;
import java.util.Scanner;

/**
 * This is the main class that recall the methods of other class Time_Memory
 */
public class Main
{
    static LecturaArchivo a;
    static int number;
    public static void Main(String [] args) throws FileNotFoundException, IOException {
        a= new LecturaArchivo();
        System.out.println ("Cuantas Abejas compararas");
        Scanner entradaEscaner = new Scanner (System.in);
        number = (int)(entradaEscaner.nextInt()); 
        time_Memory();
    }
    
    /**
     * In this method we calculate the time and memory usage, in milliseconds the time and in Mb the memory
     * And call the methods of other class
     */
    private static void time_Memory()throws FileNotFoundException, IOException{
        long startTime = System.currentTimeMillis();
        double memory = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))-((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
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
