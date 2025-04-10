package janggi.domain.moveStrategy;

import janggi.domain.path.Position;
import janggi.domain.piece.Pieces;
import janggi.domain.piece.Side;

import java.util.List;

public class KingMoveBehavior implements MoveBehavior {

    @Override
    public List<Position> getPath(Position start, Position destination) {
        validateDestinationInPalace(destination);
        validateKingMove(start, destination);
        return List.of(destination);
    }

    private static void validateKingMove(Position start, Position destination) {
        if (start.isInPalaceSideCenter() && !start.isOneStepMove(destination)) {
            throw new IllegalArgumentException("움직일 수 없는 위치 입니다.");
        }
        if (!start.isOneStepMoveInPalace(destination)) {
            throw new IllegalArgumentException("움직일 수 없는 위치 입니다.");
        }
    }

    private void validateDestinationInPalace(Position destination) {
        if (!destination.isInPalace()) {
            throw new IllegalArgumentException("왕은 궁성 밖으로 이동할 수 없습니다.");
        }
    }

    @Override
    public boolean canMove(Pieces piecesOnPath, Position destination, Side pieceSide) {
        if (piecesOnPath.isAllyOnDestination(destination, pieceSide)) return false;
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return KingMoveBehavior.class.hashCode();
    }
}
