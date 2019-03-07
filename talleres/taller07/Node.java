public class Node {
    
    int data;
    Node next;
           
    public Node(int valor)
    {
        this.data  = valor;
        this.next  = null;
    }
    
    public int getData()
    {
        return data;
    }
    
    public void linkNext(Node n)
    {
        next = n;
    }
    
    public Node getNext()
    {
        return next;
    }
    
}
