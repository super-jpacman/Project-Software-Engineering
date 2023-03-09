package UC002;

import nl.tudelft.jpacman.MultiLevelLauncher;
import nl.tudelft.jpacman.TestLauncher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.npc.Ghost;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class TS003 {
    @DisplayName("TC01: function Start")
    @Test
    public void TC01() throws InterruptedException {
        MultiLevelLauncher multiLevelLauncher = new MultiLevelLauncher();
        Game game = multiLevelLauncher.makeGame();
        multiLevelLauncher.launch();
        Player player = game.getPlayers().get(0);
        // start the game.
        game.start();
        assertEquals(true,game.isInProgress());

    }
    @DisplayName("TC02: function Stop")
    @Test
    public void TC02() throws InterruptedException {
        MultiLevelLauncher multiLevelLauncher = new MultiLevelLauncher();
        Game game = multiLevelLauncher.makeGame();
        multiLevelLauncher.launch();
        Player player = game.getPlayers().get(0);
        // stop the game.
        game.stop();
        assertEquals(false,game.isInProgress());
    }
    @DisplayName("TC03: function Stop")
    @Test
    public void TC03() throws InterruptedException {
        MultiLevelLauncher multiLevelLauncher = new MultiLevelLauncher();
        Game game = multiLevelLauncher.makeGame();
        multiLevelLauncher.launch();
        Player player = game.getPlayers().get(0);
        // restart the game.
        game.restart();
        assertEquals(false,game.isInProgress());
    }
    @DisplayName("TC04: Pacman move left")
    @Test
    public void TC04() throws InterruptedException {
        TestLauncher test = new TestLauncher();
        test.setNameoftest("_Without_Ghost");
        test.LenghtOfMap(7,11);
        MultiLevelGame game = test.makeGame();
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        // start the game.
        game.start();
        Square Location1 = player.getSquare();
        game.move(player, Direction.WEST);
        Square Location2 = player.getSquare();
        assertNotSame(Location1,Location2);
    }
    @DisplayName("TC05: Pacman move right")
    @Test
    public void TC05() throws InterruptedException {
        TestLauncher test = new TestLauncher();
        test.setNameoftest("_Without_Ghost");
        test.LenghtOfMap(7,11);
        MultiLevelGame game = test.makeGame();
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        // start the game.
        game.start();
        Square Location1 = player.getSquare();
        game.move(player, Direction.EAST);
        Square Location2 = player.getSquare();
        assertNotSame(Location1,Location2);
    }
    @DisplayName("TC06: Pacman move north")
    @Test
    public void TC06() throws InterruptedException {
        TestLauncher test = new TestLauncher();
        test.setNameoftest("_Without_Ghost");
        test.LenghtOfMap(8,11);
        MultiLevelGame game = test.makeGame();
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        // start the game.
        game.start();
        Square Location1 = player.getSquare();
        game.move(player, Direction.NORTH);
        Square Location2 = player.getSquare();
        Thread.sleep(2000);
        assertNotSame(Location1,Location2);
    }
    @DisplayName("TC07: Pacman move south")
    @Test
    public void TC07() throws InterruptedException {
        TestLauncher test = new TestLauncher();
        test.setNameoftest("_Without_Ghost");
        test.LenghtOfMap(7,11);
        MultiLevelGame game = test.makeGame();
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        // start the game.
        game.start();
        Square Location1 = player.getSquare();
        game.move(player, Direction.SOUTH);
        Square Location2 = player.getSquare();
        assertNotSame(Location1,Location2);
    }
    @DisplayName("TC08: When pacman eat pellet player should get score")
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
    @DisplayName("TC09: Test when pacman walk and win")
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
    @DisplayName("TC10: Test when pacman walk and collision Inky")
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
    @DisplayName("TC11: Test when pacman walk and collision Blinky")
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
    @DisplayName("TC12: Test when pacman walk and collision Clyde")
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
    @DisplayName("TC13: Test when pacman walk and collision Pinky")
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
    @DisplayName("TC14: Check Stage")
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
    @DisplayName("TC17: Select Start")
    @Test
    public void TC17() throws InterruptedException {
        TestLauncher test = new TestLauncher();
        test.setNameoftest("_Without_Ghost");
        test.LenghtOfMap(7,11);
        MultiLevelGame game = test.makeGame();
        //Ghost G =
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        // start the game.
        game.start();
        //Pacman move
        Square Location1 = player.getSquare();
        game.move(player, Direction.SOUTH);
        //Ghost move
        player.getSprite();
        //Time run
        //System.out.println(game.getTotalTime());
        Thread.sleep(2000);
    }
    @DisplayName("TC20: Pacman move north attached to the wall")
    @Test
    public void TC20() throws InterruptedException {
        TestLauncher test = new TestLauncher();
        test.setNameoftest("_Without_Ghost");
        test.LenghtOfMap(7,11);
        MultiLevelGame game = test.makeGame();
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        // start the game.
        game.start();
        move(game, Direction.NORTH,200);
        Square Location1 = player.getSquare();
        move(game, Direction.NORTH,200-1);
        Square Location2 = player.getSquare();
        Thread.sleep(2000);
        assertSame(Location1,Location2);
    }
    @DisplayName("TC21: Pacman move south attached to the wall")
    @Test
    public void TC21() throws InterruptedException {
        TestLauncher test = new TestLauncher();
        test.setNameoftest("_Without_Ghost");
        test.LenghtOfMap(7,11);
        MultiLevelGame game = test.makeGame();
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        // start the game.
        game.start();
        move(game, Direction.SOUTH,200);
        Square Location1 = player.getSquare();
        move(game, Direction.SOUTH,200-1);
        Square Location2 = player.getSquare();
        Thread.sleep(2000);
        assertSame(Location1,Location2);
    }
    @DisplayName("TC22: Pacman move left attached to the wall")
    @Test
    public void TC22() throws InterruptedException {
        TestLauncher test = new TestLauncher();
        test.setNameoftest("_Without_Ghost");
        test.LenghtOfMap(7,11);
        MultiLevelGame game = test.makeGame();
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        // start the game.
        game.start();
        move(game, Direction.WEST,200);
        Square Location1 = player.getSquare();
        move(game, Direction.WEST,200-1);
        Square Location2 = player.getSquare();
        Thread.sleep(2000);
        assertSame(Location1,Location2);
    }
    @DisplayName("TC23: Pacman move right attached to the wall")
    @Test
    public void TC23() throws InterruptedException {
        TestLauncher test = new TestLauncher();
        test.setNameoftest("_Without_Ghost");
        test.LenghtOfMap(7,11);
        MultiLevelGame game = test.makeGame();
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        // start the game.
        game.start();
        move(game, Direction.EAST,200);
        Square Location1 = player.getSquare();
        move(game, Direction.EAST,200-1);
        Square Location2 = player.getSquare();
        Thread.sleep(2000);
        assertSame(Location1,Location2);
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

