package janggi.domain.moveStrategy;

import janggi.domain.path.Position;
import janggi.domain.piece.Pieces;
import janggi.domain.piece.Side;

import java.util.List;

public class KingMoveBehavior implements MoveBehavior {

    @Override
    public List<Position> getPath(Position start, Position destination) {
        validateDestinationInPalace(destination);
        return List.of();
    }

    private void validateDestinationInPalace(Position destination) {
        if (!destination.isInPalace()) {
            throw new IllegalArgumentException("왕은 궁성 밖으로 이동할 수 없습니다.");
        }
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
        return KingMoveBehavior.class.hashCode();
    }
}
