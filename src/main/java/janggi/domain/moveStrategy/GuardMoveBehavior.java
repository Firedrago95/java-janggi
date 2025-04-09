package janggi.domain.moveStrategy;

import janggi.domain.path.Position;
import janggi.domain.piece.Pieces;
import janggi.domain.piece.Side;

import java.util.List;

public class GuardMoveBehavior implements MoveBehavior{

    @Override
    public List<Position> getPath(Position start, Position destination) {
        return List.of();
    }

    @Override
    public boolean canMove(Pieces piecesOnPath, Position destination, Side pieceSide) {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return GuardMoveBehavior.class.hashCode();
    }
}
