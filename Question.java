/*
 * @Param will store the questions, four possible answers, and correct answers.
 * @Param will will set question,choices, and answer
 * @Param will get question, choices, and answer
 */
public class Question {
    private String question;
    private String[] choices;
    private String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    public Question(String question, String[] choices, String answer){
        setQuestion(question);
        setChoices(choices);
        setAnswer(answer);
    }
   
}
