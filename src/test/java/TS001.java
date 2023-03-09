import nl.tudelft.jpacman.MultiLevelLauncher;
import nl.tudelft.jpacman.TestLauncher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.npc.ghost.*;
import nl.tudelft.jpacman.points.SaveScore;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class TS001 {
    @DisplayName("TC01: function Start")
    @Test
    public void TC01() throws InterruptedException {
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.LenghtOfMap(1,5);
        Game game = testLauncher.makeGame();
        game = testLauncher.getGame();
        testLauncher.launch();
        Player player = game.getPlayers().get(0);
        // start the game.
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
        testLauncher.launch();
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
        testLauncher.launch();
        Player player = game.getPlayers().get(0);
        // restart the game.
        game.restart();
        assertEquals(false,game.isInProgress());
    }
    @DisplayName("TC04: Pacman move left")
    @Test
    public void TC04() throws InterruptedException {
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.LenghtOfMap(1,5);
        Game game = testLauncher.makeGame();
        game = testLauncher.getGame();
        testLauncher.launch();
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
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.LenghtOfMap(1,5);
        Game game = testLauncher.makeGame();
        game = testLauncher.getGame();
        testLauncher.launch();
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
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.LenghtOfMap(1,5);
        Game game = testLauncher.makeGame();
        game = testLauncher.getGame();
        testLauncher.launch();
        Player player = game.getPlayers().get(0);
        // start the game.
        game.start();
        game.move(player, Direction.SOUTH);
        Square Location1 = player.getSquare();
        game.move(player, Direction.NORTH);
        Square Location2 = player.getSquare();
        assertNotSame(Location1,Location2);
    }
    @DisplayName("TC07: Pacman move south")
    @Test
    public void TC07() throws InterruptedException {
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.LenghtOfMap(1,5);
        Game game = testLauncher.makeGame();
        game = testLauncher.getGame();
        testLauncher.launch();
        Player player = game.getPlayers().get(0);
        // start the game.
        game.start();
        Square Location1 = player.getSquare();
        game.move(player, Direction.SOUTH);
        Square Location2 = player.getSquare();
        assertNotSame(Location1,Location2);
    }
    @DisplayName("TC08:When pacman eat pellet player should get score")
    @Test
    public void TC08() throws InterruptedException {
        TestLauncher test = new TestLauncher();
        test.setNameoftest("_Without_Ghost");
        test.LenghtOfMap(7,11);
        MultiLevelGame game = test.makeGame();
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        // start the game.
        game.start();
        int Total_Pellet = game.getLevel().remainingPellets();
        while(Total_Pellet == game.getLevel().remainingPellets()) {
            move(game,getRandomDirection(),1);
        }
        assertEquals(10,player.getScore());
    }
    @DisplayName("TC09:when pacman move and win")
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
    @DisplayName("TC10:when pacman move and collision Inky")
    @Test
    public void TC10() throws InterruptedException{
        TestLauncher test = new TestLauncher();
        test.setNameoftest("_Hit_Ghost");
        test.LenghtOfMap(12,15);
        MultiLevelGame game = test.makeGame();
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        game.start();
        move(game,Direction.EAST,8);
        assertEquals(false,player.isAlive());
    }
    @DisplayName("TC11:when pacman move and collision Blinky")
    @Test
    public void TC11() throws InterruptedException{
        TestLauncher test = new TestLauncher();
        test.setNameoftest("_Hit_Ghost");
        test.LenghtOfMap(13,15);
        MultiLevelGame game = test.makeGame();
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        game.start();
        move(game,Direction.EAST,8);
        assertEquals(false,player.isAlive());
    }
    @DisplayName("TC12:when pacman move and collision Clyde")
    @Test
    public void TC12() throws InterruptedException{
        TestLauncher test = new TestLauncher();
        test.setNameoftest("_Hit_Ghost");
        test.LenghtOfMap(14,15);
        MultiLevelGame game = test.makeGame();
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        game.start();
        move(game,Direction.EAST,8);
        assertEquals(false,player.isAlive());
    }
    @DisplayName("TC13:when pacman move and collision Pinky")
    @Test
    public void TC13() throws InterruptedException{
        TestLauncher test = new TestLauncher();
        test.setNameoftest("_Hit_Ghost");
        test.LenghtOfMap(15,15);
        MultiLevelGame game = test.makeGame();
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        game.start();
        move(game,Direction.EAST,8);
        assertEquals(false,player.isAlive());
    }
    @DisplayName("TC14:Check Stage")
    @Test
    public void TC14() throws InterruptedException{
        ArrayList<Integer> checkstage = new ArrayList<Integer>();
        TestLauncher test = new TestLauncher();
        test.LenghtOfMap(7,11);
        test.setNameoftest("_Without_Ghost");
        test.launch();
        MultiLevelGame game = test.getGame();
        Player player = game.getPlayers().get(0);
        game.start();
        checkstage.add(game.getLevelNumber());
        while(game.getLevelNumber() !=2) {
            if(game.getLevel().isInProgress() == false){
                checkstage.add(game.getLevelNumber());
                System.out.println(checkstage);
                game.start();
            }
            move(game,getRandomDirection(),1);
        }
        checkstage.add(game.getLevelNumber());
        for(int i=0 ; i< checkstage.size() ; i++){
            assertEquals(i,checkstage.get(i));
        }
    }
    @DisplayName("TC15:Show score")
    @Test
    public void TC15() throws InterruptedException{
        ArrayList<Integer> checkstage = new ArrayList<Integer>();
        TestLauncher test = new TestLauncher();
        test.LenghtOfMap(7,11);
        test.setNameoftest("_Without_Ghost");
        test.launch();
        MultiLevelGame game = test.getGame();
        game.start();
        Player player = game.getPlayers().get(0);
        int TotalRemaining = game.getLevel().remainingPellets();
        while(game.isInProgress() != false) {
            move(game,getRandomDirection(),1);
        }
        assertEquals(TotalRemaining*10,player.getScore());
    }
    @DisplayName("TC16:Start game Ghost,Pacman can move and time will start")
    @Test
    public void TC16() throws InterruptedException{
        final SoftAssertions soft = new SoftAssertions();
        ArrayList<String> before = new ArrayList<String>();
        ArrayList<String> after = new ArrayList<String>();
        TestLauncher test = new TestLauncher();
        test.LenghtOfMap(16,16);
        test.setNameoftest("_Walk");
        MultiLevelGame game = test.makeGame();
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        Inky inky = Navigation.findUnitInBoard(Inky.class,game.getLevel().getBoard());
        Pinky pinky = Navigation.findUnitInBoard(Pinky.class,game.getLevel().getBoard());
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class,game.getLevel().getBoard());
        Blinky blinky = Navigation.findUnitInBoard(Blinky.class,game.getLevel().getBoard());
        before.add(inky.getSquare().toString());
        before.add(pinky.getSquare().toString());
        before.add((clyde.getSquare().toString()));
        before.add(blinky.getSquare().toString());
        before.add(player.getSquare().toString());
        before.add(String.valueOf(game.getTotalTime()));
        game.start();
        Thread.sleep(500);
        after.add(inky.getSquare().toString());
        after.add(pinky.getSquare().toString());
        after.add((clyde.getSquare().toString()));
        after.add(blinky.getSquare().toString());
        for(int i = 0; i<10;i++){
            move(game,getRandomDirection(),1);
        }
        after.add(player.getSquare().toString());
        game.stop();
        after.add(String.valueOf(game.getTotalTime()));
        for(int i = 0 ; i < 6 ; i++){
            assertNotSame(after.get(i),before.get(i));
        }
    }
    @DisplayName("TC17:Stop game Ghost,Pacman can't move and time will stop")
    @Test
    public void TC17() throws InterruptedException{
        ArrayList<String> before = new ArrayList<String>();
        ArrayList<String> after = new ArrayList<String>();
        TestLauncher test = new TestLauncher();
        test.LenghtOfMap(1,5);
        MultiLevelGame game = test.makeGame();
        test.launch();
        game = test.getGame();
        Player player = game.getPlayers().get(0);
        Inky inky = Navigation.findUnitInBoard(Inky.class,game.getLevel().getBoard());
        Pinky pinky = Navigation.findUnitInBoard(Pinky.class,game.getLevel().getBoard());
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class,game.getLevel().getBoard());
        Blinky blinky = Navigation.findUnitInBoard(Blinky.class,game.getLevel().getBoard());
        before.add(inky.getSquare().toString());
        before.add(pinky.getSquare().toString());
        before.add((clyde.getSquare().toString()));
        before.add(blinky.getSquare().toString());
        before.add(player.getSquare().toString());
        before.add(String.valueOf(game.getTotalTime()));
        Thread.sleep(500);
        after.add(inky.getSquare().toString());
        after.add(pinky.getSquare().toString());
        after.add((clyde.getSquare().toString()));
        after.add(blinky.getSquare().toString());
        for(int i = 0; i<10;i++){
            move(game,getRandomDirection(),1);
        }
        after.add(player.getSquare().toString());
        after.add(String.valueOf(game.getTotalTime()));
        for(int i = 0 ; i < 6 ; i++){
            assertEquals(after.get(i),before.get(i));
        }
    }
    @DisplayName("TC18:Restart")
    @Test
    public void TC18() throws InterruptedException {
        TestLauncher test = new TestLauncher();
        test.LenghtOfMap(7, 11);
        test.setNameoftest("_Without_Ghost");
        test.launch();
        MultiLevelGame game = test.getGame();
        Player player = game.getPlayers().get(0);
        game.start();
        while (game.getLevelNumber() != 2) {
            move(game,getRandomDirection(),1);
            game.start();
        }
        game.restart();
        int CheckLevel = game.getLevelNumber();
        assertEquals(0,CheckLevel);
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
