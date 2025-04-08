package janggi.domain.board.initiator;

import janggi.ReplaceUnderBar;
import janggi.domain.moveStrategy.ElephantMoveBehavior;
import janggi.domain.moveStrategy.KnightMoveBehavior;
import janggi.domain.path.Position;
import janggi.domain.piece.Piece;
import janggi.domain.piece.PieceType;
import janggi.domain.piece.Side;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static janggi.JanggiTestFixture.getChoFixedPieces;
import static org.assertj.core.api.Assertions.assertThat;

@ReplaceUnderBar
class ChoLeftSetupInitiatorTest {

    private final SetupInitiator choLeftSetupSetupInitiator = new ChoLeftSetupInitiator();

    @Test
    void 초나라_왼상차림_기물들을_생성한다() {
        // when
        Map<Position, Piece> initialPieces = choLeftSetupSetupInitiator.generateInitialPieces();

        // then
        Map<Position, Piece> expected = getChoFixedPieces();
        expected.put(new Position(2,10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        expected.put(new Position(3,10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));
        expected.put(new Position(7,10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        expected.put(new Position(8,10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));

        assertThat(initialPieces).isEqualTo(expected);
    }
}