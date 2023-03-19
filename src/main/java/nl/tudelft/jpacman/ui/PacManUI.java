package nl.tudelft.jpacman.ui;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import javax.swing.border.Border;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.game.GameFactory;
import nl.tudelft.jpacman.game.SinglePlayerGame;
import nl.tudelft.jpacman.level.*;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.points.PointCalculatorLoader;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.ui.ScorePanel.ScoreFormatter;

/**
 * The default JPacMan UI frame. The PacManUI consists of the following
 * elements:
 *
 * <ul>
 * <li>A score panel at the top, displaying the score of the player(s).
 * <li>A board panel, displaying the current level, i.e. the board and all units
 * on it.
 * <li>A button panel, containing all buttons provided upon creation.
 * </ul>
 *
 * @author Jeroen Roosen
 *
 */
public class PacManUI extends JFrame {

    /**
     * Default serialisation UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The desired frame rate interval for the graphics in milliseconds, 40
     * being 25 fps.
     */
    private static final int FRAME_INTERVAL = 40;

    /**
     * The panel displaying the player scores.
     */
    private ScorePanel scorePanel;

    public void setBoardPanel(JPanel boardPanel) {
        this.boardPanel = boardPanel;
    }

    /**
     * The panel displaying the game.
     */
    private JPanel boardPanel;
    private Game game;

    private ButtonPanel buttonPanel;

    public ScorePanel getScorePanel() {
        return scorePanel;
    }

