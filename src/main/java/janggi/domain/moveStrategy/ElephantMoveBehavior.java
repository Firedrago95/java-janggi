package janggi.domain.moveStrategy;

import janggi.domain.path.Position;
import janggi.domain.piece.Pieces;
import janggi.domain.piece.Side;

import java.util.List;

public class ElephantMoveBehavior implements MoveBehavior{

    @Override
    public boolean supports(Position start, Position destination) {
        return true;
    }

    @Override
    public List<Position> getPath(Position start, Position destination) {
        validateLinearMove(start, destination);

        int xDistance = start.calculateXDistance(destination);
        int yDistance = start.calculateYDistance(destination);
        int xSignum = (int) Math.signum(xDistance);
        int ySignum = (int) Math.signum(yDistance);

        if (Math.abs(xDistance) == 3) {
            return generateXFirstPath(start, xSignum, ySignum);
        }
        return generateYFirstPath(start, xSignum, ySignum);
    }

    @Override
    public boolean canMove(Pieces pieceOnPath, Position destination, Side cho) {
        if (pieceOnPath.hasPieceExceptAt(destination)) return false;
        if (pieceOnPath.isAllyOnDestination(destination, cho)) return false;
        return true;
    }

    private List<Position> generateXFirstPath(Position start, int xSignum, int ySignum) {
        return List.of(
            new Position(start.getX() + xSignum, start.getY()),
            new Position(start.getX() + (2 * xSignum), start.getY() + (1 * ySignum)),
            new Position(start.getX() + (3 * xSignum), start.getY() + (2 * ySignum))
        );
    }

    private List<Position> generateYFirstPath(Position start, int xSignum, int ySignum) {
        return List.of(
            new Position(start.getX(), start.getY() + ySignum),
            new Position(start.getX() + (1 * xSignum), start.getY() + (2 * ySignum)),
            new Position(start.getX() + (2 * xSignum), start.getY() + (3 * ySignum))
        );
    }

    private void validateLinearMove(Position start, Position destination) {
        int xDistance = Math.abs(start.calculateXDistance(destination));
        int yDistance = Math.abs(start.calculateYDistance(destination));
        if (!((xDistance == 3 && yDistance == 2) || (xDistance == 2 && yDistance == 3))) {
            throw new IllegalArgumentException("상은 직선으로 한칸 이동 후 대각선으로 두칸 이동해야 합니다.");
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
        return ElephantMoveBehavior.class.hashCode();
    }
}
