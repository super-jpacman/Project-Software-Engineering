package UC001.Level;

import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.level.CollisionMap;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.npc.ghost.Inky;
import nl.tudelft.jpacman.npc.ghost.Pinky;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;

public class TestLevel {
    Board board = mock(Board.class);
    Level level;
    List<Ghost> ghosts;
    List<Square> squares;
    Square square = mock(Square.class);
    Square square1 = mock(Square.class);
    Inky inky = mock(Inky.class);
    Pinky pinky = mock(Pinky.class);

    CollisionMap collisions = mock(CollisionMap.class);
    @BeforeEach
    public void setup(){
        ghosts.add(inky);
        ghosts.add(pinky);
        squares.add(square);
        squares.add(square1);
        level = new Level(board,ghosts,squares,collisions);
    }

}
