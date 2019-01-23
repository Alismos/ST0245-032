
/**
 * @author 
 * Santiago Santacruz && Duvan Andres Ramírez
 * @version (a version number or a date)
 */
import java.lang.Math;
public class Punto {

    private double x, y;

    
    public Punto(double x, double y) {
        this.x = x; 
        this.y = y;
    }

    public double x() {
         return x;
    }

   public double y() {
        return y;
    }

    
    public double radioPolar() {
         
         return Math.sqrt(x*x+y*y);
        
    }
    public double anguloPolar() {
        return Math.atan2(x,y);         
    }
  
    public double distanciaEuclidiana(Punto otro) {  
     return  Math.sqrt((x-otro.x())*(x-otro.x()) + (y - otro.y())*(y - otro.y()));
    }
}
