package nl.tudelft.jpacman.game;

import com.google.common.collect.ImmutableList;
import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.MultiLevelLauncher;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.ui.GameEnd;
import nl.tudelft.jpacman.ui.PacManUI;
import nl.tudelft.jpacman.ui.CasualEnding;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private Player player;
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

        this.PM = PM;
        this.PF = PF;
        this.multiLevelLauncher=multiLevelLauncher;

        assert player != null;
        assert levels != null;
        assert !levels.isEmpty();

        this.player = player;
        this.levels = levels;

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
        }

    }

    public void restartConfig(String condition){

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
        if (condition.equals("RANK")){
            player.setMap(1);
            levelNumber = 0;
            System.out.println("RANK");
        }else{
            levelNumber = player.getMap();
            player.setMap(levelNumber);
            System.out.println("CASUAL");
        }
        levels.clear();
        levels.addAll(levels_);
        level = levels.get(0);
        level.registerPlayer(player);
        inProgress = false;
        getLevel().addObserver(this);
        getLevel().stop();
    }
    @Override
    public void restart() {

        Launcher.InGame=false;
        if (GE!=null){
            GE.setVisible(false);
            GE=null;
        }
        stop();
        if(Launcher.GAME_MODE_NOW=="RANK"){
            restartConfig("RANK");
            PM.PacManUI_PLAY_RANK(this);

        }else if(Launcher.GAME_MODE_NOW=="CASUAL"){
            restartConfig("CASUAL");
            PM.PLAY_AT_MAP(player.getMap());
        }
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
                stopWatch.startWatch();
                return;
            }
            // Continue to next level
            if (levelNumber < levels.size() - 1
                && getLevel().remainingPellets() == 0
                && getLevel().isAnyPlayerAlive())
            {
                levelNumber++;
                if(Launcher.GAME_MODE_NOW=="CASUAL"){
                    PM.GAMAE_CASUAL();
                }else{
                    selectMap(levelNumber);
                }
            }
        }
    }
    @Override
    public void rere(){
        restartConfig("RANK");
    }
    @Override
    public void selectMap(int i) {
        if (isInProgress()) {
            return;
        }

        player.setMap(i+1);
        level = levels.get(i);
        level.registerPlayer(player);
        System.out.println(level);
        inProgress = false;
        getLevel().setInProgress(false);
        getLevel().addObserver(this);
        getLevel().updateObservers();
    }

    public void levelLostConfig(int point, double time,String condition){
        temp = PM.getBoardPanel();
        PM.getGame().restart();
        PM.getGame().stop();
        PM.PacManUI_LOST("YOU LOSE",point,time,condition);
        PM.getBoardPanel().revalidate();
        PM.getBoardPanel().repaint();
    }
    public void levelLost() {
        stop();
        Player p = getPlayers().get(0);
        int tmpPoint = p.getScore();
        double tmpTime = getTotalTime();

        if (Launcher.GAME_MODE_NOW=="CASUAL"){
            levelLostConfig(tmpPoint,tmpTime,"c");
        }else{
            levelLostConfig(tmpPoint,tmpTime,"r");
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
            setTotalTime(getTotalTime()+seconds);
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
    @Override
    public void setSkin_Pac(){
        this.player.setSprites(Launcher.SPRITE_STORE.getPacmanSprites());
    }
    public int getLevelNumber() {
        return this.levelNumber;
    }

}

