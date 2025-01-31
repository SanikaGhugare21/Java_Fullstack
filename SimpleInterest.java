package com.basic;
import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter Principal Amount: ");
        double principal = sc.nextDouble();
        
        System.out.print("Enter Rate Of Interest: ");
        double rate = sc.nextDouble();
        
        System.out.print("Enter The No Of Years: ");
        double time = sc.nextDouble();

   
        double SimpleInterest = (principal * rate * time) / 100;

        System.out.println("Simple Interest Is: " + SimpleInterest);
        
        sc.close();
    }
}

