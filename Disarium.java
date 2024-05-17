package DisariumNumber;

import java.util.Scanner;

public class Disarium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any Number : ");
        int n= sc.nextInt();

        int temp=n,r;

        int a=0;
        for (int i = 0; temp>0; i++) {
                a++;
                temp/=10;
        }
        System.out.println(a);

        for (int i = 1; i ==a; i++) {
            r = n%10;


        }
    }
}
