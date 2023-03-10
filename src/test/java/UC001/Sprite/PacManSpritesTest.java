package UC001.Sprite;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.npc.ghost.GhostColor;
import nl.tudelft.jpacman.sprite.AnimatedSprite;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.sprite.Sprite;

@DisplayName("PacManSprites")
class PacManSpritesTest {

    private PacManSprites sprites;

    @BeforeEach
    void setUp() {
        sprites = new PacManSprites();
    }

    @Test
    @DisplayName("TC01: function getPacmanSprites")
    public void TC01() {
        Map<Direction, Sprite> pacmanSprites = sprites.getPacmanSprites();
        assertEquals(4, pacmanSprites.size());
    }

    @Test
    @DisplayName("TC02: function getPacManDeathAnimation")
    public void TC02() {
        AnimatedSprite deathAnimation = sprites.getPacManDeathAnimation();
        assertNotNull(deathAnimation);
        assertEquals(16, deathAnimation.getWidth());

    }

    @Test
    @DisplayName("TC03: function getGhostSprite")
    public void TC03() {
        Map<Direction, Sprite> ghostSprites = sprites.getGhostSprite(GhostColor.RED);
        assertNotNull(ghostSprites);
        assertEquals(4, ghostSprites.size());
    }

    @Test
    @DisplayName("TC04: function getWallSprite")
    public void TC04() {
        Sprite wallSprite = sprites.getWallSprite();
        assertNotNull(wallSprite);
    }

    @Test
    @DisplayName("TC05: function getGroundSprite")
    public void TC05() {
        Sprite groundSprite = sprites.getGroundSprite();
        assertNotNull(groundSprite);
    }
    @Test
    @DisplayName("TC06: function getPelletSprite")
    public void TC06() {
        Sprite pelletSprite = sprites.getPelletSprite();
        assertNotNull(pelletSprite);
    }
}

