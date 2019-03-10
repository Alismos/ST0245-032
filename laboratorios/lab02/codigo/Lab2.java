package Laboratorio_2;

import java.util.Random;
import java.util.Arrays;

public class Code_source
{
  
  // Sorts an array using Insertion Sort
  public static void InsertionSort(int[] A)
  {
       int temp,j;
       for (int i = 0; i < A.length; i++)
       {
         j = i;
         while (j > 0 && A[j-1] > A[j])
           {
               temp = A[j];
               A[j] = A[j-1];
               A[j-1] = temp;
               j = j-1;
            }           
       }
      // System.out.println(Arrays.toString(A));
  }
  
  public static int[] CrearArray(){
      
      Random generator = new Random();
      int num = (int) (Math.random() * 120000) + 40000;
      
      int[] array = new int[num];
        
        for (int i =0; i<num; i++){
            array[i] = generator.nextInt(200000);
        }
        return array;
    }
  

      // Sorts an array using Merge Sort
      // Taken from www.cs.cmu.edu/
	public static void mergeSort(int [ ] a)
	{
		int[] tmp = new int[a.length];
		mergeSort(a, tmp,  0,  a.length - 1);
	}


	private static void mergeSort(int [ ] a, int [ ] tmp, int left, int right)
	{
		if( left < right )
		{
			int center = (left + right) / 2;
			mergeSort(a, tmp, left, center);
			mergeSort(a, tmp, center + 1, right);
			merge(a, tmp, left, center + 1, right);
		}
	}


    private static void merge(int[ ] a, int[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left] <= a[right] )
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
  
  public static void main(String[] args)
  {
      long inicioMs, finalMs, inicioIs, finalIs, tMs, tIs;
     
      for(int i = 0; i < 20; i++){
      
      int [] X = CrearArray();
      int [] Y = CrearArray();
       inicioIs = System.currentTimeMillis();
      Code_source.InsertionSort(X);
      finalIs = System.currentTimeMillis();
      tIs = (finalIs - inicioIs);
      System.out.println( tIs);
      inicioMs = System.currentTimeMillis(); 
      Code_source.mergeSort(X);
      finalMs = System.currentTimeMillis();
      tMs = (finalMs - inicioMs);
      System.out.println( tMs);
      
      
      
      //System.out.println(X.length);
      }
      
  }
  
}
