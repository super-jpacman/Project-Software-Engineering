package nl.tudelft.jpacman.points;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class SaveScore {

    public SaveScore(String Pname, double time, int point){
        if(Pname.length()<=16 && time>=0 && point >=0) {
            JSONParser jsonParser = new JSONParser();

            try {

                JSONArray jsonArray = (JSONArray) new JSONParser().parse(new FileReader("src/main/resources/score_board.json"));

                JSONObject save_ = new JSONObject();
                save_.put("name", Pname);
                save_.put("point", point);
                save_.put("time", time);

                jsonArray.add(save_);

                FileWriter file = new FileWriter("src/main/resources/score_board.json");
                file.write(jsonArray.toJSONString());
                System.out.println("Successfully to Save JSON");
                file.flush();
                file.close();

            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
        }
    }

}
