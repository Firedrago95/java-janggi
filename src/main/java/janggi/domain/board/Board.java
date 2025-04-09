package janggi.domain.board;

import janggi.domain.path.Position;
import janggi.domain.piece.Piece;
import janggi.domain.piece.Pieces;
import janggi.domain.piece.Side;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Board {

    private Map<Position, Piece> pieces;
    private Side turn;

    public Board(Map<Position, Piece> pieces, Side turn) {
        this.pieces = pieces;
        this.turn = turn;
    }

    public void move(Position start, Position destination) {
        Piece movingPiece = findMovingPiece(start);
        movingPiece.validateTurn(turn);
        List<Position> path = movingPiece.getPath(start, destination);
        Pieces piecesOnPath = getPiecesOnPath(path);
        validateMoveable(destination, movingPiece, piecesOnPath);
        movePieceToDestination(start, destination, movingPiece);
        turn = turn.opposite();
    }

    private static void validateMoveable(Position destination, Piece movingPiece, Pieces piecesOnPath) {
        boolean canMove = movingPiece.canMove(piecesOnPath, destination);
        if (!canMove) {
            throw new IllegalArgumentException("해당 경로로 이동 할 수 없습니다.");
        }
    }

    private void movePieceToDestination(Position start, Position destination, Piece movingPiece) {
        pieces.remove(start);
        pieces.put(destination, movingPiece);
    }

    private Piece findMovingPiece(Position start) {
        if (!pieces.containsKey(start)) {
            throw new IllegalArgumentException("해당 위치에 기물이 없습니다.");
        }
        return pieces.get(start);
    }

    public boolean isGameOver() {
        int kingCount = (int) pieces.values().stream()
            .filter(piece -> piece.isKing())
            .count();
        return kingCount != 2;
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
