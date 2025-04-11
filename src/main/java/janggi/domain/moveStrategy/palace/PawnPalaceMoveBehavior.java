package janggi.domain.moveStrategy.palace;

import janggi.domain.moveStrategy.MoveBehavior;
import janggi.domain.path.Position;
import janggi.domain.piece.Pieces;
import janggi.domain.piece.Side;

import java.util.List;

public class PawnPalaceMoveBehavior implements MoveBehavior {

    private final Side pieceSide;

    public PawnPalaceMoveBehavior(Side pieceSide) {
        this.pieceSide = pieceSide;
    }

    @Override
    public boolean supports(Position start, Position destination) {
        return start.isOneStepMoveInPalace(destination);
    }

    @Override
    public List<Position> getPath(Position start, Position destination) {
        validateSideMove(start, destination);
        return List.of(destination);
    }

    private void validateSideMove(Position start, Position destination) {
        if (pieceSide == Side.CHO && start.calculateYDistance(destination) == 1) {
            throw new IllegalArgumentException("졸은 뒤로 이동 할 수 없습니다.");
        }
        if (pieceSide == Side.HAN && start.calculateYDistance(destination) == -1) {
            throw new IllegalArgumentException("졸은 뒤로 이동 할 수 없습니다.");
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
        return PawnPalaceMoveBehavior.class.hashCode();
    }
}
