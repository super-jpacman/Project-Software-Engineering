package nl.tudelft.jpacman.ui;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.level.Player;

/**
 * A panel consisting of a column for each player, with the numbered players on
 * top and their respective scores underneath.
 *
 * @author Jeroen Roosen
 *
 */
public class ScorePanel extends JPanel {

    /**
     * Default serialisation ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The map of players and the labels their scores are on.
     */
    private final Map<Player, JLabel> scoreLabels;
    private final Map<Player, JLabel> mapLabels;

    /**
     * The default way in which the score is shown.
     */
    public static final ScoreFormatter DEFAULT_SCORE_FORMATTER =
        (Player player) -> String.format("Score: %3d     ", player.getScore());
    public static final ScoreFormatter DEFAULT_MAP_FORMATTER =
        (Player player) -> String.format("   Map : %d", player.getMap());
    /**
     * The way to format the score information.
     */
    private ScoreFormatter scoreFormatter = DEFAULT_SCORE_FORMATTER;
    private ScoreFormatter mapFormatter = DEFAULT_MAP_FORMATTER;
    private JLabel JMap;

    /**
     * Creates a new score panel with a column for each player.
     *
     * @param players
     *            The players to display the scores of.
     */
    public ScorePanel(List<Player> players) {
        super();
        assert players != null;
//        System.out.println("==========+= "+players.get(0).getMap());
        setLayout(new BorderLayout());
//        JMap = new JLabel("MAP " + String.valueOf(players.get(0).getMap()), JLabel.CENTER);
//        add(JMap);
//        for (int i = 1; i <= players.size(); i++) {
//
//            add(new JLabel("MAP " + Launcher.map, JLabel.CENTER));
//        }
        mapLabels = new LinkedHashMap<>();
        for (Player player : players) {
            JLabel mapLabel = new JLabel(mapFormatter.format(player), JLabel.CENTER);
            mapLabels.put(player, mapLabel);
            mapLabel.setFont(new Font("Serif", Font.BOLD, 18));

            add(mapLabel,BorderLayout.LINE_START);
        }
        scoreLabels = new LinkedHashMap<>();
        for (Player player : players) {
            JLabel scoreLabel = new JLabel("0", JLabel.CENTER);

            scoreLabels.put(player, scoreLabel);
            add(scoreLabel,BorderLayout.LINE_END);
        }
    }

    /**
     * Refreshes the scores of the players.
     */
    protected void refresh() {
        for (Map.Entry<Player, JLabel> entry : scoreLabels.entrySet()) {
            Player player = entry.getKey();
            String score = "";
            if (!player.isAlive()) {
                score = "You died. ";
            }
            score += scoreFormatter.format(player);
            entry.getValue().setText(score);
        }
    }
    protected void reMap() {
        for (Map.Entry<Player, JLabel> entry : mapLabels.entrySet()) {
            Player player = entry.getKey();
            String map = "";
            map += mapFormatter.format(player);
            entry.getValue().setText(map);
        }
    }

    /**
     * Provide means to format the score for a given player.
     */
    public interface ScoreFormatter {

        /**
         * Format the score of a given player.
         * @param player The player and its score
         * @return Formatted score.
         */
        String format(Player player);
    }


    /**
     * Let the score panel use a dedicated score formatter.
     * @param scoreFormatter Score formatter to be used.
     */
    public void setScoreFormatter(ScoreFormatter scoreFormatter) {
        assert scoreFormatter != null;
        this.scoreFormatter = scoreFormatter;
    }

}
