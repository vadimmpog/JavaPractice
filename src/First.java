import java.util.Scanner;
import java.util.Stack;

public class First {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char a = s.charAt(0);
        boolean f = true;
        Stack<Character> kek = new Stack<>();
        for(int i=0; i<s.length();i++){
            if (!kek.isEmpty()) a = kek.peek();
            kek.push(s.charAt(i));
            if(a == '('||a == '{'||a == '['){
                if((a == '('&& kek.peek() == ')')||(a == '{'&& kek.peek() == '}')||(a == '['&& kek.peek() == ']')){
                    kek.pop();
                    if(!kek.isEmpty()) kek.pop();
                    else f = false;
                }
            }
            else break;
        }
        if(kek.isEmpty() && f ){
            System.out.print("yes");
        }
        else{
            System.out.print("no");
        }
    }
}
