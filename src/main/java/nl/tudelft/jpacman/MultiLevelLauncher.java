package nl.tudelft.jpacman;

import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.game.StopWatch;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.points.PointCalculatorLoader;

import java.util.ArrayList;
import java.util.List;


public class MultiLevelLauncher extends Launcher {

    private static final int NUMBER_OF_LEVELS = 5;

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
            for (int i = 1; i < NUMBER_OF_LEVELS+1; i++) {
                String _INDEX_MAP_ = String.valueOf(i);
                levels.add(makeLevel(_INDEX_MAP_));
            }
            List<Level> levels_tmp = new ArrayList<>();
            for (int i = 1; i < NUMBER_OF_LEVELS+1; i++) {
                String _INDEX_MAP_ = String.valueOf(i);
                levels_tmp.add(makeLevel(_INDEX_MAP_));
            }

            List<Level> levels_tmp1 = new ArrayList<>();
            for (int i = 1; i < NUMBER_OF_LEVELS+1; i++) {
                String _INDEX_MAP_ = String.valueOf(i);
                levels_tmp1.add(makeLevel(_INDEX_MAP_));
            }
            multiGame = new MultiLevelGame(player, levels, levels_tmp, levels_tmp1, loadPointCalculator());
        } finally {
            System.err.println("989997987");
        }

        

        return multiGame;
    }
    
    private PointCalculator loadPointCalculator() {
        return new PointCalculatorLoader().load();
    }
}
