

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago Santacruz && Duvan Andres Ramirez
 */
public class Materias {
    private String codigo;
    private String semestre;
    private String grupo;
    private String nomMateria;
    private String notaFinal;
    private List<NotaParcial> parcial;

    
    
    public Materias(){
        codigo = "";
   semestre = "";
     grupo = "";
     nomMateria = "";
     parcial = new ArrayList<NotaParcial>();
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

    /**
     * @return the semestre
     */
    public String getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    /**
     * @return the grupo
     */
    public String getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }



    /**
     * @return the nomMateria
     */
    public String getNomMateria() {
        return nomMateria;
    }

    /**
     * @param nomMateria the nomMateria to set
     */
    public void setNomMateria(String nomMateria) {
        this.nomMateria = nomMateria;
    }

        /**
     * @return the notaFinal
     */
    public String getNotaFinal() {
        return notaFinal;
    }

    /**
     * @param notaFinal the notaFinal to set
     */
    public void setNotaFinal(String notaFinal) {
        this.notaFinal = notaFinal;
    }
    
    /**
     * @return the parcial
     */
    public List<NotaParcial> getParcial() {
        return parcial;
    }

    /**
     * @param parcial the parcial to set
     */
    public void setParcial(List<NotaParcial> parcial) {
        this.parcial = parcial;
    }


    
}