package janggi.domain.board.initiator;

import janggi.domain.path.Position;
import janggi.domain.moveStrategy.ElephantMoveBehavior;
import janggi.domain.moveStrategy.KnightMoveBehavior;
import janggi.domain.piece.Piece;
import janggi.domain.piece.PieceType;
import janggi.domain.piece.Side;

import java.util.Map;

public class HanLeftSetupInitiator implements SetupInitiator{

    @Override
    public Map<Position, Piece> generateInitialPieces() {
        Map<Position, Piece> hanLeftSetupPieces = FixedPiecesGenerator.generateHanFixedInitialPieces();
        hanLeftSetupPieces.put(new Position(2, 1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        hanLeftSetupPieces.put(new Position(3, 1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        hanLeftSetupPieces.put(new Position(7, 1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        hanLeftSetupPieces.put(new Position(8, 1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        return hanLeftSetupPieces;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return HanLeftSetupInitiator.class.hashCode();
    }
}
