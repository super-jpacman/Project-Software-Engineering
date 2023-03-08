package nl.tudelft.jpacman.points;

import org.json.JSONObject;

import java.io.FileWriter;

public class SaveScore {

    public SaveScore(String Pname, double time, int point){

        JSONObject save_ = new JSONObject();
        save_.put("name", Pname);
        save_.put("point", time);
        save_.put("time", point);

        try (FileWriter file = new FileWriter("src/main/resources/score_board.json")) {
            file.write(save_.toString());
            System.out.println("Successfully to Save JSON");
        } catch(Exception e){
            System.out.println(e);
        }
    }

}
