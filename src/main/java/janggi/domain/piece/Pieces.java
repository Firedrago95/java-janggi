package janggi.domain.piece;

import janggi.domain.path.Position;

import java.util.HashMap;
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

    public boolean hasOnePieceOnPath(Position destination) {
        HashMap<Position, Piece> copiedPieces = new HashMap<>(pieces);
        copiedPieces.remove(destination);
        return copiedPieces.size() == 1;
    }

    public boolean hasPieceOnDestination(Position destination) {
        return pieces.containsKey(destination);
    }

    public boolean hasEnemyOnDestination(Position destination, Side pieceSide) {
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
