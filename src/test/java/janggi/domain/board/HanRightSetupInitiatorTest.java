package janggi.domain.board;

import janggi.ReplaceUnderBar;
import janggi.domain.Position;
import janggi.domain.board.initiator.HanRightSetupInitiator;
import janggi.domain.board.initiator.SetupInitiator;
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
class HanRightSetupInitiatorTest {

    private final SetupInitiator hanRightSetupInitiator = new HanRightSetupInitiator();

    @Test
    void 한나라_오른상차림_기물들을_생성한다() {
        // when
        Map<Position, Piece> hanLeftSetupPieces = hanRightSetupInitiator.generateInitialPieces();

        // then
        Map<Position, Piece> expected = new HashMap<>();
        expected.put(new Position(2,1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        expected.put(new Position(3,1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        expected.put(new Position(7,1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        expected.put(new Position(8,1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        assertThat(hanLeftSetupPieces).isEqualTo(expected);
    }
}