    public JPanel getBoardPanel() {
        return boardPanel;
    }

    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(ButtonPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    private Container contentPanel = getContentPane();
    private Map<String, Action> buttons;
    private Map<Integer, Action> keyMappings;
    private ScoreFormatter scoreFormatter;
    /**
     * Creates a new UI for a JPacman game.
     *
     * @param game
     *            The game to play.
     * @param buttons
     *            The map of caption-to-action entries that will appear as
     *            buttons on the interface.
     * @param keyMappings
     *            The map of keyCode-to-action entries that will be added as key
     *            listeners to the interface.
     * @param scoreFormatter
     *            The formatter used to display the current score.
     */
    public PacManUI(final Game game, final Map<String, Action> buttons,
                    final Map<Integer, Action> keyMappings,
                    ScoreFormatter scoreFormatter) {
        super("JPacman 2019");


        assert game != null;
        assert buttons != null;
        assert keyMappings != null;
        this.game=game;
        this.buttons=buttons;
        this.keyMappings=keyMappings;
        this.scoreFormatter=scoreFormatter;

        System.out.println("=================================");
        System.out.println("GAME: "+this.game);
        System.out.println("BTN: "+this.buttons);
        System.out.println("KEY: "+this.keyMappings);
        System.out.println("FOTMAT: "+this.scoreFormatter);
        System.out.println("=================================\n");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        PacKeyListener keys = new PacKeyListener(keyMappings);
        addKeyListener(keys);

        buttonPanel = new ButtonPanel(buttons, this);

        scorePanel = new ScorePanel(game.getPlayers(),this);
        if (scoreFormatter != null) {
            scorePanel.setScoreFormatter(scoreFormatter);
        }

//        setUndecorated(true);

        boardPanel = new BoardPanel(game);
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        contentPanel.add(scorePanel, BorderLayout.NORTH);
        contentPanel.add(boardPanel, BorderLayout.CENTER);


        pack();
        setLocationRelativeTo(null);

    }
    public PacManUI MainMenuUI(){
        contentPanel.removeAll();
//        setSize(368,336);
        contentPanel.add(new FirstMenu(this), BorderLayout.CENTER);
        pack();
        return this;
    }

    public void GAME_MODE(){
        contentPanel.removeAll();
//        setSize(368,336);
        contentPanel.add(new GameMode(this), BorderLayout.CENTER);
        pack();
    }

    public void PLAY_AT_MAP(int lv_map) {
        contentPanel.removeAll();
        System.out.println("================PLAY_AT_MAP=================");
        System.out.println("GAME: "+this.game);
        System.out.println("BTN: "+this.buttons);
        System.out.println("KEY: "+this.keyMappings);
        System.out.println("FOTMAT: "+this.scoreFormatter);
        System.out.println("=================================\n");

        buttonPanel = new ButtonPanel(buttons, this); 
        game.selectMap(lv_map-1);
        game.getLevel().setInProgress(false);

        game.getLevel().updateObservers();
        game.getLevel().start();
        game.getLevel().stop();
        System.out.println("==============PLAY_AT_MAP===================");
        System.out.println("game: "+game);
        System.out.println("isInProgress: "+game.isInProgress());
        System.out.println("getPlayers: "+game.getPlayers());
        System.out.println("isAlive: "+game.getPlayers().get(0).isAlive());
        System.out.println("getMap: "+game.getPlayers().get(0).getMap());
        System.out.println("isAnyPlayerAlive: "+game.getLevel().isAnyPlayerAlive());
        System.out.println("isInProgress: "+game.getLevel().isInProgress());
        System.out.println("=================================\n");

        if (scoreFormatter != null) {
            scorePanel.setScoreFormatter(scoreFormatter);
        }

//        setUndecorated(true);

        boardPanel = new BoardPanel(game);
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        contentPanel.add(scorePanel, BorderLayout.NORTH);
        contentPanel.add(boardPanel, BorderLayout.CENTER);
        pack();

    }

    public void RANKING_BOARD(){
        contentPanel.removeAll();
//        setSize(368,336);
        contentPanel.add(new RankingBoard(this), BorderLayout.CENTER);
        pack();
    }

    public void GAMAE_RANKING(){
        Launcher.GAME_MODE_NOW="RANK";
        System.out.println("Launcher GAME MODE : "+Launcher.GAME_MODE_NOW);
        contentPanel.removeAll();
//        setSize(368,336);
        contentPanel.add(new RankingMode(this), BorderLayout.CENTER);
        pack();
    }

    public void GAMAE_CASUAL(){
        Launcher.GAME_MODE_NOW="CASUAL";
        System.out.println("Launcher GAME MODE : "+Launcher.GAME_MODE_NOW);
        contentPanel.removeAll();
//        setSize(368,336);
        contentPanel.add(new selectMap(this), BorderLayout.CENTER);
        pack();
    }

    public void PacManUI_with_map(final Game game, final Map<String, Action> buttons,
                                  final Map<Integer, Action> keyMappings,
                                  ScoreFormatter scoreFormatter) {
        assert game != null;
        assert buttons != null;
        assert keyMappings != null;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        PacKeyListener keys = new PacKeyListener(keyMappings);
        addKeyListener(keys);

        buttonPanel = new ButtonPanel(buttons, this);

        scorePanel = new ScorePanel(game.getPlayers(),this);
        if (scoreFormatter != null) {
            scorePanel.setScoreFormatter(scoreFormatter);
        }

//        setUndecorated(true);

        boardPanel = new BoardPanel(game);
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        contentPanel.add(scorePanel, BorderLayout.NORTH);
        contentPanel.add(boardPanel, BorderLayout.CENTER);
        pack();

        setLocationRelativeTo(null);
    }

    public void PacManUI_LOST(String Text_Header, int Text_Score, double totalTime) {
        contentPanel.removeAll();
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        contentPanel.add(scorePanel, BorderLayout.NORTH);
        contentPanel.add(new CasualEnding(Text_Header,Text_Score,totalTime,this), BorderLayout.CENTER);
        //TEST GAME GUI
//
//        contentPanel.add(new RankingBoard(), BorderLayout.CENTER);
        pack();
    }
//    public void reset(){
//        getContentPane().invalidate();
//        getContentPane().validate();
//        getContentPane().repaint();
//    }
    /**
     * Starts the "engine", the thread that redraws the interface at set
     * intervals.
     */

    public void PacManUI_PLAY_RANK(Game game) {
        contentPanel.removeAll();
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        contentPanel.add(scorePanel, BorderLayout.NORTH);
        boardPanel = new BoardPanel(game);
        contentPanel.add(boardPanel, BorderLayout.CENTER);
        pack();
    }
    public void start() {
        setVisible(true);
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(this::nextFrame, 0, FRAME_INTERVAL, TimeUnit.MILLISECONDS);
    }

    /**
     * Draws the next frame, i.e. refreshes the scores and game.
     */
    public void nextFrame() {
        boardPanel.repaint();
        scorePanel.refresh();
        scorePanel.reMap();
    }

    public void ClickStart(){
        buttonPanel.ClickStart();
    }
    public void ClickStop(){
        buttonPanel.ClickStop();
    }
    public void ClickRestart(){
        buttonPanel.ClickRestart();
    }

}
