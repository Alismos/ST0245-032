
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;
import java.util.Scanner;
/**
 *
 * @author Santiago Santacruz && Duvan Andres Ramirez
 */
public class Principal {

    public final String path;
    //="C:\\Users\\gramirezv\\Documents\\NetBeansProjects\\estudiante\\Estudiante_prueba.csv"
    public List<Estudiante> estudiantes;

    public Principal(String path)
    {
        this.path=path;
    }

    public  void LoadCsv()
    {
        try {

            List<String[]> loadValues = ReadCsv.ReadCsvFile(path);
            this.estudiantes = new ArrayList<Estudiante>();
            int cont =0;
            for(String[] value: loadValues)
            {
                if(cont >0 && cont%2==0)
                {    

                    Estudiante e = ifEstudianteIsInList(value[1]);
                    boolean existeEstudiante = false;
                    boolean existeMateria = false;
                    if(e == null)
                    {    
                        e = new Estudiante();
                        e.setNombre(value[0]);
                        e.setCodigo(value[1]);
                        existeEstudiante = true;
                    }
                    Materias m = e.ifMateriaExists(value[2]);
                    if(m == null)
                    {    
                        m = new Materias();
                        existeMateria = true;
                        m.setCodigo(value[2]);
                        m.setGrupo(value[4]);
                        m.setNomMateria(value[10]);
                        m.setSemestre(value[3]);
                    }
                    NotaParcial p = new NotaParcial();
                    p.setDescripcion(value[9]);
                    p.setDescripcionEvaluacion(value[7]);
                    //System.out.println("v1: "+value[8]);

                    Double notaParcial = 0.0;
                    if(!"NULL".equals(value[12]) && !"".equals(value[12]))
                    {
                        notaParcial = Double.valueOf(value[12]);
                    }
                    //System.out.println("v2:"+notaParcial);
                    Double keyPorcentaje = (Double.valueOf(value[8])/100.0);
                    Double valuePorcentaje = (Double.valueOf(notaParcial)/100.0);
                    p.setPorcentaje_Nota(new Pair<>(keyPorcentaje, valuePorcentaje));

                    m.getParcial().add(p);
                    m.setNotaFinal(String.valueOf(this.getNotaFinal(e.getCodigo(), m.getCodigo())));
                    if(existeEstudiante)
                    {
                        this.estudiantes.add(e);
                    }
                    if(existeMateria)
                    {
                        e.getMateriasEstudiante().add(m);
                    }            
                }

                cont++;    
                //String json = new ObjectMapper().writeValueAsString(yourObjectHere);
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public Double getNotaFinal(String codEstudiante, String codMateria)
    {
        for(Estudiante estudiante: estudiantes)
        {
            if(codEstudiante.equals(estudiante.getCodigo()))
            {
                return estudiante.notaFinalXMateria(codMateria);
            }
        }
        return 0.0;
    }

    public Estudiante ifEstudianteIsInList(String codigo)
    {
        for(Estudiante estudiante: estudiantes)
        {
            if(codigo.equals(estudiante.getCodigo()))
            {
                return estudiante;
            }
        }
        return null;
    }

    /**public Materias ifMateriaExists(Estudiante estudiante, String codMateria)
    {
    //System.out.println(estudiante);
    //System.out.println(codMateria);
    for(Materias materia: estudiante.getMateriasEstudiante())
    {
    if(codMateria.equals(materia.getCodigo()))
    {
    return materia;
    }
    }
    return null;
    }*/

    public void buscarEstudiante(String codigo, String codigoMat){

        Estudiante e = ifEstudianteIsInList(codigo);
        //System.out.println(e);
        if(e != null){
            System.out.print(e.getNombre()+" "+e.getCodigo());
            Materias m = e.ifMateriaExists(codigoMat);
            //System.out.println(m);
            if(m != null){
                System.out.print(" "+ m.getNomMateria()+ " "+ m.getNotaFinal());
            }
        }
    }

    public static void main(String[] args) 
    {
        //List<List<String>> records = new ArrayList<>();
        //ReadCsvFile(path);
        System.out.println("Enter the path where the archive csv is");        
        Scanner scanner = new Scanner(System. in);
        String helppath = scanner. nextLine();
        Principal p = new Principal(helppath);
        p.LoadCsv();
        System.out.println("Enter the student code");
        Scanner scanner2 = new Scanner(System. in);
        String student = scanner. nextLine();
        System.out.println("Enter the student subject code");
        Scanner scanner3 = new Scanner(System. in);
        String student2 = scanner. nextLine();
        p.buscarEstudiante(student, student2);

    }
}
