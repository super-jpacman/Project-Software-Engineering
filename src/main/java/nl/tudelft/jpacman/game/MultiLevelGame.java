package nl.tudelft.jpacman.game;

import com.google.common.collect.ImmutableList;
import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.MultiLevelLauncher;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.ui.GameEnd;
import nl.tudelft.jpacman.ui.PacManUI;
import nl.tudelft.jpacman.ui.CasualEnding;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class MultiLevelGame extends Game {
    StopWatch stopWatch = new StopWatch();
    private int totalScore=0;
    private double totalTime=0;
    private PlayerFactory PF;

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
private MultiLevelLauncher multiLevelLauncher;
    private GameEnd GE;
    private final Player player;

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    private List<Level> levels;
    private final Object progressLock = new Object();
    private PacManUI PM;
    private Level level;
    private boolean inProgress;
    private int levelNumber = 0;
    private JPanel temp;
    public int getStartStage() {
        return StartStage;
    }

    public void setStartStage(int startStage) {
        StartStage = startStage;
    }

    private int StartStage = 0;

    public void setPacManUI(PacManUI PM){
        this.PM = PM;
    }

    public MultiLevelGame(Player player, List<Level> levels, PointCalculator pointCalculator, PacManUI PM,PlayerFactory PF,MultiLevelLauncher multiLevelLauncher) {

        super(pointCalculator);
        System.out.println("💰💰💰💰💰💰💰multiLevelLauncher💰💰💰💰💰💰💰");
        System.out.println("getPlayerFactory : " +PF);
        System.out.println("MUL LV : " +multiLevelLauncher);
        this.PM = PM;

        this.PF = PF;
        this.multiLevelLauncher=multiLevelLauncher;

        assert player != null;
        assert levels != null;
        assert !levels.isEmpty();

        this.player = player;
        this.levels = levels;
        System.out.println("💰💰💰💰💰💰💰multiLevelLauncher💰💰💰💰💰💰💰");
        System.out.println("getPlayerFactory : " +PF);
        System.out.println("MUL LV : " +multiLevelLauncher);

        System.out.println("💰💰💰💰💰💰💰💰💰💰💰💰💰💰💰💰💰💰💰💰💰💰💰💰");
        this.level = levels.get(StartStage);
        this.level.registerPlayer(player);
        this.inProgress = false;

    }
    @Override
    public void levelWon() {

        stop();
        if (Launcher.GAME_MODE_NOW=="CASUAL"){
            restart();
            Launcher.GAME_MODE_NOW="";
            PM.GAMAE_CASUAL();
        }else{
            if(levelNumber>=4){
                Player p = getPlayers().get(0);
                GE = new GameEnd("You Won !!",p.getScore(),getTotalTime(),PM);
            }else{
                start();
            }
//        getLevel().stop();
        }

    }
    @Override
    public void restart() {



        if (GE!=null){
            GE.setVisible(false);
            GE=null;
        }
        stop();

        if(Launcher.GAME_MODE_NOW=="RANK"){
            System.out.println("RANKING RESTART");
            player.setScore(0);
            setTotalTime(0);
            player.setAlive(true);

            List<Level> levels_ = new ArrayList<>();
            for (int i = 1; i < 5+1; i++) {
                Launcher.GAME_THEME_NOW=i;
                Launcher.setTheme();
                String _INDEX_MAP_ = String.valueOf(i);
                levels_.add(makeLevel(_INDEX_MAP_));

            }
            levelNumber = 0;
            player.setMap(1);
            levels.clear();
            levels.addAll(levels_);
            level = levels.get(0);
            level.registerPlayer(player);
            inProgress = false;
            getLevel().addObserver(this);

            getLevel().stop();

            PM.PacManUI_PLAY_RANK(this);
        }else if(Launcher.GAME_MODE_NOW=="CASUAL"){
            System.out.println("CASUAL RESTART");
            player.setScore(0);
            setTotalTime(0);
            player.setAlive(true);
            List<Level> levels_ = new ArrayList<>();
            for (int i = 1; i < 5+1; i++) {
                Launcher.GAME_THEME_NOW=i;
                Launcher.setTheme();
                String _INDEX_MAP_ = String.valueOf(i);
                levels_.add(makeLevel(_INDEX_MAP_));

            }
            levelNumber = player.getMap();
            player.setMap(levelNumber);
            levels.clear();
            System.out.println(levelNumber);
            levels.addAll(levels_);
            level = levels.get(0);
            level.registerPlayer(player);
            inProgress = false;

            getLevel().addObserver(this);
            getLevel().stop();
            PM.PLAY_AT_MAP(player.getMap());
        }


    }
    @Override
    public void start() {
        synchronized (progressLock) {
            // Already running
            System.out.println("🖤🖤🖤🖤🖤🖤🖤");
            if (isInProgress()) {
                System.out.println("🖤🖤🖤🖤🖤🖤🖤");
                return;
            }
            // First start and unpause
            if (getLevel().isAnyPlayerAlive() && getLevel().remainingPellets() > 0) {
                inProgress = true;
                getLevel().addObserver(this);
                System.out.println("==============start=================");
                System.out.println("GAME: "+this);
                System.out.println("isInProgress: "+isInProgress());
                System.out.println("getPlayers: "+getPlayers());
                System.out.println("isAlive: "+getPlayers().get(0).isAlive());
                System.out.println("getMap: "+getPlayers().get(0).getMap());
                System.out.println("isAnyPlayerAlive: "+getLevel().isAnyPlayerAlive());
                System.out.println("isInProgress: "+getLevel().isInProgress());
                System.out.println("=================================\n");
                getLevel().start();
//                System.out.println("Start Pressed");
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
                System.out.println("⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽");
                System.out.println(levelNumber);

                if(Launcher.GAME_MODE_NOW=="CASUAL"){
                    PM.GAMAE_CASUAL();
                }else{
                    selectMap(levelNumber);
                }


//                player.setMap(levelNumber+1);
//                level = levels.get(levelNumber);
//                level.registerPlayer(player);
//                inProgress = false;
//                getLevel().addObserver(this);
//                getLevel().stop();
            }
        }
    }
    @Override
    public void rere(){
        System.out.println("✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅");
        player.setScore(0);
        setTotalTime(0);
        player.setAlive(true);

        List<Level> levels_ = new ArrayList<>();
        for (int i = 1; i < 5+1; i++) {
            Launcher.GAME_THEME_NOW=i;
            Launcher.setTheme();
            String _INDEX_MAP_ = String.valueOf(i);
            levels_.add(makeLevel(_INDEX_MAP_));

        }
        levelNumber = 0;
        player.setMap(1);
        levels.clear();
        levels.addAll(levels_);
        level = levels.get(0);
        level.registerPlayer(player);
        inProgress = false;
        getLevel().addObserver(this);

        getLevel().stop();
    }
    @Override
    public void selectMap(int i) {
        if (isInProgress()) {
            return;
        }
        // First start and unpause


        player.setMap(i+1);
        level = levels.get(i);
        level.registerPlayer(player);
        System.out.println(level);
        inProgress = false;
        getLevel().setInProgress(false);
        System.out.println("🎀🎀isInProgress: "+getLevel().isInProgress());
        getLevel().addObserver(this);
        getLevel().updateObservers();
        System.out.println("🎀🎀isInProgress: "+getLevel().isInProgress());
        System.out.println("==============selectMap=================");
        System.out.println("GAME: "+this);
        System.out.println("MAP: "+player.getMap());
        System.out.println("isInProgress: "+isInProgress());
        System.out.println("getPlayers: "+getPlayers());
        System.out.println("isAlive: "+getPlayers().get(0).isAlive());
        System.out.println("getMap: "+getPlayers().get(0).getMap());
        System.out.println("isAnyPlayerAlive: "+getLevel().isAnyPlayerAlive());
        System.out.println("isInProgress: "+getLevel().isInProgress());
        System.out.println("=================================\n");
    }
    public void levelLost() {
        System.out.println("🎁🎁🎁🎁🎁🎁🎁🎁🎁🎁🎁");
        stop();
        if (getTotalTime()>60.0){
            int minutes = (int)getTotalTime()/60;
            int remainingSec = (int)getTotalTime()%60;
            System.out.format("Your time is: %d min %d second",minutes,remainingSec);
        }else {
            System.out.println(getTotalTime());
        }

        Player p = getPlayers().get(0);

        if (Launcher.GAME_MODE_NOW=="CASUAL"){
            temp = PM.getBoardPanel();
            PM.setBoardPanel(new CasualEnding("TEST",999,60,PM));
            System.out.println(temp);
            System.out.println(temp);
            PM.getGame().restart();
            PM.getGame().stop();
            PM.PacManUI_LOST("YOU LOSE",999,60);
            PM.getBoardPanel().revalidate();
            PM.getBoardPanel().repaint();
            System.out.println(PM.getBoardPanel());
//        GE = new GameEnd("You Lose !!",p.getScore(),getTotalTime(),PM);
//            player.setMap(player.getMap());
        }
        else{
            temp = PM.getBoardPanel();
            PM.setBoardPanel(new CasualEnding("TEST",999,60,PM));
            PM.getGame().restart();
            PM.getGame().stop();
            PM.PacManUI_LOST("YOU LOSE",999,60);
            PM.getBoardPanel().revalidate();
            PM.getBoardPanel().repaint();
            System.out.println(PM.getBoardPanel());
            player.setMap(1);
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
