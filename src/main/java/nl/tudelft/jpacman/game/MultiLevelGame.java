package nl.tudelft.jpacman.game;

import com.google.common.collect.ImmutableList;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.ui.GameEnd;

import java.util.ArrayList;
import java.util.List;


public class MultiLevelGame extends Game {
    StopWatch stopWatch = new StopWatch();
    private int totalScore=0;
    private double totalTime=0;

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }


    private final Player player;
    private List<Level> levels;
    private final Object progressLock = new Object();

    private Level level;
    private boolean inProgress;
    private int levelNumber = 0;


    public MultiLevelGame(Player player, List<Level> levels, PointCalculator pointCalculator) {
        super(pointCalculator);

        assert player != null;
        assert levels != null;
        assert !levels.isEmpty();

        this.player = player;
        this.levels = levels;

        this.level = levels.get(0);
        this.level.registerPlayer(player);
        this.inProgress = false;

    }
    @Override
    public void levelWon() {

        stop();

        System.out.println("Game WON");

        if(levelNumber>5){
            new GameEnd("You Won !!",998);
        }else{
            start();
        }
//        getLevel().stop();
    }
    @Override
    public void restart() {
        player.setScore(0);
        setTotalTime(0);
        player.setAlive(true);
        List<Level> levels_ = new ArrayList<>();
        for (int i = 1; i < 5+1; i++) {
            String _INDEX_MAP_ = String.valueOf(i);
            levels_.add(makeLevel(_INDEX_MAP_));

        }
        levelNumber = 0;
        levels.clear();
        levels.addAll(levels_);
        level = levels.get(0);
        level.registerPlayer(player);
        inProgress = false;
        getLevel().addObserver(this);
        getLevel().stop();


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
                System.out.println("Start Pressed");
                stopWatch.startWatch();
                System.out.println(getTotalTime());
                return;
            }

            if (getLevel().isAnyPlayerAlive() == false) {


            }


            // Continue to next level
            if (levelNumber < levels.size() - 1
                && getLevel().remainingPellets() == 0
                && getLevel().isAnyPlayerAlive())
            {
                levelNumber++;
                level = levels.get(levelNumber);
                level.registerPlayer(player);
                inProgress = false;
                getLevel().addObserver(this);
                getLevel().stop();
            }
        }
    }
    public void levelLost() {
        System.out.println("you lostsss");
        if (getTotalTime()>60.0){
            int minutes = (int)getTotalTime()/60;
            int remainingSec = (int)getTotalTime()%60;
            System.out.format("Your time is: %d min %d second",minutes,remainingSec);
        }else {
            System.out.println(getTotalTime());
        }
        stop();
        new GameEnd("You Lose !!",998);
    }
    @Override
    public void stop() {
        synchronized (progressLock) {
            // Already paused or ended
            if (!isInProgress()) {
                return;
            }

            inProgress = false;
            stopWatch.stopWatch();
            long elapsedTime = stopWatch.getElapsedTime();
            double seconds = (double) elapsedTime / 1_000_000_000.0;
            //System.out.println("first Totaltime is: " + getTotalTime() + " seconds");
            setTotalTime(getTotalTime()+seconds);
            //System.out.println("Totaltime is: " + getTotalTime() + " seconds");
            //System.out.println("Stop Pressed" + seconds);
            //System.out.println("Elapsed time: " + getTotalTime() + " seconds");

            if (getTotalTime()>60.0){
                int minutes = (int)getTotalTime()/60;
                int remainingSec = (int)getTotalTime()%60;
                System.out.format("Your time is: %d min %d second",minutes,remainingSec);
            }else {
                System.out.println(getTotalTime());
            }
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
