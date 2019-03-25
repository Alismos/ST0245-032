
/**
 * Write a description of class Punto2b here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.LinkedList;

public class Punto2b
{
     public static void Punto2b(String texto){

        LinkedList <String> machine = new LinkedList();
        String beg = "";
        String end = "";
        int aiuda = 0;
        for(int i=0; i<texto.length()-1; i++){
            if(texto.charAt(i)=='[' && beg == ""){
                beg = "[";
                for(int j = i+1; j<texto.length(); j++){
                    if(texto.charAt(j) == '[' || texto.charAt(j) == ']'){
                        beg = "";
                        aiuda = 0;
                        break;
                    } else {
                        machine.add(aiuda, texto.substring(j,j+1));
                        aiuda++;
                        i++;
                    }
                }
            } else if(texto.charAt(i)==']' && end == ""){
                end = "]";
                for(int h = i+1 ; h < texto.length(); h++){
                    if(texto.charAt(h) == ']' || texto.charAt(h) == '['){
                        end = "";
                        break;
                    } else if(texto.charAt(h) != ']'){
                        machine.addLast(texto.substring(h,h+1));
                        i++;
                    } else {
                        i++;
                    }
                }
            } else {
                machine.add(i, texto.substring(i,i+1));
            }
        }
        for(int a = 0; a< machine.size(); a++){
            System.out.print(machine.get(a));
        }
    }
}

