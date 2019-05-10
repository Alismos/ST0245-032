
/**
 * Write a description of class Bees here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.LinkedList;
public class Bees
{
    public double x,y,z;
    public int id;
    
    public int Cell = 100;
    public Bees(double x, double y,double z, int id)
    {
        this.x = x;
        this.y = y;
        this.z= z;
        this.id = id;
        
    }
    
    public double getX(){
    return x;
    }
    
    public double getY(){
        return y;
    }
    
    public double getZ(){
    return z;
    }
    public LinkedList<Integer> quadrants(){
    int xQ = (int)x;
    int yQ = (int)y;
    LinkedList <Integer> list = new LinkedList<Integer>();
    return list;
    }
    
    
    
    public String toString(){
    return id + " ";
    }
}
