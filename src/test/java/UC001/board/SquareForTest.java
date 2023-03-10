package UC001.board;

import com.google.common.collect.ImmutableList;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.board.Unit;
import nl.tudelft.jpacman.sprite.Sprite;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class SquareForTest extends Square{

    private List<Unit> occupants;

    private Map<Direction, nl.tudelft.jpacman.board.Square> neighbours;


    protected SquareForTest() {
        this.occupants = new ArrayList<>();
        this.neighbours = new EnumMap<>(Direction.class);
        assert invariant();
    }

    public nl.tudelft.jpacman.board.Square getSquareAt(Direction direction) {
        return neighbours.get(direction);
    }

    public void link(nl.tudelft.jpacman.board.Square neighbour, Direction direction) {
        neighbours.put(direction, neighbour);
        assert invariant();
    }

    public List<Unit> getOccupants() {
        return ImmutableList.copyOf(occupants);
    }

    public void put(Unit occupant) {
        assert occupant != null;
        assert !occupants.contains(occupant);

        occupants.add(occupant);
    }

    public void remove(Unit occupant) {
        assert occupant != null;
        occupants.remove(occupant);
    }

    @Override
    public boolean isAccessibleTo(Unit unit) {
        return false;
    }

    @Override
    public Sprite getSprite() {
        return null;
    }

}
