
/**
* Santiago Santacruz R && Duvan Andres Ramirez
 * 20/03/2019
 */
import java.util.Stack;
import java.util.Queue;

public class Tienda
{
    private Queue<Solicitud> solicitud;
    private Stack<Neveras> nevera;

    public Tienda(Stack<Neveras> nevera, Queue<Solicitud> solicitud)
    {
        this. nevera = nevera;
        this. solicitud = solicitud;
    }

    public void imprimir(){
        int tamaño = solicitud.size();
        for(int i = 0; i < tamaño ; i++){
            Solicitud actual = solicitud.poll();
            for(int j = 0 ; j < actual.numero ; j++){
                Neveras neveraSoli = nevera.pop();
                System.out.println(actual.nombre + " " + neveraSoli.codigo);
            }
        }
    }

    
}
