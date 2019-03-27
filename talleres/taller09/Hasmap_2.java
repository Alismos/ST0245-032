import java.util.Scanner;
import java.util.HashMap;

public class Hasmap_2 {

    public  void main(){
        HashMap<String, String> lista = new HashMap<String, String>();
        Scanner console = new Scanner(System.in);
        int opcion=4;
        String pais, empresa;
        while(opcion!=3){
            System.out.println("ingrese 1 si desea agregar una empresa de un pais.");
            System.out.println("ingrese 2 si desea saber el pais de la empresa.  ");
            System.out.println("ingrese 3 si desea salir");
            opcion = console.nextInt();
            switch(opcion){
                case 1:
                System.out.println("introduce la empresa que desea agregar: ");
                empresa = console.next();
                System.out.println("introduce el pais de la empresa: ");
                pais = console.next();
                guardarEmpresa(empresa, pais, lista);

                break;

                case 2:
                System.out.println("Introduce la empresa: ");
                empresa = console.next();
                printEmp(empresa, lista); 

                break;
                case 3:
                opcion = 3;
                break;

                default:
                System.out.println("valor incorrecto");

            }
        }
    }

    private  void printEmp(String emp, HashMap <String, String> lista){
        if(lista.containsKey(emp)){
            System.out.println(lista.get(emp));
        }  
        else{
            System.out.println("La empresa aun no ha sido añadida");
        }
    }

    private  boolean guardarEmpresa(String emp, String pa, HashMap <String, String> lista){
        if (lista.containsKey(emp)) {
            System.out.println("No se puede introducir el producto. El código esta repetido.");
            return false;
        }
        else{
            lista.put(emp, pa);
            return true;
        }
    }

}