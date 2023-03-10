package UC001;

import nl.tudelft.jpacman.TestLauncher;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.SaveScore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TS007 {
    @DisplayName("TC01: function Start")
    @Test
    public void TC01() throws InterruptedException {
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.LenghtOfMap(1,5);
        Game game = testLauncher.makeGame();
        game = testLauncher.getGame();
        Player player = game.getPlayers().get(0);
        game.start();
        assertEquals(true,game.isInProgress());

    }
    @DisplayName("TC02: function Stop")
    @Test
    public void TC02() throws InterruptedException {
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.LenghtOfMap(1,5);
        Game game = testLauncher.makeGame();
        game = testLauncher.getGame();
        //testLauncher.launch();
        Player player = game.getPlayers().get(0);
        // stop the game.
        game.stop();
        assertEquals(false,game.isInProgress());
    }
    @DisplayName("TC03: function restart")
    @Test
    public void TC03() throws InterruptedException {
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.LenghtOfMap(1,5);
        Game game = testLauncher.makeGame();
        game = testLauncher.getGame();
        //testLauncher.launch();
        Player player = game.getPlayers().get(0);
        // restart the game.
        game.restart();
        assertEquals(false,game.isInProgress());
    }
    @DisplayName("TC04: function addpoint")
    @Test
    public void TC04() throws InterruptedException {
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.LenghtOfMap(1,5);
        Game game = testLauncher.makeGame();
        game = testLauncher.getGame();
        Player player = game.getPlayers().get(0);
        player.addPoints(100);
        assertEquals(100,player.getScore());
    }
    @DisplayName("TC05:Save name, score and time")
    @Test
    void TC05() throws IOException {
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

    @DisplayName("TC06:Save name, score and time")
    @Test
    void TC06() throws IOException {
        System.out.println("asdasdasd");
        //assertEquals();
    }
}
