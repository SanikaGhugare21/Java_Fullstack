package com.basic;

import java.util.Scanner;

public class Circle {
	public static void main(String[] args) {
		double PI=3.14;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Radius Of Circle:");
		float radius=sc.nextFloat();
		
		double area=PI*radius*radius;
		System.out.println("Area Of Circle is:" + " " + area);
		
		double cc=2*PI*radius;
		System.out.println("Circumference Of Circle is:" + cc);
		
		
	}

}
