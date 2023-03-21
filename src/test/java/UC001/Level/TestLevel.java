package UC001.Level;

import nl.tudelft.jpacman.TestLauncher;
import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.CollisionMap;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.npc.Ghost;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.mockito.Mockito.*;

public class TestLevel {
    Board board = mock(Board.class);
    Level level;
    List<Ghost> ghosts;
    List<Square> squares;
    Square square = mock(Square.class);
    Square square1 = mock(Square.class);
    Ghost ghost = mock(Ghost.class);
    Ghost ghost1 = mock(Ghost.class);
    Level.LevelObserver levelObserver;
    Player player = mock(Player.class);


    CollisionMap collisions = mock(CollisionMap.class);
    @BeforeEach
    public void setup(){
        ghosts = new ArrayList<>();
        squares = new ArrayList<>();
        ghosts.add(ghost);
        ghosts.add(ghost1);
        squares.add(square);
        squares.add(square1);
        level = new Level(board,ghosts,squares,collisions);
        levelObserver = mock(Level.LevelObserver.class);
        level.addObserver(levelObserver);
    }
    @Test
    void noStart() {
        assertEquals(false,level.isInProgress());
    }

    @Test
    void stop() {
        level.stop();
        assertEquals(false,level.isInProgress());
    }

    @Test
    void start() {
        level.start();
        assertEquals(true,level.isInProgress());
    }

    @Test
    void startStop() {
        level.start();
        assertEquals(true,level.isInProgress());
        level.stop();
        assertEquals(false,level.isInProgress());
    }
    @Test
    void addPlayer(){
        level.registerPlayer(player);
        verify(player).occupy(square);//มีการเรียกใช้ player.occupyหรือไม่
    }
    @Test
    void add2Player(){
        Player player1 = mock(Player.class);
        level.registerPlayer(player);
        level.registerPlayer(player1);
        verify(player1).occupy(square1);//มีการเรียกใช้ player.occupyหรือไม่
    }
    @Test
    void add3Player(){
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        level.registerPlayer(player);
        level.registerPlayer(player1);
        level.registerPlayer(player2);
        verify(player2,never()).occupy(square1);//ไม่มีการเรียกใช้ occupy
    }
}
