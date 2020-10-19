/*
* Karolina Krzak
* 
* Object- Oriented Baseball Standing
* 
* 10/19/2020
* This program u will plot daily and cumulative CoVID 19 death totals for countries
* specified by the user. The data will come from a tab
* delimited file called countries_deaths.txt
* that have has been given to us it specifies total deaths over time.
*/


import javax.swing.JFrame;
import java.awt.Container;
import org.math.plot.Plot2DPanel;  //plots your 2d graph
import org.math.plot.plotObjects.BaseLabel;  // this is for the title of my plot
import java.util.Scanner;
import java.io.File;
import java.util.LinkedHashMap;
import java.awt.BorderLayout;
import java.awt.Color;


	public class CovidPlotter {
		private static Scanner sc;


		/*
		 * @param Will welcome user and print the menu to give options for covid plotter 
		 * @return the choice will decide on users input
		 *
		 */
		

		private static void printHeading() {
			System.out.println("************************************************");
			System.out.println("*    International COVID-19 MORTALITY RATES    *");
			System.out.println("************************************************");
			System.out.println(" This program reads a file that contains current");
			System.out.println(" data from a tab-delimited file. The program will");
			System.out.println(" plot daily and cumulative COVID-19 death totals ");
			System.out.println(" for countries specified by the user. ");

} 
		
		/*
		 * @param Will calculate all data in covid plotter 
		 * @return the results for the desire data from user
		 */

	public static LinkedHashMap<String, double[]> readData(Scanner fsc){
		//declare the data structure I'll return 
		LinkedHashMap<String, double[]> result = new LinkedHashMap<String,double[]>();
		fsc.nextLine();   // grab the header line
		String [] parts;
		String line;
		double[] values;   //the values I read from each line 
		String name;       //the name from the line
		while (fsc.hasNextLine()) {
			line = fsc.nextLine();
			parts = line.split("\t");
			name = parts[0];
			
		
		// The rest of the line are the values
		values = new double[parts.length -1];
		for (int i =1; i < parts.length; i++) {
			values[i-1]= Double.parseDouble(parts[i]);
			
		}
		result.put(name,values);
	}
	return result; 

}
	/* @param this function will build an array of day numbers that I
	 * can use to plot the countries values vs. days down below.
	 * @return will return the results for users desired data 
	 */
	public static double[] getDays(int howMany) {
		double[] result = new double[howMany];
		
		for (int i = 0; i <howMany; i++) {
		
			result[i] =i;
		}
		return result;
	}
	
	/*
	 * @param Will print the graph
	 * @param sets boundaries 
	 * @param will make layout of grape
	 */
	public static void setUpAndShowFrame(Plot2DPanel plot) {
		
		plot.setAxisLabels("days", "deaths");
		JFrame frm = new JFrame();
		BaseLabel title = new BaseLabel("Cumalative Deaths",Color.RED,0.5,1,1);
		plot.addPlotable(title);
		frm.setTitle("Countries Values");
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   //Get rid of frame
		frm.setBounds(100,100,500,500);
		Container c = frm.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(plot,BorderLayout.CENTER);
		frm.setVisible(true);
	}
	

	/*
	 * @param will in take users input on two countries
	 * @param will look through data for two countries and plot their daily deaths
	 * @return the choice will decide on users input and show on graph 
	 */
	public static void main(String[] args) {
		//this will hold the data
		LinkedHashMap<String,double[]> countries=null;
		String names;
		String [] parts;
		double [] data;            // each countries' data from map
		//double [] deathTolls;
		sc = new Scanner(System.in);    // or Scanner sc = new Scanner(System.in);
		
		printHeading();
		System.out.println("Please enter the name of the file. ");
		String fname = sc.nextLine();
				try {
					Scanner fsc = new Scanner(new File(fname));
					countries = readData(fsc);
					fsc.close();
				} catch (Exception ex) {
					countries = null;
				} if(countries == null) {
					System.out.println("Couldn't open the file.");
				}else {
					//The data has been successfully loaded in
					do {
					System.out.print("Please enter the countries name separated by commas(or exit to end):");
					names = sc.nextLine();
					
					//System.out.print("[D]aily or [C]umulative?");
					//choice = sc.nextLine();
					
					if (!names.equalsIgnoreCase("exit")) {
						Plot2DPanel plot = new Plot2DPanel();   //will contain the countries curves 
						parts = names.split(",");
						//add line plots for each person the user name
						for(String part : parts) {
							part = part.trim();   //gets rid of leading and trailing spaces
							if (countries.containsKey(part) == false) {
								System.out.printf("%s was not found.\n", part);
								
								//equation for daily death counts
								//death count[i] = death count[i] - death count[i-1]
								
								
						
							}else {
								data = countries.get(part);    // grab the countries values 
								// now plot data
								plot.addLinePlot(part,getDays(data.length),data);
							
							} 
		
					  }
						//plot will have the countries curves
						setUpAndShowFrame(plot);
						
					}
				}while (!names.equalsIgnoreCase("exit"));     //this breaks the do loop
				
		
		
		}
				System.out.println("Your only task is to wear a mask.");
	}
} 
				
	
	
				
	
