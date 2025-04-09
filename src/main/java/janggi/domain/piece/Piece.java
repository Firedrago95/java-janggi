package janggi.domain.piece;

import janggi.domain.moveStrategy.MoveBehavior;
import janggi.domain.path.Position;

import java.util.List;
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

    public void validateTurn(Side turn) {
        if (turn != side) {
            throw new IllegalArgumentException("상대방 기물을 움직일 수 없습니다.");
        }
    }

    public List<Position> getPath(Position start, Position destination) {
        return moveBehavior.getPath(start, destination);
    }

    public boolean canMove(Pieces piecesOnPath, Position destination) {
        return moveBehavior.canMove(piecesOnPath, destination, side);
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public boolean isCannon() {
        return pieceType == PieceType.CANNON;
    }

    public boolean isEnemy(Side pieceSide) {
        return this.side != pieceSide;
    }

    public boolean isKing() {
        return this.pieceType == PieceType.KING;
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
