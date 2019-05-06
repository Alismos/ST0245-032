import java.util.HashMap;
import java.util.LinkedList;
import javafx.util.Pair;
/**
 * 
 * @author Duvan Ramírez && Santiago Santacruz
 * @version (0.0)
 */
public class sucessors
{
    HashMap<String,LinkedList<Pair<String,String>>> struct;
    
    public sucessors(){
       struct = new HashMap<String, LinkedList<Pair<String,String>>>(335792);
    }

    public void addS(String source, String weight, String destiny){

        if(struct.containsKey(source)==true)
          struct.get(source).add(new Pair(weight, destiny));

        else{
         struct.put(source, new LinkedList<Pair<String, String>>());
         struct.get(source).add(new Pair(weight,destiny));
      }
    }

    public void printS(String source){
        
        if(struct.containsKey(source)){
        //LinkedList<Pair<String, String>> temp = new LinkedList<Pair<String,String>>();
        System.out.println();
        for(int i = 0; i < struct.get(source).size(); i++){
           //temp.add(new Pair(struct.get(source).get(i).getKey(), struct.get(source).get(i).getValue()));
           System.out.println("ID1 = " + source +"| ID2 = " + struct.get(source).get(i).getValue()  + "| Distancias = " + struct.get(source).get(i).getKey());
           
         }
        }
        else{
            System.out.println("hubo un problema");
        }    
    }

    public static void main(String[]args){
        sucessors a = new sucessors();
        a.addS("Su mas", "x1", "La suya");
        a.addS("Su ma", "x1", "La suya");
        a.addS("Su ma", "x3", "La suya");
        a.addS("Su ma", "x4", "La suya");
        a.addS("Su mas", "x1", "La suya");
        a.addS("Su ma", "x2", "La suya");
        a.addS("Su max", "x1", "La suya");
        a.printS("Su ma");
        System.out.println();
        a.printS("Su mas");
        System.out.println();
        a.printS("Su max");
        

    }
}
