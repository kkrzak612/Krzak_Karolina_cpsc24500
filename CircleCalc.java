//Karolina Krzak
//09/18/2020
//Object Oriented sec 1
//This program will calculate area and circumference of circle 

import java.util.Scanner;
public class CircleCalc {
	
	//Scanner placed for input from users
	static Scanner sc = new Scanner(System.in);
	public static void manin(String args[])
	{
		
		//Will take in the radius entered and sort
		System.out.print("Please enter the radius");
		
		double radius = sc.nextDouble();
		
		//Area
		double area = Math.PI * (radius * radius);
		System.out.println("The area of the circle is: " + area);
	
		//Circumference 
		double circumference= Math.PI * 2*radius;
		System.out.println(" The circumference of the circle is:" + circumference);
		
	}

}
