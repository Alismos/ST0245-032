public class BinaryTree {
    public Node root;

    public BinaryTree(){
        root = null;
    }

    private int max2(int i, int j)
    {
        if (i > j)
            return i;
        return j;
    }

    private int maxheightAUX(Node node)
    {
        if (node == null)
            return 0;
        else 
            return max2(maxheightAUX(node.left), maxheightAUX(node.right))+1;
    }

    public void AbuelaM(String nombre){
        Node auxiliar = new Node(nombre);
        if(root ==null){
            root = auxiliar;
        }
        else{
            auxiliar= root;
            AbuelaMAuxiliar(auxiliar, nombre);
        }

    }

    public static Node AbuelaMAuxiliar(Node auxiliar,String nombreDdo){
        if(auxiliar == null)
            return null;

        if(auxiliar.data.equals(nombreDdo)){
           Node hoja = auxiliar.left.left;
           return hoja;
        }
        else{
            AbuelaMAuxiliar(auxiliar.left, nombreDdo);
            AbuelaMAuxiliar(auxiliar.right, nombreDdo);
        }
        System.out.println("Aloah");
        return null;
    }

    public int maxheight()
    {
        return maxheightAUX(root);
    }

    private void recursivePrintAUX(Node node)
    {
        if (node != null)
        {
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.data);
        }

    }
    public void recursivePrint()
    {
        recursivePrintAUX(root);
    }

	
}
