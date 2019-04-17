
/**
 * Write a description of class BinaryTree2 here.
 *
 * @author Santiago Santacruz && Duvan Andres Ramirez
 */

import java.util.*;
import java.io.*;

public class BinaryTree2
{
    public Node2 root;
    public ArrayList<Integer> ayuda = new ArrayList<Integer>();
    
    public void readFile(String fileName, String skipLine) throws IOException {//Complejidad O(n)
        FileReader reader = new FileReader(fileName);
        BufferedReader b = new BufferedReader(reader);

        String line = "";
        while((line = b.readLine()) != null){ 
            if(! line.equals(skipLine)){
                ayuda.add(Integer.parseInt(line));
            }
        }

        b.close();
    }
    
    private void insertar(ArrayList pre){
        for(int numero: ayuda){
         if(root == null){
            root = new Node2(numero);    
        }else insertarAux(root, numero);
        }
    }            
    
    private void insertarAux(Node2 node, int n) {

        if(n < node.getData()) {
            if(node.getLeft() == null){
                Node2 temp  = new Node2(n);
                node.setLeft(temp);
            }else insertarAux(node.getLeft(), n);
        }
        else{
            if(node.getRight() == null){
                Node2 temp  = new Node2(n);
                node.setRight(temp);
            }else insertarAux(node.getRight(), n);
        }

    }
    public void recursivePrint()
    {
        recursivePrintAUX(root);
    }
    private void recursivePrintAUX(Node2 node)
    {
        if (node != null)
        {
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.data);
        }

    }
    

    
}
