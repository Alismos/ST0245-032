import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LecturaArchivo
{
    private String archivo;
    LinkedList<Bees> data = new LinkedList<>();
    HashMap<Integer, LinkedList<Bees>> hash = new HashMap<Integer, LinkedList<Bees>>();
    double maxX;
    double maxY;
    double maxZ;
    double minX;
    double minY;
    double minZ;
    int sideX;
    int sideY;
    int sideZ;
    public LecturaArchivo(){

    }

    public static void muestraContenido(String archivo)throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
    }

    public LinkedList arrayListDeDatos(String archivo) throws FileNotFoundException, IOException{
        String cadena=null;
        String temp ="";
        int id = 0; 

        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f, 36);
        temp = b.readLine(); 
        while(((cadena =b.readLine())!=null)) {
            String[] aiuda=cadena.split(",");
            String x = aiuda[0];
            String y = aiuda[1];
            String z = aiuda[2];
            Bees bee = new Bees(Double.parseDouble(x),Double.parseDouble(y), Double.parseDouble(z),id);
            if(bee.getX() > maxX)
                maxX = bee.getX();

            if(bee.getY() > maxY)
                maxY = bee.getY();

            if(bee.getZ() > maxZ)
                maxZ = bee.getZ();

            if(bee.getX() < minX)
                minX = bee.getX();

            if(bee.getY() < minY)
                minY = bee.getY();

            if(bee.getZ() < minY)
                minZ = bee.getZ();

            id++;
            data.add(bee);
        }
        b.close();
        return data;
    }   

    /*
     * creacion del hashMap
     */
    public HashMap putBeesOnHash(){

        for(Bees data: data){
            int cuadrantX= (int)(data.getX()*111111);//arreglar, es dividido la hipotenusa. recuerda raiz(3x^2)=100 lo cual seria 100/raiz(3)
            int cuadrantY = (int)(data.getY()*111111);
            int cuadrantZ = (int)(data.getZ());
            int cuadrant=getCuadrant(cuadrantX,cuadrantY,cuadrantZ);

            if(!hash.containsKey(cuadrant)){

                hash.put(cuadrant,new LinkedList<Bees>());
                hash.get(cuadrant).add(data);
            }else if(hash.containsKey(cuadrant)){
                hash.get(cuadrant).add(data);
            }
        }
        return hash;
    }

    public int getCuadrant(int x,int y, int z){
        int side = (int)(100/Math.sqrt(3));
        int aiuda = (int)((int)(x/side)+((int)(y/side)*(int)(sideX/side))+((int)(z/side)*(int)(sideX/side)*(int)(sideY/side)));
        return aiuda;
    }

    public void getSides(){
        sideX =(int)(maxX*111111-minX*111111);
        sideY = (int)(maxY*111111-minY*111111);
        sideZ = (int)(maxZ*111111-minZ*111111);
    }

    public void CuadrantCollisions(){
        for(Map.Entry<Integer, LinkedList<Bees>> entry : hash.entrySet()){
            if(entry.getValue().size() > 1){
                for(int i = 0; i<entry.getValue().size(); i++){ //intentar hacer cin for each
                    System.out.println("Coliciona Abeja con Coordenadas X,Y,Z: "+ entry.getValue().get(i).getX() + 
                        ", " + entry.getValue().get(i).getY() + ", "+ entry.getValue().get(i).getZ() );
                }
            }
        }       
    }

}
