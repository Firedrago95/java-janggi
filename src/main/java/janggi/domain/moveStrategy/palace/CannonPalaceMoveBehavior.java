package janggi.domain.moveStrategy.palace;

import janggi.domain.moveStrategy.MoveBehavior;
import janggi.domain.path.Position;
import janggi.domain.piece.Pieces;
import janggi.domain.piece.Side;

import java.util.ArrayList;
import java.util.List;

public class CannonPalaceMoveBehavior implements MoveBehavior {

    @Override
    public boolean supports(Position start, Position destination) {
        return start.isDiagonalMoveInPalace(destination);
    }

    @Override
    public List<Position> getPath(Position start, Position destination) {
        List<Position> positions = new ArrayList<>();
        getPalaceMovePath(start, destination, positions);
        return positions;
    }

    private void getPalaceMovePath(Position start, Position destination, List<Position> positions) {
        int xDistance = start.calculateXDistance(destination);
        int yDistance = start.calculateYDistance(destination);
        int xStep = (int) Math.signum(xDistance);
        int yStep = (int) Math.signum(yDistance);

        for (int i = 1; i <= Math.abs(xDistance); i++) {
            positions.add(new Position(start.getX() + i * xStep, start.getY() + i * yStep));
        }
    }

    @Override
    public boolean canMove(Pieces piecesOnPath, Position destination, Side pieceSide) {
        if (!piecesOnPath.hasPieceExceptAt(destination)) return false;
        if (piecesOnPath.hasCannon()) return false;
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
        return CannonPalaceMoveBehavior.class.hashCode();
    }
}
