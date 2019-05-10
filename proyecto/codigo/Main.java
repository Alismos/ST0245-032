
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
public class Main
{
    public static void Main(String [] args) throws FileNotFoundException, IOException {
        int number=100;
        LecturaArchivo a = new LecturaArchivo();
        a.arrayListDeDatos("Abejas"+number+".txt");
        a.getSides();
        a.putBeesOnHash();
        a.CuadrantCollisions();
    }
}
