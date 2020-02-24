import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt(),a1=0,a2=0,a3=0,a4=0;
            //1000 500 100 30
            if(sum>1000){
                a1 = sum/1000;
                sum = sum%1000;
            }else{
                if(sum>500){
                    a2 = sum/500;
                    sum = sum%5000;
                }
                else{
                    if(sum>100){
                        a3 = sum/100;
                        sum = sum%100;
                    }
                    else{
                        if(sum>30){
                            a4 = sum/30;
                            sum = sum%30;
                        }
                    }
                }
            }
            if(sum !=0){
                System.out.print("Invalid sum");
            }
            else {
                System.out.print("1000 : "+a1+"\n500 : "+a2+"\n100 : "+a3+"\n30 : "+a4);
            }


    }
}
