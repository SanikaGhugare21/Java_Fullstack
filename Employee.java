package com.basic;

import java.util.Scanner;

public class Employee {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Employee Name:");
		String name=sc.next();
		
		System.out.println("Enter Employee Age:");
		int age=sc.nextInt();
		
		System.out.println("Enter Employee ID:");
		int id=sc.nextInt();
		
		System.out.println("Enter Employee Gender:");
		String gen=sc.next();
		
		System.out.println("Enter Employee Department:");
		String dept=sc.next();
		
		System.out.println("Enter Employee Salary:");
		double sal=sc.nextDouble();		
		
		System.out.println("...Employee Details...");
		System.out.println("Employee Name:" + name);
		System.out.println("Age:" + age);
		System.out.println("Emp ID:" + id);
		System.out.println("Gender" + gen);
		System.out.println("Department:" + dept);
		System.out.println("Salary:" + sal);
		
		}

}
