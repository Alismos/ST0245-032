/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratorio_2;

import java.util.Random;
import java.util.Arrays;

public class Code_source
{
  // Computer the sum of an array
  public static int ArraySum(int[] A)
  {          
      int sum = 0;
      for (int i = 0; i < A.length; i++)
         sum = sum + A[i];
      return sum;
  }
  
  // Computes the maximum value of an array
  public static int ArrayMax(int[] A)
  {
      int max = A[0];
      for (int i = 0; i < A.length; i++)
         if (A[i] > max)
           max = A[i];
      return max;
  }
  
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
      int num = (int) (Math.random() * 1200000) + 400000;
      
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
      
      int [][] XY = {X,Y}; 
      inicioMs = System.currentTimeMillis(); 
      Code_source.mergeSort(X);
      finalMs = System.currentTimeMillis();
      
      inicioIs = System.currentTimeMillis();
      Code_source.InsertionSort(X);
      finalIs = System.currentTimeMillis();
      
      tMs = (finalMs - inicioMs);
      
      tIs = (finalIs - inicioIs);
      
      //System.out.println("Tiempo Merge sort : " + tMs + "\n" + "Tiempo Insert sort : " + tIs);
      System.out.println(X.length * Y.length);
      System.out.println();
      System.out.println( tMs + "\n" + tIs);
      }
      //System.out.println(Code_source.ArraySum(X) + " " + Code_source.ArrayMax(X) + "\n" );      
      //}
  }
  
}
