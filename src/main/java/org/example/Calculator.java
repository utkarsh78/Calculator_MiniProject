package org.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double num, num2;
        do {
            System.out.println("Scientific Calculator with DevOps, Select any one operation");
            System.out.print("Press 1 to Find Square Root\nPress 2 to Find Factorial\nPress 3 to Find Natural Logarithm\nPress 4 to Find Power\n" +
                    "Press 5 to Exit\nEnter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }

            switch (choice) {
                case 1:
                    System.out.print("Square Root Function ");
                    System.out.print("Enter a number : ");
                    num = scanner.nextDouble();
                    System.out.println("Squareroot of "+num+" is : " + calculator.sqroot(num));
                    System.out.println("\n");
                    // Square Root Function
                    break;

                case 2:
                    System.out.print("Factorial Function ");
                    System.out.print("Enter a number : ");
                    num = scanner.nextDouble();
                    System.out.println("Factorial of "+num+" is : " + calculator.factorial(num));
                    System.out.println("\n");
                    // Factorial Function
                    break;

                case 3:
                    System.out.print("Natural Logarithm Function ");
                    System.out.print("Enter a number : ");
                    num = scanner.nextDouble();
                    System.out.println("Natural Logarithm of "+num+" is : " + calculator.logarithm(num));
                    System.out.println("\n");
                    // Natural Logarithm (base е) - ln(x)
                    break;

                case 4:
                    System.out.print("Power Function ");
                    System.out.print("Enter Base number : ");
                    num = scanner.nextDouble();
                    System.out.print("Enter to the Power number : ");
                    num2 = scanner.nextDouble();
                    System.out.println("Power of "+num+" to the Power "+num2+" is : " + calculator.power(num,num2));
                    System.out.println("\n");
                    // Power Function
                    break;
                default:
                    System.out.println("Exit");
                    return;
            }
        } while (true);
    }

    public double sqroot(double num) {
        logger.info("[Square Root - " + num + " ]");
        double ans = Math.sqrt(num);
        logger.info("[RESULT ] - " + ans);
        return ans;
    }

    public double factorial(double num) {
        logger.info("[Factorial of  - " + num + " ]");
        double ans = fact(num);
        logger.info("[RESULT ] - " + ans);
        return ans;
    }

    public double fact(double num) {
        long k = 1;
        for(int i = 1;i<=num;i++) {
            k *= i;
        }
        return k;
    }

    public double power(double num, double num2) {
        logger.info("[Power of - " + num + " to the Power of " +num2+ " ]");
        double ans = Math.pow(num,num2);
        logger.info("[RESULT ] - " + ans);
        return ans;
    }

    public double logarithm(double num) {
        logger.info("[Natural Lagarithm of - " + num + " ]");
        double ans = Math.log(num);
        logger.info("[RESULT ] - " + ans);
        return ans;
    }
}