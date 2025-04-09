package janggi.domain.board;

import janggi.domain.path.Position;
import janggi.domain.piece.Piece;
import janggi.domain.piece.Pieces;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Board {

    private Map<Position, Piece> pieces;

    public Board(Map<Position, Piece> pieces) {
        this.pieces = pieces;
    }

    public Pieces getPiecesOnPath(List<Position> path) {
        Map<Position, Piece> piecesOnPath = pieces.entrySet().stream()
            .filter(entry -> path.contains(entry.getKey()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return new Pieces(piecesOnPath);
    }

    public Map<Position, Piece> getPieces() {
        return pieces;
    }
}
