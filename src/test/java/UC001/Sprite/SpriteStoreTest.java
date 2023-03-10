package UC001.Sprite;

import nl.tudelft.jpacman.sprite.AnimatedSprite;
import nl.tudelft.jpacman.sprite.Sprite;
import nl.tudelft.jpacman.sprite.SpriteStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class SpriteStoreTest {

    private SpriteStore spriteStore;
    private Sprite sprite;

    @BeforeEach
    public void setUp() throws IOException{
        spriteStore = new SpriteStore();
        sprite = spriteStore.loadSprite("/TestSprite/pacmantest.png");

    }

    @Test
    public void loadExistingSprite() throws IOException {
        // Load an existing sprite and verify that it is not null
        assertNotNull(sprite);
    }

    @Test
    public void loadNonExistingSprite() {
        assertThrows(IOException.class, () -> spriteStore.loadSprite("/sprites/non-existing.png"));
    }
    @DisplayName("TC03: function createAnimatedSprite: animated sprite cut width 64/(frame=4) = 16")
    @Test
    public void TC03() throws InterruptedException {
        AnimatedSprite animation = spriteStore.createAnimatedSprite(sprite, 4, 0,
            false);
        assertEquals(16,animation.getWidth());
    }

    /**
     * Verifies that an animated sprite is correctly cut from its base image.
     */
    @DisplayName("TC04: function createAnimatedSprite: height unchanged because animated sprite cut width ")
    @Test
    public void TC04() throws InterruptedException {
        AnimatedSprite animation = spriteStore.createAnimatedSprite(sprite, 4, 0,
            false);
        assertEquals(64,animation.getHeight());
    }

}

