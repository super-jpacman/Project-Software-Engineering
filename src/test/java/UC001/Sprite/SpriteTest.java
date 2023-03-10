package UC001.Sprite;

import nl.tudelft.jpacman.sprite.EmptySprite;
import nl.tudelft.jpacman.sprite.Sprite;
import nl.tudelft.jpacman.sprite.SpriteStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.awt.Graphics;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class SpriteTest {

    @Mock
    private Graphics graphics;
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

    @DisplayName("TC03: function draw")
    @Test
    void testDraw() {
        int x = 0;
        int y = 0;
        int width = 10;
        int height = 10;

        Sprite sprite = mock(Sprite.class);
        verify(sprite).draw(graphics, x, y, width, height);

    }
    @DisplayName("TC04: function split: getWidth")
    @Test
    public void TC04() throws InterruptedException {
        Sprite split = sprite.split(10, 11, 12, 13);
        assertEquals(12,split.getWidth());
    }
    @DisplayName("TC05: function split: getHeight")
    @Test
    public void TC05() throws InterruptedException {
        Sprite split = sprite.split(10, 11, 12, 13);
        assertEquals(13,split.getHeight());
    }
    @DisplayName("TC06: function split: getHeight")
    @Test
    public void TC06() throws InterruptedException {
        Sprite split = sprite.split(10, 11, 12, 13);
    }

}

