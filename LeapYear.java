package Time_Date;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter any Year :");
//        int a= sc.nextInt();
//
////        boolean leap = ((a % 4 == 0) && (a % 100 != 0)) || (a % 400 == 0);
////        System.out.println(leap);
/////////////////////////////////////////////////////////////////////////////
//        if (a%100!=0 && a%4==0 || a%400==0) {
//            System.out.println(a+" is Leap year");
//        }
//        else {
//            System.out.println(a + " is notLeap year");
//        }
//
/////////////////////////////////////////////////////////////////////////////
//        if (a%100==0) {
//            if (a %400==0) {
//                System.out.println(a+" is Leap Year");
//
//            }
//            else
//                System.out.println(a+" is not Leap year");
//
//        }
//        else if (a%4==0){
//            System.out.println(a+" is Leap year");
//    }
//        else
//            System.out.println(a+" is not Leap year");

        String string= "$2000";
        string.replace("$","");

        int n= Integer.parseInt(string.substring(1));
        n=n+1;

        String string1=String.valueOf(n);
        System.out.println(string1);
}}
