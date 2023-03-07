package nl.tudelft.jpacman.game;

import com.google.common.collect.ImmutableList;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;

import java.util.List;


public class MultiLevelGame extends Game {
    
    private final Player player;
    private List<Level> levels;
    private final Level level_tmp;
    private Level level_tmp0;
    private final Object progressLock = new Object();

    private Level level;
    private boolean inProgress;
    private int levelNumber = 0;
    private int count = 0;

    public MultiLevelGame(Player player, List<Level> levels,Level level0 , PointCalculator pointCalculator) {
        super(pointCalculator);

        assert player != null;
        assert levels != null;
        assert !levels.isEmpty();
    
        this.player = player;
        this.levels = levels;

        this.level = levels.get(0);
        level_tmp = level0;
        this.level.registerPlayer(player);
        this.inProgress = false;

    }

    public void setLevel(Level level0){
        this.level_tmp0 = level0;
        this.level = level0;
    }
    @Override
    public void start() {

        synchronized (progressLock) {
            // Already running
            if (isInProgress()) {
                return;
            }
            
            // First start and unpause
            if (getLevel().isAnyPlayerAlive() && getLevel().remainingPellets() > 0) {
                inProgress = true;
                getLevel().addObserver(this);
                getLevel().start();
                return;
            }

            if (getLevel().isAnyPlayerAlive() == false) {
                player.setAlive(true);
                level = makeLevel("1");
                level.registerPlayer(player);
                inProgress = true;
                getLevel().addObserver(this);
                getLevel().start();

            }


            // Continue to next level
            if (levelNumber < levels.size() - 1
                && getLevel().remainingPellets() == 0
                && getLevel().isAnyPlayerAlive())
            {
                levelNumber++;
                level = levels.get(levelNumber);
                level.registerPlayer(player);
                inProgress = true;
                getLevel().addObserver(this);
                getLevel().start();
            }
        }
    }

    @Override
    public void stop() {
        synchronized (progressLock) {
            // Already paused or ended
            if (!isInProgress()) {
                return;
            }
            
            inProgress = false;
            getLevel().stop();
        }
    }
    
    @Override
    public boolean isInProgress() {
        return inProgress;
    }
    
    @Override
    public List<Player> getPlayers() {
        return ImmutableList.of(player);
    }
    
    @Override
    public Level getLevel() {
        return level;
    }

    public int getLevelNumber() {
        return this.levelNumber;
    }
}
