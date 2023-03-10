package UC001.Sprite;


import nl.tudelft.jpacman.sprite.EmptySprite;
import nl.tudelft.jpacman.sprite.Sprite;
import nl.tudelft.jpacman.sprite.SpriteStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class EmptySpriteTest {
    private Sprite sprite;
    private SpriteStore store;

    private static final int SPRITE_SIZE = 64;
    @BeforeEach
    public void setUp() throws IOException {
        store = new SpriteStore();
        sprite = store.loadSprite("/TestSprite/64x64white.png");
    }
    @Test
    void testDraw() {
        // Create a graphics object and pass it to the empty sprite
        // draw method. The test will pass as long as the method does
        // not throw any exceptions.
        EmptySprite empty = new EmptySprite();
        assertDoesNotThrow(() -> {
            empty.draw(null, 0, 0, 0, 0);
        });
    }

    @Test
    void testSplit() {
        // Create an empty sprite and call the split method with some
        // arbitrary parameters. The result should be a new empty sprite.
        EmptySprite empty = new EmptySprite();
        Sprite result = empty.split(0, 0, 0, 0);
        assertTrue(result instanceof EmptySprite);
    }

    @Test
    void testGetWidth() {
        // Create an empty sprite and make sure the width is 0.
        EmptySprite empty = new EmptySprite();
        assertEquals(0, empty.getWidth());
    }

    @Test
    void testGetHeight() {
        // Create an empty sprite and make sure the height is 0.
        EmptySprite empty = new EmptySprite();
        assertEquals(0, empty.getHeight());
    }
    @DisplayName("TC08: function split instance of EmptySprite")
    @Test
    public void TC08() throws InterruptedException {
        Sprite split = sprite.split(10, 10, 64, 10);
        assertThat(split).isInstanceOf(EmptySprite.class);
    }

}

