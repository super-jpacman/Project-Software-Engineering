import nl.tudelft.jpacman.MultiLevelLauncher;
import nl.tudelft.jpacman.TestLauncher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.level.Player;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class TS001 {

    @DisplayName("When pacman eat pellet player should get score")
    @Test
    public void TC08() throws InterruptedException {
        TestLauncher test = new TestLauncher();
        test.setNameoftest("_Without_Ghost");
        test.LenghtOfMap(7,11);
        MultiLevelGame game = test.makeGame();
        test.launch();
        Player player = game.getPlayers().get(0);
        // start the game.
        game.start();
        int Total_Pellet = game.getLevel().remainingPellets();
        while(Total_Pellet == game.getLevel().remainingPellets()) {
            move(game,getRandomDirection(),1);
        }
        assertEquals(10,player.getScore());
    }
    @DisplayName("Test when pacman walk and win")
    @Test
    public void TC09() throws InterruptedException{
        TestLauncher test = new TestLauncher();
        test.setNameoftest("_Without_Ghost");
        test.LenghtOfMap(7,11);
        MultiLevelGame game = test.makeGame();
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        int Total_pellet = game.getLevel().remainingPellets();
        game.start();
        int level = game.getLevelNumber();
        System.out.println("Start at "+game.getLevelNumber());
        while(game.getLevel().remainingPellets() != 0 && level == game.getLevelNumber()) {
            move(game,getRandomDirection(),1);
        }
        assertEquals(Total_pellet*10.,player.getScore());
    }
    @DisplayName("Test when pacman walk and collision Inky")
    @Test
    public void TC10() throws InterruptedException{
        TestLauncher test = new TestLauncher();
        test.setNameoftest("_Hit_Ghost");
        test.LenghtOfMap(12,15);
        MultiLevelGame game = test.makeGame();
        test.setStartStage(12);
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        game.start();
        move(game,Direction.EAST,8);
        assertEquals(false,player.isAlive());
    }
    @DisplayName("Test when pacman walk and collision Blinky")
    @Test
    public void TC11() throws InterruptedException{
        TestLauncher test = new TestLauncher();
        test.setNameoftest("_Hit_Ghost");
        test.LenghtOfMap(12,15);
        MultiLevelGame game = test.makeGame();
        test.setStartStage(13);
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        game.start();
        move(game,Direction.EAST,8);
        assertEquals(false,player.isAlive());
    }
    @DisplayName("Test when pacman walk and collision Clyde")
    @Test
    public void TC12() throws InterruptedException{
        TestLauncher test = new TestLauncher();
        test.setNameoftest("_Hit_Ghost");
        test.LenghtOfMap(12,15);
        MultiLevelGame game = test.makeGame();
        test.setStartStage(14);
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        game.start();
        move(game,Direction.EAST,8);
        assertEquals(false,player.isAlive());
    }
    @DisplayName("Test when pacman walk and collision Pinky")
    @Test
    public void TC13() throws InterruptedException{
        TestLauncher test = new TestLauncher();
        test.setNameoftest("_Hit_Ghost");
        test.LenghtOfMap(12,15);
        MultiLevelGame game = test.makeGame();
        test.setStartStage(15);
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        game.start();
        move(game,Direction.EAST,8);
        assertEquals(false,player.isAlive());
    }
    @DisplayName("Check Stage")
    @Test
    public void TC14() throws InterruptedException{
        ArrayList<Integer> checkstage = new ArrayList<Integer>();
        TestLauncher test = new TestLauncher();
        test.LenghtOfMap(7,11);
        test.setNameoftest("_Without_Ghost");
        test.launch();
        MultiLevelGame game = test.getGame();
        Player player = game.getPlayers().get(0);
        int Total_pellet = game.getLevel().remainingPellets();
        game.start();
        int level = game.getLevelNumber();
        checkstage.add(game.getLevelNumber());
        //System.out.println("Start at "+game.getLevelNumber());
        while(game.getLevelNumber() != 4) {
            if(game.getLevel().isInProgress() == false){
                checkstage.add(game.getLevelNumber());
                System.out.println(checkstage);
                //assertEquals(expected,String.valueOf(checkstage));
                game.start();
            }
            move(game,getRandomDirection(),1);
        }
        checkstage.add(game.getLevelNumber());
        for(int i=0 ; i<5 ; i++){
            assertEquals(i,checkstage.get(i));
        }
    }
    private Direction getRandomDirection() {
        return Direction.values()[new Random().nextInt(Direction.values().length)];
    }
    public static void move(Game game, Direction dir, int numSteps) throws InterruptedException {
        Player player = game.getPlayers().get(0);
        for (int i = 0; i < numSteps; i++) {
            game.move(player, dir);
        }
    }
}
