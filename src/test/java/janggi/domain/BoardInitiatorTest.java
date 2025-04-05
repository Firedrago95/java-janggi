package janggi.domain;

import janggi.ReplaceUnderBar;
import janggi.domain.moveStrategy.CannonMoveBehavior;
import janggi.domain.moveStrategy.ElephantMoveBehavior;
import janggi.domain.moveStrategy.GuardMoveBehavior;
import janggi.domain.moveStrategy.KingMoveBehavior;
import janggi.domain.moveStrategy.KnightMoveBehavior;
import janggi.domain.moveStrategy.PawnMoveBehavior;
import janggi.domain.moveStrategy.RookMoveBehavior;
import janggi.domain.piece.Piece;
import janggi.domain.piece.PieceType;
import janggi.domain.piece.Side;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ReplaceUnderBar
class BoardInitiatorTest {

    private BoardInitiator boardInitiator = new BoardInitiator();

    @Test
    void 왼상차림_기물들을_생성한다() {
        // when
        Map<Position, Piece> initialPieces = boardInitiator.generateInitialPieces(PieceSetup.LEFT_SETUP, PieceSetup.LEFT_SETUP);

        // then
        Map<Position, Piece> fixedPieces = getFixedPieces();
        fixedPieces.put(new Position(2,10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        fixedPieces.put(new Position(3,10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));
        fixedPieces.put(new Position(7,10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        fixedPieces.put(new Position(8,10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));

        fixedPieces.put(new Position(2,1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        fixedPieces.put(new Position(3,1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        fixedPieces.put(new Position(7,1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        fixedPieces.put(new Position(8,1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        assertThat(initialPieces).isEqualTo(fixedPieces);
    }

    @Test
    void 오른상차림_기물을_생성한다() {
        Map<Position, Piece> initialPieces = boardInitiator.generateInitialPieces(PieceSetup.RIGHT_SETUP, PieceSetup.RIGHT_SETUP);

        // then
        Map<Position, Piece> fixedPieces = getFixedPieces();
        fixedPieces.put(new Position(2,10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));
        fixedPieces.put(new Position(3,10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        fixedPieces.put(new Position(7,10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));
        fixedPieces.put(new Position(8,10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));

        fixedPieces.put(new Position(2,1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        fixedPieces.put(new Position(3,1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        fixedPieces.put(new Position(7,1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        fixedPieces.put(new Position(8,1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        assertThat(initialPieces).isEqualTo(fixedPieces);
    }

    @Test
    void 바깥상차림_기물을_생성한다() {
        Map<Position, Piece> initialPieces = boardInitiator.generateInitialPieces(PieceSetup.OUTER_SETUP, PieceSetup.OUTER_SETUP);

        // then
        Map<Position, Piece> fixedPieces = getFixedPieces();
        fixedPieces.put(new Position(2,10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        fixedPieces.put(new Position(3,10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));
        fixedPieces.put(new Position(7,10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));
        fixedPieces.put(new Position(8,10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));

        fixedPieces.put(new Position(2,1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        fixedPieces.put(new Position(3,1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        fixedPieces.put(new Position(7,1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        fixedPieces.put(new Position(8,1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        assertThat(initialPieces).isEqualTo(fixedPieces);
    }

    @Test
    void 안상차림_기물을_생성한다() {
        Map<Position, Piece> initialPieces = boardInitiator.generateInitialPieces(PieceSetup.INNER_SETUP, PieceSetup.INNER_SETUP);

        // then
        Map<Position, Piece> fixedPieces = getFixedPieces();
        fixedPieces.put(new Position(2,10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));
        fixedPieces.put(new Position(3,10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        fixedPieces.put(new Position(7,10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        fixedPieces.put(new Position(8,10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));

        fixedPieces.put(new Position(2,1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        fixedPieces.put(new Position(3,1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        fixedPieces.put(new Position(7,1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        fixedPieces.put(new Position(8,1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        assertThat(initialPieces).isEqualTo(fixedPieces);
    }

    private static Map<Position, Piece> getFixedPieces() {
        Map<Position, Piece> fixedPieces = new HashMap<>();
        fixedPieces.put(new Position(1,10), new Piece(Side.CHO, PieceType.ROOK, new RookMoveBehavior()));
        fixedPieces.put(new Position(4,10), new Piece(Side.CHO, PieceType.GUARD, new GuardMoveBehavior()));
        fixedPieces.put(new Position(6,10), new Piece(Side.CHO, PieceType.GUARD, new GuardMoveBehavior()));
        fixedPieces.put(new Position(9,10), new Piece(Side.CHO, PieceType.ROOK, new RookMoveBehavior()));
        fixedPieces.put(new Position(5,9), new Piece(Side.CHO, PieceType.KING, new KnightMoveBehavior()));
        fixedPieces.put(new Position(2,8), new Piece(Side.CHO, PieceType.CANNON, new CannonMoveBehavior()));
        fixedPieces.put(new Position(8,8), new Piece(Side.CHO, PieceType.CANNON, new CannonMoveBehavior()));
        fixedPieces.put(new Position(1,7), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior()));
        fixedPieces.put(new Position(3,7), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior()));
        fixedPieces.put(new Position(5,7), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior()));
        fixedPieces.put(new Position(7,7), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior()));
        fixedPieces.put(new Position(9,7), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior()));

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