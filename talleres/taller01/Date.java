
/**
 * @author 
 * Santiago Santacruz && Duvan Andres Ramírez
 * @version (a version number or a date)
 */
public class Date
{
    byte dia, mes;
    short año;
    public Date(byte dia, byte mes, short año)
    {
        this.dia=dia;
        this.mes=mes;
        this.año=año;
    }

    public String fecha(){
        return "La fecha es: "+dia+"/"+mes+"/"+año;   
    }

    public byte dia(){
        return dia;   
    }

    public byte mes(){
        return mes;   
    }

    public short año(){
        return año;
    }

    public byte auxComparacion(Date otra){
        if(año==otra.año() && mes==otra.mes() && dia==otra.dia()){
            return 0;
        }else if(año==otra.año() && mes==otra.mes() && dia> otra.dia()){
            return 1;
        }else if(año==otra.año() && mes>otra.mes()){
            return 1;   
        }else if(año>otra.año()){
            return 1;
        }else
            return -1;
    }

    public void CompareDate(Date otra){
        byte ayuda=auxComparacion(otra);

        if(ayuda==0){
            System.out.println("la fecha "+ fecha()+" es igual a "+ otra.fecha());
        }else if(ayuda==1){
            System.out.println("la fecha "+fecha()+" es mayor a la fecha "+otra.fecha());   
        }else
            System.out.println("la fecha "+fecha()+" es menor a la fecha "+otra.fecha());

    }
}
