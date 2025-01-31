package com.basic;

import java.util.Scanner;

public class Rectangle {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Length Of Rectangle: ");
		double l=sc.nextDouble();
		System.out.println("Enter Breadth Of Rectangle: ");
		double b=sc.nextDouble();
		
		double area=l*b;
		System.out.println("Area of Rectangle:" + " " + area);
		
		double pr=2*(l+b);
		System.out.println("Perimeter of Rectangle is:" +" " + pr);
		
	}

}
