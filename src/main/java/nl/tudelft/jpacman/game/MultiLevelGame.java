package nl.tudelft.jpacman.game;

import com.google.common.collect.ImmutableList;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.MultiLevelLauncher;

import java.util.ArrayList;
import java.util.List;


public class MultiLevelGame extends Game {
    
    private final Player player;
    private final List<Level> levels;
    private final List<Level> levels_tmp;
    private final List<Level> levels_tmp1;
    private final Object progressLock = new Object();

    private Level level;
    private boolean inProgress;
    private int levelNumber = 0;
    private int count = 0;

    public MultiLevelGame(Player player, List<Level> levels, List<Level> levels_tmp, List<Level> levels_tmp1, PointCalculator pointCalculator) {
        super(pointCalculator);

        assert player != null;
        assert levels != null;
        assert !levels.isEmpty();
    
        this.player = player;
        this.levels = levels;
        this.levels_tmp = levels_tmp;
        this.levels_tmp1 = levels_tmp1;
        
        this.level = levels.get(0);
        this.level.registerPlayer(player);
        this.inProgress = false;
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

            if (getLevel().isAnyPlayerAlive() == false && getLevel().remainingPellets() > 0) {
                System.out.println("Test Die");


/*                    levels.clear();
                    List<Level> levels_tmp1 = new ArrayList<>(levels_tmp);
                    List<Level> levels_tmp2 = new ArrayList<>(levels_tmp1);
                    levels.addAll(levels_tmp1);
                    levels_tmp1.clear();
                    levels_tmp1.addAll(levels_tmp2);
                    level = levels.get(0);
                }

                else {
                    levels_tmp.clear();
                    List<Level> levels_tmp3 = new ArrayList<>(levels);
                    levels_tmp.addAll(levels_tmp3);
                    level = levels.get(0);
                }*/
                levels.clear();
                List<Level> levels_tmp1 = new ArrayList<>(levels_tmp);
                List<Level> levels_tmp2 = new ArrayList<>(levels_tmp1);
                levels.addAll(levels_tmp1);
                levels_tmp1.clear();
                levels_tmp1.addAll(levels_tmp2);
                level = levels.get(0);

                player.setAlive(true);
                level.registerPlayer(player);
                inProgress = true;
                getLevel().addObserver(this);
                getLevel().start();
                count++;
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
