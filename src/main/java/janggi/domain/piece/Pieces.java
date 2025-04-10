package janggi.domain.piece;

import janggi.domain.path.Position;

import java.util.Map;
import java.util.Objects;

public class Pieces {

    private final Map<Position, Piece> pieces;

    public Pieces(Map<Position, Piece> pieces) {
        this.pieces = pieces;
    }

    public boolean hasCannon() {
        return pieces.values().stream()
            .anyMatch(Piece::isCannon);
    }

    public boolean isAllyOnDestination(Position destination, Side pieceSide) {
        if (!pieces.containsKey(destination)) return false;
        Piece pieceOnDestination = pieces.get(destination);
        return !pieceOnDestination.isEnemy(pieceSide);
    }

    public boolean hasPieceExceptAt(Position destination) {
        return pieces.size() == 1 && !pieces.containsKey(destination)
            || pieces.size() == 2 && pieces.containsKey(destination);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pieces pieces1)) return false;
        return Objects.equals(pieces, pieces1.pieces);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pieces);
    }
}
