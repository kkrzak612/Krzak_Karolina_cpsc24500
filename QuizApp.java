/*
 * In this program we have a quiz tool that will ask the user random questions about the object oriented theory concepts.
 * These questions come from a file called questions.json
 * Each answer is saved in a file as questions.jason. 
 */



import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/*
 * My file path was C:/Users/karolinakrzak/Desktop/questions.json
 */

/*
 * @Param is main function that runs this application
 * @Param displays header and footer
 * @Param will repeatedly ask the user to select what they would like to do from list 
 * @param asks for user to input file path with is questions.json
 * @param relies on other classes to accomplish tasks of the program
 * @Reurn gives option for user to select what they would like to do with quiz
 *
 */

public class QuizApp {
    public static void main(String[] args) {
        System.out.println("*        What could possibly be more fun than this?         *\n"
                         + "*************************************************************\n"
                         + "*          OOP Theory and Concept Questions                 *\n"
                         + "*************************************************************\n" 
                         + "*          Nothing. Nothing at All. Nope. Nada              *");
        ArrayList<Question> questionAr = new ArrayList<Question>();
        QuestionReader qr = new QuestionReader();
        Quizzer quiz = new Quizzer();
        QuestionPrinter qp = new QuestionPrinter();
        String path;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the file containing questions: ");
        path = scan.nextLine();
        try {
            questionAr = qr.readFromJSON(path);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(QuizApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(questionAr==null)
            System.exit(1);
        System.out.println("File Found!\n");
        int choice=0;
        while(choice!=3){
            System.out.print("Here are your choices: \n1. Take the Quiz.\n2.  See questions and answers\n3.   Exit\nEnter the number of your choice: ");
            choice = scan.nextInt();
            if(choice==1){
                System.out.print("\nHow many questions would you like? ");
                int qs = scan.nextInt();
                quiz.getRandomQuestion(questionAr, qs);
                qp.runQuiz(quiz.getRandomQuestion(questionAr, qs),qs);  
                quiz.setCorrect(qp.getCorrect());
            }else if(choice==2){
                qp.peek(questionAr);
            }else if(choice==3){
                //System.exit(1);
            }   
        }
        System.out.println("*************************************************************\n"
                             + "*             Thank you for taking CPCS 24500               *\n"
                             + "*************************************************************\n");
    }
}
