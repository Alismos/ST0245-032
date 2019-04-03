
public class Node {
    public Node nodo;
    public Node left;
    public Node right;
    public int data;
    public Node(int d){

        data = d;
    }
 
    public void setData(int data) {
        this.data = data;
    }
 
    public int getData() {
        return data;
    }
 
    public Node getTop() {
        return nodo;
    }
 
    public void setTop(Node nodo) {
        this.nodo = nodo;
    }
 
    public Node getLeft() {
        return left;
    }
 
    public void setLeft(Node left) {
        this.left = left;
    }
 
    public Node getRight() {
        return right;
    }
 
    public void setRight(Node right) {
        this.right= right;
    }
    
}