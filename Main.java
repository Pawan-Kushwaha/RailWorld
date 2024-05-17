package Interface;


import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String pawan;
        System.out.println("Enter Student Name : ");
        pawan=sc.nextLine();
        System.out.println("Enter marks of "+pawan);
        int x=sc.nextInt();

        Student student=new Student(x,pawan);

        Student student1 = new Student(75,pawan);

        student.showMarks();

        student.displayName();

        //student.showMarks();
        int a= student.compareTo(student1);
        if (a == 1) {
            System.out.println("Marks is Higher");
        }
            else if(a==2)
            {
                System.out.println("Marks is equal");
            }

        else
            System.out.println("Marks is lower");
    }



}