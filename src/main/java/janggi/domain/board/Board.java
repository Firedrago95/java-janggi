package janggi.domain.board;

import janggi.domain.path.Position;
import janggi.domain.piece.Piece;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Board {

    private Map<Position, Piece> pieces;

    public Board(Map<Position, Piece> pieces) {
        this.pieces = pieces;
    }

    public Map<Position, Piece> getPiecesOnPath(List<Position> path) {
        return pieces.entrySet().stream()
            .filter(entry -> path.contains(entry.getKey()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<Position, Piece> getPieces() {
        return pieces;
    }
}
