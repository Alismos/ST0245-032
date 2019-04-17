*
 * @author Alismo
 */
public class ArbolBinario {
    NodoArbol raiz, auxiliar;
    public ArbolBinario(){
        this.raiz = null;
    }
    //Metodo para insertar un nodo en el arbol
    public void agregar(String nombre, String genero, String nombreDdo){
        NodoArbol hoja = new NodoArbol(nombre, genero);
        NodoArbol auxiliar = raiz;
        if(raiz ==null){
            raiz = hoja;
            System.out.println("valor agregado correctamente");
        }
        else{
            auxiliar= raiz;
            agregarAux(hoja,auxiliar, nombreDdo);
        }

    }

    public void agregarAux(NodoArbol hoja,NodoArbol auxiliar,String nombreDdo){
        if(auxiliar == null)
            return;
        if(auxiliar.nombre.equals(nombreDdo)){
            if(hoja.genero.equals("masculino")){
                auxiliar.Hder = hoja;
                System.out.println("valor agregado correctamente");
            }
            else if(hoja.genero.equals("femenino")){
                auxiliar.Hizq = hoja;
                System.out.println("valor agregado correctamente");
            }
            else{
                System.out.println("ocurrio un problema agregando, intentelo de nuevo");
            }
        }
        else{
            agregarAux(hoja, auxiliar.Hizq, nombreDdo);
            agregarAux(hoja, auxiliar.Hder, nombreDdo);
        }
    }

    private void recursivePrintAUX(NodoArbol node)
	{
		if (node != null)
		{
			recursivePrintAUX(node.Hizq);
			recursivePrintAUX(node.Hder);
			System.out.println(node.nombre);
		}
		
		
	}
	public void recursivePrint()
	{
		recursivePrintAUX(raiz);
	}
}
