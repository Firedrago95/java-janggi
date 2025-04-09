package janggi.domain.piece;

import janggi.domain.path.Position;

import java.util.Map;

public class Pieces {

    private final Map<Position, Piece> pieces;

    public Pieces(Map<Position, Piece> pieces) {
        this.pieces = pieces;
    }

    public boolean hasCannon() {
        return pieces.values().stream()
            .anyMatch(Piece::isCannon);
    }

    public boolean hasExactlyOnePiece() {
        return pieces.size() == 1;
    }

    public boolean isEnemyOnDestination(Position destination, Side pieceSide) {
        if (!pieces.containsKey(destination)) return false;
        Piece pieceOnDestination = pieces.get(destination);
        return pieceOnDestination.isEnemy(pieceSide);
    }

    public boolean isAllyOnDestination(Position destination, Side pieceSide) {
        if (!pieces.containsKey(destination)) return false;
        Piece pieceOnDestination = pieces.get(destination);
        return !pieceOnDestination.isEnemy(pieceSide);
    }

    public boolean hasPieceExceptAt(Position destination) {
        return !pieces.isEmpty() && !pieces.containsKey(destination);
    }
}
