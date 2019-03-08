
/**
 * Write a description of class Lab2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lab2
{
    public int countEvens(int[] nums) {
  int acum=0;
  for(int i=0; i<nums.length;i++){
    if((nums[i]%2)==0){
      acum++;
    }
  }
  return acum;
}

public int bigDiff(int[] nums) {
  int min=nums[0];
  int max=nums[0];
  for(int i=0;i<nums.length;i++){
    if(nums[i]<min){
      min=nums[i];
    }
    if(nums[i]>max){
      max=nums[i];
    }
  }
  return max-min;
}

public int centeredAverage(int[] nums) {
  int min=nums[0];
  int max=nums[0];
  int acum=0;
  for(int i=0;i<nums.length;i++){
    if(nums[i]<min){
      min=nums[i];
    }
    if(nums[i]>max){
      max=nums[i];
    }
    acum+=nums[i];
  }
  
  return (acum-max-min)/(nums.length-2);
}

public int sum13(int[] nums) {
  if(nums.length==0){
    return 0;
  }
  int acum=0;
  for(int i=0;i<nums.length;i++){
    if(nums[i]!=13){
      acum+=nums[i];
    }else if(nums[i] == 13 && i < nums.length -1 ) {
  nums[i]=0;
  nums[i+1] =0;
    }
  }
  return acum;
}

public int sum67(int[] nums) {
   int acum=0;
   int nulo=0;
   for(int i=0;i<nums.length;i++){
     if(nums[i]==6){
       for(int j=i;nums[j]!=7;j++){
        nums[j]=0;
        nulo=j;
       }
       nums[nulo+1]=0;
     }else{
       acum+=nums[i];
     }
     
   }
   return acum;
}

public boolean has22(int[] nums) {
 if(nums.length>=2){
   for(int i=0;i<nums.length-1;i++){
     if(nums[i]==2 && nums[i+1]==2){
       return true;
     }
     
   }
 }
 
 return false;
}

public boolean lucky13(int[] nums) {
  
  boolean h=true;
  for(int i=0; i<nums.length;i++){
    if(nums[i]==1 || nums[i]==3){
      h=false;
    }
  }
  return h;
}

public boolean sum28(int[] nums) {
  int acum =0;
  for(int i:nums){
    if(i==2){
      acum+=i;
    }
  }if(acum>8){
      return false;
  }
  return acum==8;
  }
  

  public boolean more14(int[] nums) {
  int acum1=0;
  int acum4=0;
  boolean xd=true;
  for(int i=0;i<nums.length;i++){
    if(nums[i]==1){
      acum1++;
    }
    if(nums[i]==4){
      acum4++;
    }
  }
  if(acum1>acum4){
    return true;
  }else;
  return false;
}

public int[] fizzArray(int n) {
  int [] a= new int[n];
  for(int b=0; b < n; b++){
   a[b]=b; 
  }
  return a;
  }

  public boolean isEverywhere(int[] nums, int val) {
  for(int a=0; a < nums.length-1;a++){
    
    if(!((nums[a]==val)||(nums[a+1]==val))){
      return false;
    }
    
  }
  return true;
}

public String[] fizzBuzz(int start, int end) {
  String[] a= new String [end-start];
  for(int b=start; b<end;b++){
    if(b%3==0 && b%5==0){
      a[b-start]="FizzBuzz";
    }else if(b%3==0){
      a[b-start]="Fizz";
    }else if(b%5==0){
      a[b-start]="Buzz";
    }else{
      a[b-start]=(new Integer(b)).toString();
    }
  }
  return a;
}


public int maxSpan(int[] nums) {
  if(nums.length>0){
 int sum=1;
 for (int left=0;left<nums.length;left++){
   for(int rigth=nums.length-1;rigth>left;rigth--){
     if(nums[left]==nums[rigth]){
       int help=rigth-left+1;
       if(sum<help){
       sum=help;
       break;
       }
     }
   }
 }
  return sum;
  }else
  return 0;
}

  public int[] fix34(int[] nums) {
    
    for(int i=0;i<nums.length;i++){
    if(nums[i]==3){
      int var=nums[i+1];
      nums[i+1]=4;
      for(int j=i+2;j<nums.length;j++){
        if(nums[j]==4){
          if(nums[j]==4)
          nums[j]=var;
        }
      }
    }  
    }
    return nums;
}


}
