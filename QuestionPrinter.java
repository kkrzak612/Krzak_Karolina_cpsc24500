/*
 * @Param will print the answers and question text for all questions 
 * @Return will display correct answers to questions 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class QuestionPrinter {
    private int correct;
    
    public void runQuiz(ArrayList<Question> questions, int howMany){
        Scanner scan = new Scanner(System.in);
        
        for(int i=0;i<howMany;i++){
            System.out.println(questions.get(i).getQuestion());
            System.out.println(String.format("a. %s",questions.get(i).getChoices()[0]));
            System.out.println(String.format("b. %s",questions.get(i).getChoices()[1]));
            System.out.println(String.format("c. %s",questions.get(i).getChoices()[2]));
            System.out.println(String.format("d. %s",questions.get(i).getChoices()[3]));
            System.out.print("Type the letter of your choice: ");
            String userAnswer = scan.nextLine();
            if(userAnswer.equals(questions.get(i).getAnswer())){
                System.out.println("Correct!\n");
                correct++;
            }else
                System.out.println("Sorry the correct answer is "+questions.get(i).getAnswer()+"\n");
        }
        System.out.println("You answered "+correct+" correct out of "+howMany+" questions asked.\n");
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getCorrect() {
        return correct;
    }
    public void peek(ArrayList<Question> questions){
        for(int i=0;i<questions.size();i++){
          System.out.println(String.format((i+1)+". %s",questions.get(i).getQuestion()));
        }
        System.out.println();
    }
    public void exit(){
        System.exit(1);
    }
}
