import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество купюр от старшей к младшей\n");
        int a01=in.nextInt(),a02=in.nextInt(),a03=in.nextInt(),a04=in.nextInt();
        System.out.print("Введите сумму\n");
        int sum = in.nextInt(),a1=0,a2=0,a3=0,a4=0;

        if (sum > a01*1000+a02*500+a03*100+a04*30 || sum % 10 != 0) {
            System.out.println("Invalid sum");
        }
        else{
            while (sum % 100 != 0 && sum >= 30 && a04 > 0){
                sum -= 30;
                a04--;
                a4++;
            }
            while (sum >= 1000 && a02 > 0){
                sum -= 1000;
                a01--;
                a1++;
            }
            while (sum >= 500 && a03 > 0){
                sum -= 500;
                a02--;
                a2++;
            }
            while (sum >= 100 && a04 > 0){
                sum -= 100;
                a03--;
                a3++;
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