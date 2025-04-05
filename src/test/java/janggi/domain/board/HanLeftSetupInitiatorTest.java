package janggi.domain.board;

import janggi.ReplaceUnderBar;
import janggi.domain.Position;
import janggi.domain.board.initiator.HanLeftSetupInitiator;
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
public class HanLeftSetupInitiatorTest {

    private final SetupInitiator hanLeftSetupInitiator = new HanLeftSetupInitiator();

    @Test
    void 한나라_왼상차림_기물들을_생성한다() {
        // when
        Map<Position, Piece> hanLeftSetupPieces = hanLeftSetupInitiator.generateInitialPieces();

        // then
        Map<Position, Piece> expected = new HashMap<>();
        expected.put(new Position(2,1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        expected.put(new Position(3,1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        expected.put(new Position(7,1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        expected.put(new Position(8,1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        assertThat(hanLeftSetupPieces).isEqualTo(expected);
    }
}
