package com.basic;

import java.util.Scanner;

public class Loop_Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Choice From 1 to 4: ");
        System.out.println("1. Accept min and max from user and display only even numbers between them.");
        System.out.println("2. Accept a number from user and check if it is prime.");
        System.out.println("3. Accept a number from user and check if it is a palindrome.");
        System.out.println("4. Accept a number from user and check if it is an Armstrong number.");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter min number:");
                int min = sc.nextInt();
                System.out.println("Enter max number:");
                int max = sc.nextInt();

                for (int num = min; num <= max; num++) {
                    if (num % 2 == 0) {
                        System.out.println(num);
                    }
                }
                break;

            case 2:
                System.out.println("Enter a number:");
                int num1 = sc.nextInt();

                if (num1 < 2) {
                    System.out.println(num1 + " is not a prime number.");
                } else {
                    boolean isPrime = true;
                    for (int i = 2; i <= Math.sqrt(num1); i++) {
                        if (num1 % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if (isPrime) {
                        System.out.println(num1 + " is a prime number.");
                    } else {
                        System.out.println(num1 + " is not a prime number.");
                    }
                }
                break;

            case 3:
                System.out.println("Enter a number:");
                int num2 = sc.nextInt();
                int original = num2;
                int reverse = 0;

                while (num2 > 0) {
                    int lastDigit = num2 % 10;
                    reverse = reverse * 10 + lastDigit;
                    num2 = num2 / 10;
                }

                if (reverse == original) {
                    System.out.println(original + " is a palindrome.");
                } else {
                    System.out.println(original + " is not a palindrome.");
                }
                break;

            case 4:
                System.out.println("Enter a number:");
                int num3 = sc.nextInt();
                int originalNumber = num3;
                int remainder, result = 0, n = 0;

                int temp = originalNumber;
                while (temp != 0) {
                    temp /= 10;
                    n++;
                }

                temp = originalNumber;
                while (temp != 0) {
                    remainder = temp % 10;
                    result += Math.pow(remainder, n);
                    temp /= 10;
                }

                if (result == num3) {
                    System.out.println(num3 + " is an Armstrong number.");
                } else {
                    System.out.println(num3 + " is not an Armstrong number.");
                }
                break;

            default:
                System.out.println("Invalid Choice...");
        }
        sc.close();
    }
}
	