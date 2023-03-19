package nl.tudelft.jpacman;

import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.points.PointCalculatorLoader;
import nl.tudelft.jpacman.ui.PacManUI;
import nl.tudelft.jpacman.ui.PacManUiBuilder;

import java.util.ArrayList;
import java.util.List;

public class TestMultiLevelLauncher extends MultiLevelLauncher{
    private static final int NUMBER_OF_LEVELS = 5;

    private String MapTest;
    private int StartStage;
    private int EndStage;
    private MultiLevelGame multiGame;
    public void setLengthOfMap(int Start,int End){
        StartStage = Start;
        EndStage = End;
    }

    public void setMapTest(String name){
        MapTest = name;
    }
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
        makeGame();
        setBuilder(new PacManUiBuilder().withDefaultButtons());
        addSinglePlayerKeys(getBuilder());
        setPacManUI(getBuilder().build(getGame()));
//        System.out.println("1111"+getPacManUI());
        multiGame.setPacManUI(getPacManUI().MainMenuUI());
        getPacManUI().start();

    }

    public void Ranking_lunch() {
        makeGame();
        setBuilder(new PacManUiBuilder().withDefaultButtons());
        addSinglePlayerKeys(getBuilder());
        setPacManUI(getBuilder().build(getGame()));
        System.out.println("💥💥💥💥💥💥Ranking_lunch💥💥💥💥💥💥");
        getPacManUI().setGame(getGame());
        multiGame.setPacManUI(getPacManUI());
        getPacManUI().start();

    }
    public void selectMap(int i){}

    @Override
    public MultiLevelGame makeGame() {
        try{
            Player player = getPlayerFactory().createPacMan();
            List<Level> levels = new ArrayList<>();
            for (int i = StartStage; i < EndStage+1; i++) {
                String _INDEX_MAP_ = String.valueOf(i);
                levels.add(makeLevel(_INDEX_MAP_+MapTest));
            }

            Level level0 = makeLevel("1");
            System.out.println("sss:" +getPacManUI());
            multiGame = new MultiLevelGame(player, levels, loadPointCalculator(),getPacManUI());


        } finally {
        }

        return multiGame;
    }

    private PointCalculator loadPointCalculator() {
        return new PointCalculatorLoader().load();
    }
}
