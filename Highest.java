package Turnary;

import java.util.Scanner;

public class Highest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a =scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int result = (a>b) ? ((a>c)?a:c):b;
        System.out.println(result);
    }
}
