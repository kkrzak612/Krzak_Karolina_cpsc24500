import java.util.Scanner;
public class GameZone{
	public static int printMenuAndGetChoice(Scanner sc){
		int choice;    // Number of their choices from the menu
		do {
			try {
				System.out.println("*************************************");
				System.out.println("* WELCOME TO THE GAME ZONE *");
				System.out.println("***********************************");
				System.out.println("What would you like to play?");
				System.out.println("1.Twenty-one ");
				System.out.println("2.Rock Paper Scissor ");
				System.out.println("3.Neither - I'm done ");
				choice = sc.nextInt();
			}catch(Exception ex) {
				System.out.println("PLease enter the number of your choice. ");
				sc.nextInt();   //clears out the input channel
				choice = 0; 
		}
	
}
			while (choice <=0 || choice>3);
	return choice;

	}	
}
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;    // Number of their choice from the menu
		do {
		
			choice = showMenuAndGetChoice(sc);
			if (choice ==1)  {        //Twenty- one
				
				
				
				
				
			} else if (choice ==2) {
				//Rock Paper Scissor
			}while (choice ! = 3);
			System.out.println("Thank you for playing (: ");
		} 
	}
				
				
				
				
				
				
			}
	
	 public static void twentyOne(Scanner sc) {
			int total = 0;						//user value for game
			int card = 0;                       // value of random car drawn 
			int dealer = 0;						// dealer value 
			string response = new String("y");	//creates a string to hold user value
			random rng - new Random();
			do { 					
				card = rng.nextInt(11)+1;		//creates a random value 
				total = total + card;           //adds card to total
				System.out.printf("You drew a %d.\n" , card);
				if (total == 21) {             
					System.out.println( "You got a perfect 21 ! You win !\n");
					total = 0; 
					mainMenu(sc); 				//return to menu
				}
				else if (total > 21) {
					System.out.println(" Sorry you lost, maybe next time!\n");
					total = 0;
					mainMenu(sc);				//return to menu
				}
				System.out.printf("your total is no %p Draw again: (y,n)\n",total);
				response = sc.next();
				}while (!response.equals("n"));
				
				dealer = rng.nextInt(7+1) + 13;  //draw random value
				if (total > dealer) {
					System.out.printf("The dealer has %d. You win!\n",dealer);
					total=0;
					mainMenu(sc);				//return to main menu 
		}
}





public static void rockPaperScissors (Scanner sc) {
	int player = 0;						//will store players choice
	int computer = 0;     				//stores random
	Random rng = new Random();
	System.out.println("What would like to choose?");
	System.out.println("1. Rock");
	System.out.println("2. Paper");
	System.out.println("3. Scissors");
	System.out.println("4. Quit");
	player = sc.nextInt();             // will record players input 
	computer = rng.nextInt(3)+1;       // chooses random value
	if (player == computer) {
		System.out.println("You both picked the same move: Draw");    //if player and computer have same draw
		}
	else if (player == 1 && computer == 2) {
		System.out.println("Paper will cover rock: You lose");        //Player would lose 
		}
	else if (player == 1 && computer == 3 ) {
		System.out.println("Rock will crush scissors: You win");     //Player would win
		}
	else if (player == 2 && computer == 1) {
		System.out.println("Paper will cover rock: You win");		//Player would win
		}
	else if (player == 2 && computer == 3) {
		System.out.println("Scissors will cut paper: You lose ");   //Player would lose
		}
	else if (player == 3 && computer == 1) {
		System.out.println("Rock will crush scissors: You lose "); 	//Player would lose
		}
	else if (player == 3 && computer == 2) {
		System.out.println("Scissors will cut paper: You win ");    //Player would win
		}
	else if (player == 4) {											//Player wants to end game and go back to main menu
		mainMenu(sc);
		}
}



				
			
			
			
			
	