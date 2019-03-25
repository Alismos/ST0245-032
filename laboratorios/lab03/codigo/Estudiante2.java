/**
 * Write a description of class Estudiante2 here.
 *
 * Santiago Santacruz && Duvan Andres Ramirez 
 */

public class Estudiante2
{
    private String codigo;
    private String semestre;
    private String grade;

    public Estudiante2(String codigo, String semestre, String grade) {
        this.codigo = codigo;
        this.semestre = semestre;
        this.grade = grade;
    }

    public void print() {
        System.out.println(this.codigo + " " + this.semestre + " " + this.grade);
    }

    public String getSemestre() {
        return this.semestre;
    }

}