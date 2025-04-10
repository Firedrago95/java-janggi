package janggi.domain.moveStrategy;

import janggi.domain.path.Position;
import janggi.domain.piece.Pieces;
import janggi.domain.piece.Side;

import java.util.List;

public class PawnMoveBehavior implements MoveBehavior{

    private final Side pieceSide;

    public PawnMoveBehavior(Side pieceSide) {
        this.pieceSide = pieceSide;
    }

    @Override
    public List<Position> getPath(Position start, Position destination) {
        validateOneStepMove(start, destination);
        return List.of(destination);
    }

    @Override
    public boolean canMove(Pieces pieceOnPath, Position destination, Side cho) {
        if (pieceOnPath.isAllyOnDestination(destination, cho)) return false;
        return true;
    }

    private void validateOneStepMove(Position start, Position destination) {
        validateOneStep(start, destination);
        validateSideMove(start, destination);
    }

    private static void validateOneStep(Position start, Position destination) {
        if (!start.isOneStepMove(destination)) {
            throw new IllegalArgumentException("졸은 직진과 좌우로 한칸 이동 할 수 있습니다.");
        }
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return PawnMoveBehavior.class.hashCode();
    }
}
