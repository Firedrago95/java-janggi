package janggi.domain.moveStrategy;

import janggi.domain.path.Position;
import janggi.domain.piece.Pieces;
import janggi.domain.piece.Side;

import java.util.ArrayList;
import java.util.List;

public class RookMoveBehavior implements MoveBehavior {

    @Override
    public List<Position> getPath(Position start, Position destination) {
        validateLinearMove(start, destination);

        List<Position> positions = new ArrayList<>();
        getHorizontalMovePath(start, destination, positions);
        getVerticalMovePath(start, destination, positions);
        return positions;
    }

    @Override
    public boolean canMove(Pieces pieceOnPath, Position destination, Side cho) {
        if (pieceOnPath.hasPieceExceptAt(destination)) return false;
        if (pieceOnPath.isAllyOnDestination(destination, cho)) return false;
        return true;
    }

    private void validateLinearMove(Position start, Position destination) {
        if (!start.isLinearMove(destination)) {
            throw new IllegalArgumentException("차는 상하좌우 직선으로만 움직일 수 있습니다.");
        }
    }

    private static void getHorizontalMovePath(Position start, Position destination, List<Position> positions) {
        int xDistance = start.calculateXDistance(destination);
        if (xDistance != 0) {
            int stepX = (int) Math.signum(xDistance);
            int steps = Math.abs(xDistance);
            for (int i = 1; i <= steps; i++) {
                positions.add(new Position(start.getX() + (i * stepX), start.getY()));
            }
        }

    }

    private static void getVerticalMovePath(Position start, Position destination, List<Position> positions) {
        int yDistance = start.calculateYDistance(destination);
        if (yDistance != 0) {
            int stepY = (int) Math.signum(yDistance);
            int steps = Math.abs(yDistance);
            for (int i = 1; i <= steps; i++) {
                positions.add(new Position(start.getX(), start.getY() + i * stepY));
            }
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
        return RookMoveBehavior.class.hashCode();
    }
}
