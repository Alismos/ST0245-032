/**
 * Santiago Santacruz R && Duvan Andres Ramirez
 * 20/03/2019
 */
import java.util.Scanner;

import java.util.Stack;

public class NotacionPolaca
{
    Stack<Integer> stack =  new Stack<>();;
    public void main(String[] args){
    
    System.out.println("Digite lo que quiere calcular en notacion polaca");
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    String[] parts=splitStr(str);
    llenarStack(parts);
    int x = respuesta(stack);
    System.out.println(x);
    }
    public NotacionPolaca()
    {
    }

    public  String[] splitStr(String str){
        String [] parts = str.split(" ");
        return parts;
    }

    public  void llenarStack(String[] parts){
        char a ='+';
        char b ='-';
        char c ='*';
        char d ='/';

        for(int i = 0;i<parts.length;i++){
            String ayuda = parts[i];
            char [] help = ayuda.toCharArray();
            if(Character.isDigit(help[0])){
                int x = Integer.valueOf(parts[i]);
                stack.push(x);
            }else{
                
                if((help[0]==a)){
                    int e = stack.pop();
                    int f = stack.pop();
                    int x = e + f;
                    
                    stack.push(x);
                }else if(help[0]==b){
                    int e = stack.pop();
                    int f = stack.pop();
                    int x = f - e ;
                    
                    stack.push(x);
                }else if(help[0]==c){
                    int e = stack.pop();
                    int f = stack.pop();
                    int x = e * f;
                    
                    stack.push(x);
                }else if(help[0]==d){
                    int e = stack.pop();
                    int f = stack.pop();
                    int x = f / e;
                    
                    stack.push(x);
                }

            }
        }
    }

    private  int respuesta(Stack stack){
        
        int x = (int)stack.pop();

        return x;
    }
    
 
}