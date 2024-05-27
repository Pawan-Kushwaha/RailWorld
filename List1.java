package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class List1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter any 3 values for List : ");
//
//        ArrayList<Integer> arrayList = new ArrayList();
//
//        arrayList.add(scanner.nextInt());
//        arrayList.add(scanner.nextInt());
//        arrayList.add(scanner.nextInt());
//        System.out.println(arrayList);
//
//        arrayList.remove(1);
//        System.out.println(arrayList);
//
        ArrayList<Employee> arrayList1 = new ArrayList();
        System.out.println("Enter Employee ID,Name,position : ");

//        int d = scanner.nextInt();
//        scanner.next();
//        String string = scanner.nextLine();
//        String string1 = scanner.next();

        Employee employee = new Employee(4,"Kamal","Trainee");
//
        Employee employee1 = new Employee(352,"Durgesh","Trainer");
        arrayList1.add(employee);
        arrayList1.add(employee1);
//
////        System.out.println(employee);
        System.out.println(arrayList1);
//
//        arrayList1.remove(employee);
//        System.out.println(arrayList1);
//
////        employee1.seteName("Rajan");
//
////        System.out.println(arrayList1);
////        System.out.println(employee1);
//
//
//        Set set = new HashSet();
//        System.out.println("Enter any 2 values for Set : ");
//        set.add(scanner.nextInt());
//        set.add(scanner.nextInt());
//        System.out.println(set);
//        System.out.println("Enter Employee Id,name,position : ");
//        Employee employee1 = new Employee(scanner.nextInt(),scanner.nextLine(),scanner.next());
//
//        Set set1 = new HashSet();
//        set1.add(employee1);

//        System.out.println(set1);
        Collections.sort(arrayList1, new EmployeeById());
        System.out.println(arrayList1);
    }
}
