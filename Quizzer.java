/*
 * @Param chooses the user's requested number of questions at random
 * @Param will check how many questions user received correct 
 * @Return will display the questions 
 * 
 */
import java.util.ArrayList;
import java.util.Random;


public class Quizzer {
    private int correct;
    private int total;
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }
    
    public ArrayList<Question> getRandomQuestion(ArrayList<Question> question, int totalItems){
        Random rand = new Random();
        setTotal(totalItems);
        ArrayList<Question> newList = new ArrayList<Question>();
        for(int i=0;i<totalItems;i++){
            int randomIndex = rand.nextInt(question.size());
            newList.add(question.get(randomIndex));
            question.remove(randomIndex);
        }
        return newList;
    }


    
}
