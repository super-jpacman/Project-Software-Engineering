import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.SaveScore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import static org.mockito.Mockito.mock;

public class TS006 {
    @DisplayName("TC01:Save name, score and time")
    @Test
    void TC01() throws IOException {
        String name = "Test Player";
        int point = 100;
        double time = 50.0;
        SaveScore saveScore = new SaveScore(name, time, point);
        File file = new File("src/main/resources/score_board.json");
        FileReader reader = new FileReader(file);
        int c;
        StringBuilder sb = new StringBuilder();
        while ((c = reader.read()) != -1) {
            sb.append((char) c);
        }
        reader.close();
        String json = sb.toString();
        Assertions.assertTrue(json.contains("\"name\":\"Test Player\""));
        Assertions.assertTrue(json.contains("\"point\":100"));
        Assertions.assertTrue(json.contains("\"time\":50.0"));
    }

    private Direction getRandomDirection() {
        return Direction.values()[new Random().nextInt(Direction.values().length)];
    }
    public static void move(Game game, Direction dir, int numSteps) throws InterruptedException {
        Player player = game.getPlayers().get(0);
        for (int i = 0; i < numSteps; i++) {
            game.move(player, dir);
            Thread.sleep(0);
        }
    }
}
