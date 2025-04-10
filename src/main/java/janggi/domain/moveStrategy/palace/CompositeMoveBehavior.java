package janggi.domain.moveStrategy.palace;

import janggi.domain.moveStrategy.MoveBehavior;
import janggi.domain.path.Position;
import janggi.domain.piece.Pieces;
import janggi.domain.piece.Side;

import java.util.List;

public class CompositeMoveBehavior implements MoveBehavior {

    private List<MoveBehavior> moveBehaviors;
    private MoveBehavior useMoveBehavior;

    public CompositeMoveBehavior(MoveBehavior defaultMoveBehavior, MoveBehavior palaceMoveBehavior) {
        this.moveBehaviors = List.of(defaultMoveBehavior, palaceMoveBehavior);
    }

    @Override
    public List<Position> getPath(Position start, Position destination) {
        if (start.isInPalaceCornerOrCenter() && destination.isInPalace() & start.isDiagonal(destination)) {
            useMoveBehavior = moveBehaviors.getLast();
            return useMoveBehavior.getPath(start, destination);
        }
        useMoveBehavior = moveBehaviors.getFirst();
        return useMoveBehavior.getPath(start, destination);
    }

    @Override
    public boolean canMove(Pieces piecesOnPath, Position destination, Side pieceSide) {
        return useMoveBehavior.canMove(piecesOnPath, destination, pieceSide);
    }
}
