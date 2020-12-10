/*
 * @Param will read json file question
 * @Return will display an array list of questions from json file
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class QuestionReader {

    public ArrayList<Question> readFromJSON(String fname) throws FileNotFoundException, IOException, ParseException{
        try{
            ArrayList<Question> questionArray = new ArrayList<Question>();
            FileReader reader = new FileReader(new File(fname));
            JSONParser parser = new JSONParser();
            JSONObject all = (JSONObject)parser.parse(reader);
            JSONArray arr = (JSONArray)all.get("questions");
            Iterator itr = arr.iterator();
            JSONObject questionObject;
            String question;
            String answer;
            
            while(itr.hasNext()){
                String[] choices = new String[4];
                questionObject = (JSONObject)(itr.next());
                question = questionObject.get("question").toString();
                choices[0] = questionObject.get("a").toString();
                choices[1] = questionObject.get("b").toString();
                choices[2] = questionObject.get("c").toString();
                choices[3] = questionObject.get("d").toString();
                answer = questionObject.get("answer").toString();
                questionArray.add(new Question(question,choices,answer));
            }
            return questionArray;
        } catch(Exception e){
            System.out.println("File not Found!\n");
            return null;
        }
    }
    public ArrayList<Question> read(String fname) {
        
        try {
            return readFromJSON(fname);
        } catch (Exception ex) {
                return null;
        }
    }
}

