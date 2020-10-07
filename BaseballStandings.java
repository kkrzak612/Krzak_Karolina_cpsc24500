
/*
* Karolina Krzak
* 
* Object- Oriented Baseball Standing
* 
* 10/07/2020
* 
* This code will read a tab-delimited file that will 
* express the current Major League Baseball standings.
* The user will be able to pick which standing they would
* like to see.Each teams will be displayed in a fashion
*  of their winning percentages The user will be able to
*  see the overall standings in the American and national League. 
*/


import java.util.ArrayList;
import java.util.Scanner; 
import java.io.*;

public class BaseballStandings {
	/*
	 * @param Will print the menu and options for baseball standing 
	 * @return the choice will decide on users input
	 */
	
	
	public static int showMenuAndGetChoice(Scanner sc) {
		System.out.println(" **************************");
		System.out.println("* BASEBALL STANDING ANALYZER * ");
		System.out.println(" **************************");
		System.out.println(" This program reads a file that contains");
		System.out.println(" current baseball standings and adds to");
		System.out.println(" more detailed statistics. It also prints");
		System.out.println(" overall standings in the American and natinal leagues");
		System.out.println(" **************************");
		System.out.println("Which standing would you like to see? ");
		System.out.println(" 1. AL East ");
		System.out.println(" 2. AL Central ");
		System.out.println(" 3. AL West ");
		System.out.println(" 4. NL East ");
		System.out.println(" 5. NL Central");
		System.out.println(" 6. NL West ");
		System.out.println(" 7. Overall ");
		System.out.println(" 8. Exit");
		System.out.print(" Please enter the number of your choice: ");
		int choice = sc.nextInt();                  			// Allows user to input choice
		return choice;											// Will return and present that choice
	
		
	}

	/*
	 * @param will take line in current stat 
	 * @param will do the total calculations of wins plus loses 
	 * @return the pct wins will return to stat function
	 */
        public static double getWinningPercentage(String line) {
		String[] parts = line.split("\t");
		double total = (Integer.parseInt(parts[1])+ Integer.parseInt(parts[2]) * 1.00); 
		double pct = (Integer.parseInt(parts[1])/ total);
		return pct; 
	} 
        
       /*
  	   * @param All array list with each team's stats
  	   * @param this pct is current pct
  	   * @param other pct comparing wins of other teams to find placement 
  	   * @param Leaves the loop b/c the insert location
  	   * @param Append at the bottom of the list
  	   * @param Insert the new student (Line) at location pos
  	   */
  	public static void insertByWinningPercentage(ArrayList<String> all, String line) {
  		double thispct = getWinningPercentage(line);
  		double otherpct;
  		int pos = -1;
  		for(int i = 0; i< all.size(); i++) {
  			otherpct = getWinningPercentage(all.get(i));
  			if (thispct > otherpct) {
  				pos = i;
  				break;                                            
  			}
  		}
  		if (pos < 0) {
  			all.add(line);										 
  		
  		}else {
  			all.add(pos,line);									  
  		}

  	}

    /*
     * @param Array of string in the file
     * @param Top team will make inputs from tops team's string
     * @param Top parts will take individual section
     * @param High win will take wins from highest team
     * @param High loss will take the losses from the team with highest 
     * @param Next win will take wins in current string
     * @param Next loss will take losses in current string
     * @param Gb win will calculate wins for highest team
     * @param Gb loses will calculate loses from highest team
     * @return Calculations will go back for the current team for games back
     */
    
    public static double getGamesBack(ArrayList<String> stats, String line) {
    	String team = stats.get(0);
    	String[] parts = team.split("\t");
    	int best_wins = Integer.parseInt(parts[1]);
    	int best_loss = Integer.parseInt(parts[2]);
    	String[] parts1 = line.split("\t");
    	int line_win = Integer.parseInt(parts1[1]);
    	int line_loss = Integer.parseInt(parts1[2]);
    	int gb_win = best_wins - line_win;
    	int gb_loss = best_loss - line_loss;
    	double g_b = ((gb_win - gb_loss)/ 2.0);
    	return g_b;
    	
    
    }
    
    
    /*
     * @param The arraylist with all strings in the file
     * @param pct takes the winning percentage of current team
     * @param g_b gets back for current team 
     */
	  public static void printStats(ArrayList<String> stats) {
		String [] parts;
		double pct;
		double g_b;
		System.out.println("Team    Win    Losses    WinningPercentage    Games Back\n");
		for(String stat : stats) {
			parts = stat.split("\t");
			pct = getWinningPercentage(stat);
			g_b = getGamesBack(stats,stat);
			System.out.printf("%-10s %-10s %-10s %-10.2f %-10.1f\n", parts[0],parts[1],parts[2],pct,g_b);
		}
	}
	  
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Please enter the name of the file: ");   //Asking user for file
			String fname = sc.nextLine();                             // Will take location of file
			ArrayList<String> aleast = new ArrayList<String>();
			ArrayList<String> alcentral = new ArrayList<String>();
			ArrayList<String> alwest = new ArrayList<String>();
			ArrayList<String> nleast = new ArrayList<String>();
			ArrayList<String> nlcentral = new ArrayList<String>();
			ArrayList<String> nlwest  = new ArrayList<String>();
			ArrayList<String> target = null;
			ArrayList<String> allTogether = new ArrayList<String>();  //Option 7: overall
			String line;
			String[] parts;
			String league;
			boolean canGoAhead;
			int choice;
			try {
				Scanner fsc = new Scanner(new File(fname));             //Takes input file from user
				while(fsc.hasNextLine()) {
					line = fsc.nextLine();
					parts = line.split("\t");							//Stores strings into their categories
					if (parts[0].equalsIgnoreCase("LEAGUE")) {
						league = parts[1].toUpperCase();
						if (league.equalsIgnoreCase("al east")) {
						target = aleast;
					}else if (league.equalsIgnoreCase("al central")) {
						target = alcentral;
					}else if (league.equalsIgnoreCase("al west")) {
						target = alwest;
					}else if (league.equalsIgnoreCase("nl east")) {
						target = nleast;
					}else if (league.equalsIgnoreCase("nl central")) {
						target = nlcentral;
					}else if (league.equalsIgnoreCase("nl west")) {
						target = nlwest;
					}
				} else {
					target.add(line);  								//Read line of text will add to array list
					insertByWinningPercentage(allTogether,line);
				}
			}				
			
				fsc.close();
				canGoAhead = true;
			  } catch(Exception ex) {
				System.out.println("Could not read your file. ");
				canGoAhead = false;
			
			}
			if (canGoAhead) {
				do {
					choice = showMenuAndGetChoice(sc);            
					if(choice ==1) {
						printStats(aleast);
					}else if(choice ==2) {
						printStats(alcentral);
					}else if (choice ==3) {
						printStats(alwest);
					}else if(choice ==4) {
						printStats(nleast);
					}else if (choice ==5) {
						printStats(nlcentral);
					}else if(choice ==6) {
						printStats(nlwest);
					}else if(choice ==7) {
						for(String team : allTogether) {
							System.out.println(team);
						}
					}else if(choice ==8) {
						sc.close();
						System.exit(0);
					}else {
						System.out.println("Please enter a number in the given range. ");
						
					}
			} while(choice!=8);
		}
	}
}


    
    
    


