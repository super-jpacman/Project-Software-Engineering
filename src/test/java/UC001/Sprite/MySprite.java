package UC001.Sprite;

import nl.tudelft.jpacman.sprite.Sprite;

import java.awt.*;

public class MySprite implements Sprite {
    @Override
    public void draw(Graphics graphics, int x, int y, int width, int height) {
    }

    @Override
    public Sprite split(int x, int y, int width, int height) {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
