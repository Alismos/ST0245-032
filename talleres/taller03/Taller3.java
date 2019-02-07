
/**
 * Write a description of class Permutacion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Taller3
{
    AdvancedEncryptionStandard ad= new AdvancedEncryptionStandard();

    public static void torresDeHannoi(int n) {
        torresDeHannoiAux(n, 1, 2, 3);
    }

    private static void torresDeHannoiAux(int n, int origen, int intermedio, int destino) {

        if(n==1){
            System.out.println("mover disco de " + origen + " a " + destino);
        }

        else{

            torresDeHannoiAux(n-1, origen, destino, intermedio);

            System.out.println("mover disco de "+ origen + " a " + destino);

            torresDeHannoiAux(n-1, intermedio, origen, destino);
        }
    }

    public static void combinations(String s) { 
        combinationsAux("", s); 
    }

    private static void combinationsAux(String prefix, String s) {  
        if(s.length()==0){
            System.out.println(prefix);
        }
        else{

            combinationsAux(prefix + s.charAt(0), s.substring(1));
            combinationsAux(prefix, s.substring(1));
        }
    }
    
    public static void permutacion(String str) { 
        permutacionAux("", str); 
    } 

    private static void permutacionAux(String prefix, String str) { 
        int ayuda = str.length(); 
        if (ayuda == 0) 
            System.out.println(prefix); 
        else { 
            for (int i = 0; i < ayuda; i++) 
                permutacionAux(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, ayuda)); 
        } 
    }

    public String Desencriptar(){

        return ad.desencriptarArchivo("adcb"); 

    }
}
