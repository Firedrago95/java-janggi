package janggi.domain.moveStrategy;

import janggi.domain.path.Position;
import janggi.domain.piece.Piece;
import janggi.domain.piece.Side;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CannonMoveBehavior implements MoveBehavior {

    public List<Position> getPath(Position start, Position destination) {
        validateLinearMove(start, destination);

        List<Position> positions = new ArrayList<>();
        getHorizontalMovePath(start, destination, positions);
        getVerticalMovePath(start, destination, positions);
        return positions;
    }

    public boolean canMove(Map<Position, Piece> piecesOnPath, Position destination, Side pieceSide) {
        if (!hasExactlyOnePieceOnPath(piecesOnPath)) return false;
        if (pathHasCannon(piecesOnPath)) return false;
        return isEnemyOnDestination(piecesOnPath, destination, pieceSide);
    }

    private static boolean isEnemyOnDestination(Map<Position, Piece> piecesOnPath, Position destination, Side pieceSide) {
        Piece pieceOnDestination = piecesOnPath.get(destination);
        return piecesOnPath.containsKey(destination)
            && pieceOnDestination.isEnemy(pieceSide);
    }

    private static boolean pathHasCannon(Map<Position, Piece> piecesOnPath) {
        return piecesOnPath.values().stream()
            .anyMatch(Piece::isCannon);
    }

    private static boolean hasExactlyOnePieceOnPath(Map<Position, Piece> piecesOnPath) {
        return piecesOnPath.size() == 1;
    }

    private void validateLinearMove(Position start, Position destination) {
        if (!start.isLinearMove(destination)) {
            throw new IllegalArgumentException("포는 상하좌우 직선으로만 움직일 수 있습니다.");
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
        return CannonMoveBehavior.class.hashCode();
    }
}
