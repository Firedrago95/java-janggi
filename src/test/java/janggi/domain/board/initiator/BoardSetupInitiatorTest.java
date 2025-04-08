package janggi.domain.board.initiator;

import janggi.ReplaceUnderBar;
import janggi.domain.PieceSetup;
import janggi.domain.path.Position;
import janggi.domain.moveStrategy.ElephantMoveBehavior;
import janggi.domain.moveStrategy.KnightMoveBehavior;
import janggi.domain.piece.Piece;
import janggi.domain.piece.PieceType;
import janggi.domain.piece.Side;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static janggi.JanggiTestFixture.getFixedPieces;
import static org.assertj.core.api.Assertions.assertThat;

@ReplaceUnderBar
class BoardSetupInitiatorTest {

    private BoardInitiator boardInitiator;

    @Test
    void 왼상차림_기물들을_생성한다() {
        // given
        boardInitiator = new BoardInitiator(PieceSetup.LEFT_SETUP, PieceSetup.LEFT_SETUP);

        // when
        Map<Position, Piece> initialPieces = boardInitiator.generateInitialPieces();

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
        // given
        boardInitiator = new BoardInitiator(PieceSetup.RIGHT_SETUP, PieceSetup.RIGHT_SETUP);

        // when
        Map<Position, Piece> initialPieces = boardInitiator.generateInitialPieces();

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
        // given
        boardInitiator = new BoardInitiator(PieceSetup.OUTER_SETUP, PieceSetup.OUTER_SETUP);

        // when
        Map<Position, Piece> initialPieces = boardInitiator.generateInitialPieces();

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
        // given
        boardInitiator = new BoardInitiator(PieceSetup.INNER_SETUP, PieceSetup.INNER_SETUP);

        // when
        Map<Position, Piece> initialPieces = boardInitiator.generateInitialPieces();

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
}