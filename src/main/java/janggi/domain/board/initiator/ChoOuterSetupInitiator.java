package janggi.domain.board.initiator;

import janggi.domain.Position;
import janggi.domain.moveStrategy.ElephantMoveBehavior;
import janggi.domain.moveStrategy.KnightMoveBehavior;
import janggi.domain.piece.Piece;
import janggi.domain.piece.PieceType;
import janggi.domain.piece.Side;

import java.util.HashMap;
import java.util.Map;

public class ChoOuterSetupInitiator implements SetupInitiator{

    @Override
    public Map<Position, Piece> generateInitialPieces() {
        Map<Position, Piece> choOuterSetup = new HashMap<>();
        choOuterSetup.put(new Position(2, 10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        choOuterSetup.put(new Position(3, 10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));
        choOuterSetup.put(new Position(7, 10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));
        choOuterSetup.put(new Position(8, 10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        return choOuterSetup;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return ChoOuterSetupInitiator.class.hashCode();
    }
}
