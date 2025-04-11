package janggi.domain.moveStrategy.palace;

import janggi.domain.moveStrategy.MoveBehavior;
import janggi.domain.path.Position;
import janggi.domain.piece.Pieces;
import janggi.domain.piece.Side;

import java.util.List;
import java.util.Objects;

public class CompositeMoveBehavior implements MoveBehavior {

    private List<MoveBehavior> moveBehaviors;
    private MoveBehavior useMoveBehavior;

    public CompositeMoveBehavior(MoveBehavior defaultMoveBehavior, MoveBehavior palaceMoveBehavior) {
        this.moveBehaviors = List.of(defaultMoveBehavior, palaceMoveBehavior);
    }

    @Override
    public boolean supports(Position start, Position destination) {
        for (MoveBehavior moveBehavior : moveBehaviors) {
            if (moveBehavior.supports(start, destination)) {
                useMoveBehavior = moveBehavior;
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Position> getPath(Position start, Position destination) {
        if (supports(start, destination)) {
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CompositeMoveBehavior that)) return false;
        return Objects.equals(moveBehaviors, that.moveBehaviors);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(moveBehaviors);
    }
}
