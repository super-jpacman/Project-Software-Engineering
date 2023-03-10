package UC001.Ghost;

import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.npc.ghost.*;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.sprite.Sprite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GhostFactoryTest {

    private GhostFactory ghostFactory;
    private PacManSprites spriteStore;

    @BeforeEach
    public void setUp() {
        spriteStore = new PacManSprites();
        ghostFactory = new GhostFactory(spriteStore);
    }

    @Test
    public void testCreateBlinky() {
        Ghost blinky = ghostFactory.createBlinky();
        assertNotNull(blinky);
        System.out.println(spriteStore.getGhostSprite(GhostColor.RED));
        //assertEquals(spriteStore.getGhostSprite(GhostColor.RED), blinky.getSprite());
       // assertTrue(blinky instanceof Blinky);
    }

    /*@Test
    public void testCreatePinky() {
        Ghost pinky = ghostFactory.createPinky();
        assertNotNull(pinky);
        assertEquals(spriteStore.getGhostSprite(GhostColor.PINK), pinky.getSprite());
        assertTrue(pinky instanceof Pinky);
    }

    @Test
    public void testCreateInky() {
        Ghost inky = ghostFactory.createInky();
        assertNotNull(inky);
        assertEquals(spriteStore.getGhostSprite(GhostColor.CYAN), inky.getSprite());
        assertTrue(inky instanceof Inky);
    }

    @Test
    public void testCreateClyde() {
        Ghost clyde = ghostFactory.createClyde();
        assertNotNull(clyde);
        assertEquals(spriteStore.getGhostSprite(GhostColor.ORANGE), clyde.getSprite());
        assertTrue(clyde instanceof Clyde);
    }*/
}
