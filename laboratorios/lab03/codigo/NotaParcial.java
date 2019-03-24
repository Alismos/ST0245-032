

import javafx.util.Pair;

/**
 *
 * @author Santiago Santacruz && Duvan Andres Ramirez
 */
public class NotaParcial {
     private String descripcion;
     private String descripcionEvaluacion;
     private Pair<Double,Double> porcentaje_Nota;

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the descripcionEvaluacion
     */
    public String getDescripcionEvaluacion() {
        return descripcionEvaluacion;
    }

    /**
     * @param descripcionEvaluacion the descripcionEvaluacion to set
     */
    public void setDescripcionEvaluacion(String descripcionEvaluacion) {
        this.descripcionEvaluacion = descripcionEvaluacion;
    }

    /**
     * @return the porcentaje_Nota
     */
    public Pair<Double,Double> getPorcentaje_Nota() {
        return porcentaje_Nota;
    }

    /**
     * @param porcentaje_Nota the porcentaje_Nota to set
     */
    public void setPorcentaje_Nota(Pair<Double,Double> porcentaje_Nota) {
        this.porcentaje_Nota = porcentaje_Nota;
    }
    
}