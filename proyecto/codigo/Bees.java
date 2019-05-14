
/**
 * @author Santiago Santacruz && Duvan Andres Ramirez
 * @version 3
 */
public class Bees
{
    
    /**
     * Atributos de la clase abeja
     */
    public double x,y,z;
    public int id;
    
    
    /**
     * Constructor de la clase abeja
     */
    public Bees(double x, double y,double z, int id)
    {
        this.x = x;
        this.y = y;
        this.z= z;
        this.id = id;
        
    }
    /**
     * Getters de la clase abeja
     */
    public double getX(){
    return x;
    }
    
    public double getY(){
        return y;
    }
    
    public double getZ(){
    return z;
    }
    
    public int getId(){
        return id;
    }
}
