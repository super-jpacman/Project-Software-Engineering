package UC001;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import nl.tudelft.jpacman.sprite.AnimatedSprite;
import nl.tudelft.jpacman.sprite.EmptySprite;
import nl.tudelft.jpacman.sprite.Sprite;
import nl.tudelft.jpacman.sprite.SpriteStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Verifies the loading of sprites.
 *
 * @author Jeroen Roosen
 */
@SuppressWarnings("magicnumber")
public class TS006 {

    private Sprite sprite;
    private SpriteStore store;

    private static final int SPRITE_SIZE = 64;
    @BeforeEach
    public void setUp() throws IOException {
        store = new SpriteStore();
        sprite = store.loadSprite("/TestSprite/64x64white.png");
    }
    @DisplayName("TC01: function getWidth in Sprite")
    @Test
    public void TC01() throws InterruptedException {
        assertEquals(SPRITE_SIZE,sprite.getWidth());
    }

    @DisplayName("TC02: function getHeight in Sprite")
    @Test
    public void TC02() throws InterruptedException {
        assertEquals(SPRITE_SIZE,sprite.getHeight());
    }
    @DisplayName("TC03: function createAnimatedSprite: animated sprite cut width 64/(frame=4) = 16")
    @Test
    public void TC03() throws InterruptedException {
        AnimatedSprite animation = store.createAnimatedSprite(sprite, 4, 0,
            false);
        assertEquals(16,animation.getWidth());
    }

    /**
     * Verifies that an animated sprite is correctly cut from its base image.
     */
    @DisplayName("TC04: function createAnimatedSprite: height unchanged because animated sprite cut width ")
    @Test
    public void TC04() throws InterruptedException {
        AnimatedSprite animation = store.createAnimatedSprite(sprite, 4, 0,
            false);
        assertEquals(64,animation.getHeight());
    }
    @DisplayName("TC05: function split: getWidth")
    @Test
    public void TC05() throws InterruptedException {
        Sprite split = sprite.split(10, 11, 12, 13);
        assertEquals(12,split.getWidth());
    }
    @DisplayName("TC06: function split: getHeight")
    @Test
    public void TC06() throws InterruptedException {
        Sprite split = sprite.split(10, 11, 12, 13);
        assertEquals(13,split.getHeight());
    }

    @DisplayName("TC08: function split instance of EmptySprite")
    @Test
    public void TC08() throws InterruptedException {
        Sprite split = sprite.split(10, 10, 64, 10);
        assertThat(split).isInstanceOf(EmptySprite.class);
    }
}

