
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

/**
 *
 * @author Santiago Santacruz && Duvan Andres Ramirez
 */
public class Estudiante {
    
    private String nombre;
    private String codigo;
    private List<Materias> materiasEstudiante;
    
    
    public Estudiante()
    {
        nombre = "";
        codigo = "";
        materiasEstudiante = new ArrayList<Materias>();
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    public Double notaFinalXMateria(String codigoMateria)
    {
        for(Materias mat:this.materiasEstudiante)
        {
            if(codigoMateria.equals(mat.getCodigo()))
            {
                Double notaFinal = 0.0;
                for(NotaParcial notaParcial:mat.getParcial())
                {
                    notaFinal += notaParcial.getPorcentaje_Nota().getKey()*notaParcial.getPorcentaje_Nota().getValue();
                }
                return notaFinal*10;
            }
        }
        return 0.0;
    }

    /**
     * @return the materiasEstudiante
     */
    public List<Materias> getMateriasEstudiante() {
        return materiasEstudiante;
    }

    /**
     * @param materiasEstudiante the materiasEstudiante to set
     */
    public void setMateriasEstudiante(List<Materias> materiasEstudiante) {
        this.materiasEstudiante = materiasEstudiante;
    }
    
    public Materias ifMateriaExists(String codMateria)
    {
        //System.out.println(estudiante);
        //System.out.println(codMateria);
        for(Materias materia: this.getMateriasEstudiante())
        {
            if(codMateria.equals(materia.getCodigo()))
            {
                return materia;
            }
        }
        return null;
    }
    
}