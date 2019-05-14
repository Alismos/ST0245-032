import java.io.*;
import java.util.*;
public class LecturaArchivo
{
    /**
     * Atributos a utilizar
     */
    private String archivo;
    LinkedList<Bees> data = new LinkedList<>();
    HashMap<Integer, LinkedList<Bees>> hash = new HashMap<Integer, LinkedList<Bees>>();
    LinkedList<Bees> AbejasCol = new LinkedList<Bees>();
    private double maxX;
    private double maxY;
    private double maxZ;
    private double minX;
    private double minY;
    private double minZ;
    private int sideX;
    private int sideY;
    private int sideZ;
    private int side = (int)(100/Math.sqrt(3));
    private int rangoCol = 100;
    
    /**
     * constructor de la clase LecturaArchivo
     */
    public LecturaArchivo(){
    }

    /**
     * Metodo el cual nos muestra el contenido del archivo
     */
    public static void muestraContenido(String archivo)throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
    }

    /**
     * este metodo recorre el archivo que se va a usar, mientras que lo va leyendo crea una instancia de abejas y crea una abeja, compara si esta abeja tiene algun max y minimo
     * para irlo guarando y desoues utilizarlo. 
     * Estas abejas se van guardando en una Linked List de tipo Abeja.
     */
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

    /**
     * creacion del hashMap el cual tiene como key los cuadrantes y de valores una lista de abejas
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

    /**
     * con este metodo se obtiene el cuadrante el cual la abeja va a estar en el mapa
     */
    public int getCuadrant(int x,int y, int z){
        int aiuda = (int)((int)(x/side)+((int)(y/side)*(int)(sideX/side))+((int)(z/side)*(int)(sideX/side)*(int)(sideY/side)));
        return aiuda;
    }

    /**
     * se obtiene el valor de los lados X,Y,Z.
     */
    public void getSides(){
        sideX =(int)(maxX*111111-minX*111111);
        sideY = (int)(maxY*111111-minY*111111);
        sideZ = (int)(maxZ*111111-minZ*111111);
    }

    /**
     * Los cuadrantes que tengan mas de un valor en en el HashMap se iran guardando en una lista.
     */
    public void CuadrantCollisions(){
        for(Map.Entry<Integer, LinkedList<Bees>> entry : hash.entrySet()){
            if(entry.getValue().size() > 1){
                for(int i = 0; i<entry.getValue().size(); i++){ //intentar hacer cin for each
                    AbejasCol.add(entry.getValue().get(i));
                }
            }
        }       
    }

    /**
     * este metodo comprueba que las abejas que esten solas no se choquen con un cuadrante adyacente
     */
    public void AbejasSolitas(){
        int my = (int)(sideX/side);
        int mz = (int) ((sideX/side)*(sideY/side));
        for(Map.Entry<Integer, LinkedList<Bees>> entry : hash.entrySet()){
            if(entry.getValue().size() ==1){
                Bees pedro = entry.getValue().get(0);
                int cuadrante = getCuadrant((int)pedro.getX(), (int)pedro.getY(), (int)pedro.getZ());
                if(!Vecinos(cuadrante+1,pedro)){
                    if(!Vecinos(cuadrante-1,pedro)){
                        if(!Vecinos(cuadrante-my,pedro)){
                            if(!Vecinos(cuadrante+my,pedro)){
                                if(!Vecinos(cuadrante-mz,pedro)){
                                    if(!Vecinos(cuadrante+mz,pedro)){
                                        if(!Vecinos((cuadrante+1)+my,pedro)){
                                            if(!Vecinos((cuadrante+1)-my,pedro)){
                                                if(!Vecinos((cuadrante-1)+my,pedro)){
                                                    if(!Vecinos((cuadrante-1)-my,pedro)){
                                                        if(!Vecinos((cuadrante+1)+mz,pedro)){
                                                            if(!Vecinos((cuadrante+1)-mz,pedro)){
                                                                if(!Vecinos((cuadrante-1)+mz,pedro)){
                                                                    if(!Vecinos((cuadrante-1)-mz,pedro)){
                                                                        if(!Vecinos((cuadrante+my)+mz,pedro)){
                                                                            if(!Vecinos((cuadrante+my)-mz,pedro)){
                                                                                if(!Vecinos((cuadrante-my)+mz,pedro)){
                                                                                    if(!Vecinos((cuadrante-my)-mz,pedro)){
                                                                                        if(!Vecinos(((cuadrante+1)+my)+mz,pedro)){
                                                                                            if(!Vecinos(((cuadrante+1)-my)+mz,pedro)){
                                                                                                if(!Vecinos(((cuadrante+1)-my)-mz,pedro)){
                                                                                                    if(!Vecinos(((cuadrante-1)+my)+mz,pedro)){
                                                                                                        if(!Vecinos(((cuadrante-1)+my)-mz,pedro)){
                                                                                                            if(!Vecinos(((cuadrante-1)-my)+mz,pedro)){
                                                                                                                if(!Vecinos(((cuadrante-1)-my)-mz,pedro)){

                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }   
                                                                                }   
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Este metodo comprueba la distancia que hay entre una abeja solitaria con las abejas que esten en un cuadrnate adyacente
     */
    public boolean Vecinos(int cua, Bees bee){
        if(hash.get(cua) != null){
            for(int j =0; j<hash.get(cua).size(); j++){
                if((Math.abs(hash.get(cua).get(j).getX() - bee.getX())<= rangoCol) && 
                (Math.abs(hash.get(cua).get(j).getY() - bee.getY())<= rangoCol) && 
                (Math.abs(hash.get(cua).get(j).getZ() - bee.getZ())<= rangoCol)){
                    AbejasCol.add(bee);
                }
            }
        }

        return false;
    }
    
    /**
     * este metodo escribe el archivo de la lista de las abejas que colisionan.
     */
    public  void writeFile(LinkedList<Bees> abejas)throws IOException{
        File file = new File("AbejasEnRiesgo.txt");
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();
        PrintWriter escritor = new PrintWriter (file);
        if(AbejasCol.isEmpty()){
            System.out.println("There are not bees that are in risk of Collision");
        }else{
            escritor.println("The bees that are in risk are the following: ");
            for(Bees juan: abejas){
                escritor.println("The id of the bee is: " +juan.getId() +". With coordinates: "+ juan.getX()+ " " + juan.getY() + " "+ juan.getZ());
            }
            escritor.close();
        } 
    }
}
