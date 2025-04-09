package janggi.domain.moveStrategy;

import janggi.domain.path.Position;
import janggi.domain.piece.Pieces;
import janggi.domain.piece.Side;

import java.util.List;

public interface MoveBehavior {

    List<Position> getPath(Position start, Position destination);

    boolean canMove(Pieces piecesOnPath, Position destination, Side pieceSide);
}
