package janggi.domain.board.initiator;

import janggi.ReplaceUnderBar;
import janggi.domain.Position;
import janggi.domain.moveStrategy.ElephantMoveBehavior;
import janggi.domain.moveStrategy.KnightMoveBehavior;
import janggi.domain.piece.Piece;
import janggi.domain.piece.PieceType;
import janggi.domain.piece.Side;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ReplaceUnderBar
class ChoOuterSetupInitiatorTest {

    private final SetupInitiator choOuterSetupInitiator = new ChoOuterSetupInitiator();

    @Test
    void 초나라_바깥상차림_기물을_생성한다() {
        Map<Position, Piece> initialPieces = choOuterSetupInitiator.generateInitialPieces();

        // then
        Map<Position, Piece> expected = new HashMap<>();
        expected.put(new Position(2, 10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        expected.put(new Position(3, 10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));
        expected.put(new Position(7, 10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));
        expected.put(new Position(8, 10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        assertThat(initialPieces).isEqualTo(expected);
    }
}