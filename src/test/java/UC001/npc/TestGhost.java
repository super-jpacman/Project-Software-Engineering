package UC001.npc;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.sprite.Sprite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.mock;

public class TestGhost {
    private Ghost ghost;
    private Map<Direction, Sprite> sprites;

    @BeforeEach
    public void setup(){
        sprites = new HashMap<>();
        Sprite sprite = mock(Sprite.class);
        sprites.put(Direction.NORTH, sprite);
        sprites.put(Direction.SOUTH, sprite);
        sprites.put(Direction.EAST, sprite);
        sprites.put(Direction.WEST, sprite);
        ghost = new Ghost(sprites,100,500){
            @Override
            public Optional<Direction> nextAiMove() {
                return Optional.empty();
            }
        };
    }
    @Test
    public void getInterval(){
        System.out.println(ghost.getInterval());
    }

}
