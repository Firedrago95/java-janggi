package janggi.domain.board.initiator;

import janggi.domain.Position;
import janggi.domain.moveStrategy.CannonMoveBehavior;
import janggi.domain.moveStrategy.GuardMoveBehavior;
import janggi.domain.moveStrategy.KingMoveBehavior;
import janggi.domain.moveStrategy.PawnMoveBehavior;
import janggi.domain.moveStrategy.RookMoveBehavior;
import janggi.domain.piece.Piece;
import janggi.domain.piece.PieceType;
import janggi.domain.piece.Side;

import java.util.HashMap;
import java.util.Map;

public class TextFixture {

    public static Map<Position, Piece> getFixedPieces() {
        Map<Position, Piece> fixedPieces = new HashMap<>();
        fixedPieces.putAll(getChoFixedPieces());
        fixedPieces.putAll(getHanFixedPieces());
        return fixedPieces;
    }

    public static Map<Position, Piece> getChoFixedPieces() {
        Map<Position, Piece> fixedPieces = new HashMap<>();
        fixedPieces.put(new Position(1,10), new Piece(Side.CHO, PieceType.ROOK, new RookMoveBehavior()));
        fixedPieces.put(new Position(4,10), new Piece(Side.CHO, PieceType.GUARD, new GuardMoveBehavior()));
        fixedPieces.put(new Position(6,10), new Piece(Side.CHO, PieceType.GUARD, new GuardMoveBehavior()));
        fixedPieces.put(new Position(9,10), new Piece(Side.CHO, PieceType.ROOK, new RookMoveBehavior()));
        fixedPieces.put(new Position(5,9), new Piece(Side.CHO, PieceType.KING, new KingMoveBehavior()));
        fixedPieces.put(new Position(2,8), new Piece(Side.CHO, PieceType.CANNON, new CannonMoveBehavior()));
        fixedPieces.put(new Position(8,8), new Piece(Side.CHO, PieceType.CANNON, new CannonMoveBehavior()));
        fixedPieces.put(new Position(1,7), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior()));
        fixedPieces.put(new Position(3,7), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior()));
        fixedPieces.put(new Position(5,7), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior()));
        fixedPieces.put(new Position(7,7), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior()));
        fixedPieces.put(new Position(9,7), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior()));
        return fixedPieces;
    }

    public static Map<Position, Piece> getHanFixedPieces() {
        Map<Position, Piece> fixedPieces = new HashMap<>();
        fixedPieces.put(new Position(1,1), new Piece(Side.HAN, PieceType.ROOK, new RookMoveBehavior()));
        fixedPieces.put(new Position(4,1), new Piece(Side.HAN, PieceType.GUARD, new GuardMoveBehavior()));
        fixedPieces.put(new Position(6,1), new Piece(Side.HAN, PieceType.GUARD, new GuardMoveBehavior()));
        fixedPieces.put(new Position(9,1), new Piece(Side.HAN, PieceType.ROOK, new RookMoveBehavior()));
        fixedPieces.put(new Position(5,2), new Piece(Side.HAN, PieceType.KING, new KingMoveBehavior()));
        fixedPieces.put(new Position(2,3), new Piece(Side.HAN, PieceType.CANNON, new CannonMoveBehavior()));
        fixedPieces.put(new Position(8,3), new Piece(Side.HAN, PieceType.CANNON, new CannonMoveBehavior()));
        fixedPieces.put(new Position(1,4), new Piece(Side.HAN, PieceType.PAWN, new PawnMoveBehavior()));
        fixedPieces.put(new Position(3,4), new Piece(Side.HAN, PieceType.PAWN, new PawnMoveBehavior()));
        fixedPieces.put(new Position(5,4), new Piece(Side.HAN, PieceType.PAWN, new PawnMoveBehavior()));
        fixedPieces.put(new Position(7,4), new Piece(Side.HAN, PieceType.PAWN, new PawnMoveBehavior()));
        fixedPieces.put(new Position(9,4), new Piece(Side.HAN, PieceType.PAWN, new PawnMoveBehavior()));
        return fixedPieces;
    }
}
