package org.example;
import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        long num1;
        do {
            System.out.println("Scientific Calculator with DevOps, Select any one operation");
            System.out.print("Press 1 to find factorial\nPress 2 to find Square root\nPress 3 to find power\nPress 4 to find natural logarithm\n" +
                    "Press 5 to exit\nEnter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter a number : ");
                    num1 = scanner.nextLong();
                    System.out.println("Factorial of "+num1+" is : " + calculator.factoral(num1));
                    System.out.println("\n");
                    // Factorial Function
                    break;

                default:
                    System.out.println("Exit");
                    return;
            }
        } while (true);
    }

    public long factoral(long num1) {
        long ans = fact(num1);
        return ans;
    }

    public long fact(long num) {
        long k = 1;
        for(int i = 1;i<= num;i++) {
            k *= i;
        }

        return k;
    }
}