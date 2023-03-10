package UC001.Sprite;

import nl.tudelft.jpacman.sprite.AnimatedSprite;
import nl.tudelft.jpacman.sprite.Sprite;
import nl.tudelft.jpacman.sprite.SpriteStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimatedSpriteTest {
    private Sprite[] frames;
    private int delay;
    private boolean loop;
    private boolean isAnimating;
    private AnimatedSprite animatedSpritesprite;
    private Sprite sprite;
    private SpriteStore store;

    private static final int SPRITE_SIZE = 64;
    /*@BeforeEach
    public void setUp() throws IOException {
        BufferedImage[] images = new BufferedImage[3];
        images[0] = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
        images[1] = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
        images[2] = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
        // Create the animation sprite
        delay = 100;
        loop = true;
        isAnimating = true;
        animatedSpritesprite = new AnimatedSprite(frames, delay, loop, isAnimating);
    }
    @Test
    @DisplayName("Test that the current sprite is the first frame when created")
    void testCurrentSprite() {
        Sprite expected = frames[0];
        Sprite actual = animatedSpritesprite.currentSprite();
        assertEquals(expected, actual, "The current sprite should be the first frame");
    }
    @Test
    @DisplayName("Test that setting the animation to non-looping stops the animation at the last frame")
    void testNonLoopingAnimation() {
        animatedSpritesprite.setAnimating(true);
        animatedSpritesprite.restart();
        animatedSpritesprite.setAnimating(false);
        assertEquals(frames[frames.length - 1], animatedSpritesprite.currentSprite(), "The current sprite should be the last frame");
        animatedSpritesprite.setAnimating(true);
        animatedSpritesprite.update();
        assertEquals(frames[frames.length - 1], animatedSpritesprite.currentSprite(), "The current sprite should remain at the last frame");
    }
*/
}
