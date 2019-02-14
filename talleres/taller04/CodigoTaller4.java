import java.util.Random;
import java.util.concurrent.TimeUnit;
/** 
 * @Duvan Ramirez & Santiago Santacruz
 */
public class Taller4
{

    public static void TiempoParaArray(String[] args){
        for(int i = 1; i <= 20; i++)
            RecorrerArray(new int[i]);
    }

    public static int RecorrerArray(int[] a){
        long start = System.currentTimeMillis();
        int s = Array(a,0);
        long tiempo =  System.currentTimeMillis() - start;
        System.out.println(tiempo);
        return s;
    }

    // Operaciones que realiza T(n) = cn + c1
    private static int Array(int[] a,int i){  
        try{
            TimeUnit.SECONDS.sleep(1);
        }
        catch (Exception e){  
        }
        if (i == a.length) // C1
            return 0;  // C2
        else
            return a[i] + Array(a, i+1); // C3 + T(n-1) 
    }

    private static int f(int i){
        return i <= 1 ? i : f(i-1)+f(i-2);
    }

    public static void complejidadArray(){
        for(int i = 18; i <= 38; i++){
            long start = System.currentTimeMillis();
            f(i);
            long tiempo =  System.currentTimeMillis() - start;
            System.out.println(tiempo);
        }
    }

    public static void TiempoParaSumaVolumenes(){
        int[] array = new int[20];
        Random generator = new Random();
        for (int i =0; i<20; i++){
            array[i] = generator.nextInt(100);
            SumaVolumenes(array, 0);
        }
    }

    public static boolean SumaVolumenes(int[] a, int target){
        long start = System.currentTimeMillis();
        boolean temp = SumaVolumenesP(0,a,target);
        long tiempo =  System.currentTimeMillis() - start;
        System.out.println(tiempo);
        return temp;
    }

    private static boolean SumaVolumenesP(int start, int[] nums, int target) {
        try{
            TimeUnit.SECONDS.sleep(1);
        }
        catch (Exception e){  
        }
        if(start == nums.length)
            return target == 0;
        return SumaVolumenesP(start+1, nums, target) || SumaVolumenesP(start+1, nums, target-nums[start]);

    }

}
    private static boolean SumaVolumenesP(int start, int[] nums, int target) {
        try{
            TimeUnit.SECONDS.sleep(1);
        }
        catch (Exception e){  
        }
        if(start == nums.length)
            return target == 0;
        return SumaVolumenesP(start+1, nums, target) || SumaVolumenesP(start+1, nums, target-nums[start]);

    }

}
