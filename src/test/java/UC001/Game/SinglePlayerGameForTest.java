package UC001.Game;

import com.google.common.collect.ImmutableList;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;

import java.util.List;

/**
 * A game with one player and a single level.
 *
 * @author Jeroen Roosen
 */
public class SinglePlayerGameForTest extends Game {

    /**
     * The player of this game.
     */
    private final Player player;

    /**
     * The level of this game.
     */
    private final Level level;

    /**
     * Create a new single player game for the provided level and player.
     *
     * @param player
     *            The player.
     * @param level
     *            The level.
     * @param pointCalculator
     *            The way to calculate points upon collisions.
     */
    public SinglePlayerGameForTest(Player player, Level level, PointCalculator pointCalculator) {
        super(pointCalculator);

        assert player != null;
        assert level != null;

        this.player = player;
        this.level = level;
        this.level.registerPlayer(player);
    }

    @Override
    public List<Player> getPlayers() {
        return ImmutableList.of(player);
    }

    @Override
    public Level getLevel() {
        return level;
    }
}
