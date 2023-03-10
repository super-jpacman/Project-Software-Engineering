package UC001.board;


import nl.tudelft.jpacman.board.Square;


public class BoardForTest {


    private Square[][] board;

    BoardForTest(Square[][] grid) {
        assert grid != null;
        this.board = grid;
        assert invariant() : "Initial grid cannot contain null squares";
    }


    protected final boolean invariant() {
        for (Square[] row : board) {
            for (Square square : row) {
                if (square == null) {
                    return false;
                }
            }
        }
        return true;
    }


    public int getWidth() {
        return board.length;
    }


    public int getHeight() {
        return board[0].length;
    }


    public Square squareAt(int x, int y) {
        assert withinBorders(x, y);
        Square result = board[x][y];
        assert result != null : "Follows from invariant.";
        return result;
    }


    public boolean withinBorders(int x, int y) {
        return x >= 0 && x < getWidth() && y >= 0 && y < getHeight();
    }
}
