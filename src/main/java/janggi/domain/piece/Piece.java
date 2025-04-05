package janggi.domain.piece;

import janggi.domain.moveStrategy.MoveBehavior;

import java.util.Objects;

public class Piece {

    private Side side;
    private PieceType pieceType;
    private MoveBehavior moveBehavior;

    public Piece(Side side, PieceType pieceType, MoveBehavior moveBehavior) {
        this.side = side;
        this.pieceType = pieceType;
        this.moveBehavior = moveBehavior;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public Side getSide() {
        return side;
    }

    @Override
    public String toString() {
        return "Piece{" +
            "side=" + side +
            ", pieceType=" + pieceType +
            ", moveBehavior=" + moveBehavior +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Piece piece)) return false;
        return side == piece.side && pieceType == piece.pieceType && Objects.equals(moveBehavior, piece.moveBehavior);
    }

    @Override
    public int hashCode() {
        return Objects.hash(side, pieceType, moveBehavior);
    }
}
