
/**
 * La siguiente clase contiene la solucion al punto #2 del
 * Laboratorio #1 del curso de estructura de datos y algoritmos 1
 * @author Duvan Ramírez, Santiago Santacruz
 * @version 1.0
 *
 * Text:
 * Title: All About Recursion
 * Author: Matuszek, D
 * Date: 1999
 * Code version: N.V
 * Availability: https://bit.ly/2EuvQjQ
 */

public class Recursion2
{
    //Factorial 
    public int factorial(int n) {       
        if(n<=1)                
            return n;           
        else return n*factorial(n-1);   
    }

    //bunnyEars  
    public int bunnyEars(int bunnies) {
        if(bunnies==0)
            return 0;

        return 2 + bunnyEars(bunnies-1);
    }

    //Fibonacci
    public int fibonacci(int n) {
        if(n==0)
            return 0;
        else if(n==1)
            return 1;

        return fibonacci(n-1)+fibonacci(n-2);
    }

    //bunny Ears2
    public int bunnyEars2(int bunnies) {
        if(bunnies==0)
            return 0;
        if(bunnies%2==0)
            return 3+bunnyEars2(bunnies-1);

        return 2+bunnyEars2(bunnies-1);
    }

    //Triangle
    public int triangle(int rows) {
        if(rows==0)
            return 0;
        else if(rows==1)
            return 1;

        return rows+triangle(rows-1);
    }

    //sumDigits
    public int sumDigits(int n) {
        if(n/10==0)
            return n;
        return sumDigits(n/10)+sumDigits(n%10);
    }

    //Split 53
    public boolean split53(int[] nums) {
        return SumaGruposTwo(0,nums,0,0);
    }

    public boolean SumaGruposTwo(int inicio, int[] nums, int m5, int m3){

        if(inicio >= nums.length){
            return m5 == m3;
        } 

        if(nums[inicio] % 5 == 0){
            return SumaGruposTwo(inicio+1, nums, nums[inicio] + m5, m3);
        }

        else if(nums[inicio] % 3 == 0){
            return SumaGruposTwo (inicio + 1, nums, m5, m3 + nums[inicio]);
        }

        if(SumaGruposTwo (inicio +1, nums, m5, nums[inicio] + m3)){
            return true;
        }

        else if(SumaGruposTwo (inicio +1, nums, nums[inicio] + m5 , m3)){
            return true;
        }
        return false;
    }

    //groupSum5
    public boolean groupSum5(int start, int[] nums, int target)
    {

        if(start >= nums.length)
        {
            if(target == 0){
                return true;
            }
            else {
                return false;
            }
        }

        if(nums[start] % 5 == 0)
        {
            if(nums[start+1] == 1 && start < nums.length - 1){
                return groupSum5(start + 2, nums, target - nums[start]);
            }
            else
            {
                return groupSum5(start + 1, nums, target - nums[start]);
            }
        }

        if(groupSum5(start + 1, nums, target - nums[start]))
            return true;
        return groupSum5(start + 1, nums, target);
    }

    //splitOdd10
    public boolean splitOdd10(int[] nums) {
        return Hel(0, nums, 0, 0);
    }

    public boolean Hel(int inicio, int[] nums, int temp, int impar) {
        if(inicio >= nums.length)
            return temp % 10 == 0 && impar % 2 == 1;

        else if(Hel(inicio + 1, nums, temp + nums[inicio], impar))
            return true;

        else if(Hel(inicio + 1, nums, temp, impar + nums[inicio]))
            return true;

        return false;
    }

    //spliteArray
    public boolean splitArray(int[] nums) {
        return AHel(0, nums, 0, 0);
    }

    public boolean AHel(int inicio, int[] nums, int A1, int B1) {
        if(inicio >= nums.length){
            return A1 == B1;
        }
        else if(AHel(inicio+1, nums, A1, B1 + nums[inicio])){
            return true;
        }

        else if(AHel(inicio+1, nums, A1 + nums[inicio], B1)){
            return true;
        }
        return false;
    }
}
