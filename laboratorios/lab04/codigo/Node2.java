
/**
 * Write a description of class Node2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Node2
{
   public Node2 nodo;
    public Node2 left;
    public Node2 right;
    public int data;
    public Node2(int d){

        data = d;
    }
 
    public void setData(int data) {
        this.data = data;
    }
 
    public int getData() {
        return data;
    }
 
    public Node2 getTop() {
        return nodo;
    }
 
    public void setTop(Node2 nodo) {
        this.nodo = nodo;
    }
 
    public Node2 getLeft() {
        return left;
    }
 
    public void setLeft(Node2 left) {
        this.left = left;
    }
 
    public Node2 getRight() {
        return right;
    }
 
    public void setRight(Node2 right) {
        this.right= right;
    }
}
