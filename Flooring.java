//Karolina Krzak
//09/18/2020
// Object Oriented Section 1
// This code will help user find out how many packages of boards would be needed and cost for their room/home


import java.util.Scanner;

public class Flooring {
	
	//Declaring our variables

	public static void main(String[] args) {
		
		double roomArea = 0, length, width;
		int EACH_BOARD_AREA = 30 *6;
		int no_of_boards = 0, no_of_packages = 0;
		double totalPackagescost = 0-0;
	
	//Creating a scanner class for user inputs
Scanner sc = new Scanner(System.in);
 
	//The input by the user
System.out.print("Please enter the length of the room in feet:");
length = sc.nextDouble();

System.out.print("Please enter the width of the room in feet:");
width = sc.nextDouble();

 	//Calculations
roomArea = length * width * 12;
roomArea = (int) (roomArea + (roomArea * 0.20));

no_of_boards = (int)Math.ceil((roomArea / EACH_BOARD_AREA));

no_of_packages = no_of_boards / 6;

totalPackagescost = costOfPackages(no_of_packages);


	//The output diplayed
System.out.println("You must buy " + no_of_packages+ "packages of boards .");
System.out.println("The total cost of packages :$"+totalPackagescost);
 
	}
 private static double costOfPackages(int no_of_packages) {
	 double ONE_PACKAGE_COST = 24.99;
	 
	 return no_of_packages * ONE_PACKAGE_COST;
	 

		
	}
}
