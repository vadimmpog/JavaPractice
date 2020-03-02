import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.Math.pow;

public class Third {

    public static void operation(Stack<Integer> s1, char q){
        int a,b;
        a = Integer.parseInt(s1.peek().toString());
        s1.pop();
        b = Integer.parseInt(s1.peek().toString());
        s1.pop();
        if(q == '+'){
            s1.push( b+a);
        }
        if(q == '-'){
            s1.push( b-a);
        }
        if(q == '*'){
            s1.push( a*b);
        }if(q == '/'){
            s1.push( b/a);
        }
        if(q == '^'){
            s1.push( (int) pow(b,a));
        }



    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите пример: ");

        String s =in.next(),num="";
        int a,b;
        Stack<Character> c = new Stack<>();//стэк для операций
        Stack<Integer> s1 = new Stack<>();
        int f= 0;

        for (int i = 0;i < s.length();i++){
            if(s.charAt(i)>='0'&& s.charAt(i) <='9'){
                num+=s.charAt(i);
                if(i == s.length()-1){
                    s1.push(Integer.parseInt(num));
                    num="";
                }
            }
            else{
                if(num!="") s1.push(Integer.parseInt(num));
                num="";
                switch (s.charAt(i)){
                    case'^':{
                        if(f >= 3){
                            operation(s1,c.peek());
                            c.pop();
                        }
                        c.push('^');
                        f=3;
                        break;
                    }
                    case'*':{
                        if(f >= 2){
                            operation(s1,c.peek());
                            c.pop();
                        }
                        c.push('*');

                        f=2;
                        break;
                    }
                    case'/':{
                        if(f >= 2){
                            operation(s1,c.peek());
                            c.pop();
                        }
                        c.push('/');
                        f=2;
                        break;
                    }
                    case'+':{
                        if(f >= 1){
                            operation(s1,c.peek());
                            c.pop();
                        }
                        c.push('+');
                        f=1;
                        break;
                    }
                    case'-':{
                        if(f >= 1){
                            operation(s1,c.peek());
                            c.pop();

                        }
                        c.push('-');
                        f=1;
                        break;
                    }
                    case'(':{
                        c.push('(');
                        f=0;
                        break;
                    }
                    case')':{
                        while(!c.peek().equals('(')){
                            operation(s1,c.peek());
                            c.pop();
                        }
                        f=0;
                        c.pop();
                        break;
                    }
                }
            }
        }

        while(!c.isEmpty()){
            operation(s1,c.peek());
            c.pop();
        }
        System.out.println(s1.peek());




    }
}
