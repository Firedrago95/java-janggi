package janggi.domain.board;

import janggi.domain.Position;
import janggi.domain.piece.Piece;

import java.util.Map;

public class Board {

    private Map<Position, Piece> pieces;

    public Board(Map<Position, Piece> pieces) {
        this.pieces = pieces;
    }

    public Map<Position, Piece> getPieces() {
        return pieces;
    }
}
