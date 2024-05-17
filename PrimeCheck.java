package PrimeNumber;

public class PrimeCheck {

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false; // 1 and negative numbers are not prime
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // Number is divisible by another number, not prime
            }
        }
        return true; // Number is prime
    }

    public static void main(String[] args) {
        int numToCheck = 29; // Example number to check
        if (isPrime(numToCheck)) {
            System.out.println(numToCheck + " is a prime number.");
        } else {
            System.out.println(numToCheck + " is not a prime number.");
        }
    }
}
