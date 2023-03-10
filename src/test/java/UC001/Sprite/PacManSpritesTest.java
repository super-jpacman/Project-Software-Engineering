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
    void testGetPacmanSprites() {
        Map<Direction, Sprite> pacmanSprites = sprites.getPacmanSprites();
        assertEquals(4, pacmanSprites.size());
    }

    @Test
    @DisplayName("TC02: function getPacManDeathAnimation")
    void testGetPacManDeathAnimation() {
        AnimatedSprite deathAnimation = sprites.getPacManDeathAnimation();
        assertNotNull(deathAnimation);
    }

    @Test
    @DisplayName("TC03: function getGhostSprite")
    void testGetGhostSprite() {
        Map<Direction, Sprite> ghostSprites = sprites.getGhostSprite(GhostColor.RED);
        assertNotNull(ghostSprites);
        assertEquals(4, ghostSprites.size());
    }

    @Test
    @DisplayName("TC04: function getWallSprite")
    void testGetWallSprite() {
        Sprite wallSprite = sprites.getWallSprite();
        assertNotNull(wallSprite);
    }

    @Test
    @DisplayName("TC05: function getGroundSprite")
    void testGetGroundSprite() {
        Sprite groundSprite = sprites.getGroundSprite();
        assertNotNull(groundSprite);
    }

    @Test
    @DisplayName("TC06: function getPelletSprite")
    void testGetPelletSprite() {
        Sprite pelletSprite = sprites.getPelletSprite();
        assertNotNull(pelletSprite);
    }
}

