package UC001.Sprite;

import nl.tudelft.jpacman.sprite.Sprite;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.awt.Graphics;

import static org.mockito.Mockito.verify;

public class SpriteTest {

    @Mock
    private Graphics graphics;

    @Test
    void testDraw() {
        int x = 0;
        int y = 0;
        int width = 10;
        int height = 10;

        Sprite sprite = new MySprite();
        sprite.draw(graphics, x, y, width, height);

    }
}

