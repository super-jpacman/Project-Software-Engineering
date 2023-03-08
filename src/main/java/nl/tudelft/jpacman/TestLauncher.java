package nl.tudelft.jpacman;

import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.points.PointCalculatorLoader;

import java.util.ArrayList;
import java.util.List;


public class TestLauncher extends Launcher {

    private static final int NUMBER_OF_LEVELS = 7+4;

    private MultiLevelGame multiGame;

    @Override
    public MultiLevelGame getGame() {
        return multiGame;
    }

    @Override
    public MultiLevelGame makeGame() {
        try{
            Player player = getPlayerFactory().createPacMan();
            List<Level> levels = new ArrayList<>();
            for (int i = 7; i < NUMBER_OF_LEVELS+1; i++) {
                String _INDEX_MAP_ = String.valueOf(i);
                levels.add(makeLevel(_INDEX_MAP_));
            }
            multiGame = new MultiLevelGame(player, levels, loadPointCalculator());
            
        } finally {
        }
        
        return multiGame;
    }
    private PointCalculator loadPointCalculator() {
        return new PointCalculatorLoader().load();
    }

}
