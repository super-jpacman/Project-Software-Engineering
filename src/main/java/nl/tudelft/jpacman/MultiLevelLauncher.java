package nl.tudelft.jpacman;

import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.game.StopWatch;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.points.PointCalculatorLoader;
import nl.tudelft.jpacman.ui.PacManUI;
import nl.tudelft.jpacman.ui.PacManUiBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class MultiLevelLauncher extends Launcher {

    private static final int NUMBER_OF_LEVELS = 5;

    private Player player;
    private MultiLevelGame multiGame;
    @Override
    public PlayerFactory getPlayerFactory() {
        return super.getPlayerFactory();
    }

    private PlayerFactory PF;

    @Override
    public MultiLevelGame getGame() {
        return multiGame;
    }
    @Override
    public PacManUI getPacManUI() {
//        System.out.println(super.getPacManUI());
        return super.getPacManUI();
    }
    @Override
    public void setPacManUI(PacManUI pacManUI) {
        super.setPacManUI(pacManUI);
    }
    @Override
    public PacManUiBuilder getBuilder() {
        return super.getBuilder();
    }
    @Override
    public void setBuilder(PacManUiBuilder builder) {
        super.setBuilder(builder);
    }

    @Override
    public void launch() {
        Launcher.GAME_THEME_NOW=1;
        makeGame();
        setBuilder(new PacManUiBuilder().withDefaultButtons());
        addSinglePlayerKeys(getBuilder());
        setPacManUI(getBuilder().build(getGame()));
        multiGame.setPacManUI(getPacManUI().MainMenuUI());
        getPacManUI().start();

    }

    public void rere(int i) {
        System.out.println("🎎🎎🎎🎎🎎🎎🎎multiLevelLauncher🎎🎎🎎🎎🎎🎎🎎");
        Launcher.GAME_THEME_NOW=2;
        makeGame();
        setBuilder(new PacManUiBuilder().withDefaultButtons());
        addSinglePlayerKeys(getBuilder());
        setPacManUI(getBuilder().build(getGame()));
        multiGame.setPacManUI(getPacManUI().MainMenuUI());

    }
    public void selectMap(int i) throws InterruptedException {}

    @Override
    public MultiLevelGame makeGame() {

        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("ghgfhghfghf");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        createPac();
        try{
            List<Level> levels = new ArrayList<>();
            for (int i = 1; i < NUMBER_OF_LEVELS+1; i++) {
                Launcher.GAME_THEME_NOW=i;
                Launcher.setTheme();
                String _INDEX_MAP_ = String.valueOf(i);
                levels.add(makeLevel(_INDEX_MAP_));
            }

            Level level0 = makeLevel("1");
            System.out.println("🧶🧶🧶🧶🧶🧶🧶🧶🧶🧶🧶🧶🧶");
            System.out.println("getPlayerFactory : " +getPlayerFactory());
            System.out.println("MUL LV : " +this);

            multiGame = new MultiLevelGame(player, levels, loadPointCalculator(),getPacManUI(),getPlayerFactory(),this);


        } finally {
        }

        return multiGame;
    }

//    public void createPac2(){
//        Launcher.setTheme2();
//        PF = getPlayerFactory();
//        player = PF.createPacMan();
//    }

    public void createPac(){
        System.out.println("THEME ::::: "+Launcher.GAME_THEME_NOW);
        System.out.println("PlayerFactory ::::: "+PF);
        System.out.println("player ::::: "+player);
        Launcher.GAME_THEME_NOW =1;
        Launcher.setTheme();
        PF = getPlayerFactory();
        player = PF.createPacMan();
    }
    private PointCalculator loadPointCalculator() {
        return new PointCalculatorLoader().load();
    }
}
